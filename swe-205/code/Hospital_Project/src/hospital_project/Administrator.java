/*
 * Class name : Administrator.java
 *
 * Created on May 4, 2009, 8:30 PM
 *
 * Last Modified on June 12, 2009
 *
 * Why was this class created?
 * This class was created to form an instance of this class so that the system
 * can have more than one system administrator.
 * Here we define the necessary attributes to create an admin account along with
 * accessors and mutators for these attributes.
 * 
 */

package hospital_project;
import java.io.*;
import java.util.ArrayList;
import java.util.*;

/**
 * @author  MHYS Software Productions. Copyright©. All rights unreserved.
 */

class Administrator extends Staff {

    /* This class extends class "Staff".
     */

    public Administrator(String name, String username, String password){
        super(name, username, password);
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
		a.add(new Doctor(name,userName,password,specialty,Gender));
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
			a.set(index,new Doctor(name,userName,password,specialty,gender));
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
