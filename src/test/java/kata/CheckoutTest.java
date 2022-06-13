package kata;

import java.util.HashSet;

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
    void CheckoutShouldGivePriceWithoutDiscountWhenBuyingSingleItem() {
        Cart cart = new Cart();
        cart.buyItem(Item.A);
        Integer checkoutPriceForSingleItemA = cart.checkout();

        Assertions.assertThat(checkoutPriceForSingleItemA).isEqualTo(Item.A.getPrice());

        Cart anotherCart = new Cart();
        anotherCart.buyItem(Item.B);

        Integer checkoutPriceForSingleItemB = anotherCart.checkout();
        Assertions.assertThat(checkoutPriceForSingleItemB).isEqualTo(Item.B.getPrice());
    }

    @Test
    void CheckoutMultipleSingleItemsShouldReturnAdditionOfPriceOfEachItems() {
        HashSet<Item> allSingleItems = new HashSet<>();
        allSingleItems.add(Item.A);
        allSingleItems.add(Item.B);
        allSingleItems.add(Item.C);
        allSingleItems.add(Item.D);

        Cart cart = new Cart();
        allSingleItems.forEach(cart::buyItem);

        Integer estimatedPriceOfAllSingleItems = allSingleItems.stream().mapToInt(Item::getPrice).sum();
        Assertions.assertThat(cart.checkout()).isEqualTo(estimatedPriceOfAllSingleItems);
    }

}
