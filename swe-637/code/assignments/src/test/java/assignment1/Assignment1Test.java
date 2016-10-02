/**
 * SWE 637 Assignment 1 test class
 *
 * @author shaeqkhan
 * @lastmodified feb 4,2013
 */

package assignment1;

import java.util.Collection;
import java.util.Vector;
import org.junit.*;
import static org.junit.Assert.*;

public class Assignment1Test {

    Vector a = new Vector();
    Vector b = new Vector();

    /*
     * Test case 1
     * Vectors are ordered lists which makes the union method unsymmetric.
     * Call to union with the same vectors in any order should return back
     * the same union Vector of objects.
     * Following test case fails because
     * union(a,b) = [3, string1, 33]
     * union(b,a) = [string1, 33, 3]
     * union(a,b)!= union(b,a)
     * This test case fails
     */
    @Test
    public void test1(){
        a.add(3); a.add("string1");
        b.add("string1");b.add(33);
        assertEquals(Assignment1.union(a,b).toString(), "[3, string1, 33]");
        assertEquals(Assignment1.union(b,a).toString(), "[3, string1, 33]");
    }

    /*
     * Test case 2
     * Current implementation does not take care of duplicates stored in the
     * first vector of the argument i.e. in this case it is 'a'
     * For eg. if we add the integer 3 twice to the Vector a and add it to
     * Vector b, the union of the two vectors should be [3] but it's not.
     * a = [3, 3]
     * b = [3]
     * union(a,b) != [3]
     * but
     * union(b,a) = [3]
     * This test case fails
     */
    @Test
    public void test2(){
        a.add(3); a.add(3);
        b.add(3);        
        assertEquals(Assignment1.union(a,b).toString(), "[3]");
    }

    /*
     * Test case 3
     * Loss of precision in double while calculating the union
     * For example, if Vectors a and b are
     * a = [3.0]
     * b = [3.00]
     * then union(a,b) = [3.0]
     * when ideally it should be calculated as
     * union(a,b) = [3.0, 3.00]
     */
    @Test
    public void test3(){
        a.add(3.0);
        b.add(3.00);
        assertEquals(Assignment1.union(a,b).toString(), "[3.0, 3.00]");
    }

}