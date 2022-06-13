package kata;

public interface SpecialPrice {

    boolean isOn(Item item);

    Integer getPrice(Integer quantities);
}
