/*
 * Class name : Doctor.java
 *
 * Created on May 6, 2009, 8:35 PM
 *
 * Last Modified on June 12, 2009
 *
 * Why was this class created?
 * This class was created to form an instance of this class so that the system
 * can have many doctors stored as users for the system.
 * Here we define the necessary attributes to create a doctor account along with
 * accessors and mutators for these attributes.
 */

package hospital_project;

/**
 * @author  MHYS Software Productions. Copyright©. All rights unreserved.
 */

/* The Doctor Class is a child class of Staff and contains the doctor constructors
 * in order to create new objects of this type. It also contains
 * The Methods that the doctor can invoke when using the application*/

class Doctor extends Staff {

    /*
     * This class will extend the class "Staff".
     * Besides that it will also have three variables declared in itself. 
     * This class is mainly to 
     * store infromation about the doctors and the pateints that visit them.
     * The two variables are:
     * 1. gender of type STRING
     * 2. speciality of type STRING
     */

    //Instance Variables

    private String gender;
	private String specialty;

	//Constructors

    public Doctor()
	{
		super();
		this.specialty=null;
		this.gender=null;
	}

    public Doctor(String name,String userName,String password,String specialty,String gender)
	{
		super(name,userName,password);
		this.specialty=specialty;
		this.gender=gender;
	}

	//Methods

    public String toString()
	{
		return super.toString()+"\ngender: "+gender+"\nspecialty: "+specialty;
	}

    //
	//Accessors and Mutators
	//

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
