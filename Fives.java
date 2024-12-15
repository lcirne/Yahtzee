/**
 * The Fives class represents a scoring category in the game Yahtzee.
 * Fives scores the sum of all dice that show a value of 5.
 * This class extends the Category abstract class and implements evaluated.
 */
class Fives extends Category
{
   /**
    * Evaluates the given Dice object by summing the values of all dice that show a value of 5.
    * @param d the Dice object to evaluate.
    * @return the sum of all dice values in the given Dice object that show a value of 5.
    */
   public int evaluate(Dice d)
   {
      int score = 0;
      for (int i = 0; i < d.getNumDice(); i++)
      {
         if (d.getDie(i).getValue() == 5)
         {
            score += 5;
         }
      }
      return score;
   }
}