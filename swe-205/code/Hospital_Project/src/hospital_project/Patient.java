/*
 * Class name : Patient.java
 *
 * Created on May 6, 2009, 8:00 PM
 *
 * Last Modified on June 12, 2009
 *
 * Why was this class created?
 * This class was created to form an instance of this class so that the system
 * can have record of many patients for the system.
 * Here we define the necessary attributes to create a patientalong with
 * accessors and mutators for these attributes.
 */

package hospital_project;

/**
 * @author  MHYS Software Productions. Copyright©. All rights unreserved.
 */

class Patient {

    /*
     * This class is for storing information of the patient that will visit
     * the hospital.
     * It is an independent class and will not inherit or implement any class.
     * It has a total of 8 variables.
     * They are as follows:
     * 1. bloodType of type STRING
     * 2. dateOfBirth of type STRING
     * 3. fileNumber of type STRING
     * 4. name of type STRING
     * 5. nationality of type STRING
     * 6. patientHistory of type STRING
     * 7. socialSecurityNumber of type STRING
     * 8. gender of type STRING
     *
     * Patient Class is a class created to store patient information which is
     * done by the receptionist, it contains constructor(s) in order to create
     * new patients and store their information.
     */

    private String bloodType;
	private String dateOfBirth;
	private String fileNumber;
	private String name;
	private String nationality;
	private String patientHistory;
	private String socialSecurityNumber;
	private String gender;

    // Constructors
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
			"\nNationality"+nationality+ "\nPatient History: "+patientHistory+"\nSocial Security Number: "+socialSecurityNumber+
			"\nGender"+gender;
	}

	//
    //Setter And Getter
	//

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
