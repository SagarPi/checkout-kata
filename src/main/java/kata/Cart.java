package kata;

import java.util.HashMap;

public class Cart {

    private Item item;

    public void buyItem(Item item) {
        this.item = item;
    }

    public Integer checkout() {
        return item.getPrice();
    }
}
