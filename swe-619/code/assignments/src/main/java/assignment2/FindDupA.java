/*
 * Author - Shaeq Khan
 * 
 * Description - coded as per requirements in assignment problem statement
 * Assignment#2 - Due 12th Sept 2012, 16:30 
 * Course - SWE 619 OO Software Specification and Construction
 * Professor - Dr. Paul Ammann
 * GTA - Ehsan Kouroshfar
 */

package assignment2;

public class FindDupA {
    public static int findDup(int[] a, int[] b){
		/*
         * Requires: a is not null
         *			 b is not null
         *			 There is some index i such that a[i] == b[i]
         * Effects: return the first index i at which a[i] == b[i]
         * 			if a or b is null, return -2
         *			if there is no index i such that a[i]==b[i], then return -1
         */
         if(a==null || b==null)
         	return -2;
         else{
         	for(int i=0;i<a.length;i++){
	         	if(a[i]==b[i])	         		
	         		return i;	         	         	
         	}         	
         }
         return -1;         
    }
}
        