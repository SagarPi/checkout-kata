package kata;

import java.util.HashMap;

public class Market {

    private Item item;
    private HashMap<Item, Integer> priceList;

    public Market(HashMap<Item, Integer> priceList) {

        this.priceList = priceList;
    }

    public void buyItem(Item item) {
        this.item = item;
    }

    public Integer checkout() {
        return priceList.get(item);
    }
}
