/*
 * SWE 619 - Assignment 10
 * @author shaeqkhan
 * Point3Test.java
 */

package assignment10;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class Point3Test {

	Point3 x;
	Point2 y;
	Point3 z;

	@Before
	public void SetUp() {
		x = new Point3(7, 8, 9);
		y = new Point2(7, 8);
		z = new Point3(7, 8, 0);
	}

	// test for constructor
	@Test
	public void testConstructor() {
		assertEquals("7,8,9", x.toString());
		assertEquals("7,8", y.toString());
		assertEquals("7,8,0", z.toString());
	}

	// test for reflexivity
	@Test
	public void testEquals() {
		assertTrue(x.equals(x));
		assertTrue(y.equals(y));
		assertTrue(z.equals(z));
	}

	// test for equals - Point3 compared to Point2 in Point3's equals
	// and Point2 compared to Point3 in Point2's equal
	// check symmetry
	@Test
	public void testEquals1() {
		assertTrue(x.equals(y));
		assertTrue(y.equals(x));
	}

	// test for equals - Point2 compared to Point3 in Point2's equals
	// and Point3 compared to Point2 in Point3's equal
	// check symmetry
	@Test
	public void testEquals2() {
		assertTrue(y.equals(z));
		assertTrue(z.equals(y));
	}

	// test for equals - transitivity is violated because if
	// x==y and y==z then x==z but this is not the case
	@Test
	public void testEquals3() {
		assertFalse(x.equals(z));
	}

	// test for null references should return false
	@Test
	public void testNull() {
		assertFalse(x.equals(null));
		assertFalse(y.equals(null));
		assertFalse(z.equals(null));
	}

}