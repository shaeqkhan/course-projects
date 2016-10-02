/**
 * SWE 619 - Assignment 11
 * NutritionFactsTelescoping.java
 * Implementing the NutritionFacts class using telescoping constructors
 *
 * @author shaeqkhan
 */

package assignment11;

public class NutritionFactsTelescoping {

    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrate;
    private final int protein; //new variable

    public NutritionFactsTelescoping(int servingSize, int servings){
        this(servingSize, servings, 0);
    }

    public NutritionFactsTelescoping(int servingSize, int servings,
            int calories){
        this(servingSize, servings, calories, 0);
    }

    public NutritionFactsTelescoping(int servingSize, int servings,
            int calories, int fat){
        this(servingSize, servings, calories, fat, 0);
    }

    public NutritionFactsTelescoping(int servingSize, int servings,
            int calories, int fat, int sodium){
        this(servingSize, servings, calories, fat, sodium, 0);
    }

    public NutritionFactsTelescoping(int servingSize, int servings,
            int calories, int fat, int sodium, int carbohydrate){
        this(servingSize, servings, calories, fat, sodium, carbohydrate, 0);
    }

	 public NutritionFactsTelescoping(int servingSize, int servings,
            int calories, int fat, int sodium, int carbohydrate, int protein){
	 	this.servingSize = servingSize;
        this.servings = servings;
        this.calories = calories;
        this.fat = fat;
        this.sodium = sodium;
        this.carbohydrate = carbohydrate;
		this.protein = protein; //new variable initialized
	}

	 public String toString(){
	 	return "[" + servingSize + "," + servings + "," + calories + "," +
                        fat + "," + sodium + "," + carbohydrate + "," + protein + "]";
	 }

    public static void main(String[] args) {
        // Sample usage
        // NutritionFactsTelescoping cocaCola =
        //   new NutritionFactsTelescoping (240, 8, 200, 8, 35, 27,33);

        // Objections:
        // Hard to write and hard to read
        // What does each parameter mean?
        // What if client reverses two arguments?
    }
}
