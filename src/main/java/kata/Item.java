package kata;

public enum Item {
    B(30), A(50), C(20), D(15);

    private final Integer price;

    Item(Integer price) {
        this.price = price;
    }

    public Integer getPrice(){
        return price;
    }
}
