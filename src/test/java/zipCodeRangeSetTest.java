import ZipCodeProcessor.CSVReader;
import ZipCodeProcessor.ZipCodeRange;
import ZipCodeProcessor.ZipCodeRangeSet;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class zipCodeRangeSetTest {


    @Test
    public void scenario_0_no_overlap() {

        //Setup - use reversed sorted data
        List<ZipCodeRange> input = new ArrayList<ZipCodeRange>();
        input.add(new ZipCodeRange(10000, 10100));
        input.add(new ZipCodeRange(10200, 10300));

        List<ZipCodeRange> expected = new ArrayList<ZipCodeRange>();
        expected.add(new ZipCodeRange(10000, 10100));
        expected.add(new ZipCodeRange(10200, 10300));

        //Execute
        List<ZipCodeRange> results = ZipCodeRangeSet.mergeRows(input);

        //Verify - data should be sorted
        assertEquals(expected, results);
    }

    @Test
    public void scenario_1_combine_overlap() {

        //Setup - use reversed sorted data
        List<ZipCodeRange> input = new ArrayList<ZipCodeRange>();
        input.add(new ZipCodeRange(12000, 12030));
        input.add(new ZipCodeRange(12015, 12045));

        List<ZipCodeRange> expected = new ArrayList<ZipCodeRange>();
        expected.add(new ZipCodeRange(12000, 12045));

        //Execute
        List<ZipCodeRange> results = ZipCodeRangeSet.mergeRows(input);

        //Verify - data should be sorted
        assertEquals(expected, results);
    }


    @Test
    public void scenario_2_retain_first() {

        //Setup - use reversed sorted data
        List<ZipCodeRange> input = new ArrayList<ZipCodeRange>();
        input.add(new ZipCodeRange(10000, 10150));
        input.add(new ZipCodeRange(10001, 10100));

        List<ZipCodeRange> expected = new ArrayList<ZipCodeRange>();
        expected.add(new ZipCodeRange(10000, 10150));

        //Execute
        List<ZipCodeRange> results = ZipCodeRangeSet.mergeRows(input);

        //Verify - data should be sorted
        assertEquals(expected, results);
    }

    @Test
    public void scenario_3_composite_input() {

        //Setup - use reversed sorted data
        List<ZipCodeRange> input = new ArrayList<ZipCodeRange>();
        input.add(new ZipCodeRange(10000, 10150));
        input.add(new ZipCodeRange(10001, 10100));
        input.add(new ZipCodeRange(10101, 10175));

        List<ZipCodeRange> expected = new ArrayList<ZipCodeRange>();
        expected.add(new ZipCodeRange(10000, 10175));

        //Execute
        List<ZipCodeRange> results = ZipCodeRangeSet.mergeRows(input);

        //Verify - data should be sorted
        assertEquals(expected, results);
    }



    @Test
    public void scenario_4_edge_case() {

        //Setup - use reversed sorted data
        List<ZipCodeRange> input = new ArrayList<ZipCodeRange>();
        input.add(new ZipCodeRange(10000, 10100));
        input.add(new ZipCodeRange(10100, 10200));

        List<ZipCodeRange> expected = new ArrayList<ZipCodeRange>();
        expected.add(new ZipCodeRange(10000, 10200));

        //Execute
        List<ZipCodeRange> results = ZipCodeRangeSet.mergeRows(input);

        //Verify - data should be sorted
        assertEquals(expected, results);
    }

    @Test
    public void test_file_2() {

        //Setup - use reversed sorted data
        CSVReader reader = new CSVReader("src/test/resources/data2.csv");

        List<ZipCodeRange> expected = new ArrayList<ZipCodeRange>();
        expected.add(new ZipCodeRange(10000, 10175));
        expected.add(new ZipCodeRange(12000, 12045));

        //Execute
        List<ZipCodeRange> results = reader.readFile();
        results = ZipCodeRangeSet.mergeRows(results);

        //Verify - data should be sorted
        assertEquals(expected, results);
    }
}
