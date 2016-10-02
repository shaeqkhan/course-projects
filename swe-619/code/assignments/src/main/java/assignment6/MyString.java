/*
 * SWE 619
 * Assignment 6 - MyString.java implements Iterable,Iterator
 * @author shaeq
 */

package assignment6;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyString implements Iterable<String>, 
                             	 Iterator<String> { 
	private String str; 
  	private int count = 0; //store position of pointer
 
  	//constructor
  	public MyString(String s) { 
    	str = s; 
  	}
  	
  	//Effects: returns an iterator over this to return characters in
  	//String as String objects 
  	public Iterator<String> iterator() { 
    	return this; 
  	} 
 
  	public boolean hasNext() {     
    	return (count < str.length());
  	} 
 
  	public String next() { 
    	if(count == str.length())  
      		throw new NoSuchElementException("MyString:iterator"); 
 	
 		char c = str.charAt(count);
 		String t = "" + c; //converting char at position count to string
    	count++; //increment position of counter on string
    	return t; 
  	} 
 
  	public void remove() { 
    	throw new UnsupportedOperationException(); 
  	}
  	
  	public static void main(String args[]) {  
    MyString ms = new MyString("Test string."); 
 
    for(String s : ms) 
      System.out.println(s);   
  	} 
  	 
} 
 
