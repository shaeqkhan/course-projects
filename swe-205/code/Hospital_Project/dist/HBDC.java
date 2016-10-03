/**
 * @(#)HBDC.java
 *
 *
 * @author 
 * @version 1.00 2009/4/23
 */
import java.util.*;
import java.io.*;
import javax.swing.*;
public class HBDC 
{

    public static void main(String args[]) 
    {
    	/*Scanner Keyboard=new Scanner(System.in);
		System.out.print("Insert the doctor's name: ");
		String dName=Keyboard.next();
		Receptionist a=new Receptionist();
		
		a.createAppointment(b.importAppointmentDatabase(dName),b.importDocDatabase(),dName,b.importPatientDatabase());*/
		Cantrol b=new Cantrol();

		System.out.println(b.importPatientDatabase());
		//System.out.println(b.loginValidation(b.importDocDatabase(),b.importReceptionistDatabase(),"jamjam","looka"));
    	
    	
    
    }
    
    
}

//Program Classes

/* The Staff Class is a parent class for the hospital's staff which are: Receptionist,Adminstrator and Doctor*/
class Staff
{
	//Instance Variables
	private String name;
	private String password;
	private String userName;
	
	//Constructors
	public Staff(String name,String userName,String password)
	{
		this.name=name;
		this.userName=userName;
		this.password=password;
	}
	public Staff()
	{
		this.name=null;
		this.userName=null;
		this.password=null;
	}
	
	//Methods
	
	public String toString()
	{
		return "Name: "+name+"\nUser Name: "+userName+"\nPassword: "+password;
	}
	//Accessors and Mutators
	//Name
	public void setName(String name)
	{
		this.name=name;
	}
	public String getName()
	{
		return name;
	}
	//userName
	public void setUserName(String userName)
	{
		this.userName=userName;
	}
	public String getUserName()
	{
		return userName;
	}
	//password
	public void setPassword(String password)
	{
		this.password=password;
	}
	public String getPassword()
	{
		return password;
	}

}

/* The Doctor Class is a sub class of Staff and contains the doctor constructors in order to create new objects of this type. It also contains
 *The Methods that the doctor can invoke when using the application*/
class Doctor extends Staff
{
	//Instance Variables
	private String gender;
	private String specialty;
	private Appointment schedule;
	
	//Constructors
	public Doctor()
	{
		super();
		this.specialty=null;
		this.gender=null;
		this.schedule=null;
	}
	public Doctor(String name,String userName,String password,String specialty,String gender,Appointment schedule)
	{
		super(name,userName,password);
		this.specialty=specialty;
		this.gender=gender;
		this.schedule=schedule;
	}

	//Methods	
	public String toString()
	{
		return super.toString()+"\ngender: "+gender+"\nspecialty: "+specialty;
	}
	
	//Accessors and Mutators
	
	//specialty
	public void setSpecialty(String specialty)
	{
		this.specialty=specialty;
	}
	public String getSpecialty()
	{
		return specialty;
	}
	
	//gender
	public void setGender(String gender)
	{
		this.gender=gender;
	}
	public String getGender()
	{
		return gender;
	}
}

/*The Receptionist Class is a sub Class of Staff and contains the Receptionist constructors to creat new objects of this type. It also contains 
 *the Methods that a receptionist can invoke when using this application
 *Methods: addToPatientDatabase(),createAppointment()
 **/
class Receptionist extends Staff
{
	// Instance Variables
	
	
	//Constructors
	public Receptionist()
	{
		super();
	}
	public Receptionist(String name,String userName,String password)
	{
		super(name,userName,password);
	}
	
	//Methods
	
    // ADD PATIENT TO DB
   	public void addToPatientDatabase(ArrayList<Patient> a)
	{	
		
		Scanner Keyboard=new Scanner(System.in);
		System.out.print("Insert the Patient's Name: ");
		String name=Keyboard.next();
		System.out.print("Insert the Nationality: ");
		String nationality=Keyboard.next();
		System.out.print("Insert the Social Security Number: ");
		String socialSecurityNumber=Keyboard.next();
		System.out.print("Insert the Patient File Number: ");
		String fileNumber=Keyboard.next();
		System.out.print("Insert the Patient's Date of Birth: ");
		String dateOfBirth=Keyboard.next();
		System.out.print("Insert the Patient's Gender: ");
		String gender=Keyboard.next();
		System.out.print("Insert the Blood Type: ");
		String bloodType=Keyboard.next();
		System.out.print("Insert the Patient's History: ");
		String patientHistory=Keyboard.next();
		a.add(new Patient(name,nationality,socialSecurityNumber,fileNumber,dateOfBirth,gender,bloodType,patientHistory));
		a.trimToSize();	
	}
	
    // CREATE APPOINTMENT
    public void createAppointment(ArrayList<Appointment> app,ArrayList<Doctor> doc,String dName,ArrayList<Patient> pat)
    {
    	Scanner Keyboard=new Scanner(System.in);
    	int appointmentIndex=0;//contains the appointment index 
    	int i=0;// counter to check if the loop reached the end of the array list
    	boolean pastAppointment=true; //boolean to see if there is a previous appointment made for the same doctor
    	boolean pastDate=false;//boolean to see if there are any appointments to the assigned date
    	String doctorName=null;
    	String patientName=null;
    	String appDate=null;
    	for(Doctor n:doc)
    	{
    			
    			System.out.println("Doctor: "+n.getName());
    			if(n.getName().equalsIgnoreCase(dName))
    			{
    				doctorName=n.getName();
					break;
    			}
    			else if(i==doc.size()-1)
    			{
    				System.out.println("Doctor  not Found!");
    				System.exit(0);
    			}
    			i++;
    	}

    	
    	System.out.print("What is the patient's name: ");
    	String pName=Keyboard.next();
    	i=0;
    	for(Patient p:pat)
    	{
    		if(p.getName().equalsIgnoreCase(pName))
    		{
    			patientName=p.getName();
    			break;
    		}
    		
    		if(i== pat.size()-1)
    		{
    			System.out.println("Error: unable to find patient");
    		}
    		i++;
    	}
    	
    	i=0;
    	if(app.size()==0)
    	{
    		pastAppointment=false;
    	}
    	
    	else
    	{
    	
    		for(Appointment a:app)
    		{		
	
    				if(a.getDoctorName().equalsIgnoreCase(doctorName))
    				{
	    				appDate=a.getAppointmentDate();
    					appointmentIndex=app.indexOf(a);
						break;
    				}
    				else if(i==app.size()-1)
    				{
	    				System.out.println("Date not Found!");
    					pastAppointment=false;
    				}
    				i++;
    		}
    	}
    	
    	
    	System.out.print("Insert the department's name: ");
    	String department=Keyboard.next();
    	
    	System.out.print("Specify the date of the appointment: (day/month/year)");
    	String date=Keyboard.next();
    	
    	if(!pastAppointment)
    	{
    		pastDate=false;
    	}
    	
    	else
    	{
    		if(appDate.equalsIgnoreCase(date))
			{
				pastDate=true;
			}
    	}
    	System.out.print("insert the time u want to have the appoinment: ");
    	String time=Keyboard.next();
    	
    	//at this point we check if the date AND time are already used in the database or not before adding the new appointment
    	if(pastAppointment&&pastDate)
    	{
    		while(!app.get(appointmentIndex).checkTime(app,time))
    		{
	    		System.out.print("that time is already taken,insert the time u want to have the appoinment: ");
    			time=Keyboard.next();
    		}
    	}

    	app.add(new Appointment(date,time,department,doctorName,patientName));
    	Cantrol c=new Cantrol();
    	c.printAppointments(app,doctorName);
    	 	    
    }
	

}

/* The Admin Class is a sub  class of Staff and contains the admin constructor in order to create one admin who can take cantrol of the whole 
 *application.It also contains all the methods that provides the admin access to the System
 *Methods: printDocDatabase(),addToReceptionistDatabase(),changeUser(),removeUser()
 */
class Admin extends Staff
{
	//Instance Variables
	
	//Constructors
	public Admin(String name,String userName,String password)
	{
		super(name,userName,password);
			
	}
	
	//**************Methods

     
     //**********************************************************Add to DB****************************************************************
   	public void printDocDatabase(ArrayList<Doctor> a)
	{	
		int i=0; //counter for the output (scroll down)
		Scanner Keyboard=new Scanner(System.in);
		System.out.print("Insert your Name: ");
		String name=Keyboard.next();
		System.out.print("Insert your User Name: ");
		String userName=Keyboard.next();
		System.out.print("Insert your Passowrd: ");
		String password=Keyboard.next();
		System.out.print("Insert your specialty: ");
		String specialty=Keyboard.next();
		System.out.print("Insert your gender: ");
		String gender=Keyboard.next();
		String Gender=gender.substring(0,1);
		a.add(new Doctor(name,userName,password,specialty,Gender,null));
		a.trimToSize();
		//Iterator cursor=a.iterator();
     	PrintWriter output=null;
     	try
     	{
     		output=new PrintWriter(new File(name+".txt"));
     	}
     	catch(FileNotFoundException e)
     	{
     		System.out.println("File Not found");
     		System.exit(0);
     	}
     	
      	output.close();  
	}
	

	//***************************************************Add new Receptionist*********************************************************************
    public void addToReceptionistDatabase(ArrayList<Receptionist> a)
	{	
		int i=0; //counter for the output (scroll down)
		Scanner Keyboard=new Scanner(System.in);
		System.out.print("Insert your Name: ");
		String name=Keyboard.next();
		System.out.print("Insert your User Name: ");
		String userName=Keyboard.next();
		System.out.print("Insert your Passowrd: ");
		String password=Keyboard.next();
		a.add(new Receptionist(name,userName,password));
		a.trimToSize();
		//Iterator cursor=a.iterator();
     	PrintWriter output=null;
     	try
     	{
     		output=new PrintWriter(new File("ReceptionistDB.txt"));
     	}
     	catch(FileNotFoundException e)
     	{
     		System.out.println("File Not found");
     		System.exit(0);
     	}
     	for(Receptionist r:a)
      	{	
      		if(i==0)
      		{
      			output.print(r.getName()+"\t"+r.getUserName()+"\t"+r.getPassword());
      			output.println();
      		}
      		else
      		{
      			output.print(r.getName()+"\t"+r.getUserName()+"\t\t"+r.getPassword());
      			output.println();	
      		}
      		i++;
      	}
      	output.close();  
	}
	// ******************************************************User Editing***************************************************************
	public int searchForUser(ArrayList<Doctor> a,ArrayList<Receptionist> b)
	{
		Scanner Keyboard=new Scanner(System.in);
		
		System.out.print("Insert the type of User: ");
		String userType=Keyboard.next();
		
		System.out.print("Insert the User's Real Name: ");
		String name=Keyboard.next();
		
		System.out.print("Insert the User's User Name: ");
		String userName=Keyboard.next();
		
		if(userType.equalsIgnoreCase("Doctor"))
		{
			for(Doctor doc:a)
			{
				if(doc.getName().equals(name)&&doc.getUserName().equals(userName))
				{
					return a.indexOf(doc);
				}		
			}
			return -1;
		}
		else if(userType.equalsIgnoreCase("Receptionist"))
		{
			for(Receptionist receps:b)
			{
				if(receps.getName().equals(name)&&receps.getUserName().equals(userName))
				{
					return b.indexOf(receps);
				}		
			}
			return -1;
		}
		return -1;
	}
	
	public ArrayList changeUser(ArrayList <Doctor> a,ArrayList<Receptionist> b,int index)
	{	
		
		Scanner kb=new Scanner (System.in);
		
		System.out.print("Insert the User Type: ");
		String userType=kb.next();
		
		if(userType.equalsIgnoreCase("Doctor"))
		{
			System.out.print("Enter the New User Name: ");
			String userName =kb.next();
			System.out.print("Enter the New Password: ");
			String password=kb.next();
			System.out.print(" Retype the Password: ");
			String repassword=kb.next();
			System.out.print(" Enter the New Name: ");
			String name= kb.next();
			System.out.print("Enter the Speciality: ");
			String specialty=kb.next();
			System.out.print("Enter the New Gender: ");
			String gender=kb.next();
		
			
			if(!password.equals(repassword))
			{
				System.out.print(" The Password Does  Not Match Please Re-enter It: ");
				password=kb.next();
				System.out.print("Re Enter the Password: ");
				repassword=kb.next();
			}
			a.set(index,new Doctor(name,userName,password,specialty,gender,null));
			return a;
		}
		else if(userType.equalsIgnoreCase("Receptionist"))
		{
			System.out.print("enter the new user name");
			String userName =kb.next();
			System.out.print("enter the new password");
			String password=kb.next();
			System.out.print(" retype the password");
			String repassword=kb.next();
			System.out.print(" enter the new name");
			String name= kb.next();
			
			if(!password.equals(repassword))
			{
				System.out.println(" the password does not match please reenter it");
				password=kb.next();
				System.out.println("re enter the password");
				repassword=kb.next();
			}
			b.set(index,new Receptionist(name,userName,password));
			return b;
		}
		
		return a;
	}
	
	public ArrayList removeUser(ArrayList <Doctor> a,ArrayList<Receptionist> b,int index)
	{
		Scanner Keyboard=new Scanner(System.in);
		
		System.out.print("What Type of User Will you Remove? ");
		String userType=Keyboard.next();
		
		if(userType.equalsIgnoreCase("Doctor"))
		{
			a.remove(index);
			return a;
		}
		
		else if(userType.equalsIgnoreCase("Receptionist"))
		{
			b.remove(index);
				return b;
		}
		return null;
	}
	

}


/*Patient Class is a class created to store patient information which is done by the receptionist, it contains constructor(s) in order to create
 *new patients and store their information.
 */
class Patient
{
	private String bloodType;
	private String dateOfBirth;
	private String fileNumber;
	private String name;
	private String nationality;
	private String patientHistory;
	private String socialSecurityNumber;
	private String gender;
	
	public Patient()
	{
		bloodType=null;
		dateOfBirth=null; 
		fileNumber=null; 
		name=null;
		nationality=null;
		patientHistory=null;
		socialSecurityNumber =null;
		gender=null;
	}
	public Patient(String name,String nationality,String socialSecurityNumber,String fileNumber,String dateOfBirth,String gender,String bloodType,String patientHistory)
	{
		this.bloodType=bloodType;
		this.dateOfBirth=dateOfBirth; 
		this.fileNumber=fileNumber; 
		this.name=name;
		this.nationality=nationality;
		this.patientHistory=patientHistory;
		this.socialSecurityNumber =socialSecurityNumber;
		this.gender=gender;
	}
	//METHODS
	public String toString()
	{
		return "Blood Type: "+bloodType+"\nDate of birth: "+dateOfBirth+"\nFile Number: "+fileNumber+"\nName: "+name+
			"\nNationality"+nationality+ "\nPatient History: "+patientHistory+/*"\nPrescription: "+prescription+*/"\nSocial Security Number: "+socialSecurityNumber+
			"\nGender"+gender;
	}
	
	//Setter And Getter
	//Blood Type
	void setBloodType(String bloodType)
	{
		this.bloodType=bloodType;
	}
	String getBloodType()
	{
		return bloodType;
	}
	//DOB
	void setDateOfBirth(String dateOfBirth)
	{
		this.dateOfBirth=dateOfBirth;
	}
	String getDateOfBirth()
	{
		return dateOfBirth;
	}
	//File Number
	void setFileNumber(String fileNumber)
	{
		this.fileNumber=fileNumber;
	}
	String getFileNumber()
	{
		return fileNumber;
	}
	//Name
	void setName(String name)
	{
		this.name=name;
	}
	String getName()
	{
		return name;
	}
	//Nationality
	void setNationality(String nationality)
	{
		this.nationality=nationality;
	}
	String getNationality()
	{
		return nationality;
	}
	//History
	void setPatientHistory(String patientHistory) 
	{
		this.patientHistory=patientHistory;
	}
	String getPatientHistory()
	{
		return patientHistory;
	}
	/*
	void setPrescription(String prescription)
	{
		this.prescription=prescription;
	}
	String getPrescription()
	{
		return prescription;
	}
	*/
	//Social ID
	void setSocialSecurityNumber(String socialSecurityNumber)
	{
		this.socialSecurityNumber=socialSecurityNumber;
	}
	String getSocialSecurityNumber()
	{
		return socialSecurityNumber;
	}
	//Gender
	void setGender(String gender)
	{
		this.gender=gender;
	}
	String getGender()
	{
		return gender;
	}
}

/*the Appointment Class is a class used to create appointments by the receptionist and then stores that in a database file named by the doctor*/
class Appointment
{
	private String appointmentDate;
	private String appointmentTime;
	private String department;
	private String doctorName;
	private String patientName;
	public static final String time1="8-9";
	public static final String time2="9-10";
	public static final String time3="10-11";
	public static final String time4="11-12";
	public static final String time5="1-2";
	public static final String time6="2-3";
	public static final String time7="3-4";
	public static final String time8="4-5";
	
	public Appointment()
	{
		appointmentDate="no Date";
		appointmentTime="00:00";
		department="nothing";
		doctorName="no Name";
		patientName="no Name";
	}
	public Appointment(String appoinemntDate,String appointmentTime,String department,String doctorName,String patientName)
	{
		this.appointmentDate=appoinemntDate;
		this.appointmentTime=appointmentTime;
		this.department=department;
		this.doctorName=doctorName;
		this.patientName=patientName;
	}
	
	//Methods
	public String toString()
	{
		return "appointment Date: "+appointmentDate+"\nappointment Time: "+appointmentTime+"\nDepartment: "+department+"\nDoctorName: "+doctorName+
			"\nPatient Name"+patientName;
	}
	
	public boolean checkTime(ArrayList<Appointment> app,String time)
	{	
		for(Appointment a:app)
		{
			System.out.println(a.getAppointmentTime());
			System.out.println(time);
			if(a.getAppointmentTime().equalsIgnoreCase(time))
			{
				return false;
			}
		}
		return true;
	}
	//Setter and Getter
	//Date
	void setAppointmentDate(String appointmentDate)
	{
		this.appointmentDate=appointmentDate;
	}
	String getAppointmentDate()
	{
		return appointmentDate;
	}
	//Time
	void setAppointmentTime(String appointmentTime)
	{
		this.appointmentTime=appointmentTime;
	}
	String getAppointmentTime()
	{
		return appointmentTime;
	}
	//Department
	void setDepartment(String department)
	{
		this.department=department;
	}
	String getDepartment()
	{
		return department;
	}
	//Doctor's Name
	void setDoctorName(String doctorName)
	{
		this.doctorName=doctorName;
	}
	String getDoctorName()
	{
		return doctorName;
	}
	//Patient Name
	void setPatientName (String patientName)
	{
		this.patientName=patientName;
	}
	String getPatientName()
	{
		return patientName;
	}
 }    

class Cantrol
{
	//PATIENT INFO IMPORTING
		public static ArrayList importPatientDatabase()
    {
     	Scanner Keyboard=new Scanner(System.in);
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
     		/*	if(i==(counter*7)+6)
     			{

     			}
     		*/

     				//System.out.println("counter: "+counter);
     		}
     		     	//	System.out.println("i"+i);
     	}
       	input.close();
       	input2.close();
      	return pats;
    }
    
    //APPOINTMENT IMPORTING
	public static ArrayList importAppointmentDatabase(String docName)
     {	
     	Scanner Keyboard=new Scanner(System.in);
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
     		System.out.println("File not found/Unable to access file");
     		System.exit(0);
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
     
    //APPOINTMENT PRINTING
	public void printAppointments(ArrayList<Appointment> app,String docName)
{
		int i=0;
		PrintWriter output=null;
     	try
     	{
     		output=new PrintWriter(new File(docName+".txt"));
     	}
     	catch(FileNotFoundException e)
     	{
     		System.out.println("File Not found");
     		System.exit(0);
     	}
     	
     	for(Appointment a:app)
      	{	
      		if(a.getDoctorName().equals(docName))
      		{
      			if(i==0)
      			{
	      			output.print(a.getPatientName()+"\t"+a.getAppointmentDate()+"\t"+a.getAppointmentTime()+
      				"\t"+a.getDepartment());
	      			output.println();
      			}
      			else
      			{
      				output.print(a.getPatientName()+"\t"+a.getAppointmentDate()+"\t"+a.getAppointmentTime()+
      				"\t"+a.getDepartment());
	      			output.println();	
      			}
      			i++;
      		}
      	}
      	output.close();
	}
	
	//DOCTOR IMPORTING
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
     		System.out.println("File not found/Unable to access file");
     		System.exit(0);
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
     
    //RECEPTIONIST IMPORTING
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
     		System.out.println("File not found/Unable to access file");
     		System.exit(0);
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
     
    //DOCTOR PRINTING
   	public void printDoctorDatabase(ArrayList<Doctor> a)
	{	int i=0;
		PrintWriter output=null;
     	try
     	{
     		output=new PrintWriter(new File("DoctorDB.txt"));
     	}
     	catch(FileNotFoundException e)
     	{
     		System.out.println("File Not found");
     		System.exit(0);
     	}
     	for(Doctor r:a)
      	{	
      		if(i==0)
      		{
      			output.print(r.getName()+"\t"+r.getUserName()+"\t"+r.getPassword()+
      			"\t"+r.getGender()+"\t"+r.getSpecialty());
      			output.println();
      		}
      		else
      		{
      			output.print(r.getName()+"\t"+r.getUserName()+"\t\t"+r.getPassword()+
      			"\t\t"+r.getGender()+"\t"+r.getSpecialty());
      			output.println();	
      		}
      		i++;
      	}
      	output.close();
	}
	
	//RECEPTIONIST PRINTING
	public void printReceptionistDatabase(ArrayList<Receptionist> a)
	{
		PrintWriter output=null;
     	try
     	{
     		output=new PrintWriter(new File("ReceptionistDB.txt"));
     	}
     	catch(FileNotFoundException e)
     	{
     		System.out.println("File Not found");
     		System.exit(0);
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
      			output.print(r.getName()+"\t"+r.getUserName()+"\t\t\t"+r.getPassword());
      			output.println();	
      		}
      		i++;
      	}
      	output.close();  
	}
	
	//PATIENT PRINTING
	public void printPatientDatabase(ArrayList<Patient> pat)
	{
		PrintWriter output=null;
		int i=0;
     	try
     	{
     		output=new PrintWriter(new File("PatientDB.txt"));
     	}
     	catch(FileNotFoundException e)
     	{
     		System.out.println("File Not found");
     		System.exit(0);
     	}
     	
		for(Patient r:pat)
      	{	
      		if(i==0)
      		{
      			output.print(r.getName()+"\t"+r.getNationality()+"\t"+r.getSocialSecurityNumber()+
      			"\t"+r.getFileNumber()+"\t\t"+r.getDateOfBirth()+"\t\t"+r.getGender()+"\t"+r.getBloodType()+
      			"\t"+r.getPatientHistory());
      			output.println();
      		}
      		else
      		{
      			output.print(r.getName()+"\t"+r.getNationality()+"\t\t"+r.getSocialSecurityNumber()+
      			"\t"+r.getFileNumber()+"\t\t"+r.getDateOfBirth()+"\t"+r.getGender()+"\t"+r.getBloodType()+
      			"\t\t"+r.getPatientHistory());
      			output.println();	
      		}
      		i++;
      	}
      	output.close();
	}
	
	public boolean loginValidation(ArrayList<Doctor> doc,ArrayList<Receptionist> rec,String userName,String password)
	{
		//check if its a doctor or receptionist then set the string accordingly
		String occupation="Receptionist";
		
		if(occupation.equalsIgnoreCase("Doctor"))
		{
			for(Doctor a:doc)
			{
				if(a.getUserName().equals(userName))
				{
					if(a.getPassword().equals(password))
					{
						return true;
					}
				}
			}
			return false;
		}
		
		else if(occupation.equalsIgnoreCase("Receptionist"))
		{
			for(Receptionist a:rec)
			{
				if(a.getUserName().equals(userName))
				{
					if(a.getPassword().equals(password))
					{
						return true;
					}
				}
			}
			return false;
		}

		return false;
	}
	
	public void editPatientHistory(ArrayList<Patient> pat,String patientName,String patientNumber,String patientHistory)
	{
		for(Patient p: pat)
		{
			if(p.getName().equalsIgnoreCase(patientName))
			{
				if(p.getName().equalsIgnoreCase(patientNumber))
				{
					p.setPatientHistory(patientHistory);
				}
				return;
			}
			System.out.println("Patient not found");
			
		}
	}
    
}
