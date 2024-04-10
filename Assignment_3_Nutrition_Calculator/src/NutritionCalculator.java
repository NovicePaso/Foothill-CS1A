// CS 1A Lab 3 - Nutrition Calculator
// Timothy Kwock
// Nutritional Facts source: https://tools.myfooddata.com/nutrition-facts
import java.util.Scanner;
public class NutritionCalculator
{
   // food #1 constants
   static final String FOOD_1_NAME = "Chicken Breast";
   static final int FOOD_1_CALORIES_P100G = 157; // in calories
   static final double FOOD_1_TOTAL_FAT_P100G = 3.2; // in grams
   static final double FOOD_1_SODIUM_P100G = 47; // in milligrams
   static final double FOOD_1_TOTAL_CARBS_P100G = 0; // in grams
   static final double FOOD_1_PROTEIN_P100G = 32.1; // in grams
   // food #2 constants
   static final String FOOD_2_NAME = "Romaine Lettuce";
   static final int FOOD_2_CALORIES_P100G = 17; // in calories
   static final double FOOD_2_TOTAL_FAT_P100G = 0.3; // in grams
   static final double FOOD_2_SODIUM_P100G = 8; // in milligrams
   static final double FOOD_2_TOTAL_CARBS_P100G = 3.3; // in grams
   static final double FOOD_2_PROTEIN_P100G = 1.2; // in grams
   // food #3 constants
   static final String FOOD_3_NAME = "Rice";
   static final int FOOD_3_CALORIES_P100G = 130; // in calories
   static final double FOOD_3_TOTAL_FAT_P100G = 0.28; // in grams
   static final double FOOD_3_SODIUM_P100G = 1; // in milligrams
   static final double FOOD_3_TOTAL_CARBS_P100G = 28.2; // in grams
   static final double FOOD_3_PROTEIN_P100G = 2.7; // in grams
   // food #4 constants
   static final String FOOD_4_NAME = "Beef Chuck";
   static final int FOOD_4_CALORIES_P100G = 196; // in calories
   static final double FOOD_4_TOTAL_FAT_P100G = 9.2; // in grams
   static final double FOOD_4_SODIUM_P100G = 87; // in milligrams
   static final double FOOD_4_TOTAL_CARBS_P100G = 0; // in grams
   static final double FOOD_4_PROTEIN_P100G = 28.2; // in grams
   // food #5 constants
   static final String FOOD_5_NAME = "Eggs";
   static final int FOOD_5_CALORIES_P100G = 154; // in calories
   static final double FOOD_5_TOTAL_FAT_P100G = 11.7; // in grams
   static final double FOOD_5_SODIUM_P100G = 155; // in milligrams
   static final double FOOD_5_TOTAL_CARBS_P100G = 0.64; // in grams
   static final double FOOD_5_PROTEIN_P100G = 10.6; // in grams
   static final String INDENT = " ";
   static final String SEPARATOR = "\n";
   public static void main(String[] args)
   {
      String recipeName, userInputStr;
      int userInputInt, numServings;
      double totalCals, totalFat, totalSodium, totalCarbs, totalProtein;
      int maxServings = 10;
      int minServings = 1;
      int maxUserInputInt = 2000;
      int minUserInputInt = 0;
      Scanner inputStream = new Scanner(System.in);
// initialize accumulator variables
      totalCals = 0;
      totalFat = 0.;
      totalSodium = 0;
      totalCarbs = 0.;
      totalProtein = 0.;
// print menu
      System.out.println("---------- List of Possible Ingredients --------
                      -");
              System.out.println(INDENT + "Food #1: " + FOOD_1_NAME);
      System.out.println(INDENT + "Food #2: " + FOOD_2_NAME);
      System.out.println(INDENT + "Food #3: " + FOOD_3_NAME);
      System.out.println(INDENT + "Food #4: " + FOOD_4_NAME);
      System.out.println(INDENT + "Food #5: " + FOOD_5_NAME + SEPARATOR);
// name of recipe
      System.out.print("What are you calling this recipe? ");
      recipeName = inputStream.nextLine();
// number of servings
      System.out.print("How many servings will you be making? (Max 10) ");
      userInputStr = inputStream.nextLine();
      numServings = Integer.parseInt(userInputStr);
      if (numServings < minServings || numServings > maxServings)
      {
         System.out.println("ERROR! You've entered a number outside of the
                 "
                         + "allowable range.");
         System.exit(1);
      }
// food #1 ---------------------------------------------------------
      System.out.print("How many grams of " + FOOD_1_NAME + "? (Max 2000g)
              ");
              userInputStr = inputStream.nextLine();
      userInputInt = Integer.parseInt(userInputStr);
      if (userInputInt < minUserInputInt || userInputInt >
              maxUserInputInt)
      {
         System.out.println("ERROR! You've entered a number outside of the
                 "
                         + "allowable range.");
         System.exit(1);
      }
// update accumulators
      totalCals += userInputInt * (FOOD_1_CALORIES_P100G / 100.);
      totalFat += userInputInt * (FOOD_1_TOTAL_FAT_P100G / 100.);
      totalSodium += userInputInt * (FOOD_1_SODIUM_P100G / 100.);
      totalCarbs += userInputInt * (FOOD_1_TOTAL_CARBS_P100G / 100.);
      totalProtein += userInputInt * (FOOD_1_PROTEIN_P100G / 100.);
// food #2 ---------------------------------------------------------
      System.out.print("How many grams of " + FOOD_2_NAME + "? (Max 2000g)
              ");
              userInputStr = inputStream.nextLine();
      userInputInt = Integer.parseInt(userInputStr);
      if (userInputInt < minUserInputInt || userInputInt >
              maxUserInputInt)
      {
         System.out.println("ERROR! You've entered a number outside of the
                 "
                         + "allowable range.");
         System.exit(1);;
      }
// update accumulators
      totalCals += userInputInt * (FOOD_2_CALORIES_P100G / 100.);
      totalFat += userInputInt * (FOOD_2_TOTAL_FAT_P100G / 100.);
      totalSodium += userInputInt * (FOOD_2_SODIUM_P100G / 100.);
      totalCarbs += userInputInt * (FOOD_2_TOTAL_CARBS_P100G / 100.);
      totalProtein += userInputInt * (FOOD_2_PROTEIN_P100G / 100.);
// food #3 ---------------------------------------------------------
      System.out.print("How many grams of " + FOOD_3_NAME + "? (Max 2000g)
              ");
              userInputStr = inputStream.nextLine();
      userInputInt = Integer.parseInt(userInputStr);
      if (userInputInt < minUserInputInt || userInputInt >
              maxUserInputInt)
      {
         System.out.println("ERROR! You've entered a number outside of the
                 "
                         + "allowable range.");
         System.exit(1);;
      }
// update accumulators
      totalCals += userInputInt * (FOOD_3_CALORIES_P100G / 100.);
      totalFat += userInputInt * (FOOD_3_TOTAL_FAT_P100G / 100.);
      totalSodium += userInputInt * (FOOD_3_SODIUM_P100G / 100.);
      totalCarbs += userInputInt * (FOOD_3_TOTAL_CARBS_P100G / 100.);
      totalProtein += userInputInt * (FOOD_3_PROTEIN_P100G / 100.);
// food #4 ---------------------------------------------------------
      System.out.print("How many grams of " + FOOD_4_NAME + "? (Max 2000g)
              ");
              userInputStr = inputStream.nextLine();
      userInputInt = Integer.parseInt(userInputStr);
      if (userInputInt < minUserInputInt || userInputInt >
              maxUserInputInt)
      {
         System.out.println("ERROR! You've entered a number outside of the
                 "
                         + "allowable range.");
         System.exit(1);;
      }
// update accumulators
      totalCals += userInputInt * (FOOD_4_CALORIES_P100G / 100.);
      totalFat += userInputInt * (FOOD_4_TOTAL_FAT_P100G / 100.);
      totalSodium += userInputInt * (FOOD_4_SODIUM_P100G / 100.);
      totalCarbs += userInputInt * (FOOD_4_TOTAL_CARBS_P100G / 100.);
      totalProtein += userInputInt * (FOOD_4_PROTEIN_P100G / 100.);
// food #5 ---------------------------------------------------------
      System.out.print("How many grams of " + FOOD_5_NAME + "? (Max 2000g)
              ");
              userInputStr = inputStream.nextLine();
      userInputInt = Integer.parseInt(userInputStr);
      if (userInputInt < minUserInputInt || userInputInt >
              maxUserInputInt)
      {
         System.out.println("ERROR! You've entered a number outside of the
                 "
                         + "allowable range.");
         System.exit(1);;
      }
// update accumulators
      totalCals += userInputInt * (FOOD_5_CALORIES_P100G / 100.);
      totalFat += userInputInt * (FOOD_5_TOTAL_FAT_P100G / 100.);
      totalSodium += userInputInt * (FOOD_5_SODIUM_P100G / 100.);
      totalCarbs += userInputInt * (FOOD_5_TOTAL_CARBS_P100G / 100.);
      totalProtein += userInputInt * (FOOD_5_PROTEIN_P100G / 100.);
// update accumulators for individual serving size
      totalCals /= numServings;
      totalFat /= numServings;
      totalSodium /= numServings;
      totalCarbs /= numServings;
      totalProtein /= numServings;
      inputStream.close();
// report results --------------------------------------------------
      System.out.println("\n------- Single Serving Nutrition for " +
              recipeName
              + " -------");
      System.out.println(INDENT + "Calories: " + totalCals + " calories");
      System.out.println(INDENT + "Total Fat: " + totalFat + " grams");
      System.out.println(INDENT + "Sodium: " + totalSodium + "
              milligrams");
              System.out.println(INDENT + "Total Carbohydrates: " + totalCarbs
                      + " grams");
      System.out.println(INDENT + "Protein: " + totalProtein + " grams");
   }
}
/* -------------------- Sample Run #1 ------------------
---------- List of Possible Ingredients ---------
Food #1: Chicken Breast
Food #2: Romaine Lettuce
Food #3: Rice
Food #4: Beef Chuck
Food #5: Eggs
What are you calling this recipe? Chicken Salad
How many servings will you be making? (Max 10) 2
How many grams of Chicken Breast? (Max 2000g) 400
How many grams of Romaine Lettuce? (Max 2000g) 500
How many grams of Rice? (Max 2000g) 0
How many grams of Beef Chuck? (Max 2000g) 0
How many grams of Eggs? (Max 2000g) 150
-------- Single Serving Nutrition for Chicken Salad --------
Calories: 472.0 calories
Total Fat: 15.924999999999999 grams
Sodium: 230.25 milligrams
Total Carbohydrates: 8.73 grams
Protein: 75.15 grams
-------------------- Sample Run #2 ------------------
---------- List of Possible Ingredients ---------
Food #1: Chicken Breast
Food #2: Romaine Lettuce
Food #3: Rice
Food #4: Beef Chuck
Food #5: Eggs
What are you calling this recipe? Chicken Curry
How many servings will you be making? (Max 10) 4
How many grams of Chicken Breast? (Max 2000g) 680
How many grams of Romaine Lettuce? (Max 2000g) 0
How many grams of Rice? (Max 2000g) 250
How many grams of Beef Chuck? (Max 2000g) 0
How many grams of Eggs? (Max 2000g) 63
-------- Single Serving Nutrition for Chicken Curry --------
Calories: 372.40500000000003 calories
Total Fat: 7.45775 grams
Sodium: 104.9375 milligrams
Total Carbohydrates: 17.7258 grams
Protein: 57.927 grams
-------------------- Sample Run #3 ------------------
---------- List of Possible Ingredients ---------
Food #1: Chicken Breast
Food #2: Romaine Lettuce
Food #3: Rice
Food #4: Beef Chuck
Food #5: Eggs
What are you calling this recipe? Chicken Lettuce Wraps
How many servings will you be making? (Max 10) 5
How many grams of Chicken Breast? (Max 2000g) 700
How many grams of Romaine Lettuce? (Max 2000g) 300
How many grams of Rice? (Max 2000g) 0
How many grams of Beef Chuck? (Max 2000g) 0
How many grams of Eggs? (Max 2000g) 0
-------- Single Serving Nutrition for Chicken Lettuce Wraps --------
Calories: 230.0 calories
Total Fat: 4.66 grams
Sodium: 70.6 milligrams
Total Carbohydrates: 1.98 grams
Protein: 45.660000000000004 grams
-------------------- Sample Run #4 ------------------
---------- List of Possible Ingredients ---------
Food #1: Chicken Breast
Food #2: Romaine Lettuce
Food #3: Rice
Food #4: Beef Chuck
Food #5: Eggs
What are you calling this recipe? Burrito Bowls
How many servings will you be making? (Max 10) 8
How many grams of Chicken Breast? (Max 2000g) 500
How many grams of Romaine Lettuce? (Max 2000g) 450
How many grams of Rice? (Max 2000g) 300
How many grams of Beef Chuck? (Max 2000g) 500
How many grams of Eggs? (Max 2000g) 0
-------- Single Serving Nutrition for Burrito Bowls --------
Calories: 278.9375 calories
Total Fat: 8.02375 grams
Sodium: 88.625 milligrams
Total Carbohydrates: 12.431249999999999 grams
Protein: 39.375 grams
-------------------- Sample Run #5 ------------------
---------- List of Possible Ingredients ---------
Food #1: Chicken Breast
Food #2: Romaine Lettuce
Food #3: Rice
Food #4: Beef Chuck
Food #5: Eggs
What are you calling this recipe? Too much Chicken!
How many servings will you be making? (Max 10) 10
How many grams of Chicken Breast? (Max 2000g) 2001
ERROR! You've entered a number outside of the allowable range
----------------------------------------------------------------- */
