package kata;

import java.util.Set;

public class PriceCalculator {
    private final Set<Price> pricePrice;

    public PriceCalculator() {
        pricePrice = Set.of(new DiscountedSpecialPrice(Item.A, 3, 130), new DiscountedSpecialPrice(Item.B, 2, 45));
    }

    public Integer getPrice(Item item, Integer quantities) {
        Price price = pricePrice
                .stream()
                .filter(priceOnItem -> priceOnItem.isOn(item))
                .findFirst()
                .orElseGet(() -> new NoSpecialPrice(item));

        return price.getPrice(quantities);
    }
}
