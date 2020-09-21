import ZipCodeProcessor.CSVReader;
import ZipCodeProcessor.ZipCodeRange;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class CSVReaderTest {

    @Test
    public void readFile1Test(){

        //Setup
        CSVReader reader = new CSVReader("src/test/resources/data1.csv");
        List <ZipCodeRange> expected = new ArrayList<ZipCodeRange>();
        expected.add(new ZipCodeRange(94133, 94133));
        expected.add(new ZipCodeRange(94200, 94299));
        expected.add(new ZipCodeRange(94600, 94699));

        //Execute
        List<ZipCodeRange> results = reader.readFile();

        //Verify
        assertEquals(expected, results);
    }



    @Test
    public void readFile2Test(){

        //Setup
        CSVReader reader = new CSVReader("src/test/resources/data2.csv");
        List <ZipCodeRange> expected = new ArrayList<ZipCodeRange>();
        expected.add(new ZipCodeRange(10000, 10150));
        expected.add(new ZipCodeRange(10001, 10100));
        expected.add(new ZipCodeRange(10101, 10175));
        expected.add(new ZipCodeRange(12000, 12030));
        expected.add(new ZipCodeRange(12015, 12045));

        //Execute
        List<ZipCodeRange> results = reader.readFile();

        //Verify
        assertEquals(expected, results);
    }
}
