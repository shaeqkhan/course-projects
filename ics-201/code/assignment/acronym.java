/**
 * @(#)acronym.java
 *
 *
 * @author 
 * @version 1.00 2009/1/18
 */


public class acronym {

    public String word;
    public String meaning;
    
    public acronym() {
    	word = null;
    	meaning = null;
    }
    
    public acronym(String word, String meaning){
    	this.word = word;
    	this.meaning = meaning;
    }
    public acronym(String word){
    	this.word = word;
    	
    }
    
    public String getWord(){
    	return word;
    }
    
    public String getMeaning(){
    	return meaning;
    }
    
    public void setWord(String word){
    	this.word = word;
    }
    
    public void setMeaning(String meaning){
    	this.meaning = meaning;
    }
    
    public String toString(){
    	return (word + " - " + meaning);
    }
    
}