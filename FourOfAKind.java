/**
 * The FourOfAKind class represents a scoring category in the game Yahtzee.
 * FourOfAKind scores the sum of all dice when at least four dice have the same value.
 * This class extends the Category abstract class and implements evaluate.
 */
class FourOfAKind extends Category
{
   /**
    * Evaluates the given Dice object to check if there are at least four dice with the same value.
    * If found, returns the sum of all dice values in the given Dice object, otherwise returns 0.
    * @param d the Dice object to evaluate.
    * @return the sum of all dice values in the given Dice object if at least four dice have the same value, otherwise 0.
    */
   public int evaluate(Dice d)
   {
      int score = 0;
      
      for (int i = 0; i < 1; i++)
      {
         int copies = 1;
         for (int j = i + 1; j < d.getNumDice(); j++)
         {
         
            if (d.getDie(j).getValue() == d.getDie(i).getValue())
               copies++;
            
            if (copies >= 4)
            {
               for (int k = 0; k < d.getNumDice(); k++)
               {
                  score += d.getDie(k).getValue();
               }
               return score;
            }
         }
      }
      
      return score;
   }
}