/*
 * Author - Shaeq Khan
 * Description - coded as per requirements in assignment problem statement
 
 * Assignment#2 - Due 12th Sept 2012, 16:30 
 * Course - SWE 619 OO Software Specification and Construction
 * Professor - Dr. Paul Ammann
 * GTA - Ehsan Kouroshfar
 */

package assignment2;

public class FindDupB {
	public static int findDup(int[] a, int[] b) throws NullPointerException, 
													   ArrayIndexOutOfBoundsException
	{
		/*
         * Requires: 
         * Effects: if a or b is null, throw NullPointerException NPE
         *			if index i for a[i] == b[i] is not found, throw
         *			ArrayIndexOutOfBoundsException
         */
       	for(int i=0;i<a.length;i++){
         	if(a[i]==b[i])	         		
         		return i;
	
       	}
         
		throw new ArrayIndexOutOfBoundsException();    
	}
}