/*
 * SWE 619
 * Assignment 5 - IntSet.java with ImmutableIterator
 * @author shaeq
 */

package assignment5;

import java.util.*;
import java.util.NoSuchElementException;

public class IntSet{
	//Overview: IntSets are unbounded, mutable sets of integers
	private Vector<Integer> els; //the rep
	
	//constructors
	public IntSet(){
		//Effects: Initializes this to empty
		els = new Vector<Integer>();
	}
	
	//Effects: Returns an immutable generator that will produce all of the elements
	//of this, (as Integer), each exactly once, in arbitrary order.
	//Requires: this must not be modified while the generator is in use
	public ImmutableIterator iIterator(){
		return new ImmutableIterator(this);
	}
	
	//inner class
	private static class ImmutableIterator{
		private IntSet s;
		int n; //next term to consider
		
		ImmutableIterator(IntSet it){
			//Requires: it!=null
			s=it;
			if(s.els.size()==0)
				n=1;
			else
				n=0;
		}
		
		public boolean hasNext(){
			return n<s.els.size();
		}
				
		public Object nextObject() throws NoSuchElementException{
			if(hasNext()){
				return new Integer(s.els.get(n));
			}
			throw new NoSuchElementException("ImmutableIterator.nextObject");
		}
		
		public ImmutableIterator nextIterator() throws NoSuchElementException{
			if(hasNext()){
				n++;
				return this;
			}
			throw new NoSuchElementException("ImmutableIterator.nextIterator");
		}		
	}
	
	//methods
	public void insert(Integer x){
		//Modifies: this
		//Effects: Adds x to the elements of this		
		if(getIndex(x)<0)
			els.add(x);	
	}
	
	public void remove(int x){
		//Modifies: this
		//Effects: Removes x from this
		int i = getIndex(new Integer(x));
		if(i<0)
			return;
		els.set(i,els.lastElement());
		els.remove(els.size()-1);
	}
	
	public boolean isIn(int x){
		//Effects: Returns true if x is in this else returns false
		return (getIndex(new Integer(x))>=0) ;
	}
	
	private int getIndex(Integer x){
		//Effects: If x is in this returns index where x appears else returns -1
		ImmutableIterator it = iIterator();
		while(it.hasNext()){
			Integer y = (Integer)it.nextObject();			
			if(x.equals(y))
				return it.n;
			it = it.nextIterator();
		}
		return -1;		
	}
	
	public int size(){
		//Effects: returns the cardinality of this
		ImmutableIterator it = iIterator();
		int size=0;
		while(it.hasNext()){
			size++;
			it = it.nextIterator();
		}
		return size;
	}
	
	public int choose() throws IndexOutOfBoundsException{
		//Effects: If this is empty throws EmptyException else
		//returns an arbitrary element of this
		if(els.size()==0)
			throw new IndexOutOfBoundsException("IntSet.choose");
		return els.lastElement() ;
	}
	
	public String toString(){
    	if(size()==0)
    		return "IntSet:{}";
    	String s = "IntSet:{";
    	ImmutableIterator it = iIterator();
    	while(it.hasNext()){
    		s = s + it.nextObject().toString() + ",";
    		it = it.nextIterator();
    	}
    	//it.nextObject();
    	//it.nextIterator();    	
    	return s + "}";
    }
}