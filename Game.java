/**
 * The Game class handles all main functions for each player in tg=he game Yahtzee.
 * This class holds the scorecard for each player, a dice object and diceroll object, as well
 * as a String for user input and a scanner.
 */
import java.util.*;
class Game
{
   private int numRolls;
   private int player = 0;
   private ScoreCard sc1;
   private ScoreCard sc2;
   private String input;
   private Dice holder;
   private DiceRoll currentDice;
   private Scanner scan;
   
   /**
    * Creates a Game object and instantiates two scorecard objects and
    * prints a welcome message.
    */
   public Game()
   {
      sc1 = new ScoreCard();
      sc2 = new ScoreCard();
      
      for (int i = 0; i < 56; i++)
      {
         System.out.print("*");
      }
      String welcome = "WELCOME TO YAHTZEE";
      System.out.printf("\n%36s\n", welcome);
      
      for (int i = 0; i < 56; i++)
      {
         System.out.print("*");
      }
   }
   
   /**
    * Checks whether all categories in the given ScoreCard have been scored.
    * @param sc the ScoreCard object to check.
    * @return true if all categories have been scored, false otherwise.
    */
   public boolean checkDone(ScoreCard sc)
   {
      boolean checked = true;
      for (int i = 0; i < 12; i++)
      {
         CategoryValue cv = CategoryValue.values()[i];
         checked = sc.checkScored(cv);
         if (checked = false)
         {
            return false;
         }
      }
      return checked;
   }
   
   /**
    * Scores the specified category by calling the choose method.
    * @param sc the ScoreCard object to score.
    * @param categoryNum the chosen category.
    * @param d the dice object to evaluate.
    * @return true if the category was successfully scored.
    */
   public boolean scoreCat(ScoreCard sc, int categoryNum, Dice d)
   {
      CategoryValue cv = CategoryValue.values()[categoryNum-1];
      sc.choose(cv, d);
      System.out.printf("You scored %d points in %s\n\n", sc.getCategoryScore(cv), cv);
      
      for (int i = 0; i < 55; i++)
      {
         System.out.print("*");
      }
      
      return true;
   }
   
   /**
    * Plays a game of dice by instantiating two dice objects, a scanner, a scorecard, and a number of rolls.
    * The player number is incremented and the turn method is called for the corresponding player.
    * If the player number is odd, the turn is for player 1 using the given Scorecard object sc1.
    * If the player number is even, the turn is for player 2 using the given Scorecard object sc2.
    */
   public void play()
   {
      //Instantiate two dice objects, scanner, scorecard, & numRolls
      numRolls = 3;
      holder = new Dice();
      scan = new Scanner(System.in);
      player++;
      if (player % 2 == 1)
         turn(sc1, player);
      else if (player % 2 == 0)
         turn(sc2, player);
   }
   
   /**
    * Handles the bulk of each players turn by printing scorecards, taking input, rerolling die, etc.
    * Inline comments are included to document exact functions of each section.
    * @param sc the scorecard to be used for this turn.
    * @param player the player whose turn it is.
    */
   public void turn(ScoreCard sc, int player)
   {  
      //print the player and scorecard
      if (player % 2 == 1)
      {
         System.out.println("\n\nPlayer 1:");
         System.out.println(sc);
      }
      else
      {
         System.out.println("\n\nPlayer 2:");
         System.out.println(sc);
      }
      
      //roll dice
      currentDice = new DiceRoll();
      
      while (numRolls > 1)
      {
         System.out.println("Dice To Reroll:");
         System.out.println(currentDice);
         
         if (holder.getNumDice() >= 1)
         {
            System.out.println("Dice To Save:");
            System.out.println(holder);
         }
         
         System.out.println("Save dice with [ ] filled with index values separated by spaces\n"
                              + "'roll' to reroll, 'score' to score");
         
         //get user input 
         input = scan.nextLine().trim();
         if (input.equals(""))
         {
            System.out.println("Input invalid");
         }
         else if (input.equals("roll"))
         {
            currentDice.toss();
            numRolls--;
         }
         //action for score
         else if (input.equals("score"))
         {
            //set numrolls to 0
            numRolls = 0;
         }
         
         else if (input.charAt(0) == '[' && input.charAt(input.length() - 1) == ']')
         {
            input = input.substring(1, input.length() - 1);
            String[] indexesToSave = input.split(" ");
            int[] numberIndexes = new int[indexesToSave.length];
            boolean valid = true;
            
            for (String str : indexesToSave)
            {
               try 
               {
                  int num = Integer.parseInt(str);
                  if (num < 6)
                  {
                     holder.addDie(currentDice.getDie(num - 1));
                     valid = false;
                  }
                  else
                  {
                     throw new NumberFormatException();
                  }
               }
               catch (NumberFormatException e) 
               {
                  System.out.printf("[%s] is not valid\n\n", input);
               }
            }
            
            if (!valid)
            {
               int count = 0;
               for (String str : indexesToSave)
               {
                  try
                  {
                     int num = Integer.parseInt(str);
                     numberIndexes[count] = num;
                     count++;
                  }
                  catch (NumberFormatException e) 
                  {
                     System.out.printf("[%s] is not valid\n\n", input);
                  }
               }
               
               Arrays.sort(numberIndexes);
               count = 0;
               for (int num : numberIndexes)
               {
                  if (num < 6)
                  {
                     count++;
                     currentDice.removeDie(num - count); 
                  }
               }
            }
         }
         
         else
         {
            System.out.printf("[%s] is not valid\n\n", input);
         }
      }//end of while loop
      
      //populate holder with any remaining dice
      for (int j = 0; j < currentDice.getNumDice(); j++)
      {
         holder.addDie(currentDice.getDie(j));
      }      
      
      //print the final dice roll
      System.out.println("Final roll:");
      System.out.println(holder);
      System.out.println("\nSelect a category that you have not scored in yet:");
      
      //print scores for each category
      String s = "";
      for (int i = 0; i < 13; i++)
      {
         CategoryValue cv = CategoryValue.values()[i];
         s += String.format("%d: ", i+1);
         s += String.format("%s, %d points\n", cv, sc.getEvaluation(cv, holder));
      }
      System.out.println(s);
      
      //get user input
      int categoryNum = 0;
      while (categoryNum < 1)
      {
         input = scan.nextLine();
         try
         {
            categoryNum = Integer.parseInt(input);
            if (sc.checkScored(CategoryValue.values()[categoryNum-1]))
            {
               System.out.println("That category has already been used");
               categoryNum = 0;
            }
         }
         catch (NumberFormatException e)
         {
            System.out.println("Input invalid");
         }
      }
      
      //call the category to score
      if (scoreCat(sc, categoryNum, holder))
      {
         boolean finished = checkDone(sc);
         if (finished)
         {
            System.out.printf("Finished Scorecard:\n%s", sc);
         }
         else
         play();
      }
      
   }//end turn method
  
}