/**
 * The LgStraight class represents a scoring category in the game Yahtzee.
 * LgStraight scores 40 points if the dice contain a sequence of five consecutive numbers.
 * This class extends the Category abstract class and implements evaluate.
 */
class LgStraight extends Category
{
   /**
    * Evaluates the given Dice object by checking for a sequence of five consecutive numbers.
    * @param d the Dice object to evaluate.
    * @return 40 if the given Dice object contains a sequence of five consecutive numbers, 0 otherwise.
    */
   public int evaluate(Dice d)
   { 
      boolean isStraight = true;
      int score = 0;
      
      for (int i = 1; i <= 2; i++)
      {
         if (d.contains(i) && d.contains(i+1) && d.contains(i+2) && d.contains(i+3) && d.contains(i+4))
         {
            score = 40;
            return score;
         }
      }
      return score;
   } 
}