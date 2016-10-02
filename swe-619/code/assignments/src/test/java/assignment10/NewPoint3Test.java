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

public class NewPoint3Test {

	NewPoint3 a;
	Point2 b;
	NewPoint3 c;

	@Before
	public void SetUp() {
		a = new NewPoint3(7, 8, 9);
		b = new Point2(7, 8);
		c = new NewPoint3(7, 8, 0);
	}

	// test for constructor
	@Test
	public void testConstructor() {
		assertEquals("7,8,9", a.toString());
		assertEquals("7,8", b.toString());
		assertEquals("7,8,0", c.toString());
	}

	// test for reflexivity
	@Test
	public void testEquals() {
		assertTrue(a.equals(a));
		assertTrue(b.equals(b));
		assertTrue(c.equals(c));
	}

	// test for equals - NewPoint3 complared to Point2 in NewPoint3's equals
	// should return false because Point2 is not an instance of NewPoint3
	// check symmetry
	@Test
	public void testEquals1() {
		assertFalse(a.equals(b));
		assertFalse(b.equals(a));
	}

	// test for equals - Point2 compared to NewPoint3 in Point2's equals
	// should return false because NewPoint3 is not an instance of Point2
	// check symmetry
	@Test
	public void testEquals2() {
		assertFalse(b.equals(c));
		assertFalse(c.equals(b));
	}

	// test for equals - transitivity is maintained
	@Test
	public void testEquals3() {
		assertFalse(a.equals(c));
		assertFalse(c.equals(a));
	}

	// test for null references should return false
	@Test
	public void testNull() {
		assertFalse(a.equals(null));
		assertFalse(b.equals(null));
		assertFalse(c.equals(null));
	}

}
