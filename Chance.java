/**
 * The Chance class represents a scoring category in Yahtzee.
 * Chance scores the sum of all dice regardless of their values.
 * This class extends the Category abstract class and implements evaluate.
 */
class Chance extends Category
{
   /**
    * Evaluates the given Dice object by summing all values of the dice.
    * @param d the Dice object to evaluate.
    * @return the sum of all dice values in the given Dice object.
    */
   public int evaluate(Dice d)
   {
      int score = 0;
      
      for (int i = 0; i < d.getNumDice(); i++)
      {
         score += d.getDie(i).getValue();
      }
      return score;
   }
}  