/*
 * SWE 619
 * Assignment 5 - test for IntSet.java
 * @author shaeq
 */

package assignment5;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestIntSet {

    //test constructor
    @Test
    public void testConst() {
        IntSet s = new IntSet();
        assertEquals("IntSet:{}",s.toString());        
    }

    //test insert element
    @Test
    public void testInsert(){
        IntSet s = new IntSet();
        s.insert(2);
        s.insert(33);
        assertEquals("IntSet:{2,33,}", s.toString());
    }

    //test insert duplicate elements
    @Test
    public void testInsert1(){
        IntSet s = new IntSet();
        s.insert(3);
        s.insert(3);
        assertEquals("IntSet:{3,}", s.toString());
    }

    //test insert for negative integers
    @Test
    public void testInsert2(){
        IntSet s = new IntSet();
        s.insert(-3);
        s.insert(3);
        assertEquals("IntSet:{-3,3,}", s.toString());
    }

    //test remove element
    @Test
    public void testRemove(){
        IntSet s = new IntSet();
        s.insert(3);
        s.remove(3);
        assertEquals("IntSet:{}", s.toString());
    }

    //test remove non-existing element
    @Test
    public void testRemove1(){
        IntSet s = new IntSet();
        s.insert(3);
        s.remove(4);
        assertEquals("IntSet:{3,}", s.toString());
    }

    //test isIn
    @Test
    public void testIsIn(){
        IntSet s = new IntSet();
        s.insert(3);
        assertEquals(true, s.isIn(3));
    }

    //test size
    @Test
    public void testSize(){
    	IntSet s = new IntSet();
        s.insert(3); s.insert(4); s.insert(5); s.insert(6);
        assertEquals(4, s.size());
    }

    //test choose
    @Test
    public void testChoose(){
        IntSet s = new IntSet();
        s.insert(3); s.insert(4); s.insert(5); s.insert(6);
        assertEquals(6, s.choose());
    }

    //test choose with IndexOutOfBoundsException
    @Test (expected = IndexOutOfBoundsException.class)
    public void testChoose1(){
        IntSet s = new IntSet();
        int i = s.choose();
    }

}    