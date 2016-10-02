/**
 * SWE 637 Software Testing
 * Assignment 9
 * @SetTest.java
 *
 *
 * @author skhan27
 */

package assignment9;
/*
 * IDM based on JavaDoc API for Set
 * The three methods tested are add(E e), isEmpty(), removeAll(Collection<?> c)
 * Characteristics identified are
 * C1 T - element is added to the set
 * C2 T - set is empty
 * C3 T - asymmetric set difference calculated
 * C4 T - removeAll is supported by this
 * C5 T - Class of element in this is compatible
 * C6 T - Set does not contain any null elements
 *
 */

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

public class SetTest {

   /*
    * 5 tests for method add(E e)
    * Characteristics associated with add method are C1, C4, C5, C6
    */

    @Test
    /**
     * add(E e): Test 1
     * Characteristics and Test Frames: C1-T, C4-T, C5-T, C6-T	 
     */
    public void testAdd1()
    {
        HashSet set = new HashSet();
        assertTrue(set.add("this"));
    }

    @Test
    /*
     * add(E e): Test 2
     * Characteristics and Test Frames: C1-F, C4-T, C5-T, C6-T
     */
    public void testAdd2(){
        HashSet set = new HashSet();
        set.add("this");
        assertFalse(set.add("this"));
    }

    @Test(expected=UnsupportedOperationException.class)
    /*
     * add(E e): Test 3
     * Characteristics and Test Frames: C1-F, C4-F, C5-T, C6-T
     */
     public void testAdd3(){
        Set set = new HashSet();
        Set newSet = Collections.unmodifiableSet(set);
        newSet.add("this");
    }

    @Test(expected=ClassCastException.class)
    /*
     * add(E e): Test 4
     * Characteristics and Test Frames: C1-F, C4-T, C5-F, C6-T
     */
    public void testAdd4(){
        Set set = new TreeSet();
        set.add("A");
        set.add(3.0);
    }

    @Test(expected=NullPointerException.class)
    /*
     * add(E e): Test 5
     * Characteristics and Test Frames: C1-F, C4-T, C5-T, C6-F
     */
     public void testAdd5(){
        HashSet set = null;
        set.add("this");
    }

    /*
     * 2 tests for method isEmpty()
     * Characteristics associated with add method is C2
     */

    @Test
    /*
     * isEmpty(): Test 1
     * Characteristics and Test Frames: C2-T
     */
    public void testEmpty1(){
        HashSet set = new HashSet();
        assertTrue(set.isEmpty());
    }

    @Test
    /*
     * isEmpty(): Test 2
     * Characteristics and Test Frames: C2-F
     */
    public void testEmpty2(){
        HashSet set = new HashSet();
        set.add("this");
        assertFalse(set.isEmpty());
    }

    /*
     * 5 tests for method removeAll(Collection<?> c)
     * Characteristics associated with add method are C3, C4, C5, C6
     */

    @Test
    /**
     * removeAll(Collection<?> c): Test 1
     * Characteristics and Test Frames: C3-T, C4-T, C5-T, C6-T
     */
    public void testRemoveAll1()
    {
        HashSet set1 = new HashSet();
        set1.add("this");
        set1.add(3);
        set1.add(2.0);

        HashSet set2 = new HashSet();
        set2.add("this");
        set2.add(3);
        set2.add(5.0);

        set1.removeAll(set2);

        assertTrue(set1.contains(2.0));

    }

     @Test
    /**
     * removeAll(Collection<?> c): Test 2
     * Characteristics and Test Frames: C3-F, C4-T, C5-T, C6-T
     */
     public void testRemoveAll2(){
         HashSet set1 = new HashSet();
        set1.add("this");
        set1.add(3);

        HashSet set2 = new HashSet();
        set2.add("that");
        set2.add(5.0);

        assertFalse(set1.removeAll(set2));
     }

      @Test(expected=UnsupportedOperationException.class)
     /**
      * removeAll(Collection<?> c): Test 3
      * Characteristics and Test Frames: C3-F, C4-F, C5-T, C6-T
      */
      public void testRemoveAll3(){
          HashSet hset = new HashSet();
          HashSet newHSet = new HashSet();
          newHSet.add("this");
          Set set = Collections.unmodifiableSet(hset);
          set.removeAll(newHSet);
      }

      @Test(expected=ClassCastException.class)
     /**
      * removeAll(Collection<?> c): Test 4
      * Characteristics and Test Frames: C3-F, C4-T, C5-F, C6-T
      */
      public void testRemoveAll4(){
          Set set1 = new TreeSet();
          Set set2 = new HashSet();
          set1.add("A"); set1.add("B");
          set2.add(3.0); set2.add(4.0);
          set2.removeAll(set1);
      }

      @Test(expected=NullPointerException.class)
     /**
      * removeAll(Collection<?> c): Test 5
      * Characteristics and Test Frames: C3-F, C4-T, C5-T, C6-F
      */
      public void testRemoveAll5(){
            HashSet set1 = new HashSet();
            set1.add("A");
            HashSet set2 = null;
            set1.removeAll(set2);

      }

}