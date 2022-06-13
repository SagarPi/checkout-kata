package kata;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private final List<Item> items = new ArrayList<>();

    public void buyItem(Item item) {
        items.add(item);
    }

    public Integer checkout() {
        return items.stream().mapToInt(Item::getPrice).sum();
    }
}
