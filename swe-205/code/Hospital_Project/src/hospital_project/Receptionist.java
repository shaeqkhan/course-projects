/*
 * Class name : Receptionist.java
 *
 * Created on May 6, 2009, 9:35 PM
 *
 * Last Modified on June 12, 2009
 *
 * Why was this class created?
 * This class was created to form an instance of this class so that the system
 * can have many receptionist stored as users for the system.
 * Here we define the necessary attributes to create a receptionist account
 * along with accessors and mutators for these attributes.
 * The Receptionist Class is a sub Class of Staff and contains the Receptionist
 * constructors to create new objects of this type. It also contains
 * the Methods that a receptionist can invoke when using this application
 * Methods: addToPatientDatabase(),createAppointment()
 */

package hospital_project;

/*
 * @author  MHYS Software Productions. Copyright©. All rights unreserved.
 */


import java.util.*;
import java.io.*;

class Receptionist extends Staff{

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
    	if(appDate.equalsIgnoreCase(date))
		{
			pastDate=true;
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
    	Control c=new Control();
    	c.printAppointments(app,doctorName);

    }


}
