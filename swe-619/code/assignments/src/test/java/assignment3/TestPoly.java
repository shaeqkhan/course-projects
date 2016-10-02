/*
 * Author - Shaeq Khan
 * Description - Test cases for mutable Poly class 				  

 * Assignment#3 - Due 19th Sept 2012, 16:30 
 * Course - SWE 619 OO Software Specification and Construction
 * Professor - Dr. Paul Ammann
 * GTA - Ehsan Kouroshfar
 */

package assignment3;

import org.junit.*;
import static org.junit.Assert.*;

public class TestPoly {
    
    Poly p = new Poly(5,4);
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
        p = new Poly();
    }
    
    /*
     * Test case #1 - When the arrays have only one common element in a
     * unique position
     */
    @Test
    public void testConstructor1() {
        System.out.println("testConstructor1()");
        p = new Poly();
        String s1 = p.toString();
        String s2 = "Poly: 0";
        assertEquals(s1,s2);
        System.out.println("New polynomial created. \n");
    }
    
    @Test
    public void testConstructor2() {
        System.out.println("testConstructor2()");
        p = new Poly(5,4);
        String s1 = p.toString();
        String s2 = "Poly: + 5x^4";
        assertEquals(s1,s2);
        System.out.println("New polynomial with arguments to constructor created. \n");
    }
    
    @Test
    public void testDegree() {
        System.out.println("testDegree()");
        p = new Poly(5,4);
        int d = p.degree();
        assertEquals(d,4);
        System.out.println("Degree function returns degree of polynomial. \n");
    }
    
    @Test
    public void testCoef() {
        System.out.println("testCoef()");
        p = new Poly(5,4);
        int c = p.coef(4);
        assertEquals(c,5);
        System.out.println("Coef function returns coefficient for a degree passed as argument \n");
    }
    
    @Test
    public void testAdd1() {
        System.out.println("testAdd1()");
        Poly p1 = new Poly(5,4);
        Poly p2 = new Poly(3,4);
        assertEquals(p1.add(p2),"Poly: + 8x^4");
        System.out.println("Adds two polynomials with the same coefficients. \n");
    }
    
    @Test
    public void testAdd2() {
        System.out.println("testAdd2()");
        Poly p1 = new Poly(5,4);
        Poly p2 = new Poly(3,3);
        assertEquals(p1.add(p2),"Poly: + 3x^3 + 5x^4");
        System.out.println("Adds two polynomials with different coefficients. \n");
    }
    
    @Test
    public void testAdd3() {
        System.out.println("testAdd3()");
        Poly p1 = new Poly(5,4);        
        assertEquals(p1.add(new Poly(3,0)),"Poly: 3 + 5x^4");
        System.out.println("Adds a polynomial to a whole number. \n");
    }
    
    @Test
    public void testSub1() {
        System.out.println("testSub1()");
        Poly p1 = new Poly(5,4);
        Poly p2 = new Poly(3,4);
        assertEquals(p2.sub(p1),"Poly: - 2x^4");
        System.out.println("Subtracts two polynomials with the same coefficients. \n");
    }
    
    @Test
    public void testSub2() {
        System.out.println("testSub2()");
        Poly p1 = new Poly(5,4);
        Poly p2 = new Poly(3,3);
        assertEquals(p1.sub(p2),"Poly: - 3x^3 + 5x^4");
        System.out.println("Subtracts two polynomials with different coefficients. \n");
    }
    
    @Test
    public void testSub3() {
        System.out.println("testSub3()");
        Poly p1 = new Poly(5,4);        
        assertEquals(p1.sub(new Poly(3,0)),"Poly: -3 + 5x^4");
        System.out.println("Subtracts a polynomial with a whole number. \n");
    }
    
    @Test
    public void testMult1() {
        System.out.println("testMult1()");
        Poly p1 = new Poly(5,4);
        Poly p2 = new Poly(3,3);
        assertEquals(p1.mul(p2),"Poly: + 15x^7");
        System.out.println("Multiplies two polynomials with different coefficients. \n");
    }
    
    @Test
    public void testMult2() {
        System.out.println("testMult2()");
        Poly p1 = new Poly(5,4);        
        assertEquals(p1.mul(new Poly(3,0)),"Poly: + 15x^4");
        System.out.println("Multiplies a polynomial with a whole number. \n");
    }
    
    @Test
    public void testMult3() {
        System.out.println("testMult3()");
        Poly p1 = new Poly(5,4);        
        assertEquals(p1.mul(new Poly(0,0)),"Poly:");
        System.out.println("Multiplies a polynomial with zero. \n");
    }
}