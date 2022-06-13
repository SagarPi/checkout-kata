package kata;

import java.util.HashMap;

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

        Assertions.assertThat(checkoutPriceForSingleItemA).isEqualTo(50);

        Cart anotherCart = new Cart();
        anotherCart.buyItem(Item.B);

        Integer checkoutPriceForSingleItemB = anotherCart.checkout();
        Assertions.assertThat(checkoutPriceForSingleItemB).isEqualTo(30);
    }

}
