/**
 * The Yahtzee class represents a scoring category in the game Yahtzee.
 * Yahtzee scores 50 points if all dice have the same value, and 0 otherwise.
 * This class extends the Category abstract class and implements evaluate.
 */
class Yahtzee extends Category
{
   /**
    * Evaluates the given Dice object to check if all dice have the same value.
    * If all dice have the same value, returns 50. Otherwise, returns 0.
    * @param d the Dice object to evaluate.
    * @return 50 if all dice have the same value, 0 otherwise.
    */
   public int evaluate(Dice d)
   {
      int score = 0;
      int value = d.getDie(0).getValue();
      
      for (int i = 1; i < d.getNumDice(); i++)
      {
         if (value != d.getDie(i).getValue())
         {
            return 0;
         }
      }
      score = 50;
      return score;
   }
}