package kata;

public interface Discount {

    boolean isOn(Item item);

    Integer getPrice(Integer quantities);
}
