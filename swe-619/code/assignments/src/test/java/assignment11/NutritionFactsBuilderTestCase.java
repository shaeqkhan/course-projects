/*
 * SWE 619 - Assignment 11
 * NutritionFactsTelescopingTestCase.java
 * 
 * @author shaeqkhan
 */

package assignment11;

import static org.junit.Assert.*;
import org.junit.*;

public class NutritionFactsBuilderTestCase {

    NutritionFactsBuilder productA, productB, productC, productD, productE, productF, productG;

    //test for constructor 1
    @Test
    public void testConstructor1(){
    	productA = new NutritionFactsBuilder.Builder(240,8).build();
        assertEquals("[240,8,0,0,0,0,0]", productA.toString());
    }

    //test for constructor 2
    @Test
    public void testConstructor2(){
    	productB = new NutritionFactsBuilder.Builder(240,8).calories(200).build();
        assertEquals("[240,8,200,0,0,0,0]", productB.toString());
    }

    //test for constructor 3
    @Test
    public void testConstructor3(){
    	productC = new NutritionFactsBuilder.Builder(240,8).calories(200).fat(8).build();
        assertEquals("[240,8,200,8,0,0,0]", productC.toString());
    }

    //test for constructor 4
    @Test
    public void testConstructor4(){
    	productD = new NutritionFactsBuilder.Builder(240,8).calories(200).fat(8).sodium(35).build();
        assertEquals("[240,8,200,8,35,0,0]", productD.toString());
    }

    //test for constructor 5
    @Test
    public void testConstructor5(){
    	productE = new NutritionFactsBuilder.Builder(240,8).calories(200).fat(8).sodium(35).carbohydrate(27).build();
        assertEquals("[240,8,200,8,35,27,0]", productE.toString());
    }

    //test for constructor 6
    @Test
    public void testConstructor6(){
    	productF = new NutritionFactsBuilder.Builder(240,8).calories(200).fat(8).sodium(35).carbohydrate(27).protein(33).build();
        assertEquals("[240,8,200,8,35,27,33]", productF.toString());
    }

    //test for constructor 7
    @Test
    public void testConstructor7(){
    	productG = new NutritionFactsBuilder.Builder(240,8).calories(200).sodium(35).carbohydrate(27).build();
        assertEquals("[240,8,200,0,35,27,0]", productG.toString());
    }
    
}
