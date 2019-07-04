package assignment4;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class LineTest {

	@Test
	void testGetSlope() {
		double x0 = Math.random();
		double x1 = Math.random();
		double y0 = Math.random();
		double y1 = Math.random();
		
		Line testLine = new Line(x0, y0, x1, y1);
		double val = testLine.getSlope();
		double val2 = (x1 - x0 ) / (y1 - y0);
		
		assertTrue(val - val2 <= .0001);
	}

	@Test
	void testGetDistance() {
		double x0 = Math.random();
		double x1 = Math.random();
		double y0 = Math.random();
		double y1 = Math.random();
		
		Line testLine = new Line(x0, y0, x1, y1);
		double val = testLine.getDistance();
		double val2 = Math.sqrt((x1 - x0) * (x1 - x0) + (y1 - y0) * (y1 - y0));
		assertTrue(val - val2 <= .001);
	}

	@Test
	void testParallelTo() {
		double x0 = Math.random();
		double x1 = Math.random();
		double y0 = Math.random();
		double y1 = Math.random();
		double X1 = Math.random();
		double X2 = Math.random();
		double Y1 = Math.random();
		double Y2 = Math.random();
		
		Line testLine = new Line(x0, y0, x1, y1);
		Line testLine2 = new Line( X1, Y1, X2, Y2);
		boolean case1 = testLine.parallelTo(testLine2);
		double val1 = testLine.getSlope();
		double val2 = testLine2.getSlope();
		boolean case2 = val1 - val2 <= .001;
		assertTrue(case1 == case2);
	}

}