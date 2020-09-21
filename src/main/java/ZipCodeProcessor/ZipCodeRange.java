package ZipCodeProcessor;

public class ZipCodeRange implements Comparable<ZipCodeRange> {

    private final Integer lowerRange;
    private final Integer upperRange;

    public ZipCodeRange(Integer lower, Integer upper) {
        this.lowerRange = lower;
        this.upperRange = upper;
    }

    public Integer getLowerRange() {
        return lowerRange;
    }

    public Integer getUpperRange() {
        return upperRange;
    }

    @Override
    public String toString() {
        return "ZipCodeProcessor.ZipCodeRange{" +
                "lowerRange=" + lowerRange +
                ", upperRange=" + upperRange +
                '}';
    }

    public String toCSVLine() {
        return lowerRange +"," + upperRange + "\n";
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ZipCodeRange)) return false;
        ZipCodeRange that = (ZipCodeRange) o;
        return getLowerRange().equals(that.getLowerRange()) &&
                getUpperRange().equals(that.getUpperRange());
    }

    @Override
    public int hashCode() {
        int prime = 71;
        int result = prime;
        result = prime * result + getLowerRange();
        result = prime * result + getUpperRange();
        return result;
    }

//    @Override
    public int compareTo(ZipCodeRange zipCodeRange) {
        return this.getLowerRange().compareTo(zipCodeRange.getLowerRange());
    }
}
