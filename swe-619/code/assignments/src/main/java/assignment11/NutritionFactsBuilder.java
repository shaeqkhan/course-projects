/**
 * SWE 619 - Assignment 11
 * NutritionFactsBuilder.java
 * Implementing the NutritionFacts class using the Builder pattern
 *
 * @author - shaeqkhan
 */

package assignment11;

public class NutritionFactsBuilder {

    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrate;
	private final int protein; //new variable

    public static class Builder{
        private final int servingSize;
        private final int servings;

        private int calories = 0;
        private int fat = 0;
        private int carbohydrate = 0;
        private int sodium = 0;
		private int protein = 0; //new variable initialized

        public Builder(int servingSize, int servings){
            this.servingSize = servingSize;
            this.servings = servings;
        }

        public Builder calories(int a){
            calories = a;
            return this;
        }

        public Builder fat(int a){
            fat = a;
            return this;
        }

        public Builder carbohydrate(int a){
            carbohydrate = a;
            return this;
        }

        public Builder sodium(int a){
            sodium = a;
            return this;
        }
		
		//builder method for new variable
		public Builder protein(int a){
		    protein = a;
			return this;
		}

        public NutritionFactsBuilder build(){
            return new NutritionFactsBuilder(this);
        }
    }

    private NutritionFactsBuilder(Builder builder){
        servingSize = builder.servingSize;
        servings = builder.servings;
        calories = builder.calories;
        fat = builder.fat;
        sodium = builder.sodium;
        carbohydrate = builder.carbohydrate;
		protein = builder.protein; //build new variable as part of object
    }

    public String toString(){
	 	return "[" + servingSize + "," + servings + "," + calories + "," +
                fat + "," + sodium + "," + carbohydrate + "," + protein + "]";
	 }

    public static void main(String[] args) {
        // Sample usage
        //NutritionFactsBuilder cocaCola =
        //new NutritionFactsBuilder.Builder (240, 8).
        //calories(100).sodium(35).carbohydrate(27).protein(33).build();

        // Advantages:
        // Client code is easy to write and read
        // Like constructor, can impose invariants
        // No inconsistent state exposed to client
        // Fine for immutable objects

        // Note:  If Builder pattern is appropriate, start with
	    // Builder model.  When evolving to Builder model, it is
        // not possible to get rid of obsolete constructors or factories
    }

}
