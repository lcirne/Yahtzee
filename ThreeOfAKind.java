/**
 * The ThreeOfAKind class represents a scoring category in the game Yahtzee.
 * ThreeOfAKind scores the sum of all dice if there are at least three dice with the same value.
 * This class extends the Category abstract class and implements evaluate.
 */
import java.util.*;

class ThreeOfAKind extends Category
{
   /**
    * Evaluates the given Dice object to determine if it contains at least three dice with the same value.
    * If so, scores the sum of all dice in the given Dice object.
    * @param d the Dice object to evaluate.
    * @return the sum of all dice values in the given Dice object if at least three dice have the same value, 0 otherwise.
    */
   public int evaluate(Dice d)
   {
      int score = 0;
      int copies = 1;
      
      for (int i = 0; i < 2; i++)
      {
         for (int j = i + 1; j < d.getNumDice(); j++)
         {
         
            if (d.getDie(j).getValue() == d.getDie(i).getValue())
               copies++;
            
            if (copies >= 3)
            {
               for (int k = 0; k < d.getNumDice(); k++)
               {
                  score += d.getDie(k).getValue();
               }
               return score;
            }
         }
      }
      
      return score;
   }
}