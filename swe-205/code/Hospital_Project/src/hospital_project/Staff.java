/*
 * Class name : Staff.java
 *
 * Created on May 6, 2009, 8:37 PM
 *
 * Last Modified on June 12, 2009
 *
 * Why was this class created?
 * This class was created after the common attributes from all the users were
 * collected. Then these were put together in this class.
 */

package hospital_project;

/*
 * @author  MHYS Software Productions. Copyright©. All rights unreserved.
 */

/* The Staff Class is a parent class for the hospital's staff which are: 
 * Receptionist,Adminstrator and Doctor.
 */

class Staff {
    
    /* Here I declare three elements. They are as follows:
     * name of type STRING
     * password of type STRING
     * userName of type STRING
     * Three other classes will extend this class. They are :
     * 1. Doctor
     * 2. Administrator
     * 3. Receptionist
    */

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
    
    //
    //Accessors and Mutators
    //

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
