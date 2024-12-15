/**
 * The ScoreCard class represents the scorecard used in the game Yahtzee.
 * The scorecard has categories which can be scored based on the results of the dice rolls.
 * This class provides methods for choosing a category to score, retrieving the evaluation of a category based
 * on the results of a dice roll, checking if a category has already been scored, and calculating the total score
 * for the upper section, lower section, and the entire scorecard.
 */
import java.util.*;
class ScoreCard
{
   private ArrayList<Category> scorecard = new ArrayList<>();
   private int yahtzeeBonus = 100;
   private final int NUM_CATS = 13;
   
   /**
    * Constructs a new ScoreCard object and initializes its categories to their respective scoring categories.
    */
   public ScoreCard()
   {
      scorecard.add(new Ones());
      scorecard.add(new Twos());
      scorecard.add(new Threes());
      scorecard.add(new Fours());
      scorecard.add(new Fives());
      scorecard.add(new Sixes());
      scorecard.add(new ThreeOfAKind());
      scorecard.add(new FourOfAKind());
      scorecard.add(new FullHouse());
      scorecard.add(new SmStraight());
      scorecard.add(new LgStraight());
      scorecard.add(new Yahtzee());
      scorecard.add(new Chance());
   }
   
   /**
    * Adds the score for the specified category value based on the given dice roll.
    * @param cv the CategoryValue enum value representing the category to score.
    * @param d the Dice object containing the results of the dice roll.
    */
   public void choose(CategoryValue cv, Dice d)
   {
      scorecard.get(cv.getValue()).addValue(d);
   }
   
   /**
    * Evaluates the score for the specified category value based on the given dice roll.
    * @param cv the CategoryValue enum value representing the category to evaluate.
    * @param d the Dice object containing the results of the dice roll.
    * @return the score for the specified category value based on the given dice roll.
    */
   public int getEvaluation(CategoryValue cv, Dice d)
   {
      return scorecard.get(cv.getValue()).evaluate(d);
   }
   
   /**
    * Checks if the specified category value has already been scored.
    * @param cv the CategoryValue enum value representing the category to check.
    * @return true if the specified category value has already been scored; false otherwise.
    */
   public boolean checkScored(CategoryValue cv)
   {
      return scorecard.get(cv.getValue()).getUsed();
   }
   
   /**
    * Retrieves the score for the specified category value.
    *
    * @param cv the CategoryValue enum value representing the category to retrieve the score for.
    * @return the score for the specified category value.
    */
   public int getCategoryScore(CategoryValue cv)
   {
      return scorecard.get(cv.getValue()).getScore();
   }
   
   /**
    * Calculates and returns the total score for the upper section of the scorecard.
    * @return the total score for the upper section of the scorecard.
    */
   public int scoreTop()
   {
      int totalScore = 0;
      for (int i = 0; i < 6; i++)
      {
         if (scorecard.get(i).getUsed())
            totalScore += scorecard.get(i).getScore();
      }
      return totalScore;
   }
   
  /**
   * Calculates and returns the total score of all the categories in the lower section of the scorecard
   * that have been used to score a roll.
   * @return the total score of all used categories in the lower section of the scorecard.
   */
   public int scoreBottom()
   {
      int totalScore = 0;
      for (int i = 6; i < scorecard.size(); i++)
      {
         if (scorecard.get(i).getUsed())
            totalScore += scorecard.get(i).getScore();
      }
      return totalScore;
   }
   
  /**
   * Calculates and returns the total score of all the categories in the scorecard
   * that have been used to score a roll.
   * @return the total score of all used categories in the scorecard.
   */
   public int score()
   {
      int totalScore = 0;
      for (int i = 0; i < scorecard.size(); i++)
      {
         if (scorecard.get(i).getUsed())
            totalScore += scorecard.get(i).getScore();
      }
      return totalScore;
   }
   
  /**
   * Returns a string representation of the scorecard, including the scores for each category,
   * the upper and lower total scores, and the overall total score.
   * @return a string representation of the scorecard.
   */
   @Override
   public String toString()
   {
      String s = "Current Scorecard:";
      for (int i = 0; i < scorecard.size(); i++)
      {
         CategoryValue cv = CategoryValue.values()[i];
         s += String.format("\n%15s: %d", cv, scorecard.get(i).getScore());
      }
      s += String.format("\n%15s: %d", "Upper Total", scoreTop());
      s += String.format("\n%15s: %d", "Lower Total", scoreBottom());
      s += String.format("\n%15s: %d", "Total", score());

      return s;

   }
   
   
}