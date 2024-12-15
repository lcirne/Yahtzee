/**
 * The Threes class represents a scoring category in the game Yahtzee.
 * Threes scores the sum of all dice showing the value 3.
 * This class extends the Category abstract class and implements evaluate.
 */
class Threes extends Category
{
  /**
   * Evaluates the given Dice object by summing the values of all dice that show the value 3.
   * @param d the Dice object to evaluate.
   * @return the sum of all dice values showing the value 3 in the given Dice object.
   */
   public int evaluate(Dice d)
   {
      int score = 0;
      for (int i = 0; i < d.getNumDice(); i++)
      {
         if (d.getDie(i).getValue() == 3)
         {
            score += 3;
         }
      }
      return score;
   }
}  