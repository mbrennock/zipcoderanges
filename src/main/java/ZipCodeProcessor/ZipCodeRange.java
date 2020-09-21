package ZipCodeProcessor;

public class ZipCodeRange implements Comparable<ZipCodeRange> {

    private Integer lowerRange;
    private Integer upperRange;

    static Integer MIN_ZIP = 0;
    static Integer MAX_ZIP = 99999;

    public ZipCodeRange(Integer lower, Integer upper) {
        this.lowerRange = lower;
        this.upperRange = upper;
    }

    public Integer getLowerRange() {
        return lowerRange;
    }

    public void setLowerRange(Integer lowerRange) {
        this.lowerRange = lowerRange;
    }

    public Integer getUpperRange() {
        return upperRange;
    }

    public void setUpperRange(Integer upperRange) {
        this.upperRange = upperRange;
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
