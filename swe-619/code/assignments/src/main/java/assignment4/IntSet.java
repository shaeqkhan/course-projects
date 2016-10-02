/* @author shaeqkhan  
 * 
 * assignment#3 26th Sept 2012, 16:30 
 * SWE 619 OO Software Specification and Construction
 * Dr. Paul Ammann | Ehsan Kouroshfar
 */

package assignment4;

import java.util.*;

public class IntSet{
	// OVERVIEW: IntSets are unbounded, mutable sets of integers.
	private boolean[] els = new boolean[100];
	private Vector<Integer> otherEls;
	private int sz;
	
	//constructor
    public IntSet() {
    	//EFFECTS: Initializes this to be empty
    	for(int i=0; i<100; i++)
    		els[i]=false;
    	otherEls = new Vector<Integer>();
    	sz = 0;    	    	
    }
    
    //methods
    public String insert(Integer x){
    	//MODIFIES: this
    	//EFFECTS: Adds x to the elements of this.
		
    	if(getIndex(x)<0){
    		if(x>=100){
    			otherEls.add(x);
    		}
    		else{
    			for(int i=0; i<100; i++){
    				if(i==x)
    					els[i] = true;
    			}
    		}
    	}
		
		return "RepOk insert: " + repOk();
    }
    
    public String remove(int x){
    	//MODIFIES: this
    	//EFFECTS: Removes x from this.
    	Integer y = new Integer(x);
    	if(getIndex(y)>=0){
    		if(x>=100){
    			otherEls.remove(y);
    		}
    		else{
    			for(int i=0; i<100; i++){
    				if(i==x)
    					els[i] = false;
    			}
    		}
    	}
    	return "RepOk remove: " + repOk();
    }
    
    public boolean isIn(int x){
    	//EFFECTS: Returns true if x is in this else returns false.
    		return (getIndex(new Integer(x)) >=0);
    }
    
    private int getIndex(Integer x){
    	//EFFECTS: If x is in this returns index where x appears else returns -1
    	if(x.intValue() >= 100){
    		return otherEls.indexOf(x);
    	}
    	else if(els[x.intValue()]) {
    		return x.intValue();	
    	}
    	return -1;
    }
    
    public int size(){
    	//EFFECTS: Returns the cardinality of this.    	
    	sz=0;
    	for(int i=0;i<100;i++){
    		if(els[i]==true){
    			sz++;    		
    		}
    			
    	}    	
    	sz+=otherEls.size();
    	return sz;
    }
    
    public int choose() throws NullPointerException{
    	//EFFECTS: If this is empty throws EmptyException else
    	// returns an arbitrary element of this.
    	if(size()>0){
    		if(otherEls.size()==0){
    			for(int i=0;i<100;i++){
    				if(els[i])
    					return i;
    			}
    		}
    		else
    			return (otherEls.firstElement().intValue());
    	}    		
    	
    	throw new NullPointerException("Set is empty");	
    }
    
    public boolean repOk(){
    	//els not equal to null && otherEls not equal to null   	
    	if(otherEls==null && els==null){
    		return false;
    	}
    		    	
    	//0...99 elements not in otherEls
    	for(int i=0;i<otherEls.size();i++){    		
    		if(otherEls.get(i).intValue() < 100){    			
    			return false;
    		}    			
    	}
    	    		
    	//no duplicates in otherEls
    	for(int j=0;j<otherEls.size();j++){    		
    		for(int k=j+1; k<otherEls.size();k++){    			
    			if(otherEls.elementAt(j).equals(otherEls.elementAt(k))){   				
    				return false;
    			}   				
    		}
    	}
    	
    	//only integers in otherEls
    	//no null in otherEls
    	for(int i=0;i<otherEls.size();i++){
    		Object x = otherEls.get(i);
    		if(!(x instanceof Integer)){    			
    			return false;
    		}
    			
    		if(x.equals(null)){  			
    			return false; 
    		}    			   		
    	}
    	
    	//s = otherEls.size + cnt(els,0)
    	//where cnt(a,i) = if i>=100 then 0
    	//else if a[i] then 1+cnt(a,i+1)
    	//else cnt(a,i+1)
    	
    	int s = otherEls.size() + cnt(els,0);    
    	if(s!= size()){
    		return false;    		
    	}    		
    	
    	return true;	
    }
    
    //recursive method to get size of els
    //refer to repOk() for description
    private int cnt(boolean[] a, int i){
    	if(i>=100)
    		return 0;
    	else if(a[i])
    		return 1+cnt(a,i+1);
    	else
    		return cnt(a,i+1);
    }
    
    public String toString(){
    	if(size()==0)
    		return "IntSet:{}";
    	String s = "IntSet: {";
    	for(int i=0;i<100;i++){
    		if(els[i])
    			s = s + i + " , ";
    	}
    	for(int j=0; j<otherEls.size();j++){
    		s = s + otherEls.elementAt(j).toString() + " , " ;
    	}
    	return s + "}";
    }
    
}