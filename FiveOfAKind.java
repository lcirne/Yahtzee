/**
 * The FiveOfAKind class represents a scoring category in the game Yahtzee.
 * FiveOfAKind scores the sum of all dice values if all dice have the same value.
 * This class extends the Category abstract class and implements evaluate.
 */
class FiveOfAKind extends Category
{
   /**
    * Evaluates the given Dice object by checking if all dice have the same value and
    * summing their values if they do.
    * @param d the Dice object to evaluate.
    * @return the sum of all dice values in the given Dice object if all dice have the
    * same value, or 0 otherwise.
    */
   public int evaluate(Dice d)
   {
      int score = 0;
      
      for (int i = 0; i < d.getNumDice() - 1; i++)
      {
         score += d.getDie(i).getValue();
         if (d.getDie(i).getValue() != d.getDie(i+1).getValue())
            return 0;
      }

      return score;
   }
}






