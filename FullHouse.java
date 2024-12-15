/**
 * The FullHouse class represents a scoring category in the game Yahtzee.
 * FullHouse scores 25 if the dice contain three of one value and two of another.
 * This class extends the Category abstract class and implements evaluate.
 */
class FullHouse extends Category
{
   /**
    * Evaluates the given Dice object to determine if it contains a full house combination.
    * A full house requires three dice of one value and two dice of another value.
    * If the combination is found, the score is 25, otherwise 0.
    * @param d the Dice object to evaluate.
    * @return 25 if the given Dice object contains a full house combination, 0 otherwise.
    */
   public int evaluate(Dice d)
   {
      int v1;
      int v2;
      int numVals = 0;
      
      for (int j = 1; j < 7; j++)
      {
         if (d.contains(j))
         {
            numVals++;
         }
      }
      
      v1 = d.getDie(0).getValue();
      if (numVals == 2)
      {
         return 25;
      }
      return 0;
   }
}