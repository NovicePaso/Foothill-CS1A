// CS1A Fall 2023 - Tic-Tac-Toe
// Timothy Kwock
import java.util.Scanner;
public class TicTacToe
{
   static Scanner input = new Scanner(System.in);
   public static void main(String[] args)
   {
      final String NEW_LINE = "\n";
      final int NUM_PLAYERS = 3;
      final int MAX_WINS = 5;
      boolean winCheck;
      boolean drawCheck;
// insantiate 3 objects (2 players, 1 blank)
      Player[] playerIndex = new Player[NUM_PLAYERS];
      for (int i = 0; i < playerIndex.length; i++)
      {
         playerIndex[i] = new Player();
      }
// create 3x3 game board
      Player[][] gameBoard = new Player[3][3];
      for (int row = 0; row < gameBoard.length; row++)
      {
         for (int column = 0; column < gameBoard[row].length; column++)
         {
            gameBoard[row][column] = playerIndex[2];
         }
      }
// askUserForSymbol() with duplicate error checking
      for (int i = 0; i < playerIndex.length - 1; i++)
      {
         System.out.println("Player " + (i + 1) + ":");
         playerIndex[i].setSymbol(askUserForSymbol());
// checks for duplicate symbols
         while (playerIndex[0].getSymbol() == playerIndex[1].getSymbol())
         {
            System.out.println("Duplicate symbol. Please enter a new "
                    + "symbol.");
            playerIndex[i].setSymbol(askUserForSymbol());
         }
         System.out.println("Player " + (i + 1) + " is set.");
         System.out.print(NEW_LINE);
      }
// main game logic:
      int count = 0;
      int gameNumber = 1;
      int playerIndexNum = count % 2;
      Player currentPlayer = playerIndex[playerIndexNum];
// play until a player gets MAX_WINS
      while (playerIndex[0].getWins() < MAX_WINS &&
              playerIndex[1].getWins()
                      < MAX_WINS)
      {
         System.out.println("Game " + gameNumber + ":");
         displayBoard(gameBoard);
         winCheck = isWin(gameBoard, currentPlayer);
         drawCheck = isDraw(gameBoard);
// Single game loop
         while (winCheck == false && drawCheck == false)
         {
// ask for player to makeAMove()
            System.out.println("Current player is " +
                    currentPlayer.getSymbol());
            makeAMove(gameBoard, currentPlayer);
            displayBoard(gameBoard);
            winCheck = isWin(gameBoard, currentPlayer);
            drawCheck = isDraw(gameBoard);
// Game won; display who wins
            if (winCheck == true)
            {
               System.out.println("Player " + currentPlayer.getSymbol()
                       + " Wins!");
               currentPlayer.addWin();
               System.out.println("Player " + currentPlayer.getSymbol()
                       + " now has " + currentPlayer.getWins() + " wins");
               System.out.print(NEW_LINE);
            }
// Game draw
            if (winCheck == false && drawCheck == true)
            {
               System.out.println("Draw!");
               System.out.print(NEW_LINE);
            }
// alternate player turns
            count++;
            playerIndexNum = count % 2;
            currentPlayer = playerIndex[playerIndexNum];
         }
// resetBoard; losing player begins with first turn
         resetBoard(gameBoard, playerIndex[2]);
         gameNumber++;
      }
// after a player reaches MAX_WINS, display player wins and end
      program
      count++;
      playerIndexNum = count % 2;
      currentPlayer = playerIndex[playerIndexNum];
      System.out.println("Player " + currentPlayer.getSymbol() + " wins
              the set"
                      + " with a score of " + currentPlayer.getWins() + " to "
                      + playerIndex[Math.abs(playerIndexNum - 1)].getWins() + "!");
   }
   // askUserForSymbol() method
   static char askUserForSymbol()
   {
      final char MIN_SYMBOL = 'A';
      final char MAX_SYMBOL = 'Z';
      System.out.print("Please enter a capital letter as your symbol (A-
              Z): ");
      char inputChar = input.next().charAt(0);
      while (inputChar < MIN_SYMBOL || inputChar > MAX_SYMBOL)
      {
         System.out.print("Please enter a valid symbol (A-Z): ");
         inputChar = input.next().charAt(0);
      }
      return inputChar;
   }
   // resetBoard method
   static void resetBoard(Player[][] currentBoard, Player defaultPlayer)
   {
      for (int row = 0; row < currentBoard.length; row++)
      {
         for (int column = 0; column < currentBoard[row].length; column++)
         {
            currentBoard[row][column] = defaultPlayer;
         }
      }
   }
   // makeAMove method
   static void makeAMove(Player[][] currentBoard, Player actingPlayer)
   {
      final int MAX_INPUT = 2;
      final int MIN_INPUT = 0;
      System.out.println("Enter a row index for player " +
              actingPlayer.getSymbol() + ":");
      int row = input.nextInt();
      while (row < MIN_INPUT || row > MAX_INPUT)
      {
         System.out.println("Out of input range.");
         System.out.println("Enter a row index for player " +
                 actingPlayer.getSymbol() + ":");
         row = input.nextInt();
      }
      System.out.println("Enter a column index for player " +
              actingPlayer.getSymbol() + ":");
      int column = input.nextInt();
      while (column < MIN_INPUT || column > MAX_INPUT)
      {
         System.out.println("Out of input range.");
         System.out.println("Enter a column index for player " +
                 actingPlayer.getSymbol() + ":");
         column = input.nextInt();
      }
      while (currentBoard[row][column].getSymbol() != ' ')
      {
         System.out.println("Invalid move - Position taken.");
         System.out.println("Enter a row index for player " +
                 actingPlayer.getSymbol() + ":");
         row = input.nextInt();
         System.out.println("Enter a column index for player " +
                 actingPlayer.getSymbol() + ":");
         column = input.nextInt();
      }
      currentBoard[row][column] = actingPlayer;
   }
   // displayBoard method
   static void displayBoard(Player[][] currentBoard)
   {
      System.out.println("Current Board:");
      for (int row = 0; row < currentBoard.length; row++)
      {
         System.out.println(" ------------- ");
         for (int column = 0; column < currentBoard[row].length; column++)
         {
            System.out.print(" | " +
                    currentBoard[row][column].getSymbol());
         }
         System.out.println(" | ");
      }
      System.out.println(" ------------- ");
   }
   // isWin method
   static boolean isWin(Player[][] currentBoard, Player actingPlayer)
   {
      char symbol = actingPlayer.getSymbol();
      for (int row = 0; row < currentBoard.length; row++)
      {
// checks for 3 in a row vertically
         if (currentBoard[row][0].getSymbol() == symbol &&
                 currentBoard[row][1].getSymbol() == symbol &&
                 currentBoard[row][2].getSymbol() == symbol)
         {
            return true;
         }
         for (int column = 0; column < currentBoard[row].length; column++)
         {
// checks for 3 in a row horizontally
            if (currentBoard[0][column].getSymbol() == symbol &&
                    currentBoard[1][column].getSymbol() == symbol &&
                    currentBoard[2][column].getSymbol() == symbol)
            {
               return true;
            }
         }
// checks for first diagonal
         if (currentBoard[0][0].getSymbol() == symbol &&
                 currentBoard[1][1].getSymbol() == symbol &&
                 currentBoard[2][2].getSymbol() == symbol)
         {
            return true;
         }
// checks for second diagonal
         if (currentBoard[2][0].getSymbol() == symbol &&
                 currentBoard[1][1].getSymbol() == symbol &&
                 currentBoard[0][2].getSymbol() == symbol)
         {
            return true;
         }
      }
      return false;
   }
// isDraw method: checks if there are any remaining ' ' spots on the
   board
   static boolean isDraw(Player[][] currentBoard)
   {
      for (int row = 0; row < currentBoard.length; row++)
      {
         for (int column = 0; column < currentBoard[row].length; column++)
         {
            if (currentBoard[row][column].getSymbol() == ' ')
            {
               return false;
            }
         }
      }
      return true;
   }
}
class Player
{
   // instance members
   private char symbol;
   private int wins;
   // constants
   public final int MAX_WINS = 5;
   public final char MIN_SYMBOL = 'A';
   public final char MAX_SYMBOL = 'Z';
   public final char DEFAULT_SYMBOL = ' ';
   public final int DEFAULT_WINS = 0;
   // accessors (getters)
   public char getSymbol()
   {
      return symbol;
   }
   public int getWins()
   {
      return wins;
   }
   // mutator (setter)
   public boolean setSymbol(char symbol)
   {
      while (symbol < MIN_SYMBOL || symbol > MAX_SYMBOL)
      {
         return false;
      }
      this.symbol = symbol;
      return true;
   }
   // constructor (default)
   Player()
   {
      resetWins();
      symbol = DEFAULT_SYMBOL;
   }
   // constructor (paramterized)
   Player(char symbol)
   {
      resetWins();
      setSymbol(symbol);
   }
   // addWin method
   public boolean addWin()
   {
      if (wins < MAX_WINS)
      {
         wins++;
         return true;
      }
      return false;
   }
   // resetWins method
   public void resetWins()
   {
      wins = DEFAULT_WINS;
   }
}
/* --------------------------- Output Result -----------------------------
----
Player 1:
Please enter a capital letter as your symbol (A-Z): X
Player 1 is set.
Player 2:
Please enter a capital letter as your symbol (A-Z): 0
Please enter a valid symbol (A-Z): O
Player 2 is set.
Game 1:
Current Board:
-------------
| | | |
-------------
| | | |
-------------
| | | |
-------------
Current player is X
Enter a row index for player X:
0
Enter a column index for player X:
0
Current Board:
-------------
| X | | |
-------------
| | | |
-------------
| | | |
-------------
Current player is O
Enter a row index for player O:
2
Enter a column index for player O:
1
Current Board:
-------------
| X | | |
-------------
| | | |
-------------
| | O | |
-------------
Current player is X
Enter a row index for player X:
1
Enter a column index for player X:
1
Current Board:
-------------
| X | | |
-------------
| | X | |
-------------
| | O | |
-------------
Current player is O
Enter a row index for player O:
0
Enter a column index for player O:
1
Current Board:
-------------
| X | O | |
-------------
| | X | |
-------------
| | O | |
-------------
Current player is X
Enter a row index for player X:
2
Enter a column index for player X:
2
Current Board:
-------------
| X | O | |
-------------
| | X | |
-------------
| | O | X |
-------------
Player X Wins!
Player X now has 1 wins
Game 2:
Current Board:
-------------
| | | |
-------------
| | | |
-------------
| | | |
-------------
Current player is O
Enter a row index for player O:
2
Enter a column index for player O:
1
Current Board:
-------------
| | | |
-------------
| | | |
-------------
| | O | |
-------------
Current player is X
Enter a row index for player X:
1
Enter a column index for player X:
1
Current Board:
-------------
| | | |
-------------
| | X | |
-------------
| | O | |
-------------
Current player is O
Enter a row index for player O:
1
Enter a column index for player O:
0
Current Board:
-------------
| | | |
-------------
| O | X | |
-------------
| | O | |
-------------
Current player is X
Enter a row index for player X:
0
Enter a column index for player X:
2
Current Board:
-------------
| | | X |
-------------
| O | X | |
-------------
| | O | |
-------------
Current player is O
Enter a row index for player O:
0
Enter a column index for player O:
1
Current Board:
-------------
| | O | X |
-------------
| O | X | |
-------------
| | O | |
-------------
Current player is X
Enter a row index for player X:
2
Enter a column index for player X:
0
Current Board:
-------------
| | O | X |
-------------
| O | X | |
-------------
| X | O | |
-------------
Player X Wins!
Player X now has 2 wins
Game 3:
Current Board:
-------------
| | | |
-------------
| | | |
-------------
| | | |
-------------
Current player is O
Enter a row index for player O:
1
Enter a column index for player O:
1
Current Board:
-------------
| | | |
-------------
| | O | |
-------------
| | | |
-------------
Current player is X
Enter a row index for player X:
0
Enter a column index for player X:
0
Current Board:
-------------
| X | | |
-------------
| | O | |
-------------
| | | |
-------------
Current player is O
Enter a row index for player O:
0
Enter a column index for player O:
1
Current Board:
-------------
| X | O | |
-------------
| | O | |
-------------
| | | |
-------------
Current player is X
Enter a row index for player X:
1
Enter a column index for player X:
0
Current Board:
-------------
| X | O | |
-------------
| X | O | |
-------------
| | | |
-------------
Current player is O
Enter a row index for player O:
2
Enter a column index for player O:
2
Current Board:
-------------
| X | O | |
-------------
| X | O | |
-------------
| | | O |
-------------
Current player is X
Enter a row index for player X:
2
Enter a column index for player X:
0
Current Board:
-------------
| X | O | |
-------------
| X | O | |
-------------
| X | | O |
-------------
Player X Wins!
Player X now has 3 wins
Game 4:
Current Board:
-------------
| | | |
-------------
| | | |
-------------
| | | |
-------------
Current player is O
Enter a row index for player O:
0
Enter a column index for player O:
1
Current Board:
-------------
| | O | |
-------------
| | | |
-------------
| | | |
-------------
Current player is X
Enter a row index for player X:
1
Enter a column index for player X:
1
Current Board:
-------------
| | O | |
-------------
| | X | |
-------------
| | | |
-------------
Current player is O
Enter a row index for player O:
0
Enter a column index for player O:
0
Current Board:
-------------
| O | O | |
-------------
| | X | |
-------------
| | | |
-------------
Current player is X
Enter a row index for player X:
1
Enter a column index for player X:
0
Current Board:
-------------
| O | O | |
-------------
| X | X | |
-------------
| | | |
-------------
Current player is O
Enter a row index for player O:
2
Enter a column index for player O:
2
Current Board:
-------------
| O | O | |
-------------
| X | X | |
-------------
| | | O |
-------------
Current player is X
Enter a row index for player X:
1
Enter a column index for player X:
2
Current Board:
-------------
| O | O | |
-------------
| X | X | X |
-------------
| | | O |
-------------
Player X Wins!
Player X now has 4 wins
Game 5:
Current Board:
-------------
| | | |
-------------
| | | |
-------------
| | | |
-------------
Current player is O
Enter a row index for player O:
0
Enter a column index for player O:
1
Current Board:
-------------
| | O | |
-------------
| | | |
-------------
| | | |
-------------
Current player is X
Enter a row index for player X:
1
Enter a column index for player X:
0
Current Board:
-------------
| | O | |
-------------
| X | | |
-------------
| | | |
-------------
Current player is O
Enter a row index for player O:
0
Enter a column index for player O:
0
Current Board:
-------------
| O | O | |
-------------
| X | | |
-------------
| | | |
-------------
Current player is X
Enter a row index for player X:
0
Enter a column index for player X:
2
Current Board:
-------------
| O | O | X |
-------------
| X | | |
-------------
| | | |
-------------
Current player is O
Enter a row index for player O:
2
Enter a column index for player O:
0
Current Board:
-------------
| O | O | X |
-------------
| X | | |
-------------
| O | | |
-------------
Current player is X
Enter a row index for player X:
2
Enter a column index for player X:
2
Current Board:
-------------
| O | O | X |
-------------
| X | | |
-------------
| O | | X |
-------------
Current player is O
Enter a row index for player O:
2
Enter a column index for player O:
1
Current Board:
-------------
| O | O | X |
-------------
| X | | |
-------------
| O | O | X |
-------------
Current player is X
Enter a row index for player X:
1
Enter a column index for player X:
2
Current Board:
-------------
| O | O | X |
-------------
| X | | X |
-------------
| O | O | X |
-------------
Player X Wins!
Player X now has 5 wins
Player X wins the set with a score of 5 to 0!
--------------------------------------------------------------------------
-- */
