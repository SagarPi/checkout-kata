package kata;

import com.github.larseckart.tcr.CommitOnGreenExtension;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(CommitOnGreenExtension.class)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class CheckoutTest {

    @Test
    void start_here() {

    }
}
