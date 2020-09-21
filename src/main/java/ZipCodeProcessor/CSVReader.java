package ZipCodeProcessor;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class CSVReader {

    private String filename;

    public CSVReader(String filename) {
        this.filename = filename;
    }

    public List<ZipCodeRange> readFile() {
        List<ZipCodeRange> result = new ArrayList<ZipCodeRange>();

        BufferedReader br = null;
        String line;

        try {
            br = new BufferedReader(new FileReader(filename));
            while ((line = br.readLine()) != null) {

                String[] zipCodes =  line.split(",");

                result.add(new ZipCodeRange(Integer.valueOf(zipCodes[0]), Integer.valueOf(zipCodes[1])));
            }
        }
        //ToDo: clean up this exception-handling code
        catch (FileNotFoundException e) {
            System.out.println("Error: unable to open file");
        }
        catch (IOException e) {
            System.out.println("UError: unable to process file");
        }
        finally {
            if(br != null) {
                try {
                    br.close();
                }
                catch (IOException e) {
                    System.out.println("Error: unable to close file");
                }
            }
        }

        return result;
    }
}
