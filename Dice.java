/**
 * The Dice class represents a set of dice.
 * This class contains methods for manipulating the dice and performing common operations
 * such as counting the number of dice with a given value, computing the sum of all
 * dice values, and checking if the set of dice contains a given value.
 */
import java.util.*;
class Dice
{
   private ArrayList<Die> dice;
   private final int DEF_CAPACITY = 5;
   
   /**
    * Constructs a new Dice object with the default capacity.
    */
   public Dice()
   {
      dice = new ArrayList<>(DEF_CAPACITY);
   }
   
   /**
    * Constructs a new Dice object with the specified number of dice.
    * @param num the number of dice to instantiate the dice object with.
    */
   public Dice(int num)
   {
      dice = new ArrayList<>(num);
   }
   
   /**
    * Adds a Die object to the set of dice.
    * @param d the Die object to add.
    */
   public void addDie(Die d)
   {
      dice.add(d);
   }  
   
   /**
    * Returns the number of dice in the set.
    * @return the number of dice in the set.
    */
   public int getNumDice()
   {
      return dice.size();
   }
   
   /**
    * Returns the Die object at the specified index.
    * @param i the index of the Die object to return.
    * @return the Die object at the specified index.
    */
   public Die getDie(int i)
   {
      return dice.get(i);
   }
   
   /**
    * Removes the Die object at the specified index from the set of dice.
    * @param i the index of the Die object to remove.
    */
   public void removeDie(int i)
   {
      dice.remove(i);
   }
   
   /**
    * Counts the number of dice in the set with the specified value.
    * @param val the value to compare dice with.
    * @return the number of dice in the set with the specified value.
    */
   public int count(int val)
   {
      int count = 0;
      for (int i = 0; i < dice.size(); i++)
      {
         if (dice.get(i).getValue() == val)
            count++;
      }
      return count;
   }
   
   /**
    * Computes the sum of all dice values in the set.
    * @return the sum of all dice values in the set.
    */
   public int sum()
   {
      int sum = 0;
      for (int i = 0; i < dice.size(); i++)
      {
         sum += dice.get(i).getValue();
      }
      return sum;
   }
   
   /**
    * Returns true if the set of dice contains at least one die with the specified value, false otherwise.
    * @param val the value to check for.
    * @return true if the set of dice contains at least one die with the specified value, false otherwise.
    */
   public boolean contains(int val)
   {
      for (int i = 0; i < dice.size(); i++)
      {
         if (dice.get(i).getValue() == val)
            return true;
      }
      return false;
   }
   
   /**
    * Returns a string representation of the set of dice.
    * @return a string representation of the set of dice.
    */
   public String toString()
   {
      String s = "";
      for (int i = 0; i < dice.size(); i++)
      {
         s += String.format("%d: value %d\n", i+1, dice.get(i).getValue());
      }
      return s;
   }  
   
}