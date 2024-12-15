/**
 * The Twos class represents a scoring category in the game Yahtzee.
 * Twos scores the sum of all dice with a value of two.
 * This class extends the Category abstract class and implements evaluate.
 */
class Twos extends Category
{
   /**
    * Evaluates the given Dice object by summing the values of all dice with a value of two.
    * @param d the Dice object to evaluate.
    * @return the sum of all dice with a value of two in the given Dice object.
    */
   public int evaluate(Dice d)
   {
      int score = 0;
      for (int i = 0; i < d.getNumDice(); i++)
      {
         if (d.getDie(i).getValue() == 2)
         {
            score += 2;
         }
      }
      return score;
   }
}