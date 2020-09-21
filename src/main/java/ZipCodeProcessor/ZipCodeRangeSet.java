package ZipCodeProcessor;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class ZipCodeRangeSet {

    public ZipCodeRangeSet() {
    }

    public static List<ZipCodeRange> mergeRows(List<ZipCodeRange> input){

        //pre-sort the data coming in to this method
        Collections.sort(input);

        List<ZipCodeRange> output = new ArrayList<ZipCodeRange>();

        Deque<ZipCodeRange> result = new ArrayDeque<ZipCodeRange>();
        for(ZipCodeRange range: input) {
            result.addLast(range);
        }

        //process the data in the queue until we've exhausted it
        while(result.size() > 1) {

            ZipCodeRange first = result.removeFirst();
            ZipCodeRange second = result.removeFirst();
            ZipCodeRange range;

            //base case: ranges don't intersect
            if(first.getUpperRange() + 1 < second.getLowerRange()) {
                output.add(first);
                result.addFirst(second);
            }

            //merge case 1: combine overlap
            //range 1:  (12000, 12030)
            //range 2:  (12015, 12045)
            //expected: (12015, 12045)
            else if(first.getUpperRange() >= second.getLowerRange() &&
               first.getUpperRange() <= second.getUpperRange()) {
                range = new ZipCodeRange(first.getLowerRange(), second.getUpperRange());
                result.addFirst(range);
            }
            //merge case 2: retain first
            //range 1:  (10000, 10150)
            //range 2:  (10001, 10100)
            //expected: (10000, 10150)
            else if( first.getUpperRange() >= second.getLowerRange() &&
                     first.getUpperRange() >= second.getUpperRange()) {
                range = new ZipCodeRange(first.getLowerRange(), first.getUpperRange());
                result.addFirst(range);
            }

        }

        output.add(result.getLast());

        return output;
    }


}
