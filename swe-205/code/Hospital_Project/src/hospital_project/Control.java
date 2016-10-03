/*
 * Class name : Control.java
 *
 * Created on May 5, 2009, 6:31 PM
 *
 * Last Modified on June 12, 2009
 *
 * Why was this class created?
 * This class is what we call the "Master Class" or the "Control Class". This
 * class is very important as it forms the link between the GUI and the data text
 * files. All the GUI in the system interact with the data files only through this
 * class. This is the most powerful class in the program and this is what keeps
 * it stable and running.
 * Any changes made to this class in particular needs to be documented in excessive
 * detail to avoid system faliure.
 */

package hospital_project;
import java.util.*;
import java.io.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * @author  MHYS Software Productions. Copyright©. All rights unreserved.
 */

class Control {

    /*
     * This method will import all the information of a patient stored in a text
     * file to an array list and send it back to the class calling it.
    */
	public static ArrayList importPatientDatabase()
    {

     	Scanner input=null;
     	Scanner input2=null;
     	ArrayList<Patient> pats= new ArrayList<Patient>();
     	try
     	{
     		input=new Scanner(new File("PatientDB.txt"));
     		input2=new Scanner(new File("PatientDB.txt"));
     	}
     	catch(FileNotFoundException e)
     	{
     		JOptionPane.showMessageDialog(null, "Unable to import patient database file.", "Error", JOptionPane.ERROR_MESSAGE);
     	}
     	int i=0;//Predefined value of the word counter
     	int counter=0;//Predefined value of the inner loop counter
     	for(i=0;input.hasNext();i++)
     	{

     		String reader=input.next();//Info Reader that reads from file
     		//System.out.println("i1: "+i);
     		for(counter=0;counter<=i;counter++)
     		{
				if(input2.hasNextLine())
				{

                     pats.add(new Patient());
                     input2.nextLine();
                     if(input2.hasNextLine())
                     {
                     	input2.nextLine();
                     	if(input2.hasNextLine())
                     	{
                     		input2.nextLine();
                     	}
                     }
				}
     			if(i==counter*7)
     			{
     				String name=reader;
     				//System.out.println("------"+reader);
     				pats.get(counter).setName(name);
     				//System.out.println(docs.get(counter-1).getName());
     			}

     			if(i==(counter*7)+1)
     			{
     				String nationality=reader;
     				//System.out.println("------"+reader);
     				pats.get(counter).setNationality(nationality);

     				//System.out.println(docs.get(counter-1).getUserName());
     			}

     			if(i==(counter*7)+2)
     			{
     				String socialSecurityNumber=reader;
     				//System.out.println("------"+reader);
     				pats.get(counter).setSocialSecurityNumber(socialSecurityNumber);

     				//System.out.println(docs.get(counter-1).getPassword());
     			}
	     		if(i==(counter*7)+3)
	     		{
	     			String fileNumber=reader;
	     			  //   				System.out.println("------"+reader);
     				pats.get(counter).setFileNumber(fileNumber);
     				//System.out.println(docs.get(counter-1).getGender());

     			}
     			if(i==(counter*7)+4)
	     		{
     				String dateOfBirth=reader;
     				    // 				System.out.println("------"+reader);
     				pats.get(counter).setDateOfBirth(dateOfBirth);
					//System.out.println(docs.get(counter-1).getSpecialty());
					//System.out.println(docs.get(counter));
     			}
     			if(i==(counter*7)+5)
     			{
     				String gender=reader;
     				     //				System.out.println("------"+reader);
     				pats.get(counter).setGender(gender);

     			}
     			if((i==(counter*7)+6))
     			{
     				String bloodType=reader;
     				     	//			System.out.println("------"+reader);
     				pats.get(counter).setBloodType(bloodType);
     				input.nextLine();
     				String patientHistory=input.nextLine();
     				     	//			System.out.println("------"+reader);
     				pats.get(counter).setPatientHistory(patientHistory);
     			}
     				//System.out.println("counter: "+counter);
     		}
     		     	//	System.out.println("i"+i);
     	}
       	input.close();
       	input2.close();
      	return pats;
    }

    /*
     * This method will import all the information of appointment stored in a text
     * file to an array list and send it back to the class calling it. This class
     * takes the name of the doctor as an argument because the appointments for
     * each doctor is stored in a text file by the "name" of the doctor.
    */
	public static ArrayList importAppointmentDatabase(String docName)
    {
     	
     	Scanner input=null;
     	Scanner input2=null;
     	ArrayList<Appointment> app= new ArrayList<Appointment>();
     	try
     	{
     		input=new Scanner(new File(docName+".txt"));
     		input2=new Scanner(new File(docName+".txt"));
     	}
     	catch(FileNotFoundException e)
     	{
     		JOptionPane.showMessageDialog(null, "Unable to import appointment database.", "Error", JOptionPane.ERROR_MESSAGE);
     	}
     	int i=0;//Predefined value of the word counter
     	int counter=0;//Predefined value of the inner loop counter
     	for(i=0;input.hasNext();i++)
     	{

     		String reader=input.next();//Info Reader that reads from file
     		//System.out.println("i1: "+i);
     		for(counter=0;counter<=i;counter++)
     		{
				if(input2.hasNextLine())
				{
     				app.add(new Appointment());
     				input2.nextLine();
                   
				}

     			if(i==counter*4)
     			{	app.get(counter).setDoctorName(docName);
     				String patientName=reader;
     				app.get(counter).setPatientName(patientName);
     				//System.out.println(docs.get(counter-1).getName());
     			}

     			if(i==(counter*4)+1)
     			{
     				String appointmentDate=reader;
     				app.get(counter).setAppointmentDate(appointmentDate);
     				//System.out.println(receps.get(counter-1).getUserName());
     			}

     			if(i==(counter*4)+2)
     			{
     				String appointmentTime=reader;
     				app.get(counter).setAppointmentTime(appointmentTime);
     				//System.out.println(receps.get(counter-1).getPassword());
     			}
     			if(i==(counter*4)+3)
     			{
     				String department=reader;
     				app.get(counter).setDepartment(department);
     			}
     				//System.out.println("counter: "+counter);
     		}
     		     	//	System.out.println("i"+i);
     	}
     	//receps.removeRange(counter,receps.size());
       	input.close();
       	input2.close();
      	return app;
     }

    /*
     * This method will print all the information of the doctor's appointment
     * stored in an arraylist to a file named by the doctor's name.
     * This method takes two arguments.
     * 1. The array list of appointments for a doctor.
     * 2. The name of the doctor to create a file using his/her name.
    */
	public static void printAppointments(ArrayList<Appointment> app,String docName)
    {
		int i=0;
		PrintWriter output=null;
     	try
     	{
     		output=new PrintWriter(new File(docName+".txt"));
     	}
     	catch(FileNotFoundException e)
     	{
     		JOptionPane.showMessageDialog(null, "Unable to write appointment to the file.", "Error", JOptionPane.ERROR_MESSAGE);
     	}

     	for(Appointment a:app)
      	{
             
      		if(a.getDoctorName().equals(docName))
      		{
      			if(i==0)
      			{
                    
	      			output.print(a.getPatientName()+"\t"+a.getAppointmentDate()+"\t"+a.getAppointmentTime()+
      				"\t"+a.getDepartment());
	      			
      			}
      			else
      			{
                    output.println();
      				output.print(a.getPatientName()+"\t"+a.getAppointmentDate()+"\t"+a.getAppointmentTime()+
      				"\t"+a.getDepartment());
	      			
      			}
      			i++;
      		}
      	}
      	output.close();
	}

	/*
     * This method will import all the information of a doctor stored in a text
     * file to an array list and send it back to the class calling it.
    */
	public static ArrayList importDocDatabase()
     {
     	Scanner Keyboard=new Scanner(System.in);
     	Scanner input=null;
     	Scanner input2=null;
     	ArrayList<Doctor> docs= new ArrayList<Doctor>();
     	try
     	{
     		input=new Scanner(new File("DoctorDB.txt"));
     		input2=new Scanner(new File("DoctorDB.txt"));
     	}
     	catch(FileNotFoundException e)
     	{
     		JOptionPane.showMessageDialog(null, "Unable to import doctor database.", "Error", JOptionPane.ERROR_MESSAGE);
     	}
     	int i=0;//Predefined value of the word counter
     	int counter=0;//Predefined value of the inner loop counter
     	for(i=0;input.hasNext();i++)
     	{

     		String reader=input.next();//Info Reader that reads from file
     		//System.out.println("i1: "+i);
     		for(counter=0;counter<=i;counter++)
     		{
				if(input2.hasNextLine())
				{

     				docs.add(new Doctor());
     				input2.nextLine();
                    //System.out.println("size: "+docs.size());
                   
				}
     			if(i==counter*5)
     			{
                    
     				String name=reader;
     				docs.get(counter).setName(name);
     				//System.out.println(docs.get(counter-1).getName());
     			}

     			if(i==(counter*5)+1)
     			{
     				String userName=reader;
     				docs.get(counter).setUserName(userName);
     				//System.out.println(docs.get(counter-1).getUserName());
     			}

     			if(i==(counter*5)+2)
     			{
     				String password=reader;
     				docs.get(counter).setPassword(password);
     				//System.out.println(docs.get(counter-1).getPassword());
     			}
	     		if(i==(counter*5)+3)
	     		{
     				String gender=reader;
     				docs.get(counter).setGender(gender);
     				//System.out.println(docs.get(counter-1).getGender());

     			}
     			if(i==(counter*5)+4)
	     		{
     				String specialty=reader;
					docs.get(counter).setSpecialty(specialty);
					//System.out.println(docs.get(counter-1).getSpecialty());
					//System.out.println(docs.get(counter));
     			}

     				//System.out.println("counter: "+counter);
     		}
     		     	//	System.out.println("i"+i);
     	}
     	//docs.removeRange(counter,docs.size());
       	input.close();
       	input2.close();
      	return docs;
     }
     

    /*
     * This method will import all the information of a receptionist stored in a
     * text file to an array list and send it back to the class calling it.
    */
	public static ArrayList importReceptionistDatabase()
    {
     	Scanner Keyboard=new Scanner(System.in);
     	Scanner input=null;
     	Scanner input2=null;
     	ArrayList<Receptionist> receps= new ArrayList<Receptionist>();
     	try
     	{
     		input=new Scanner(new File("ReceptionistDB.txt"));
     		input2=new Scanner(new File("ReceptionistDB.txt"));
     	}
     	catch(FileNotFoundException e)
     	{
     		JOptionPane.showMessageDialog(null, "Unable to import receptionist from the file.", "Error", JOptionPane.ERROR_MESSAGE);
     	}
     	int i=0;//Predefined value of the word counter
     	int counter=0;//Predefined value of the inner loop counter
     	for(i=0;input.hasNext();i++)
     	{

     		String reader=input.next();//Info Reader that reads from file
     		//System.out.println("i1: "+i);
     		for(counter=0;counter<=i;counter++)
     		{
				if(input2.hasNextLine())
				{

     				receps.add(new Receptionist());
     				input2.nextLine();
				}
     			if(i==counter*3)
     			{
     				String name=reader;
     				receps.get(counter).setName(name);
     				//System.out.println(docs.get(counter-1).getName());
     			}

     			if(i==(counter*3)+1)
     			{
     				String userName=reader;
     				receps.get(counter).setUserName(userName);
     				//System.out.println(receps.get(counter-1).getUserName());
     			}

     			if(i==(counter*3)+2)
     			{
     				String password=reader;
     				receps.get(counter).setPassword(password);
     				//System.out.println(receps.get(counter-1).getPassword());
     			}
     				//System.out.println("counter: "+counter);
     		}
     		     	//	System.out.println("i"+i);
     	}
     	//receps.removeRange(counter,receps.size());
       	input.close();
       	input2.close();
      	return receps;
     }

    /*
     * This method will print all the information of the doctor
     * stored in an arraylist to a file.
     * This method takes one argument.
     * 1. The array list of doctor that is written back to the file.
    */
   	public static void printDoctorDatabase(ArrayList<Doctor> a)
	{	int i=0;
		PrintWriter output=null;
     	try
     	{
     		output=new PrintWriter(new File("DoctorDB.txt"));
     	}
     	catch(FileNotFoundException e)
     	{
     		JOptionPane.showMessageDialog(null, "Unable to print doctor to the database.", "Error", JOptionPane.ERROR_MESSAGE);
     	}
     	for(Doctor r:a)
      	{
      		if(i==0)
      		{
               
      			output.print(r.getName()+"\t"+r.getUserName()+"\t"+r.getPassword()+
      			"\t"+r.getGender()+"\t"+r.getSpecialty());
      			//output.println();
      		}
      		else
      		{
                output.println();

      			output.print(r.getName()+"\t"+r.getUserName()+"\t"+r.getPassword()+
      			"\t"+r.getGender()+"\t"+r.getSpecialty());
      			//output.println();
      		}
      		i++;
      	}
      	output.close();
	}

	/*
     * This method will print all the information of the receptionist
     * stored in an arraylist to a file.
     * This method takes one argument.
     * 1. The array list of receptionist that is written back to the file.
    */
	public static void printReceptionistDatabase(ArrayList<Receptionist> a)
	{
		PrintWriter output=null;
     	try
     	{
     		output=new PrintWriter(new File("ReceptionistDB.txt"));
     	}
     	catch(FileNotFoundException e)
     	{
     		JOptionPane.showMessageDialog(null, "Unable to write receptionist to the database file.", "Error", JOptionPane.ERROR_MESSAGE);
     	}
     	for(Receptionist r:a)
      	{	int i=0;
      		if(i==0)
      		{
      			output.print(r.getName()+"\t"+r.getUserName()+"\t"+r.getPassword());
                output.println();
      			
      		}
      		else
      		{
                output.println();
      			output.print(r.getName()+"\t"+r.getUserName()+"\t\t\t"+r.getPassword());
      			
      		}
      		i++;
      	}
      	output.close();
	}

    /*
     * This method will print all the information of the patients
     * stored in an arraylist to a file.
     * This method takes one argument.
     * 1. The array list of patient that is written back to the file.
    */
    public static void printPatientDatabase(ArrayList<Patient> pat)
	{
		PrintWriter output=null;
		int i=0;
     	try
     	{
     		output=new PrintWriter(new File("PatientDB.txt"));
     	}
     	catch(FileNotFoundException e)
     	{
     		JOptionPane.showMessageDialog(null, "Unable to write patient to the file.", "Error", JOptionPane.ERROR_MESSAGE);
     	}

		for(Patient r:pat)
      	{
      		if(i==0)
      		{
                
      			output.print(r.getName()+"\t"+r.getNationality()+"\t"+r.getSocialSecurityNumber()+
      			"\t"+r.getFileNumber()+"\t\t"+r.getDateOfBirth()+"\t\t"+r.getGender()+"\t"+r.getBloodType());
                output.println();
                output.println(r.getPatientHistory());
      			
      		}
      		else
      		{
                output.println();
      			output.print(r.getName()+"\t"+r.getNationality()+"\t\t"+r.getSocialSecurityNumber()+
      			"\t"+r.getFileNumber()+"\t\t"+r.getDateOfBirth()+"\t"+r.getGender()+"\t"+r.getBloodType());
                output.println();
                output.println(r.getPatientHistory());
      			
      		}
      		i++;
      	}
      	output.close();
	}

    /*
     * This method is to verify the login procedure. Here the username and
     * password entered by the user is passed as an argument along with the
     * entire doctor and receptionist array list.
     * It searches for the presence of the particular user and returns back
     * a true or a false answer as it has a boolean return type.
     */
    public static boolean loginValidation(ArrayList<Doctor> doc, ArrayList<Receptionist> rec, String userName,String password, String occupation)
	{
		//check if its a doctor or receptionist then set the string accordingly
		

		if(occupation.equalsIgnoreCase("Doctor"))
		{
			for(Doctor d:doc)
			{
				if(d.getUserName().equals(userName))
				{
					if(d.getPassword().equals(password))
					{
						return true;
					}
				}
			}
			return false;
		}

		else if(occupation.equalsIgnoreCase("Receptionist"))
		{
			for(Receptionist r:rec)
			{
				if(r.getUserName().equals(userName))
				{
					if(r.getPassword().equals(password))
					{
						return true;
					}
				}
			}
			return false;
		}

		return false;
	 }

    /*
     * This method allows the doctor to make changes to the patient history.
     * The method has 4 arguments.
     * 1. The patient array list.
     * 2. The patient name from the GUI.
     * 3. The patient file number from the GUI.
     * 4. The patient history from the database.
     * This will allow the doctor to update or make changes to the patient
     * history and then write the changed history back to the databse file.
     */
    public static void editPatientHistory(ArrayList<Patient> pat,String patientName,String patientNumber,String patientHistory)
	{
		for(Patient p: pat)
		{
			if(p.getName().equalsIgnoreCase(patientName))
			{
				if(p.getFileNumber().equalsIgnoreCase(patientNumber))
				{
					p.setPatientHistory(patientHistory);
				}
				return;
			}
			System.out.println("Patient not found");

		}
	}
}

