/**
 * @(#)reader.java
 *
 *
 * @author 
 * @version 1.00 2009/1/18
 */

import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;

public class reader {

    public static void main(String[] args){
    	
    	ArrayList<acronym> list = new ArrayList<acronym>();
    	
    	System.out.println("Reading from file....");
    	Scanner k = new Scanner(System.in);
    	Scanner inputStream = null;
    	try{
    		inputStream = new Scanner(new FileInputStream("Dictionary.txt"));
    	}
    	catch(FileNotFoundException e){
    		System.out.println("File was not found.");
    		System.out.println("Exiting program.");
    		System.exit(0);
    	}
    	while(inputStream.hasNext()){
    		String line = inputStream.nextLine();
    		int doubleDash = line.indexOf("--");
    		String word = line.substring(0,doubleDash-1);
    		String meaning = line.substring(doubleDash+2);
    		list.add(new acronym(word,meaning));
    		//System.out.println(line);
    	}
    	inputStream.close();
    	
    	for(acronym e : list){
    		System.out.println(e);
    	}
        
        // Features.
        
        System.out.println("1. Add word.");
        System.out.println("2. Delete word.");
        System.out.println("3. Search for Acronym.");
        System.out.print("Enter choice : ");
        int choice = k.nextInt();
        if(choice==1){
        	System.out.print("Enter acronym to add : ");
        	String w = k.next();
        	System.out.println("Enter the meaning : ");
        	k.nextLine();
        	String m = k.nextLine();
        	list.add(new acronym(w,m));
        	for(acronym e : list){
    		System.out.println(e);
            }
        }
        if(choice==2){
        	System.out.print("Enter acronym to delete : ");
        	k.nextLine();
        	String w = k.next();
        	System.out.println("Searching...");
        	
        	Iterator<acronym> i1 = list.iterator();
        	boolean ans=false;
        	while(i1.hasNext()){
        		if(w.equals((i1.next()).getWord())){
        			i1.remove();
        			ans=true;
        		}
        		
        	}
        	if(ans==false)
        		System.out.println("Not FOund.");
        	for(acronym e : list){
    		System.out.println(e);
            }
        }
        
        if(choice==3){
        	System.out.println("Enter an acronym to search for meaning : ");
        	k.nextLine();
        	String a = k.next();
        	int l = a.length();
        	
        } 	
        	
        
        }	
    	
        
}
