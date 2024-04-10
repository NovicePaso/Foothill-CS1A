// CS1A Fall 2023 - A Three String Class
// Timothy Kwock

import java.util.*;
public class ThreeStringClass
{
   public static void main(String[] args)
   {
      final String NEW_LINE = "\n";
// Instantiate 4 ThreeString objects
      ThreeString threeString1 = new ThreeString();
      ThreeString threeString2 = new ThreeString();
      ThreeString threeString3 = new ThreeString("hello", "I'm", "Tim");
      ThreeString threeString4 = new ThreeString("test", "TEST", "");
// display all objects
      System.out.println("All newly instantiated objects");
      System.out.println("threeString1:" + NEW_LINE + threeString1 +
              NEW_LINE);
      System.out.println("threeString2:" + NEW_LINE + threeString2 +
              NEW_LINE);
      System.out.println("threeString3:" + NEW_LINE + threeString3 +
              NEW_LINE);
      System.out.println("threeString4:" + NEW_LINE + threeString4 +
              NEW_LINE);
// mutate at least 1 member in each object
      threeString1.setString1("Foothill");
      threeString2.setString2("Software");
      threeString2.setString3("Engineering");
      threeString3.setString1("Hey!");
      threeString4.setString1("1");
      threeString4.setString2("2");
      threeString4.setString3("3!");
// display all objects (updated)
      System.out.println("All updated objects after mutating");
      System.out.println("threeString1:" + NEW_LINE + threeString1 +
              NEW_LINE);
      System.out.println("threeString2:" + NEW_LINE + threeString2 +
              NEW_LINE);
      System.out.println("threeString3:" + NEW_LINE + threeString3 +
              NEW_LINE);
      System.out.println("threeString4:" + NEW_LINE + threeString4 +
              NEW_LINE);
// First mutator test
      System.out.println("First mutator test");
      threeString1.setString2("Coding is fun!");
      if (threeString1.getString2() == "Coding is fun!")
      {
         System.out.println("The mutator was successful");
      }
      else
      {
         System.out.println("The mutator was unsuccessful");
      }
      System.out.println("threeString1 - String2: "
              + threeString1.getString2());
      System.out.print(NEW_LINE);
// Second mutator test
      System.out.println("Second mutator test");
      threeString1.setString1("Hello, This is absolutely, 100% a test to
              make "
                      + "sure that the validString method is working as intended, and "
                      + "should never be seen as an output to the user!");
      if (threeString1.getString1() == "Hello, This is absolutely, 100% a
      test "
           + "to make sure that the validString method is working as
      intended,"
              + " and should never be seen as an output to the user!")
      {
         System.out.println("The mutator was successful, but the "
                 + "validString helper method did not function properly.");
      }
else if (threeString1.getString1() == "Foothill")
   {
      System.out.println("The mutator was unsuccessful and the "
              + "validString method works as intended.");
   }
   else
   {
      System.out.println("An unexpected error occured.");
   }
      System.out.println("threeString1 - String1: "
              + threeString1.getString1());
   }
}
class ThreeString
{
   // declare variables
   private String string1, string2, string3;
   public static final int MIN_LEN = 1;
   public static final int MAX_LEN = 50;
   public static final String DEFAULT_STRING = "(undefined)";
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
      return string1 + " " + string2 + " " + string3;
   }
   // validString()
   private static boolean validString(String str)
   {
      if (str != null && str.length() <= MAX_LEN &&
              str.length() >= MIN_LEN)
      {
         return true;
      }
      else
      {
         return false;
      }
   }
}
/* ------------------------ Output Result -----------------------------
All newly instantiated objects
threeString1:
(undefined) (undefined) (undefined)
threeString2:
(undefined) (undefined) (undefined)
threeString3:
hello I'm Tim
threeString4:
test TEST (undefined)
All updated objects after mutating
threeString1:
Foothill (undefined) (undefined)
threeString2:
(undefined) Software Engineering
threeString3:
Hey! I'm Tim
threeString4:
1 2 3!
First mutator test
The mutator was successful
threeString1 - String2: Coding is fun!
Second mutator test
The mutator was unsuccessful and the validString method works as intended.
threeString1 - String1: Foothill
---------------------------------------------------------------------- */
