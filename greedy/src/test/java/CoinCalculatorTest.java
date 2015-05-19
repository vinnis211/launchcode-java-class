import junit.framework.TestCase;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by omx on 5/18/2015.
 */
public class CoinCalculatorTest extends TestCase {

    @Test
    public void testEuroCoins() throws Exception {

        CoinCalculator coinCalculator = new CoinCalculator();
        int coinCount = coinCalculator.getCoinCount(3);
        assertEquals(4,coinCount);
    }

    }




