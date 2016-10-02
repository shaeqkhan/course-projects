/**
 * SWE 619 - Assignment 11
 * NutritionFactsBeans.java
 * Implementing the NutritionFacts class using the JavaBeans pattern.
 *
 * @author shaeqkhan
 */

package assignment11;

public class NutritionFactsBeans {

    private int servingSize = -1;
    private int servings = -1;
    private int calories = 0;
    private int fat = 0;
    private int sodium = 0;
    private int carbohydrate = 0;
    private int protein = 0; //new variable

    public NutritionFactsBeans(){}

    public void setServingSize(int servingSize) {
        this.servingSize = servingSize;
    }

    public void setServings(int servings) {
        this.servings = servings;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public void setFat(int fat) {
        this.fat = fat;
    }

    public void setSodium(int sodium) {
        this.sodium = sodium;
    }

    public void setCarbohydrate(int carbohydrate) {
        this.carbohydrate = carbohydrate;
    }

	 public void setProtein(int protein){
	 	  this.protein = protein;
	 }

    public int getServingSize() {
        return servingSize;
    }

    public int getServings() {
        return servings;
    }

    public int getCalories() {
        return calories;
    }

    public int getFat() {
        return fat;
    }

    public int getSodium() {
        return sodium;
    }

    public int getCarbohydrate() {
        return carbohydrate;
    }
	
	//accessor for new variable
    public int getProtein(){
        return protein;
    }

    public String toString(){
	 	return "[" + servingSize + "," + servings + "," + calories + "," +
                fat + "," + sodium + "," + carbohydrate + "," + protein + "]";
	}
    
 public static void main(String[] args) {
        // Sample usage
        // NutritionFactsBeans cocaCola = new NutritionFactsBeans ();
        // cocaCola.setServingSize(240);
        // cocaCola.setServings(8);
        // cocaCola.setCalories(100);
        // cocaCola.setSodium(35);
        // cocaCola.setCarbohydrate(27);
        // cocaCola.setProtein(33);

        // Objections:
        // Bean potentially in inconsistent state partway through construction
        // Not possible to validate all parameters together
        // Precludes possibility of making class immutable
        // Possible to manually "freeze" object -
		// but that puts obligation on client
    }
}
