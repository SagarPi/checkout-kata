package kata;

public class NoDiscount implements Discount {

    private final Item item;

    public NoDiscount(Item item) {
        this.item = item;
    }

    @Override
    public boolean isOn(Item item) {
        return this.item.equals(item);
    }

    @Override
    public Integer getPrice(Integer quantities) {
        return item.getPrice() * quantities;
    }
}
