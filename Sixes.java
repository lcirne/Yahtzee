/**
 * The Sixes class represents a scoring category in the game Yahtzee.
 * Sixes scores the sum of all dice with a value of 6.
 * This class extends the Category abstract class and implements evaluate.
 */
class Sixes extends Category
{
   /**
    * Evaluates the given Dice object by summing the values of all dice with a value of 6.
    * @param d the Dice object to evaluate.
    * @return the sum of all dice values with a value of 6 in the given Dice object.
    */
   public int evaluate(Dice d)
   {
      int score = 0;
      for (int i = 0; i < d.getNumDice(); i++)
      {
         if (d.getDie(i).getValue() == 6)
         {
            score += 6;
         }
      }
      return score;
   }
}