/*
 * @course SWE 645
 * @author skhan27
 * @class WinningResult.java
 * 
 * A class to store the value of the mean and standard deviation in
 * case the survey taker wins the raffle draw
 */
package skhan27.struts2;

public class WinningResult {
	
	static double mean;
    static double standardDeviation;
    
    public static double getMean() { return mean; }
    public static double getSD() { return standardDeviation; }
	
}
