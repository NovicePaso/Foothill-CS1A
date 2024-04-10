// CS1A - Text Processing
// Timothy Kwock

import java.util.Scanner;
public class TextProcessing
{
   // instantiate Scanner and global variables
   static Scanner input = new Scanner(System.in);
   static String output = "";
   static int keyCharacterCounter = 0;
   // Input method: gets key character
   public static char getKeyCharacter()
   {
      final int KEY_CHARACTER_LIMIT = 1;
      System.out.println("Enter a single character:");
      String keyCharacterString = input.nextLine();
      while (keyCharacterString.length() != KEY_CHARACTER_LIMIT)
      {
         System.out.println("Only 1 character is allowed. Please input
                 one" +
                 " character.");
         keyCharacterString = input.nextLine();
      }
      char keyCharacter = (char)keyCharacterString.charAt(0);
      return keyCharacter;
   }
   // Input method: gets target string
   public static String getString()
   {
      final int TARGET_STRING_MIN_LENGTH = 6;
      System.out.println("Enter a phrase or sentence (at least 6
              characters):");
      String targetString = input.nextLine();
      while (targetString.length() < TARGET_STRING_MIN_LENGTH)
      {
         System.out.println("Entry is not long enough. Please enter a
                 longer "
                         + "string.");
         targetString = input.nextLine();
      }
      return targetString;
   }
   // Output method: replace key char with $
   public static String maskCharacter(String theString, char keyCharacter)
   {
      for (int i = 0; i < theString.length(); i++)
      {
         if (theString.charAt(i) == keyCharacter)
         {
            output += "$";
         }
         else
         {
            output += theString.charAt(i);
         }
      }
      return output;
   }
   // Output method: remove key char
   public static String removeCharacter(String theString, char
           keyCharacter)
   {
      for (int i = 0; i < theString.length(); i++)
      {
         if (theString.charAt(i) != keyCharacter)
         {
            output += theString.charAt(i);
         }
      }
      return output;
   }
   // Output method: count # occurrences of key char
   public static int countingTheKeys(String theString, char keyCharacter)
   {
      for (int i = 0; i < theString.length(); i++)
      {
         if (theString.charAt(i) == keyCharacter)
         {
            keyCharacterCounter++;
         }
      }
      return keyCharacterCounter;
   }
   public static void main(String[] args)
   {
      final String INDENT = "\n";
// prompt user to enter keyCharacter
      char keyCharacter = getKeyCharacter();
      System.out.println("keyCharacter is: '" + keyCharacter + "'" +
              INDENT);
// prompt user to enter targetString
      String targetString = getString();
      System.out.println(INDENT + "targetString is: " + targetString);
// execute maskCharacter
      String newMaskedCharacters = maskCharacter(targetString,
              keyCharacter);
      System.out.println(INDENT + "String with '" + keyCharacter + "'
              masked: "
           + newMaskedCharacters);
      output = "";
// execute removeCharacter
      String newRemovedCharacter = removeCharacter(targetString,
              keyCharacter);
      System.out.println(INDENT + "String with '" + keyCharacter + "'
              removed: "
           + newRemovedCharacter);
      output = "";
// execute countingTheKeys
      int keyCharacterCount = countingTheKeys(targetString, keyCharacter);
      System.out.println(INDENT + "Number of keyCharacter occurrences: " +
              keyCharacterCount);
      keyCharacterCounter = 0;
   }
}
/* ----------------------------- Sample Run #1 ---------------------------
---
Enter a single character:
test
Only 1 character is allowed. Please input one character.
s
keyCharacter is: 's'
Enter a phrase or sentence (at least 6 characters):
no ty
Entry is not long enough. Please enter a longer string.
Somedays, I wish Mondays did not exist!
targetString is: Somedays, I wish Mondays did not exist!
String with 's' masked: Someday$, I wi$h Monday$ did not exi$t!
String with 's' removed: Someday, I wih Monday did not exit!
Number of keyCharacter occurrences: 4
---------------------------- Sample Run #2 ------------------------------
-
Enter a single character:
hi
Only 1 character is allowed. Please input one character.
!
keyCharacter is: '!'
Enter a phrase or sentence (at least 6 characters):
YESS!!! !!! ! @@output = "";
// execute removeCharacter
String newRemovedCharacter = removeCharacter(targetString,
keyCharacter);
System.out.println(INDENT + "String with '" + keyCharacter + "'
removed: "
+ newRemovedCharacter);
output = "";
// execute countingTheKeys
int keyCharacterCount = countingTheKeys(targetString, keyCharacter);
System.out.println(INDENT + "Number of keyCharacter occurrences: " +
keyCharacterCount);
keyCharacterCounter = 0;
}
}
/* ----------------------------- Sample Run #1 ---------------------------
---
Enter a single character:
test
Only 1 character is allowed. Please input one character.
s
keyCharacter is: 's'
Enter a phrase or sentence (at least 6 characters):
no ty
Entry is not long enough. Please enter a longer string.
Somedays, I wish Mondays did not exist!
targetString is: Somedays, I wish Mondays did not exist!
String with 's' masked: Someday$, I wi$h Monday$ did not exi$t!
String with 's' removed: Someday, I wih Monday did not exit!
Number of keyCharacter occurrences: 4
---------------------------- Sample Run #2 ------------------------------
-
Enter a single character:
hi
Only 1 character is allowed. Please input one character.
!
keyCharacter is: '!'
Enter a phrase or sentence (at least 6 characters):
YESS!!! !!! ! @@
targetString is: YESS!!! !!! ! @@
String with '!' masked: YESS$$$ $$$ $ @@
String with '!' removed: YESS @@
Number of keyCharacter occurrences: 7
------------------------------ Sample Run #3 -----------------------------
-
Enter a single character:
P
keyCharacter is: 'P'
Enter a phrase or sentence (at least 6 characters):
Please Excuse My Dear Aunt Sally
targetString is: Please Excuse My Dear Aunt Sally
String with 'P' masked: $lease Excuse My Dear Aunt Sally
String with 'P' removed: lease Excuse My Dear Aunt Sally
Number of keyCharacter occurrences: 1
------------------------------ Sample Run #4 -----------------------------
-
Enter a single character:
keyCharacter is: ' '
Enter a phrase or sentence (at least 6 characters):
hello friend. Please take me to your subordinate.
targetString is: hello friend. Please take me to your subordinate.
String with ' ' masked: hello$friend.$$Please$take$me$to$your$subordinate.
String with ' ' removed: hellofriend.Pleasetakemetoyoursubordinate.
Number of keyCharacter occurrences: 8
------------------------------------------------------------------------
*/
