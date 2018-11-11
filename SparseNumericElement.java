package A1Q1;

public class SparseNumericElement {
	 private long index;
	    private double value;

	    public SparseNumericElement(long i, double v) throws IndexOutOfBoundsException {
	        if (i < 1) {
	            throw new IndexOutOfBoundsException("Negative index = " + i);
	        }
	        index = i;
	        value = v;
	    }

	    public long getIndex() { return index;};
	    public double getValue() { return value;};
	    public void setValue(double v) { value = v;};
}
