import junit.framework.TestCase;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by omx on 5/18/2015.
 */
public class CoinCalculatorTest extends TestCase {

    @Test
    public void testGetValidChange() throws Exception {

            CoinCalculator coinCalculator = new CoinCalculator();
            int changeTest = coinCalculator.getValidChange();
            assertEquals(0,changeTest);
        }

    }


