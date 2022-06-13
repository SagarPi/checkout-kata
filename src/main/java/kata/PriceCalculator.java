package kata;

import java.util.Set;

public class PriceCalculator {
    private final Set<Discount> discountPrice;

    public PriceCalculator() {
        discountPrice = Set.of(new DiscountedItem(Item.A, 3, 130));
    }

    public Integer getPrice(Item item, Integer quantities) {
        Discount discount = discountPrice
                .stream()
                .filter(discountOnItem -> discountOnItem.isOn(item))
                .findFirst()
                .orElseGet(() -> new NoDiscount(item));

        return discount.getPrice(quantities);
    }
}
