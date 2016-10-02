/*
 * SWE 619 - Assignment 11
 * NutritionFactsTelescopingTestCase.java
 * 
 * @author shaeqkhan
 */

package assignment11;

import static org.junit.Assert.*;
import org.junit.*;

public class NutritionFactsTelescopingTestCase {

    NutritionFactsTelescoping productA;
    NutritionFactsTelescoping productB;
    NutritionFactsTelescoping productC;
    NutritionFactsTelescoping productD;
    NutritionFactsTelescoping productE;
    NutritionFactsTelescoping productF;

    //test for constructor 1
    @Test
    public void testConstructor1(){
    	productA = new NutritionFactsTelescoping(240,8);
        assertEquals("[240,8,0,0,0,0,0]", productA.toString());
    }

    //test for constructor 2
    @Test
    public void testConstructor2(){
    	productB = new NutritionFactsTelescoping(240,8,200);
        assertEquals("[240,8,200,0,0,0,0]", productB.toString());
    }

    //test for constructor 3
    @Test
    public void testConstructor3(){
    	productC = new NutritionFactsTelescoping(240,8,200,8);
        assertEquals("[240,8,200,8,0,0,0]", productC.toString());
    }

    //test for constructor 4
    @Test
    public void testConstructor4(){
    	productD = new NutritionFactsTelescoping(240,8,200,8,35);
        assertEquals("[240,8,200,8,35,0,0]", productD.toString());
    }

    //test for constructor 5
    @Test
    public void testConstructor5(){
    	productE = new NutritionFactsTelescoping(240,8,200,8,35,27);
        assertEquals("[240,8,200,8,35,27,0]", productE.toString());
    }

    //test for constructor 6
    @Test
    public void testConstructor6(){
    	productF = new NutritionFactsTelescoping(240,8,200,8,35,27,33);
        assertEquals("[240,8,200,8,35,27,33]", productF.toString());
    }
}
