/**
 * 
 * Information and Computer Science (ICS) Department
 * College of Computer Sciences and Engineering (CCSE)
 * King Fahd University of Petroleum and Minerals - KFUPM
 * Dhahran, Saudi Arabia  
 * 
 * Course - ICS 102 Term 073
 *
 * This is the main class that reads information from "Software Store.txt", updates and deletes information.
 *
 * Author : Shaeq Pervez Khan
 * Date of Submission : 23 August 2008
 */
 
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;

public class SoftwarePurchase {

    public static void main(String[] args){
    	
    	int choice=0; // Take input value from the user for his choice based on the menu given. Initialized to zero.
    	int count=0; // counter to count the number of products in the software store 
    	String answer="n";
    	
    	Scanner keyboard = new Scanner(System.in);	// Creating an object of class Scanner by the name of "keyboard".   	
    	
    	System.out.println("ICS 102 PROJECT");
    	System.out.println("***************");
    	System.out.println("THIS IS A CONSOL PROGRAM THAT MANAGES A COMPUTER SOFTWARE STORE FOR MAXIMUM OF 20 ITEMS.\n");
    	
    	// The following statement will create an object "items" of class SoftwareCompany of the type arrays.
    	SoftwareCompany[] items = new SoftwareCompany[20];
    	
    	// Initializing the objects of class Scanner and PrintWriter.
    	Scanner inputStream = null;
    	PrintWriter outputStream = null;
    	
    	//The following code is to get the number of products in the store by using a counter.    	
    	try{
    		inputStream = new Scanner(new FileInputStream("Software Store.txt"));
    	}
    	catch(FileNotFoundException e){
    	    System.out.println("File Not Found.");
    	    System.out.println("ERROR!");
    	    // Will display exception errors if it does not find the file on the mentioned path.
    	}	
    	String header = inputStream.nextLine();   	   	
    	while(inputStream.hasNextLine()){
    		inputStream.nextLine();
    		count++; // counter to count the number of products.
       	}
       	inputStream.close();		
    	
    	// The following code is to read information from the file "Software Store.txt" and create objects of type array of class "SoftwareCompany".
    	try{
    		inputStream = new Scanner(new FileInputStream("Software Store.txt"));
    	}
    	catch(FileNotFoundException e){
    	    System.out.println("File Not Found.");
    	    System.out.println("ERROR!");
    	}	
    	String junk = inputStream.nextLine();
    	for(int i=0;i<count;i++){
       		String s1 = inputStream.next();
    		String s2 = inputStream.next();
    		int n = inputStream.nextInt();
    		int q = inputStream.nextInt();
    		items[i] = new SoftwareCompany(s1,s2,n,q);
    		// initializing the object of class SoftwareCompany by reading data from the file.
    	}
    	inputStream.close();   	
    	
    	// A do-while loop to display the menu whenever an operation is completed.   	
    	do{
    		System.out.println();
    		System.out.println("1. DISPLAY THE WHOLE INVENTORY.");
    		System.out.println("2. DISPLAY PRODUCTS OF A COMPANY.");
    		System.out.println("3. CHECK THE AVAILIBILITY OF A PRODUCT.");
    		System.out.println("4. MODIFY THE PRICE OF AN ITEM.");
    		System.out.println("5. ADD AN ITEM TO THE STORE.");
    		System.out.println("6. PURCHASING SOFTWARE FROM STORE.");
    		System.out.println("7. EXIT.");
    		System.out.println();
    		System.out.println("ENTER YOUR CHOICE (in numbers 1 to 7) : ");
    		choice = keyboard.nextInt();
    		
    		// if loop to make sure that choice entered is correct.
    		if(choice<=0 || choice>7){
    			System.out.println("!! ERROR !! ");
    			System.out.println();
    			System.out.println("WRONG CHOICE ENTERED. PLEASE ENTER THE RIGHT CHOICE.");
    			System.out.println();
    			choice=0;
    			/* this will assign the value of choice to 0 
    			 *whenever the user enters invalid option number 
    			 *to make sure the program does not terminate.*/
    		}
    		
    		/* Loop for choice 1. 
    		 * We read all the elements of the 
    		 * object "items" and simply display it.*/
    		if(choice==1){
    			System.out.println();
    			System.out.println("Your choice is : 1. DISPLAY THE WHOLE INVENTORY. ");
    			System.out.println();
    			System.out.println("Company Name\tProduct Name\tPrice\tQuantity");
    			for(int i=0;i<count;i++){    				
    				System.out.println(items[i]); // This will display all the variables of items.
    			}
    			System.out.println();
    			System.out.println("THANK YOU FOR USING OUR SERVICES.");
    			System.out.println("PLEASE WAIT FOR A MOMENT... WHILE WE REDIRECT YOU TO THE MAIN MENU.");
    		}
    		
    		/* Loop for choice 2. 
    		 * We only read the product name from the object
    		 * using getters from class "SoftwareCompany" and 
    		 * simply display it.*/
    		if(choice==2){
    			System.out.println();
    			System.out.println("Your choice is : 2. DISPLAY PRODUCTS OF A COMPANY.");
    			System.out.println();
    			System.out.println("ENTER THE COMPANY NAME OF WHOSE PRODUCT YOU WANT : ");
    			String compName = keyboard.next();
    			System.out.println();
    			System.out.println("THE PRODUCTS AVAILABLE FOR THE COMPANY " + compName + " IN THE STORE ARE : ");
    			System.out.println();
    			for(int i=0;i<count;i++){
    				if(compName.equalsIgnoreCase(items[i].getCompanyName())){
    					System.out.println("PRODUCT : " + items[i].getProductName()); // getProductName() is the getter that returns the product name.
    				}
    			}
    			System.out.println();
    			System.out.println("THANK YOU FOR USING OUR SERVICES.");
    			System.out.println("PLEASE WAIT FOR A MOMENT... WHILE WE REDIRECT YOU TO THE MAIN MENU.");
    		}
    		
    		/* Loop for choice 3.
    		 * To check the availibilty we read the product name
    		 * to be changed and compare it to the product names 
    		 * stored in the object. Then we make sure its quantity 
    		 * is more than 0 and the display the result. */ 
    		if(choice==3){
    			System.out.println();
    			System.out.println("Your choice is : 3. CHECK THE AVAILIBILITY OF A PRODUCT.");
    			do{
    				int flag=0; // indicator to make sure that the product is found in the store.
    				int quantity=0;
    				System.out.println();
    				System.out.println("ENTER THE NAME OF THE PRODUCT : ");
    				String nop = keyboard.next();
    				System.out.println();
    				for(int i=0;i<count;i++){
    					String nameFromFile = items[i].getProductName();
    					// Loop to compare the entered product name and the product name from the file.
    					if(nop.equalsIgnoreCase(nameFromFile)){
    						flag=1;
    						quantity = items[i].getQuantityOfProduct(); // getter to get the quantity of product in store.
    					}
    					
    				}
    				// Loop to check availibility of the product entered.
    				// Also makes sure that quantity is more than 0.
    				if(flag==1 && quantity>0){
    					System.out.println("THE PRODUCT " + nop + " IS IN STOCK. WE HAVE " + quantity + " LEFT IN THE STORE." );
    					System.out.println();
    				}	
    				else 
    					System.out.println("I'M SORRY! THE PRODUCT " + nop + " IS NOT IN STOCK.");
    					System.out.println();
    			
    				System.out.println("DO YOU WANT TO CHECK THE AVAILIBILTY OF MORE PRODUCTS?(Enter y for yes, n for no) : ");
    				answer = keyboard.next();
    			}while(answer.equals("Y") ||answer.equals("y"));
    			
    			System.out.println();
    			System.out.println("THANK YOU FOR USING OUR SERVICES.");
    			System.out.println("PLEASE WAIT FOR A MOMENT... WHILE WE REDIRECT YOU TO THE MAIN MENU.");
    		}
    		
    		/* Loop for choice 4. This is to modify the price of an item.
    		 * We check the availibilty of the product and then using a
    		 * setter from class "SofwareCompany" we modify the price.*/
    		if(choice==4){
    			
    			System.out.println("Your choice is : 4. MODIFY THE PRICE OF AN ITEM.");
      			do{
    				int newPrice=0,flag=0;
    				System.out.println();
       				System.out.println("THE PRODUCTS AVAILABLE IN THE STORE ARE AS FOLLOWS.");
      				System.out.println();
    				for(int i=0;i<count;i++){
    					System.out.println("PRODUCT " + (i+1) + " : " + items[i].getProductName() + "\tPRICE : " + items[i].getPriceOfProduct());
    				}
    				// The 2 getters used are for the name and the price of the product.
    				System.out.println();
       				System.out.println("YOU ARE NOW GOING TO CHANGE THE PRICE OF AN ITEM.");
       				System.out.println();
    				System.out.println("ENTER THE PRODUCT NAME FOR WHICH YOU WANT TO CHANGE THE PRICE (Please use _ between spaces): ");
    				String nop = keyboard.next();
  
    				for(int i=0;i<count;i++){
    					String nameFromFile = items[i].getProductName();
    					if(nop.equalsIgnoreCase(nameFromFile)){
    						newPrice = items[i].modifyPrice(nameFromFile); // This is a getter to make sure that the price entered is positive and not 0.
    						// this is to make sure that the price entered is more than 0.
    						if(newPrice == 0){
    							System.out.println("PRICE ENTERED IS EITHER ZERO OR NEGATIVE.");
    							break;
    						}
    						items[i].setPrice(newPrice); // This is the setter to enter the new price.
    						flag=1;
    					}
    				}
    				if(flag==0){
    					System.out.println();
    					System.out.println("I'M SORRY. THE PRODUCT ENTERED IS NOT AVAILABLE.");
    					System.out.println();
    				}	
    				else{
    					System.out.println();
    					System.out.println("THE PRICE OF " + nop + " HAS BEEN CHANGED TO " + newPrice);
    					System.out.println();
    				}	
    				System.out.println("DO YOU WANT TO CHANGE THE PRICE OF MORE PRODUCTS?(Enter y for yes, n for no) : ");
    				answer = keyboard.next();						
    			}while(answer.equals("Y") ||answer.equals("y"));
    			
    			System.out.println();
    			System.out.println("THANK YOU FOR USING OUR SERVICES.");
    			System.out.println("PLEASE WAIT FOR A MOMENT... WHILE WE REDIRECT YOU TO THE MAIN MENU.");	
    		}
    		
    		/* Loop for choice 5. This is to add a new item to the store.
    		 * We do this by first making sure that the new item we are
    		 * trying to enter is already available in the store. Then we
    		 * also make sure that the price we enter for the new item is
    		 * greater than zero. Also the loop does not add anymore items
    		 * if there are 20 items available in the store.*/
    		if(choice==5){
    			int flag=0;
    			System.out.println("Your choice is : 5. ADD AN ITEM TO THE STORE.");
    			// Loop to make sure program does not store products more than 20.
    			if(count>=20){
    				System.out.println("ERROR.");
    				System.out.println("CANNOT ADD MORE ITEMS TO THE SHOP.");
    				System.out.println("THE SHOP IS FULL.");
    			}
    			if(count<20){
    				do{
    				System.out.println();
    				System.out.println("YOU ARE NOW GOING TO ENTER A NEW PRODUCT. PLEASE MAKE SURE YOU HAVE ALL THE DESIRED INFORMATION.");
    				System.out.println();
    				System.out.println("ENTER THE COMPANY NAME : ");
    				String companyName = keyboard.next();
    				System.out.println();
    				System.out.println("ENTER NAME OF THE PRODUCT : ");
    				String productName = keyboard.next();
    				System.out.println();
    				System.out.println("ENTER PRICE OF THE PRODUCT : ");
    				int price = keyboard.nextInt();
    				// Making sure that the price entered by user is more than 0.
    				if(price<=0){
    					System.out.println("PLEASE RE-ENTER PRICE. IT CANNOT BE 0.");
    					System.out.println("ENTER THE PRICE OF THE PRODUCT : ");
    					price = keyboard.nextInt();
    				}
    				System.out.println();
    				System.out.println("ENTER QUANTITY OF PRODUCTS THAT ARE INITIALLY AVAILABLE IN THE STORE : ");
    				int quantity = keyboard.nextInt();
    				for(int i=0;i<count;i++){
    					// Loop to check if the product is already available in the store.
    					// getters used to get the company name and the product name.
    					if(companyName.equalsIgnoreCase(items[i].getCompanyName()) && productName.equalsIgnoreCase(items[i].getProductName())){
    						System.out.println();
    						System.out.println("ERROR!");
    						System.out.println();
    						System.out.println("REDUNDANT DATA.");
    						System.out.println();
    						System.out.println("PRODUCT " + productName + " ALREADY EXISTS IN THE STORE." );
    						flag=1;
    						break;
    					}
    				}
    				// This loop will add the new information entered bby user as a new item at the store.
    				if(flag==0 && count<20){
    					items[count] = new SoftwareCompany(companyName,productName,price,quantity);
       					count++;
       					// the above creates one more item for the store.
    					System.out.println();
    					System.out.println("NEW ITEM SUCCESSFULY ADDED.");
    					System.out.println();
    					System.out.println("Company Name\tProduct Name\tPrice\tQuantity");
    					for(int i=0;i<count;i++){    				
    						System.out.println(items[i]);
    					}
    				}
    					System.out.println();
    					System.out.println("DO YOU WANT TO ADD ANOTHER ITEM TO THE STORE? (Enter y for yes, n for no) : ");
    					answer = keyboard.next();
    			}while(answer.equals("Y") ||answer.equals("y"));

    			}
    			    			
    			System.out.println();
    			System.out.println("THANK YOU FOR USING OUR SERVICES.");
    			System.out.println("PLEASE WAIT FOR A MOMENT... WHILE WE REDIRECT YOU TO THE MAIN MENU.");	
    		}
    		
    		/* Loop for choice 6. This will help a user to purchase any
    		 * available items in the store. It will also compute the 
    		 * total price after the user has finished shopping. This 
    		 * will check the availibilty of the product entered by the
    		 * user with those present in the store and give the option 
    		 * of purchasing it. */
    		if(choice==6){
    			int sum=0;
    			System.out.println();
    			System.out.println("Your choice is : 6. PURCHASING SOFTWARE FROM STORE.");	
    			do{
       				int flag=0;
       				System.out.println();
       				System.out.println("THE PRODUCTS AVAILABLE IN THE STORE ARE AS FOLLOWS.");
      				System.out.println();
    				// Getters used to get the product name and price of the product.
    				for(int i=0;i<count;i++){
    					System.out.println("PRODUCT " + (i+1) + " : " + items[i].getProductName() + "\t\t\tPRICE : " + items[i].getPriceOfProduct());
    				}
    				System.out.println();
    				System.out.println("ENTER THE NAME OF THE PRODUCT YOU WANT TO BUY : ");
    				String productName = keyboard.next();
    				System.out.println();
    				System.out.println("YOU ARE LOOKING FOR THE PRODUCT - " + productName);
    				System.out.println();
    				System.out.println("LET ME CHECK IF " + productName + " IS AVAILABLE IN THE STORE... ");
       				// Loop to check availibilty of the product in the store.
       				for(int i=0;i<count;i++){
    					String productFromFile = items[i].getProductName();
    					//Loop to compare the product name and the quantity(making sure its more than 0).
    					if(productFromFile.equalsIgnoreCase(productName) && (items[i].getQuantityOfProduct()>0)){
    						flag=1;
    						System.out.println();
    						System.out.println("YES. THE PRODUCT IS AVAILABLE.");
    						System.out.println();
    						System.out.println("WOULD YOU LIKE TO PURCHASE IT? (Enter y for yes, n for no): ");
    						answer = keyboard.next();
    						if(answer.equals("y") || answer.equals("Y")){
    							System.out.println("PLEASE WAIT. WE ARE PROCESSING YOUR REQUEST...");
    							System.out.println();
    							int newQuantity = items[i].getQuantityOfProduct();
    							// updating the product info to the file
    							items[i].setQuantityOfProduct(newQuantity-1);
    							System.out.println("OK. THANKS FOR SHOPPING.");
    							sum = sum + items[i].getPriceOfProduct(); // getter to get the price of the product.
    						}
    						else
       							break;
    					}
       				}
       				if(flag==0){
       					System.out.println("SORRY! THE PRODUCT IS NOT AVAILABLE IN THE STORE.");
       				}
    				System.out.println();
    				System.out.println("WOULD YOU LIKE TO PURCHASE ANOTHER PRODUCT?(Enter y for yes, n for no)");
    				answer = keyboard.next();
    			}while(answer.equals("Y") ||answer.equals("y")); 
    			
    			System.out.println();
    			System.out.println("YOUR COST OF SHOPPING IS = " + sum);
    			System.out.println();
    			System.out.println("THANK YOU FOR USING OUR SERVICES.");
    			System.out.println("PLEASE WAIT FOR A MOMENT... WHILE WE REDIRECT YOU TO THE MAIN MENU.");		   	
    		}
    		
    		/* Loop for choice 7. This will write all the changes made to 
    		 * object items to the file so that the changes done by the 
    		 * user is not lost. It will also give the user an option to
    		 * display the final inventory and then exit.*/ 
    		if(choice==7){
    			System.out.println();
    			System.out.println("UPDATING THE FILE USED...");
    			try{
    				outputStream = new PrintWriter(new FileOutputStream("Software Store1.txt")); // I am not writing to the same file so that i dont loose any data.
    			}
    			catch(FileNotFoundException e){
    				System.out.println("File Not Found.");
    				System.out.println("ERROR.");
    			}
    			// Code to write to the file "Software Store1.txt"
    			outputStream.println("Company Name\tProduct Name\tPrice\tQuantity");
    			for(int i=0;i<count;i++){
    				outputStream.println(items[i]);
    			}
    			outputStream.close();
    			System.out.println();
    			System.out.println("FINISHED FILE UPDATE.");
    			System.out.println();
    			System.out.println("DO YOU WANT TO PRINT THE INVENTORY?(Enter y for yes, n for no)");
    			answer = keyboard.next();
    			if(answer.equals("Y") ||answer.equals("y")){
    				System.out.println();
    				System.out.println("Company Name\tProduct Name\tPrice\tQuantity");
    				for(int i=0;i<count;i++){
    					System.out.println(items[i]);
    				}
    			}
    			System.out.println();
    			System.out.println("THANK YOU FOR USING OUR SERVICES.");
    			System.out.println();
    			System.out.println("YOU ARE NOW EXITING FROM THE PROGRAM.");
    			System.exit(0);
    		}
    	}while(choice>=0 && choice<=7);
    }
    
}