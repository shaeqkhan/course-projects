/**
 * SWE 619 - Assignment 7
 * LiskovSet.java
 * @author shaeqkhan 
 */

package assignment7;

import java.util.*;

public class LiskovSet<E> {

	//OVERVIEW: Sets are unbounded, mutable sets of objects
	//null is never an element of a Set. 
	//The methods use equals to determine equality of elements
	
	private Vector<E> els;
	
	//constructors	
    public LiskovSet() {
    	//EFFECTS: Initializes this to be empty
    	els = new Vector<E>();
    }
    
    public LiskovSet(Vector<E> x) {
    	//EFFECTS: Initializes this to x
    	els = x;
    }
    
    //methods
    public void insert (E e) throws NullPointerException{
    	//MODIFIES: this
    	//EFFECTS:  if x is null throws NullPointerException
    	//			else adds x to elements of this
    	if(e == null)
    		throw new NullPointerException("LiskovSet: insert.");
    	if(getIndex(e) < 0)
    		els.add(e);
    }
    
    public void remove (E e) {
    	//MODIFIES: this
    	//EFFECTS:  If x is in this, remove x from this
    	//			else does nothing
    	int index = getIndex(e);
    	if(index > -1)
    		els.removeElementAt(index);
    }
    
    public boolean isIn (E e){
    	//EFFECTS:  returns true if x is in this 
    	//			else returns false
    	return (getIndex(e) > -1);
    }
    
    private int getIndex (E e){
    	//EFFECTS:  If x is in this return its index
		//			else return -1
		for(Object obj : els)
			if(e.equals(obj))
				return els.indexOf(obj);
		return -1;    				
    }
    
    public boolean subset (LiskovSet<? super E> s){
    	//EFFECTS:  If all elements of this are elements of s returns true
    	//			else retunrs false specifications of size and elements
    	if(s == null)
    		return false;
    	for(E e : els)
    		if(!s.isIn(e))
    			return false;
    	return true;
    }
    
    public String toString(){
    	String r = "{";
    	for(E e : els)
    		r = r + " " + e.toString();
    	return r + " }";
    }
    
}


	
		
