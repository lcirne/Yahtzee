/**
 * The Die class represents a single die in a set of dice.
 * Each die has a value that can be set and retrieved, and can be rolled to generate a new value.
 */
import java.util.*;
class Die
{
   private int value;
   private final int SIDES = 6;
   private Random rand = new Random();
   
   /**
    * Constructs a new Die object with a random initial value.
    */
   public Die()
   {
      value = rand.nextInt(SIDES) + 1;
   }
   
   /**
    * Rolls the die to generate a new random value.
    */
   public void roll()
   {
      value = rand.nextInt(SIDES) + 1;
   }
   
   /**
    * Returns the current value of the die.
    * @return the current value of the die.
    */
   public int getValue()
   {
      return value;
   }
   
   /**
    * Returns a String representation of the die's current value.
    * @return a String representation of the die's current value.
    */
   public String toString()
   {
      return String.format("%d", value);
   }

}