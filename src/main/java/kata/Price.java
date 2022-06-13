package kata;

public interface Price {

    boolean isOn(Item item);

    Integer getPrice(Integer quantities);
}
