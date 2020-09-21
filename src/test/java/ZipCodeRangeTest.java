import ZipCodeProcessor.ZipCodeRange;
import org.junit.*;

import static junit.framework.TestCase.assertEquals;

public class ZipCodeRangeTest {

    @Test
    public void test1() {

        //A control test to make sure we can create a proper ZipCodeProcessor.ZipCodeRange object
        ZipCodeRange range = new ZipCodeRange(10000, 10100);
        assertEquals(new Integer(10000), range.getLowerRange());
        assertEquals(new Integer(10100), range.getUpperRange());
    }

}
