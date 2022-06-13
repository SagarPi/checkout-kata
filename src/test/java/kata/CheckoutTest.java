package kata;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import com.github.larseckart.tcr.CommitOnGreenExtension;

@ExtendWith(CommitOnGreenExtension.class)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class CheckoutTest {
    @Test
    void checkoutShouldGivePriceWithoutDiscountWhenBuyingSingleItem() {
        Cart cart = new Cart();
        cart.addItem(Item.A);
        Integer checkoutPriceForSingleItemA = cart.checkout();

        Assertions.assertThat(checkoutPriceForSingleItemA).isEqualTo(Item.A.getPrice());

        Cart anotherCart = new Cart();
        anotherCart.addItem(Item.B);

        Integer checkoutPriceForSingleItemB = anotherCart.checkout();
        Assertions.assertThat(checkoutPriceForSingleItemB).isEqualTo(Item.B.getPrice());
    }

    @Test
    void checkoutMultipleSingleItemsShouldReturnAdditionOfPriceOfEachItems() {
        Set<Item> allSingleItems = Set.of(Item.A, Item.B, Item.C, Item.D);

        Cart cart = new Cart();
        allSingleItems.forEach(cart::addItem);

        Integer estimatedPriceOfAllSingleItems = allSingleItems.stream().mapToInt(Item::getPrice).sum();
        Assertions.assertThat(cart.checkout()).isEqualTo(estimatedPriceOfAllSingleItems);
    }

    @Test
    void shouldCalculatePriceOfMultipleItemAsPerDiscountedRate() {
        List<Item> items = Arrays.asList(Item.A, Item.A, Item.A);

        Cart cart = new Cart();
        items.forEach(cart::addItem);

        Assertions.assertThat(cart.checkout()).isEqualTo(130);

        items = Arrays.asList(Item.A, Item.A, Item.A, Item.A, Item.A, Item.A, Item.A, Item.B, Item.B, Item.B, Item.D, Item.C);

        Cart anotherCart = new Cart();
        items.forEach(anotherCart::addItem);

        Assertions.assertThat(anotherCart.checkout()).isEqualTo(420);
    }

}
