package kata;

import java.util.Set;

public class PriceCalculator {
    private final Set<SpecialPrice> specialPrices;

    public PriceCalculator() {
        specialPrices = Set.of(new DiscountedSpecialPrice(Item.A, 3, 130), new DiscountedSpecialPrice(Item.B, 2, 45));
    }

    public Integer getPrice(Item item, Integer quantities) {
        SpecialPrice price = specialPrices
                .stream()
                .filter(specialPrice -> specialPrice.isOn(item))
                .findFirst()
                .orElseGet(() -> new NoSpecialPrice(item));

        return price.getPrice(quantities);
    }
}
