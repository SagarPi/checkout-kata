package kata;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class DiscountedItemTest {

    @Test
    void shouldNotAddDiscountOnTotalPriceIfPurchasedQuantitiesIsLessThanEligibleQuantityForDiscount() {
        Integer totalPrice = new DiscountedItem(Item.A, 2, 10).getPrice(1);

        Assertions.assertThat(totalPrice).isEqualTo(Item.A.getPrice());

        Integer anotherTotalPrice = new DiscountedItem(Item.A, 5, 100).getPrice(3);
        Assertions.assertThat(anotherTotalPrice).isEqualTo(Item.A.getPrice() * 3);
    }

    @Test
    void shouldGetDiscountedPriceOnTotalPriceIfPurchasedQuantitiesEqualsEligibleQuantityForDiscount() {
        Integer totalPrice = new DiscountedItem(Item.A, 2, 10).getPrice(2);

        Assertions.assertThat(totalPrice).isEqualTo(10);
    }

    @Test
    void shouldReturnDiscountedPriceWithEachItemsPriceIfPurchasedQuantityIsMoreThanEligibleQuantityForDiscount() {
        Integer totalPrice = new DiscountedItem(Item.A, 2, 10).getPrice(3);
        Assertions.assertThat(totalPrice).isEqualTo(10 + Item.A.getPrice());

        Integer anotherTotalPrice = new DiscountedItem(Item.A, 3, 10).getPrice(11);
        Assertions.assertThat(anotherTotalPrice).isEqualTo((10*3) + (2*Item.A.getPrice()));
    }
}