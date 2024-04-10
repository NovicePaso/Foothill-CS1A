// CS 1A Lab 4 - Free Ice Cream
// Timothy Kwock

import java.util.Scanner;
public class FreeIceCream
{
   public static void main(String[] args)
   {
      Scanner input = new Scanner(System.in);
// initialize variables
      String userInput = "";
      char mainMenuInput = 0;
      char freeIceCreamInput = 0;
      int totalIceCream = 0;
      int totalCredits = 0;
      final char PURCHASE_KEY = 'P';
      final char SHUT_DOWN_KEY = 'S';
      final char YES_KEY = 'Y';
      final char NO_KEY = 'N';
      final int FREE_ICE_CREAM_CREDITS = 11;
      final String INDENT = " ";
      final String SEPARATOR = "\n";
      while (mainMenuInput != SHUT_DOWN_KEY)
      {
// start of main prompt (P or S)
         System.out.println("Main Menu:");
         System.out.println(INDENT + "P (Purchase)");
         System.out.println(INDENT + "S (Shut Down)");
         System.out.print(SEPARATOR);
         System.out.print(INDENT + "Your Choice: ");
         userInput = input.nextLine().toUpperCase();
         mainMenuInput = userInput.charAt(0);
// Processing a Purchase
         if (mainMenuInput == PURCHASE_KEY)
         {
            if (totalCredits < FREE_ICE_CREAM_CREDITS)
            {
// normal transaction
               System.out.println(SEPARATOR + "You have " + totalCredits +
                       " points.");
               System.out.print("How any Ice Creams will you be
                       purchasing? ");
                       userInput = input.nextLine();
               totalIceCream = Integer.parseInt(userInput);
// ensure a positive number is entered for # Ice Creams
               if (totalIceCream < 0)
               {
                  System.out.println(SEPARATOR + "*** Invalid Response
                          ***");
                  totalIceCream = 0;
               }
               else
               {
                  totalCredits += totalIceCream;
               }
            }
            else
            {
// award transaction
               System.out.println(SEPARATOR + "You have " + totalCredits +
                       " points.");
               System.out.print("Would you like a free ice cream today? "
                       + "(Y/N) ");
               userInput = input.nextLine().toUpperCase();
               freeIceCreamInput = userInput.charAt(0);
// user opts for free ice cream
               if (freeIceCreamInput == YES_KEY)
               {
                  totalIceCream++;
                  totalCredits -= FREE_ICE_CREAM_CREDITS;
               }
// user does not opt for free ice cream => normal
               transaction
else if (freeIceCreamInput == NO_KEY)
            {
               System.out.print(SEPARATOR + "How any Ice Creams will
                       you be"
                               + " purchasing? ");
               userInput = input.nextLine();
               totalIceCream = Integer.parseInt(userInput);
               totalCredits += totalIceCream;
            }
            else
            {
               System.out.print(SEPARATOR + "*** Invalid Response ***"
                       +
                       SEPARATOR);
            }
            }
// display total ice creams and final credits for transaction
            System.out.println(SEPARATOR + "Total Ice Creams: " +
                    totalIceCream);
            System.out.println("Total Credits: " + totalCredits +
                    SEPARATOR);
            totalIceCream = 0;
         }
// shut down exits loop
         else if (mainMenuInput == SHUT_DOWN_KEY)
         {
            break;
         }
         else
         {
            System.out.println(SEPARATOR + "*** Invalid Response ***" +
                    SEPARATOR);
         }
// Display shut down message
      }
      System.out.println(SEPARATOR + "Shutting Down..." + SEPARATOR);
      input.close();
   }
}
/* ------------------- Sample Output 1 ---------------------------------
Main Menu:
P (Purchase)
S (Shut Down)
Your Choice: test1
*** Invalid Response ***
Main Menu:
P (Purchase)
S (Shut Down)
Your Choice: Process a Purchase
You have 0 points.
How any Ice Creams will you be purchasing? 8
Total Ice Creams: 8
Total Credits: 8
Main Menu:
P (Purchase)
S (Shut Down)
Your Choice: p123
You have 8 points.
How any Ice Creams will you be purchasing? -3
*** Invalid Response ***
Total Ice Creams: 0
Total Credits: 8
Main Menu:
P (Purchase)
S (Shut Down)
Your Choice: p1 p2 p3
You have 8 points.
How any Ice Creams will you be purchasing? 30
Total Ice Creams: 30
Total Credits: 38
Main Menu:
P (Purchase)
S (Shut Down)
Your Choice: P
You have 38 points.
Would you like a free ice cream today? (Y/N) yes please!
Total Ice Creams: 1
Total Credits: 27
Main Menu:
P (Purchase)
S (Shut Down)
Your Choice: p
You have 27 points.
Would you like a free ice cream today? (Y/N) maybe... I'm not sure.
*** Invalid Response ***
Total Ice Creams: 0
Total Credits: 27
Main Menu:
P (Purchase)
S (Shut Down)
Your Choice: P
You have 27 points.
Would you like a free ice cream today? (Y/N) No
How any Ice Creams will you be purchasing? 2
Total Ice Creams: 2
Total Credits: 29
Main Menu:
P (Purchase)
S (Shut Down)
Your Choice: P
You have 29 points.
Would you like a free ice cream today? (Y/N) Y!
Total Ice Creams: 1
Total Credits: 18
Main Menu:
P (Purchase)
S (Shut Down)
Your Choice: shadow
Shutting Down...
------------------------------ Sample Output 2 ---------------------------
-
Main Menu:
P (Purchase)
S (Shut Down)
Your Choice: I refuse!
*** Invalid Response ***
Main Menu:
P (Purchase)
S (Shut Down)
Your Choice: P1 p1 pppp
You have 0 points.
How any Ice Creams will you be purchasing? 5
Total Ice Creams: 5
Total Credits: 5
Main Menu:
P (Purchase)
S (Shut Down)
Your Choice: p
You have 5 points.
How any Ice Creams will you be purchasing? 0
Total Ice Creams: 0
Total Credits: 5
Main Menu:
P (Purchase)
S (Shut Down)
Your Choice: PPPPPP
You have 5 points.
How any Ice Creams will you be purchasing? 111
Total Ice Creams: 111
Total Credits: 116
Main Menu:
P (Purchase)
S (Shut Down)
Your Choice: p
You have 116 points.
Would you like a free ice cream today? (Y/N) Yes
Total Ice Creams: 1
Total Credits: 105
Main Menu:
P (Purchase)
S (Shut Down)
Your Choice: purchase
You have 105 points.
Would you like a free ice cream today? (Y/N) Nope
How any Ice Creams will you be purchasing? 2
Total Ice Creams: 2
Total Credits: 107
Main Menu:
P (Purchase)
S (Shut Down)
Your Choice: ppppp
You have 107 points.
Would you like a free ice cream today? (Y/N) yup
Total Ice Creams: 1
Total Credits: 96
Main Menu:
P (Purchase)
S (Shut Down)
Your Choice: p
You have 96 points.
Would you like a free ice cream today? (Y/N) yup yup
Total Ice Creams: 1
Total Credits: 85
Main Menu:
P (Purchase)
S (Shut Down)
Your Choice: hello
*** Invalid Response ***
Main Menu:
P (Purchase)
S (Shut Down)
Your Choice: p
You have 85 points.
Would you like a free ice cream today? (Y/N) hello
*** Invalid Response ***
Total Ice Creams: 0
Total Credits: 85
Main Menu:
P (Purchase)
S (Shut Down)
Your Choice: p
You have 85 points.
Would you like a free ice cream today? (Y/N) n
How any Ice Creams will you be purchasing? 10
Total Ice Creams: 10
Total Credits: 95
Main Menu:
P (Purchase)
S (Shut Down)
Your Choice: shut it down!
Shutting Down...
* ------------------------------------------------------------------*/
