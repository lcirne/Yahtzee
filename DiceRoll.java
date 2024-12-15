/**
 * The DiceRoll class represents a roll of dice in a game.
 * It extends the Dice class and adds the ability to roll all dice.
 * This class initializes five dice with no values and implements the toss method to roll all dice.
 */
class DiceRoll extends Dice
{
   private final int NUM_DIE = 5;
   
   /**
    * Creates a new DiceRoll object with five dice.
    */
   public DiceRoll()
   {
      for (int i = 0; i < NUM_DIE; i++)
      {
         super.addDie(new Die());
      }
   }
   
   /**
    * Rolls all dice in this DiceRoll object.
    * Randomly generates values for each die.
    */
   public void toss()
   {
      for (int i = 0; i < super.getNumDice(); i++)
      {
         super.getDie(i).roll();
      }
   }
   
}