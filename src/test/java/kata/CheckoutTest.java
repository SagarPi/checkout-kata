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

    private final HashMap<Item, Integer> priceList;

    public CheckoutTest() {
        priceList = new HashMap<>();
        priceList.put(Item.A, 50);
    }

    @Test
    void CheckoutShouldGivePriceWithoutDiscountWhenBuyingSingleItem() {
        Market market = new Market(priceList);
        market.buyItem(Item.A);
        Integer checkoutPrice = market.checkout();

        Assertions.assertThat(checkoutPrice).isEqualTo(50);
    }
}
