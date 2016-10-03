/*
 * Class name : Appointment.java
 *
 * Created on May 4, 2009, 8:24 PM
 *
 * Last Modified on June 12, 2009
 *
 * Why was this class created?
 * This class was created to form an instance of this class so that the system
 * can create appointments for the doctors.
 * Here we define the necessary attributes to create an appointment along with
 * accessors and mutators for these attributes.
 * the Appointment Class is a class used to create appointments by the
 * receptionist and then stores that in a database file named by the doctor's name.
 */

package hospital_project;
import java.util.ArrayList;

/**
 * @author  MHYS Software Productions. Copyright©. All rights unreserved.
 */

class Appointment {

    /*
     * This class will contain 5 variables.
     * They are as follows:
     * 1. appointmentDate of type STRING
     * 2. appointmentTime of type STRING
     * 3. department of type STRING
     * 4. doctorName of type STRING
     * 5. patientName of type STRING
     */

    // Attribute initialization
    private String appointmentDate;
	private String appointmentTime;
	private String department;
	private String doctorName;
	private String patientName;

    // default constructor
	public Appointment()
	{
		appointmentDate="no Date";
		appointmentTime="00:00";
		department="nothing";
		doctorName="no Name";
		patientName="no Name";
	}

    // Constructor
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

    /* This method is to check if the time entered by the receptionist has not
     * been already reserved by another patient. This is important to make sure
     * that there are no appointment conflicts in the doctor's schedule.
     * It is of type boolean and will return FALSE is the time has been taken.
     */
	public static boolean checkTime(ArrayList<Appointment> app,String time)
	{
		for(Appointment a:app)
		{
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
