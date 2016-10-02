/*
 * SWE 619
 * Assignment 6 - TestMyString.java, test cases for MyString.java
 * @author shaeq
 */

package assignment6;

import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;

public class MyStringTest{

	private MyString ms;
	private MyString empty;

	@Before
	public void SetUp(){
		ms = new MyString("bat.");
		empty = new MyString("");
	}

	//Test for next() true
	@Test
	public void testNextTrue() {
    	String temp = "";
    	for(String s : ms)
   			temp = temp + s;
   		assertEquals(temp, "bat.");
	}

	//Test for next() false
	@Test
	public void testNextFalse(){
		try{
    	    empty.next();
        } catch (NoSuchElementException e){
            return;
        }
        fail("Expected NoSuchElementException");
	}
    
    //Test for remove()
    @Test
    public void testRemove(){
    	try{
        	ms.remove();
        } catch(UnsupportedOperationException e){
            return;
        }
    	fail("Expected UnsupportedOperationException");
    }

    //Test for hasNext() true
    @Test
    public void testHasNextTrue(){
    	assertTrue(ms.hasNext());
    }

    //Test for hasNext() false
    @Test
    public void testHasNextFalse(){
        assertFalse(empty.hasNext());
    }

    //Palindrome test
    @Test
    public void testPalindrome(){
	    String temp = "";
	    for(String s : ms)
      		temp = s + temp;
            assertEquals(temp, ".tab");
        }
}