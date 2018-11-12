package A1Q1;

import static org.junit.Assert.*;

import org.junit.Test;

public class A1Q1test {

	@Test
	public void testException_1() {
        SparseNumericVector X = new SparseNumericVector();
        try {
        	 X.add(new SparseNumericElement(150000, 3.1415));
             X.add(new SparseNumericElement(15, 3));
             X.add(new SparseNumericElement(1500, 3.14));
             X.add(new SparseNumericElement(15, 4));
		} catch (UnsupportedOperationException e) {

		}
	}
	
	@Test (expected = UnsupportedOperationException.class)
	public void testException_2() {
		SparseNumericVector X = new SparseNumericVector();
		X.add(new SparseNumericElement(150000, 3.1415));
		X.add(new SparseNumericElement(15, 3));
		X.add(new SparseNumericElement(1500, 3.14));
		X.add(new SparseNumericElement(2, 0));
	}
	
	@Test
	public void testException_3() {
		SparseNumericVector X = new SparseNumericVector();
		X.remove((long) 1);
	}
	
	@Test
	public void testRemove_3() {
		SparseNumericVector X = new SparseNumericVector();
		X.add(new SparseNumericElement(141, 3.1415));
		SparseNumericVector E = new SparseNumericVector();
		E.add(new SparseNumericElement(14, 3.1415));
		E.add(new SparseNumericElement(141, 3.1415));
		E.remove((long) 14);
		assertEquals(E.toString(), X.toString());
		 
	}
	
	@Test
	public void testRemove_4() {
		SparseNumericVector X = new SparseNumericVector();
		SparseNumericVector E1 = new SparseNumericVector();
		SparseNumericVector E2 = new SparseNumericVector();
		SparseNumericVector E3 = new SparseNumericVector();
		SparseNumericVector E4 = new SparseNumericVector();
		SparseNumericVector E5 = new SparseNumericVector();
		SparseNumericVector E6 = new SparseNumericVector();
		SparseNumericVector E7 = new SparseNumericVector();

		X.add(new SparseNumericElement(141, 3.1415));
		X.add(new SparseNumericElement(124, 3));
		X.add(new SparseNumericElement(135, 3.14));
		X.add(new SparseNumericElement(193, 3.1415));
		X.add(new SparseNumericElement(163, 3));
		X.add(new SparseNumericElement(111, 3.14));
		X.add(new SparseNumericElement(222, 3.12));
		
		X.remove((long)141);
		E1.add(new SparseNumericElement(124, 3));
		E1.add(new SparseNumericElement(135, 3.14));
		E1.add(new SparseNumericElement(193, 3.1415));
		E1.add(new SparseNumericElement(163, 3));
		E1.add(new SparseNumericElement(111, 3.14));
		E1.add(new SparseNumericElement(222, 3.12));
		assertEquals(E1.toString(), X.toString());

		X.remove((long)124);
		E2.add(new SparseNumericElement(135, 3.14));
		E2.add(new SparseNumericElement(193, 3.1415));
		E2.add(new SparseNumericElement(163, 3));
		E2.add(new SparseNumericElement(111, 3.14));
		E2.add(new SparseNumericElement(222, 3.12));
		assertEquals(E2.toString(), X.toString());

		X.remove((long)135);
		E3.add(new SparseNumericElement(193, 3.1415));
		E3.add(new SparseNumericElement(163, 3));
		E3.add(new SparseNumericElement(111, 3.14));
		E3.add(new SparseNumericElement(222, 3.12));
		assertEquals(E3.toString(), X.toString());

		X.remove((long)193);
		E4.add(new SparseNumericElement(163, 3));
		E4.add(new SparseNumericElement(111, 3.14));
		E4.add(new SparseNumericElement(222, 3.12));
		assertEquals(E4.toString(), X.toString());

		X.remove((long)163);
		E5.add(new SparseNumericElement(111, 3.14));
		E5.add(new SparseNumericElement(222, 3.12));
		assertEquals(E5.toString(), X.toString());

		assertTrue(X.remove((long)111));

		X.remove((long)222);
		assertEquals(E7.toString(), X.toString());

		assertFalse(X.remove((long)222));
		
	}
	@Test
	public void testDot_5() {
		SparseNumericVector X = new SparseNumericVector();
		X.add(new SparseNumericElement(141, 3.1415));
		X.add(new SparseNumericElement(124, 3));
		X.add(new SparseNumericElement(135, 3.14));
		X.add(new SparseNumericElement(193, 3.1415));
		X.add(new SparseNumericElement(163, 3));
		
		SparseNumericVector Y = new SparseNumericVector();
		Y.add(new SparseNumericElement(141, 1));
		Y.add(new SparseNumericElement(124, 3));
		Y.add(new SparseNumericElement(135, 3));
		Y.add(new SparseNumericElement(193, 1));
		Y.add(new SparseNumericElement(163, 5));
		
		assertEquals(39.703, X.dot(Y), 0.001);
		
		

	}

}
