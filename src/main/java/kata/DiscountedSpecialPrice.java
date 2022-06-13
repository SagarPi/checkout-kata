package kata;

public class DiscountedSpecialPrice implements SpecialPrice {

    private final Item item;
    private final Integer eligibleQuantity;
    private final Integer discountedSpecialPrice;

    public DiscountedSpecialPrice(Item item, Integer eligibleQuantity, Integer discountedSpecialPrice) {
        this.item = item;
        this.eligibleQuantity = eligibleQuantity;
        this.discountedSpecialPrice = discountedSpecialPrice;
    }

    public boolean isOn(Item item) {
        return this.item.equals(item);
    }

    @Override
    public Integer getPrice(Integer purchasedQuantities) {
        if (purchasedQuantities < eligibleQuantity)
            return item.getPrice() * purchasedQuantities;

        Integer multipleDiscountedSpecialPrice = discountedSpecialPrice * (purchasedQuantities / eligibleQuantity);
        Integer remainingItemsPriceForNoSpecialPrice = item.getPrice() * (purchasedQuantities % eligibleQuantity);
        return multipleDiscountedSpecialPrice + remainingItemsPriceForNoSpecialPrice;
    }
}
