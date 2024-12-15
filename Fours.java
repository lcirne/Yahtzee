/**
 * The Fours class represents a scoring category in the game Yahtzee.
 * Fours scores the sum of all dice that show the value of four.
 * This class extends the Category abstract class and implements evaluate.
 */
class Fours extends Category
{
   /**
    * Evaluates the given Dice object by summing the values of all dice that show the value of four.
    * @param d the Dice object to evaluate.
    * @return the sum of all dice that show the value of four in the given Dice object.
    */
   public int evaluate(Dice d)
   {
      int score = 0;
      for (int i = 0; i < d.getNumDice(); i++)
      {
         if (d.getDie(i).getValue() == 4)
         {
            score += 4;
         }
      }
      return score;
   }
} 