/**
 * The SmStraight class represents a scoring category in the game Yahtzee.
 * SmStraight scores 30 points if the dice contain a sequence of four consecutive numbers.
 * This class extends the Category abstract class and implements evaluate.
 */
class SmStraight extends Category
{
   /**
    * Evaluates the given Dice object to check for a small straight sequence of four numbers.
    * @param d the Dice object to evaluate.
    * @return 30 if the dice contain a small straight sequence of four numbers, 0 otherwise.
    */
   public int evaluate(Dice d)
   {
      int score = 0;
      
      for (int i = 1; i <= 3; i++)
      {
         if (d.contains(i) && d.contains(i+1) && d.contains(i+2) && d.contains(i+3))
            score = 30;
            return score;
      }
      return score;
   }
}