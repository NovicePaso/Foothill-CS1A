// CS1A Lab 2 - Arithmetic
// Timothy Kwock

public class ArithmeticFundamentals
{
   public static void main(String[] args)
   {
      final String name = "Timothy";
      final int myId = 20578786;
      final int numLet = 7;
      int intResult;
      double doubleResult;
      System.out.println("My first name is " + name);
      System.out.println("My Student ID is " + myId);
      System.out.println("The number of characters in my first name is "
              + numLet);
      System.out.println();
      intResult = myId % 15784;
      System.out.println("Expression #1 = " + intResult);
      System.out.println();
      intResult = (myId + 4) % 11111;
      System.out.println("Expression #2 = " + intResult);
      System.out.println();
      doubleResult = (myId / (numLet + 500.0));
      System.out.println("Expression #3 = " + doubleResult);
      System.out.println();
      intResult = 1 + 2 + 3 + 4 + 5 + 6 + numLet;
      System.out.println("Expression #4 = " + intResult);
      System.out.println();
      doubleResult = 15_000.0 / (80.0 + ((double)(myId - 123_456) /
              ((numLet + 22) * (numLet + 22))));
      System.out.println("Expression #5 = " + doubleResult);
   }
}
/* ---------------------------- Output Result ----------------------------
---
My first name is Timothy
My Student ID is 20578786
The number of characters in my first name is 7
Expression #1 = 12234
Expression #2 = 1218
Expression #3 = 40589.32149901381
Expression #4 = 28
Expression #5 = 0.6146878978843334
--------------------------------------------------------------------------
- */
