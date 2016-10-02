/*
 * SWE 619 - Assignment 11
 * NutritionFactsTelescopingTestCase.java
 * 
 * @author shaeqkhan
 */

package assignment11;

import static org.junit.Assert.*;
import org.junit.*;

public class NutritionFactsBeansTestCase {

    NutritionFactsBeans product;

    //test for constructor - erroneously accesing value before initialized
    @Test
    public void testConstructor(){
    	product = new NutritionFactsBeans();
        product.setServingSize(240);
        int s = product.getServings();
        assertEquals(-1,s);
    }

    //test for constructor 1 - erroneously accessing value before initialized
    @Test
    public void testConstructor1(){
    	product = new NutritionFactsBeans();
        product.setServings(8);
        int ss = product.getServingSize();
        assertEquals(-1,ss);
    }

    //test for constructor 2
    @Test
    public void testConstructor2(){
    	product = new NutritionFactsBeans();
        product.setServingSize(240);
        product.setServings(8);
        assertEquals("[240,8,0,0,0,0,0]", product.toString());
    }

    //test for constructor 3
    @Test
    public void testConstructor3(){
    	product = new NutritionFactsBeans();
        product.setServingSize(240);
        product.setServings(8);
        product.setCalories(200);
        assertEquals("[240,8,200,0,0,0,0]", product.toString());
    }

    //test for constructor 4
    @Test
    public void testConstructor4(){
        product = new NutritionFactsBeans();
        product.setServingSize(240);
        product.setServings(8);
        product.setCalories(200);
        product.setFat(8);
        assertEquals("[240,8,200,8,0,0,0]", product.toString());
    }

    //test for constructor 5
    @Test
    public void testConstructor5(){
    	product = new NutritionFactsBeans();
        product.setServingSize(240);
        product.setServings(8);
        product.setCalories(200);
        product.setFat(8);
        product.setSodium(35);
        assertEquals("[240,8,200,8,35,0,0]", product.toString());
    }

    //test for constructor 6
    @Test
    public void testConstructor6(){
    	product = new NutritionFactsBeans();
        product.setServingSize(240);
        product.setServings(8);
        product.setCalories(200);
        product.setFat(8);
        product.setSodium(35) ;
        product.setCarbohydrate(27);
        assertEquals("[240,8,200,8,35,27,0]", product.toString());
    }

    //test for constructor 7
    @Test
    public void testConstructor7(){
    	product = new NutritionFactsBeans();
        product.setServingSize(240);
        product.setServings(8);
        product.setCalories(200);
        product.setFat(8);
        product.setSodium(35);
        product.setCarbohydrate(27);
        product.setProtein(33);
        assertEquals("[240,8,200,8,35,27,33]", product.toString());
    }

    //test for constructor 8
    @Test
    public void testConstructor8(){
    	product = new NutritionFactsBeans();
        product.setServingSize(240);
        product.setServings(8);
        product.setCalories(200);
        product.setCarbohydrate(27);
        assertEquals("[240,8,200,0,0,27,0]", product.toString());
    }
}
