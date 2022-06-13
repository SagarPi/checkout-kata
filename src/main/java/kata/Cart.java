package kata;

import java.util.HashMap;

public class Cart {
    private final HashMap<Item, Integer> itemsWithPurchasedQuantity = new HashMap<>();

    private final PriceCalculator priceCalculator = new PriceCalculator();

    public void addItem(Item item) {
        if (!itemsWithPurchasedQuantity.containsKey(item)) {
            itemsWithPurchasedQuantity.put(item, 1);
            return;
        }

        Integer previouslyPurchasedQuantities = itemsWithPurchasedQuantity.get(item);
        itemsWithPurchasedQuantity.put(item, previouslyPurchasedQuantities + 1);
    }

    public Integer checkout() {
        final Integer[] totalPrice = { 0 };

        itemsWithPurchasedQuantity.forEach((item, purchasedQuantities) -> totalPrice[0] = totalPrice[0] + priceCalculator.getPrice(item, purchasedQuantities));
        return totalPrice[0];
    }
}
