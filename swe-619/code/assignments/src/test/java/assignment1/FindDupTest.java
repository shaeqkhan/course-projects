/*
 * Author - Shaeq Khan
 * Description - test class for the class FindDup.java
 * 
 * Assignment#1 - Due 5th Sept 2012, 16:30 
 * Course - SWE 619 OO Software Specification and Construction
 * Professor - Dr. Paul Ammann
 * GTA - Ehsan Kouroshfar 
 */

package assignment1;

import org.junit.*;

import assignment1.FindDup;

import static org.junit.Assert.*;

public class FindDupTest {
      
    /*
     * Test cases for findDup method, of class FindDup.
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
     * Test case #1 - When the arrays have only one common element in a
     * unique position
     */
    @Test
    public void testOneDuplicate() {
        System.out.println("testOneDuplicate()");
        int a[] = {7,13,6};
        int b[] = {5,13,5};
        assertEquals(1, FindDup.findDup(a, b));
        System.out.println("Match on index 1, test case succesful \n");
    }
    
    
    /*
     * Test case #2 - When the arrays have no common element(s) 
     */
    @Test
    public void testNoDuplicate(){
        System.out.println("testNoDuplicate()");
        int[] a = {7,13,5};
        int[] b = {6,8,9};
        assertEquals(-1, FindDup.findDup(a, b));
        System.out.println("No match, test case succesful \n");        
    }
    
    
    /*
     * Test case #3 - When the arrays have multiple common elements in the
     * same positions
     */
    @Test
    public void testMultipleDuplicates(){
        System.out.println("testMultipleDuplicates()");
        int[] a = {7,13,5};
        int[] b = {7,13,6};
        assertEquals(0, FindDup.findDup(a, b));
        System.out.println("Match on index 0, test case succesful \n");
    }
    
    
    /*
     * Test case #4 - When the arrays have multiple common elements but in
     * different positions
     */
    @Test
    public void testMultipleDuplicatesOnDifferentPositions(){
        System.out.println("testMultipleDuplicatesOnDifferentPositions()");
        int[] a = {7,13,5};
        int[] b = {2,5,13};
        assertEquals(-1, FindDup.findDup(a, b));
        System.out.println("No match, test case succesful \n");       
    }
    
    /*
     * Test case #5 - When the arrays are empty
     */
    @Test
    public void testEmptyArrays(){
        System.out.println("testEmptyArrays()");
        int[] a = null;
        int[] b = null;        
        assertEquals(-1, FindDup.findDup(a, b));
        System.out.println("No match, test case succesful \n");       
    }
    
    /*
     * Test case #6 - Array a is bigger than array b, one common element
     */
    @Test
    public void testUnequalSizedArrays(){
        System.out.println("testUnequalSizedArrays()");
        int[] a = {7,13,5,2,5,8};
        int[] b = {2,1,5};       
        assertEquals(2, FindDup.findDup(a, b));
        System.out.println("Match on index 2, test case succesful \n");       
    }
    
    /*
     * Test case #7 - Array b is bigger than array a, one common element
     */
    @Test
    public void testUnequalSizedArrays1(){
        System.out.println("testUnequalSizedArrays1()");
        int[] a = {2,1,4,1,5};
        int[] b = {7,13,5,2,5,8};        
        assertEquals(4, FindDup.findDup(a, b));
        System.out.println("Match on index 4, test case succesful \n");       
    }
    
}
