/**
 * 
 * Information and Computer Science (ICS) Department
 * College of Computer Sciences and Engineering (CCSE)
 * King Fahd University of Petroleum and Minerals - KFUPM
 * Dhahran, Saudi Arabia  
 * 
 * Course - ICS 102 Term 073
 *
 * This is the class definition in order to store objects read from the file "Software Store.txt".
 *
 * Author : Shaeq Pervez Khan
 * Date of Submission : 23 August 2008
 */


import java.util.Scanner;

public class SoftwareCompany {

    // The four variables that will store data read from file.
    String companyName, productName;
    int priceOfProduct=0;
    int quantityOfProduct=0;
    
    // Constructor that will help initialize the variables.
    public SoftwareCompany(String coName, String proName, int price, int quantity){
    	companyName = coName;
    	productName = proName;
    	priceOfProduct = price;
    	quantityOfProduct = quantity;
    }
    
    // Method(getter) to return the Company Name.
    public String getCompanyName(){
    	return companyName;
    }
    
    // Method(getter) to return the name of the product.
    public String getProductName(){
    	return productName;
    }
    
    // Method(getter) to return the price of ONE unit of the product.
    public int getPriceOfProduct(){
    	return priceOfProduct;
    }
    
    // Method(getter)to return the quantity of products available in the store.
    public int getQuantityOfProduct(){
    	return quantityOfProduct;
    }
    
    // Method(setter) to initialize the price of the product.
    public void setPrice(int price){
    	priceOfProduct = price;
    }
    
    public void setQuantityOfProduct(int quantity){
    	quantityOfProduct = quantity;
    }
    
    // Method to print the objects of the class using only its name.
    public String toString(){
    	return(companyName + "\t\t" + productName + "\t\t" + priceOfProduct + "\t\t" + quantityOfProduct);
    }
    
    // Method to change the price of a product.
    public int modifyPrice(String nameOfProduct){
    	int flag=0;
    	Scanner keyboard = new Scanner(System.in);
    	System.out.println();
    	System.out.println("YOU ARE GOING TO MODIFY THE PRICE OF THE PRODUCT : " + nameOfProduct);
    	System.out.println();
    	System.out.println("ENTER A NEW PRICE FOR THE PRODUCT : ");
    	int newPrice = keyboard.nextInt();
    	if(newPrice<=0){
    		System.out.println("CANNOT ACCEPT A NEGATIVE PRICE.");
    		System.out.println("PLEASE RE-ENTER A NEW PRICE.");
    		return 0;
    	}
    	return newPrice;
    }
}