/*
 * Author - Shaeq Khan
 * Description - coded as per requirements in assignment problem statement
 * 
 * Assignment#2 - Due 12th Sept 2012, 16:30 
 * Course - SWE 619 OO Software Specification and Construction
 * Professor - Dr. Paul Ammann
 * GTA - Ehsan Kouroshfar
 */

package assignment2;

import org.junit.*;

import assignment2.FindDupB;

import static org.junit.Assert.*;

public class FindDupTestB {
      
    /*
     * Test cases for findDup method, of class FindDupB.
     */
    int[] a;
    int[] b;    
    
    @Before
    public void runBeforeEachTest(){
        
    }
    
    @After
    public void runAfterEachTest(){
        a = null;
        b = null;
    }
    
    /*
     * Test case #1 - When the arrays have one common element in a
     * unique position
     */
    @Test
    public void testDuplicate() {
        System.out.println("testDuplicate()");
        int a[] = {7,13,6};
        int b[] = {5,13,5};
        assertEquals(1, FindDupB.findDup(a, b));
        System.out.println("Match on index 1, test case succesful \n");
    }
    
    /*
     * Test case #2 - When the arrays are null
     */
    @Test(expected = NullPointerException.class)
    public void testNullArrays(){
        System.out.println("testNullArrays()");
        int[] a = null;
        int[] b = null;        
        FindDupB.findDup(a, b);
    }
    
    /*
     * Test case #3 - When there is no common element in the array
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testNoCommonElement(){
        System.out.println("testNoCommonElement()");
        int[] a = {7,13,2};
        int[] b = {2,1,5};       
        FindDupB.findDup(a, b);               
    }   
}
