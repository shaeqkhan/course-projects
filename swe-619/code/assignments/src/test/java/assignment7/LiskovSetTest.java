/**
 * SWE 619 - Assignment 7
 * LiskovSetTest.java
 * @author shaeqkhan
 */

package assignment7;

import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;

public class LiskovSetTest {

    LiskovSet<Object> s1;
	LiskovSet<Object> s2;
	LiskovSet empty;

    @Before
	public void SetUp(){
		s1 = new LiskovSet<Object>();
		s2 = new LiskovSet<Object>();
		empty = new LiskovSet();
	}

    //test for constructor
	@Test
	public void testConstructor() {
    	assertEquals("{ }", s1.toString());
    	assertEquals("{ }", s2.toString());
    	assertEquals("{ }", empty.toString());
	}

	//test for inserting null in this
	@Test
	public void testInsertNull(){
		try{
			s1.insert(null);
		} catch(NullPointerException npe){
			return;
		}
		fail("Expected NullPointerException");
	}

	//test for inserting objects in this
	@Test
	public void testInsert1(){
		s1.insert(new String("apple")); s1.insert(new Float(33.03)); 
		s1.insert(new Integer(33)); s1.insert(new Boolean(false));
		assertEquals("{ apple 33.03 33 false }",s1.toString());
	}

	//test for inserting other LiskovSet in this
	@Test
	public void testInsert2(){
		s1.insert(new String("grapes"));
		s2.insert(new String("watermelon")); s2.insert(new Integer(33));
		s1.insert(s2);
		s1.insert(new Boolean(true));
		assertEquals("{ grapes { watermelon 33 } true }", s1.toString());
	}

	//test for inserting duplicates
	@Test
	public void testInsert3(){
		s1.insert(new Integer(33)); s1.insert(new Integer(33));
		assertEquals("{ 33 }", s1.toString());
	}

	//test to remove element from this
	@Test
	public void testRemove(){
		s1.insert(new Integer(33)); s1.remove(new Integer(33));
		assertEquals("{ }", s1.toString());
	}

	//test to remove null from this
	@Test
	public void testRemove1(){
		s1.remove(null);
		assertEquals("{ }", s1.toString());
	}

	//test for element in this
	@Test
	public void testIsInTrue(){
		s1.insert(new Integer(-33));
		assertTrue(s1.isIn(new Integer(-33)));
	}

	//test for element not in this
	@Test
	public void testIsInFalse(){
		assertFalse(s1.isIn(0));
	}
	
	//test to check a set of integers as subset of this
    @Test
    public void testSubset1(){
        s1.insert(1); s1.insert(2); s1.insert(3); s1.insert(4);
        s2.insert(4); s2.insert(3);
        assertTrue(s2.subset(s1));
    }
	
	//test to check if a LiskovSet is a subset of this
	@Test
	public void testSubset2(){
		s1.insert(new Integer(1)); s1.insert(new Boolean(true)); 
		s1.insert(new String("apples"));
		s2.insert(new Boolean(true)); s2.insert(new String("apples"));
		assertTrue(s2.subset(s1));
	}

	//test to check nested LiskovSet is a subset of this
	@Test
	public void testSubset3(){
		empty.insert("nothing"); empty.insert("here");
        s1.insert(new String("grapes")); s1.insert(new Integer(33)); 
        s1.insert(new Boolean(true)); s1.insert(empty);
        s2.insert(new String("grapes")); s2.insert(empty);
        assertTrue(s2.subset(s1));
	}
	
	//test to show when LiskovSet is not a subset of this
	@Test
    public void testSubset4(){
        s1.insert(3);
        empty.insert("zero");
        assertFalse(empty.subset(s1));
    }

}