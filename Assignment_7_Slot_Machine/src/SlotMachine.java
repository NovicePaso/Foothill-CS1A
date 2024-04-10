// CS1A Fall 2023 - Slot Machine with Methods and a Class
// Timothy Kwock
import java.util.*;
import java.lang.Math;
public class SlotMachine
{
   // declares probabilities of potential slot results x 100
   static final String CHERRIES = "cherries";
   static final String BAR = "BAR";
   static final String SEVEN = "7";
   static final String SPACE = "(space)";
   static final int BAR_PROBABILITY = 38; // 38%
   static final int CHERRIES_PROBABILITY = 40; // 40%
   static final int SPACE_PROBABILITY = 7; // 7%
   static final int SEVEN_PROBABILITY = 15; // 15%
   static final int MAX_BET = 50;
   static final int MIN_BET = 0;
   static final String NEW_LINE = "\n";
   static Scanner input = new Scanner(System.in);
   // Gets bet amount by user. Assume int is always entered
   public static int getBet()
   {
      int bet = -1; // initializer
      while (bet > MAX_BET || bet < MIN_BET)
      {
         System.out.println("How much is your bet (1-50)? Press 0 to
                 quit.");
                 bet = input.nextInt();
      }
      return bet;
   }
   // Generates concatenated slot pull from 3 random slot rolls
   public static ThreeString pullSlot()
   {
      ThreeString pullString = new ThreeString(Foothill.randString(),
              Foothill.randString(), Foothill.randString());
      pullString.toString();
      return pullString;
   }
   // Generates a single random Slot roll based off given probabilities
   private static String randString()
   {
      String slotRoll;
      int slotRollNumber = (int)(Math.random() * 100);
      if (slotRollNumber < CHERRIES_PROBABILITY)
      {
         slotRoll = CHERRIES; // cherries number range: 0 - 39
      }
      else if (slotRollNumber < (CHERRIES_PROBABILITY + BAR_PROBABILITY))
      {
         slotRoll = BAR; // BAR number range: 40 - 77
      }
      else if (slotRollNumber < (CHERRIES_PROBABILITY + BAR_PROBABILITY +
              SEVEN_PROBABILITY))
      {
         slotRoll = SEVEN; // 7 number range: 78 - 92
      }
      else
      {
         slotRoll = SPACE; // (space) number range: 93 - 99
      }
      return slotRoll;
   }
   // Gets pay multiplier based off given win conditions
   public static int getPayMultiplier(ThreeString thePull)
   {
      int payMultiplier = 0;
      if (thePull.getString1() == CHERRIES && thePull.getString2() !=
              CHERRIES)
      {
         payMultiplier = 5;
      }
      else if (thePull.getString1() == CHERRIES && thePull.getString2() ==
              CHERRIES && thePull.getString3() != CHERRIES)
      {
         payMultiplier = 15;
      }
      else if (thePull.getString1() == CHERRIES && thePull.getString2() ==
              CHERRIES && thePull.getString3() == CHERRIES)
      {
         payMultiplier = 30;
      }
      else if (thePull.getString1() == BAR && thePull.getString2() == BAR
              && thePull.getString3() == BAR)
      {
         payMultiplier = 50;
      }
      else if (thePull.getString1() == SEVEN && thePull.getString2() ==
              SEVEN
              && thePull.getString3() == SEVEN)
      {
         payMultiplier = 100;
      }
      return payMultiplier;
   }
   // Displays the slot pull string and winnings
   public static void display(ThreeString thePull, int winnings)
   {
      System.out.println(thePull);
      if (winnings == 0)
      {
         System.out.println("Sorry, you lost." + NEW_LINE);
      }
      else
      {
         System.out.println("Congrats! You won $" + winnings + NEW_LINE);
      }
   }
   // main
   public static void main(String[] args)
   {
      int betAmount = getBet();
      while (betAmount != 0)
      {
         ThreeString pullString = pullSlot();
         int winningsMultiplier = getPayMultiplier(pullString);
         int winnings = winningsMultiplier * betAmount;
         System.out.println("You bet $" + betAmount);
         System.out.println("(slot machine sound effect)... your pull is
...");
         display(pullString, winnings);
         betAmount = getBet();
      }
      System.out.println("Thank you for playing. Exiting now...");
      input.close();
   }
}
class ThreeString // from Assignment 6
{
   // declare variables
   private String string1, string2, string3;
   public static final int MIN_LEN = 1;
   public static final int MAX_LEN = 50;
   public static final String DEFAULT_STRING = "(undefined)";
   public static final String INDENT = " ";
   // default constructor
   ThreeString()
   {
      string1 = DEFAULT_STRING;
      string2 = DEFAULT_STRING;
      string3 = DEFAULT_STRING;
   }
   // parameterized constructor
   ThreeString(String str1, String str2, String str3)
   {
      if (ThreeString.validString(str1))
      {
         string1 = str1;
      }
      else
      {
         string1 = DEFAULT_STRING;
      }
      if (ThreeString.validString(str2))
      {
         string2 = str2;
      }
      else
      {
         string2 = DEFAULT_STRING;
      }
      if (ThreeString.validString(str3))
      {
         string3 = str3;
      }
      else
      {
         string3 = DEFAULT_STRING;
      }
   }
   // mutators (setters)
   public boolean setString1(String str1)
   {
      if (ThreeString.validString(str1))
      {
         this.string1 = str1;
         return true;
      }
      else
      {
         return false;
      }
   }
   public boolean setString2(String str2)
   {
      if (ThreeString.validString(str2))
      {
         this.string2 = str2;
         return true;
      }
      else
      {
         return false;
      }
   }
   public boolean setString3(String str3)
   {
      if (ThreeString.validString(str3))
      {
         this.string3 = str3;
         return true;
      }
      else
      {
         return false;
      }
   }
   // accessors (getters)
   public String getString1()
   {
      return string1;
   }
   public String getString2()
   {
      return string2;
   }
   public String getString3()
   {
      return string3;
   }
   // toString()
   public String toString()
   {
      return INDENT + string1 + INDENT + string2 + INDENT + string3;
   }
   // validString()
   private static boolean validString(String str)
   {
      if (str != null && str.length() <= MAX_LEN && str.length() >=
              MIN_LEN)
      {
         return true;
      }
      else
      {
         return false;
      }
   }
}
// *** I rolled 3 cherries in pull #3 and 3 BARs in pull #4, 7, 15, 18, 38
***
/* ------------------------ Output Result --------------------------------
-
How much is your bet (1-50)? Press 0 to quit.
- 1
How much is your bet (1-50)? Press 0 to quit.
100
How much is your bet (1-50)? Press 0 to quit.
50
You bet $50
(slot machine sound effect)... your pull is ...
cherries 7 BAR
Congrats! You won $250
How much is your bet (1-50)? Press 0 to quit.
1
You bet $1
(slot machine sound effect)... your pull is ...
BAR 7 BAR
Sorry, you lost.
How much is your bet (1-50)? Press 0 to quit.
10
You bet $10
(slot machine sound effect)... your pull is ...
cherries cherries cherries
Congrats! You won $300
How much is your bet (1-50)? Press 0 to quit.
5
You bet $5
(slot machine sound effect)... your pull is ...
BAR BAR BAR
Congrats! You won $250
How much is your bet (1-50)? Press 0 to quit.
5
You bet $5
(slot machine sound effect)... your pull is ...
7 cherries BAR
Sorry, you lost.
How much is your bet (1-50)? Press 0 to quit.
5
You bet $5
(slot machine sound effect)... your pull is ...
BAR cherries BAR
Sorry, you lost.
How much is your bet (1-50)? Press 0 to quit.
5
You bet $5
(slot machine sound effect)... your pull is ...
BAR BAR BAR
Congrats! You won $250
How much is your bet (1-50)? Press 0 to quit.
5
You bet $5
(slot machine sound effect)... your pull is ...
BAR cherries BAR
Sorry, you lost.
How much is your bet (1-50)? Press 0 to quit.
5
You bet $5
(slot machine sound effect)... your pull is ...
BAR cherries BAR
Sorry, you lost.
How much is your bet (1-50)? Press 0 to quit.
5
You bet $5
(slot machine sound effect)... your pull is ...
BAR cherries cherries
Sorry, you lost.
How much is your bet (1-50)? Press 0 to quit.
5
You bet $5
(slot machine sound effect)... your pull is ...
cherries BAR BAR
Congrats! You won $25
How much is your bet (1-50)? Press 0 to quit.
5
You bet $5
(slot machine sound effect)... your pull is ...
cherries 7 cherries
Congrats! You won $25
How much is your bet (1-50)? Press 0 to quit.
5
You bet $5
(slot machine sound effect)... your pull is ...
cherries BAR BAR
Congrats! You won $25
How much is your bet (1-50)? Press 0 to quit.
5
You bet $5
(slot machine sound effect)... your pull is ...
BAR 7 cherries
Sorry, you lost.
How much is your bet (1-50)? Press 0 to quit.
5
You bet $5
(slot machine sound effect)... your pull is ...
BAR BAR BAR
Congrats! You won $250
How much is your bet (1-50)? Press 0 to quit.
5
You bet $5
(slot machine sound effect)... your pull is ...
7 cherries BAR
Sorry, you lost.
How much is your bet (1-50)? Press 0 to quit.
5
You bet $5
(slot machine sound effect)... your pull is ...
BAR cherries BAR
Sorry, you lost.
How much is your bet (1-50)? Press 0 to quit.
5
You bet $5
(slot machine sound effect)... your pull is ...
BAR BAR BAR
Congrats! You won $250
How much is your bet (1-50)? Press 0 to quit.
5
You bet $5
(slot machine sound effect)... your pull is ...
BAR cherries BAR
Sorry, you lost.
How much is your bet (1-50)? Press 0 to quit.
5
You bet $5
(slot machine sound effect)... your pull is ...
BAR 7 cherries
Sorry, you lost.
How much is your bet (1-50)? Press 0 to quit.
5
You bet $5
(slot machine sound effect)... your pull is ...
BAR cherries cherries
Sorry, you lost.
How much is your bet (1-50)? Press 0 to quit.
5
You bet $5
(slot machine sound effect)... your pull is ...
(space) 7 BAR
Sorry, you lost.
How much is your bet (1-50)? Press 0 to quit.
5
You bet $5
(slot machine sound effect)... your pull is ...
cherries BAR BAR
Congrats! You won $25
How much is your bet (1-50)? Press 0 to quit.
5
You bet $5
(slot machine sound effect)... your pull is ...
cherries (space) cherries
Congrats! You won $25
How much is your bet (1-50)? Press 0 to quit.
5
You bet $5
(slot machine sound effect)... your pull is ...
BAR cherries 7
Sorry, you lost.
How much is your bet (1-50)? Press 0 to quit.
5
You bet $5
(slot machine sound effect)... your pull is ...
cherries 7 BAR
Congrats! You won $25
How much is your bet (1-50)? Press 0 to quit.
5
You bet $5
(slot machine sound effect)... your pull is ...
7 BAR cherries
Sorry, you lost.
How much is your bet (1-50)? Press 0 to quit.
5
You bet $5
(slot machine sound effect)... your pull is ...
cherries cherries (space)
Congrats! You won $75
How much is your bet (1-50)? Press 0 to quit.
5
You bet $5
(slot machine sound effect)... your pull is ...
cherries BAR 7
Congrats! You won $25
How much is your bet (1-50)? Press 0 to quit.
5
You bet $5
(slot machine sound effect)... your pull is ...
BAR (space) cherries
Sorry, you lost.
How much is your bet (1-50)? Press 0 to quit.
5
You bet $5
(slot machine sound effect)... your pull is ...
cherries cherries BAR
Congrats! You won $75
How much is your bet (1-50)? Press 0 to quit.
5
You bet $5
(slot machine sound effect)... your pull is ...
(space) BAR BAR
Sorry, you lost.
How much is your bet (1-50)? Press 0 to quit.
5
You bet $5
(slot machine sound effect)... your pull is ...
BAR 7 BAR
Sorry, you lost.
How much is your bet (1-50)? Press 0 to quit.
5
You bet $5
(slot machine sound effect)... your pull is ...
cherries cherries 7
Congrats! You won $75
How much is your bet (1-50)? Press 0 to quit.
5
You bet $5
(slot machine sound effect)... your pull is ...
cherries 7 BAR
Congrats! You won $25
How much is your bet (1-50)? Press 0 to quit.
5
You bet $5
(slot machine sound effect)... your pull is ...
7 BAR cherries
Sorry, you lost.
How much is your bet (1-50)? Press 0 to quit.
5
You bet $5
(slot machine sound effect)... your pull is ...
BAR cherries 7
Sorry, you lost.
How much is your bet (1-50)? Press 0 to quit.
5
You bet $5
(slot machine sound effect)... your pull is ...
BAR BAR BAR
Congrats! You won $250
How much is your bet (1-50)? Press 0 to quit.
5
You bet $5
(slot machine sound effect)... your pull is ...
7 BAR BAR
Sorry, you lost.
How much is your bet (1-50)? Press 0 to quit.
5
You bet $5
(slot machine sound effect)... your pull is ...
BAR BAR cherries
Sorry, you lost.
How much is your bet (1-50)? Press 0 to quit.
5
You bet $5
(slot machine sound effect)... your pull is ...
BAR 7 BAR
Sorry, you lost.
How much is your bet (1-50)? Press 0 to quit.
5
You bet $5
(slot machine sound effect)... your pull is ...
BAR BAR (space)
Sorry, you lost.
How much is your bet (1-50)? Press 0 to quit.
5
You bet $5
(slot machine sound effect)... your pull is ...
7 BAR 7
Sorry, you lost.
How much is your bet (1-50)? Press 0 to quit.
5
You bet $5
(slot machine sound effect)... your pull is ...
cherries BAR cherries
Congrats! You won $25
How much is your bet (1-50)? Press 0 to quit.
5
You bet $5
(slot machine sound effect)... your pull is ...
BAR cherries BAR
Sorry, you lost.
How much is your bet (1-50)? Press 0 to quit.
0
Thank you for playing. Exiting now...
--------------------------------------------------------------------------
*/
