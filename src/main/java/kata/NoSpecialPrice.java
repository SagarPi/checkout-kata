package kata;

public class NoSpecialPrice implements SpecialPrice {

    private final Item item;

    public NoSpecialPrice(Item item) {
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
