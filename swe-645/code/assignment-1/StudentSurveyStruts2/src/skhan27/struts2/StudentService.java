/*
 * @course SWE 645
 * @author skhan27
 * @class StudentService.java
 * A service class to do back end work for the web application.
 * This class reads and writes survey data from/to a text file
 * 
 * **********************************************
 * public accessors 							*
 * **********************************************
 * 												*
 * readSurveyData()								*
 * saveSurveyData(Student student)				*
 * calculateMean(String raffle)					*
 * calculateStandardDeviation(String raffle)	*
 * getRaffleNumbers(String raffle)				*
 * 												*
 * **********************************************
 */

package skhan27.struts2;

import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;

public class StudentService {
	
	/*
	 * ***********************
	 * CHANGE FILE PATH HERE *
	 * *********************** 
	 * File path is set as per users location before running the web application
	 * 
	 * During testing I wasn't writing data to the same file to
	 * avoid data loss. You may set both Strings as the same so that the same
	 * file is used to read and write data 
	 *			 
	 */
	static String fileName = "C:\\Users\\Shaeq\\Desktop\\SurveyInformation.txt";
	static String newFile = "C:\\Users\\Shaeq\\Desktop\\SurveyInformation.txt";
	
	
	// Initializing the objects of class Scanner and PrintWriter.
	static Scanner inputStream = null;
	static PrintWriter outputStream = null;
	
	
	/*****************************************************************************
	 * 
	 * public accessor readSurveyData()
	 * @param none
	 * @return array of students read from text file
	 * 
	 ****************************************************************************/
	public static Student[] readSurveyData() {
		
		int numOfStudentSurvey = countNumberOfSurveys();
		
		Student[] student = new Student[numOfStudentSurvey];
		
		if(openFile()) {
			
			for(int i = 0; i < numOfStudentSurvey; i++) {
	            String firstName = inputStream.nextLine();
	            String lastName = inputStream.nextLine();
	            String address = inputStream.nextLine();
	            String city = inputStream.nextLine();
	            String state = inputStream.nextLine();
	            String zip = inputStream.nextLine();
	            String phone = inputStream.nextLine();
	            String email = inputStream.nextLine();
	            String dateofsurvey = inputStream.nextLine();
	                        
	            String campusAttraction = inputStream.nextLine();
	            String interestInUniversity = inputStream.nextLine();
	            String recommendation = inputStream.nextLine();
	            String raffle = inputStream.nextLine();
	            String comments = inputStream.nextLine();

	            student[i] = new Student(firstName, lastName, address, city, state,
	                    zip, phone, email, dateofsurvey, campusAttraction,
	                    interestInUniversity, recommendation, raffle, comments);

	            double sd = calculateStandardDeviation(raffle);	            

	            double avg = calculateMean(raffle);
	            
	            if(avg > WinningResult.mean) {
	            	
	            	WinningResult.mean = (avg);
	            	WinningResult.standardDeviation = (sd);
	            	
	            }//end of if
	        
			}//end of for
			
			inputStream.close();
		
		}//end of if-openFile()
		
		return student;
		
	}//end of readSurveyData()
	
	
	
	/*****************************************************************************
	 * 
	 * public accessor saveSurveyData()
	 * @param new student survey to be saved in the file
	 * @return true if new data is written to file, else return false
	 * 
	 ****************************************************************************/
	public static boolean saveSurveyData(Student student) {
						
		if(openFile() && student!=null) {
			
			int numOfStudentSurvey = countNumberOfSurveys();			
			
			Student[] studentsOnFile = new Student[numOfStudentSurvey];			
			
			studentsOnFile = readSurveyData();
			
			try{
				outputStream = new PrintWriter(new FileOutputStream(newFile)); 
				
			}
			catch(FileNotFoundException e){
				System.out.println("File Not Found.");				
			}
			
			//loop to write the existing data back to the file
			for(int i = 0 ; i < numOfStudentSurvey; i++){
				outputStream.println(studentsOnFile[i].getFirstname());
				outputStream.println(studentsOnFile[i].getLastname());
				outputStream.println(studentsOnFile[i].getAddress());
				outputStream.println(studentsOnFile[i].getCity());
				outputStream.println(studentsOnFile[i].getState());
				outputStream.println(studentsOnFile[i].getZip());
				outputStream.println(studentsOnFile[i].getPhone());
				outputStream.println(studentsOnFile[i].getEmail());
				outputStream.println(studentsOnFile[i].getDateofsurvey());
				outputStream.println(studentsOnFile[i].getLikes());
				outputStream.println(studentsOnFile[i].getInterest());
				outputStream.println(studentsOnFile[i].getRecommend());
				outputStream.println(studentsOnFile[i].getRaffle());
				outputStream.println(studentsOnFile[i].getComments());
			}
			
			//set of statements to write the new survey to the file
			outputStream.println(student.getFirstname());
			outputStream.println(student.getLastname());
			outputStream.println(student.getAddress());
			outputStream.println(student.getCity());
			outputStream.println(student.getState());
			outputStream.println(student.getZip());
			outputStream.println(student.getPhone());
			outputStream.println(student.getEmail());
			outputStream.println(student.getDateofsurvey());
			outputStream.println(student.getLikes());
			outputStream.println(student.getInterest());
			outputStream.println(student.getRecommend());
			outputStream.println(student.getRaffle());
			outputStream.println(student.getComments());
			
			outputStream.close();

			return true;
		
		}//end of if openFile()
		
		return false;
	
	}//end of saveSurveyData()
	
	
	/*****************************************************************************
	 * 
	 * public accessor calculateMean()
	 * @param a string of 10 raffle numbers seperated by commas with no space 
	 * @return mean of the 10 numbers
	 * 
	 ****************************************************************************/
	
	public static double calculateMean(String raffle){
        
        int[] raffleNumbers = getRaffleNumbers(raffle);
        int sum = 0;
        for(int i = 0; i < raffleNumbers.length; i++)
            sum = sum + raffleNumbers[i];
        
        return sum/(raffleNumbers.length);
	}
	
	
	/*****************************************************************************
	 * 
	 * public accessor calculateMean()
	 * @param a string of 10 raffle numbers seperated by commas with no space 
	 * @return mean of the 10 numbers
	 * 
	 ****************************************************************************/
	public static double calculateStandardDeviation(String raffle) {

		int[] raffleNumbers = getRaffleNumbers(raffle);
		double addSquares = 0.0;
		double mean = calculateMean(raffle);
        	
		for(int i = 0; i < raffleNumbers.length; i++) {
        
			double differenceOfdataPointWithMean = raffleNumbers[i] - mean;
        		double squareTheDifference = differenceOfdataPointWithMean * differenceOfdataPointWithMean;
        		addSquares = addSquares + squareTheDifference;
        
		}//end of for	
    
        return Math.sqrt(addSquares/raffleNumbers.length);
	
	}//end of calculateStandardDeviation()
	
	
	/*
	 * @param A string of 10 raffle numbers seperated by commas and no space
	 * @return array of type int which contains the 10 raffle numbers 
	 */

    public static int[] getRaffleNumbers(String raffle) {
    	
    	//In case the student does not enter a raffle number, they just see 0's on their screen
    	//for the calculated mean and standard deviation values
    	if(raffle.equals("")) {
    		int[] zeroRaffle = new int[10];
    		for(int i = 0; i < 10; i++)
    			zeroRaffle[i] = 0;
    		return zeroRaffle;
    	} 
    	
    	int[] numbers = new int[10];
    	numbers[0] = Integer.parseInt(raffle.substring(0,raffle.indexOf(",")));
        
        raffle = raffle.substring(raffle.indexOf(",")+1);
        
        numbers[1] = Integer.parseInt(raffle.substring(0,raffle.indexOf(",")));
        raffle = raffle.substring(raffle.indexOf(",")+1);

        numbers[2] = Integer.parseInt(raffle.substring(0,raffle.indexOf(",")));
        raffle = raffle.substring(raffle.indexOf(",")+1);

        numbers[3] = Integer.parseInt(raffle.substring(0,raffle.indexOf(",")));
        raffle = raffle.substring(raffle.indexOf(",")+1);

        numbers[4] = Integer.parseInt(raffle.substring(0,raffle.indexOf(",")));
        raffle = raffle.substring(raffle.indexOf(",")+1);

        numbers[5] = Integer.parseInt(raffle.substring(0,raffle.indexOf(",")));
        raffle = raffle.substring(raffle.indexOf(",")+1);

        numbers[6] = Integer.parseInt(raffle.substring(0,raffle.indexOf(",")));
        raffle = raffle.substring(raffle.indexOf(",")+1);

        numbers[7] = Integer.parseInt(raffle.substring(0,raffle.indexOf(",")));
        raffle = raffle.substring(raffle.indexOf(",")+1);

        numbers[8] = Integer.parseInt(raffle.substring(0,raffle.indexOf(",")));
        raffle = raffle.substring(raffle.indexOf(",")+1);

        numbers[9] = Integer.parseInt(raffle.substring(0));
        
        return numbers;
    
    }//end of getRaffleNumbers()
    
    
	
	/************************************************
	 * 												*
	 * private methods for intra class use			*
	 * **********************************************
	 * openFile()									*
	 * countNumberOfSurveys()						*
	 * 												*
	 * **********************************************
	 */
	
	
	/*
	 * @return true if the inputStream is successfully connected to the file
	 */
	private static boolean openFile() {
				
    	try{
    		inputStream = new Scanner(new FileInputStream(fileName));
    		return true;
    	}
    	catch(FileNotFoundException e){
    	    System.out.println("File Not Found.");    	    
    	}
		return false;
	}//end of openFile()
	
	
	/*
	 * @return the number of surveys currently stored in the file 
	 */
	private static int countNumberOfSurveys() {
		
		int count = 0;
		
		//The following code is to get the number of lines in the file by using a counter.
		if(openFile()) {
			while(inputStream.hasNextLine()){
	    		inputStream.nextLine();
	    		count++; // counter to count the number of lines.
	       	}
		}
    	
       	inputStream.close();
        
       	//each survey is stored in 14 lines in a text file
        int numOfStudentSurvey = count/14;
        
        return numOfStudentSurvey;
	
	}//end of countNumberOfSurveys()
	
	
}//end of StudentService
