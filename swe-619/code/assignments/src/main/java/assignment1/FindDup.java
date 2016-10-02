/*
 * Author - Shaeq Khan
 * Description - coded as per requirements in assignment problem statement
 * 
 * Assignment#1 - Due 5th Sept 2012, 16:30 
 * Course - SWE 619 OO Software Specification and Construction
 * Professor - Dr. Paul Ammann
 * GTA - Ehsan Kouroshfar
 */

package assignment1;

public class FindDup {
    public static int findDup(int[] a, int[] b){
		/*
         * Since we are interested in finding same elements at the same
         * positions in array a and b, we can use the length of the shorter
         * array to mark the end point of the for loop
         */
        if(a!=null && b!=null){
            /*
             * if condition to determine the longer array
             */
            if(a.length > b.length){
                for(int i=0; i<b.length; i++){					
                    if (a[i] == b[i]){                          
                    /*
                     * Return the index at which the first common elements 
                     * are found in array a and b
                    */
                        return i;                    				
                    }
                }
            }
            /*
             * and if they are of the same size, the else block is executed
             */
            else{
                for(int i=0; i<a.length; i++){					
                    if (a[i] == b[i]){                          
                    /*
                     * Return the index at which the first common elements 
                     * are found in array a and b
                     */
                        return i;                    				
                    }
                }
            }
        }
		/*
         * If no common elements are found, then return -1 as the index
         */
        return -1;			
    }
}
