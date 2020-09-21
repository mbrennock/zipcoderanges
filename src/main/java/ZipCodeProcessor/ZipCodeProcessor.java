package ZipCodeProcessor;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static ZipCodeProcessor.ZipCodeRangeSet.mergeRows;

class ZipCodeProcessor {

    public static void main(String[] args){

        System.out.println("args: " + Arrays.toString(args));

        if(args.length != 1) {
            System.out.print("Incorrect parameters. Expected parameters are: zipcoderanges <input_file_name.csv>");
            return;
        }
        String filename = args[0];

        CSVReader reader = new CSVReader(filename);
        List<ZipCodeRange> input = reader.readFile();
        List<ZipCodeRange> output = mergeRows(input);

        try {
            FileWriter myWriter = new FileWriter(filename + "_out.csv");
            for(ZipCodeRange range : output) {
                myWriter.write(range.toCSVLine());

            }

            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }
}
