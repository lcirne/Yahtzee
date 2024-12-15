/**
 * The Ones class represents a scoring category in the game Yahtzee.
 * Ones scores the sum of all dice with a value of one.
 * This class extends the Category abstract class and implements evaluate.
 */
class Ones extends Category
{
   /**
    * Evaluates the given Dice object by counting the number of dice with a value of one.
    * @param d the Dice object to evaluate.
    * @return the sum of all dice values in the given Dice object that are equal to one.
    */
   public int evaluate(Dice d)
   {
      int score = 0;
      for (int i = 0; i < d.getNumDice(); i++)
      {
         if (d.getDie(i).getValue() == 1)
         {
            score++;
         }
      }
      return score;
   }  
}