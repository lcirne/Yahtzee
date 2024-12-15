/**
 * The abstract Category class represents different categories to score in Yahtzee.
 * This class tracks the score and usage status for each category.
 */
public abstract class Category
{  
   private int score;
   private boolean used;
   
   /**
    * Evaluates the given Dice object according to the rules of the category.
    * @param d the Dice object to evaluate.
    * @return the score achieved for the given Dice object in this category.
    */
   public abstract int evaluate(Dice d);
   
   /**
    * Evaluates the given Dice object and updates the score and usage status for this category
    * @param d the Dice object to evaluate.
    */
   public void addValue(Dice d)
   {
      score = evaluate(d);
      used = true;
   }
   
   /**
    * Returns the score for this category.
    * @return the score for this category.
    */
   public int getScore()
   {
      return score;
   }
   
   /**
    * Returns true if this category has already been used to score a roll, false otherwise
    * @return true if this category has already been used to score a roll, false otherwise.
    */
   public boolean getUsed()
   {
      return used;
   }
   
}