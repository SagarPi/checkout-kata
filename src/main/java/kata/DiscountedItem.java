package kata;

public class DiscountedItem implements Discount {

    private final Item item;
    private final Integer eligibleQuantity;
    private final Integer discountedPrice;

    public DiscountedItem(Item item, Integer eligibleQuantity, Integer discountedPrice) {
        this.item = item;
        this.eligibleQuantity = eligibleQuantity;
        this.discountedPrice = discountedPrice;
    }

    public boolean isOn(Item item) {
        return this.item.equals(item);
    }

    @Override
    public Integer getPrice(Integer purchasedQuantities) {
        if(purchasedQuantities < eligibleQuantity)
            return item.getPrice() * purchasedQuantities;
        else if (purchasedQuantities.equals(eligibleQuantity))
            return discountedPrice;
        else {
            Integer multipleDiscountedPrices = discountedPrice * (purchasedQuantities / eligibleQuantity);
            Integer remainingNonDiscountedPrice = item.getPrice() * (purchasedQuantities % eligibleQuantity);
            return multipleDiscountedPrices + remainingNonDiscountedPrice;
        }
    }
}
