/* @author shaeqkhan	  
 * 
 * assignment#3 26th Sept 2012, 16:30 
 * SWE 619 OO Software Specification and Construction
 * Dr. Paul Ammann | Ehsan Kouroshfar
 */

package assignment4; 

import org.junit.*;
import static org.junit.Assert.*;

public class TestIntSet {

    IntSet s = new IntSet();
    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    //Inserting new elements into IntSet
    @Test
    public void testInsert() {
        
        assertEquals(s.insert(20),"RepOk insert: true");
        assertEquals(s.insert(33),"RepOk insert: true");
        assertEquals(s.insert(59),"RepOk insert: true");
        assertEquals(s.insert(100),"RepOk insert: true");
        assertEquals(s.insert(120),"RepOk insert: true");
        assertEquals(s.insert(330),"RepOk insert: true");
        System.out.println(s.toString());
        System.out.println("testInsert() successful.\n");
    }

    //Inserting existing element into IntSet
    @Test
    public void testInsertSame() {
       	s.insert(20); s.insert(33); s.insert(59); s.insert(100); s.insert(120); s.insert(330);
        assertEquals(s.insert(20),"RepOk insert: true");
       	assertEquals(s.insert(120),"RepOk insert: true");
        System.out.println(s.toString());
       	System.out.println("testInsertSame() successful.\n");
    }

    // Removing an existing and non existing element
    @Test
    public void testRemove() {
        s.insert((int)20); s.insert((int)33); s.insert((int)59); s.insert((int)100); s.insert((int)120); s.insert((int)330);
        //Existing element
        assertEquals(s.remove((int)59),"RepOk remove: true");
        //Non existing element
        assertEquals(s.remove((int)99),"RepOk remove: true");
        System.out.println(s.toString());
        System.out.println("testRemove() successful.\n");
    }

    // To check if element is in the IntSet
    @Test
    public void testIsIn() {
        s.insert((int)20); s.insert((int)33); s.insert((int)59); s.insert((int)100); s.insert((int)120); s.insert((int)330);
        assertEquals(s.isIn((int)100),true);
        assertEquals(s.isIn((int)111),false);
        System.out.println("testIsIn() successful.\n");
    }

    // Size of IntSet
    @Test
    public void testSize() {
        s.insert((int)20); s.insert((int)33); s.insert((int)59); s.insert((int)100); s.insert((int)120); s.insert((int)330);
        assertEquals(s.size(), (int)6);
        System.out.println("testSize() successful.\n");
    }

    //Get an arbitrary element from IntSet
    @Test
    public void testChoose() {
        s.insert((int)20); s.insert((int)33); s.insert((int)59); s.insert((int)100); s.insert((int)120); s.insert((int)330);
        assertEquals(s.choose(),(int)100);
        System.out.println("testChoose() successful.\n");
    }
}