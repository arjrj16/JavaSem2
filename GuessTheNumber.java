import java.util.*;
import java.io.*;

/**
 * Arjun Melwani
 * JAVA
 * 
 
 * Write a program that plays a reverse guessing game with the user. The user thinks of a number between 1 and 10, and
the computer repeatedly tries to guess it by guessing random numbers. It’s fine for the computer to guess the same
random number more than once. At the end of the game, the program reports how many guesses it made. Here is a
sample execution:
This program has you, the user, choose a number
between 1 and 10. Then I, the computer, will try
my best to guess it.
Is it 8? (y/n) n
Is it 7? (y/n) n
Is it 5? (y/n) n
Is it 1? (y/n) n
Is it 8? (y/n) n
Is it 1? (y/n) n
Is it 9? (y/n) y
I got your number of 9 correct in 7 guesses.
For an added challenge, consider having the user hint to the computer whether the correct number is higher or lower
than the computer’s guess. The computer should adjust its range of random guesses on the basis of the hint.
 */
public class GuessTheNumber {
    public static void main(String args []){
        System.out.println("This progam has you, the user, choose a number\nbetween 1 and 10. Then, I, the computer, will try\nmy best to guess it."); //ui
        //make objects
        Random rn = new Random(); 
        Scanner input = new Scanner (System.in);
        //variable declaration
        String in;
        boolean found = false;
        int numGuesses = 0;
        int rangeHigh = 10;
        int rangeLow = 1;
        String highOrlow;
        int gueessedNumbers [] = new int [10]; //array to know which nums have been guessed
        while(!found){ //while the num is not found
            numGuesses++;
            int guess = (rn.nextInt(rangeHigh - rangeLow + 1) + rangeLow); //guesses a number
            while(gueessedNumbers[guess-1]>0){ //checks num hasn't been guessed before 
                guess = (rn.nextInt(rangeHigh - rangeLow + 1) + rangeLow);
            }
            gueessedNumbers[guess-1]++; //records number so knows not to guess it again
            System.out.println("between: "+rangeLow+" and "+rangeHigh);

            System.out.print("Is it "+ guess +"? (y/n) ");
            in = input.next();
            if(in.contains("y")){ //if yes, UI
                System.out.println("I got yor number in "+numGuesses+" guesses.");
                found = true; // dont loop again
            }
            else{//if no,
                found = false; //loop again
                System.out.print("Is it higher or lower? ");
                highOrlow = input.next();
                if(highOrlow.equalsIgnoreCase("higher")){ //if higher, make guess with smaller range
                    rangeLow = guess;
                    if(guess == rangeHigh){ //user is lying
                        System.out.println("You may only choose a number between 1 and 10 and you are not allowed to change your number. Please re-run program and try again");
                        break;
                    }
                }
                else if(highOrlow.equalsIgnoreCase("lower")){ //if lower, guess with smaller range
                    rangeHigh = guess; 
                    if(guess == rangeLow){ //user is lying
                        System.out.println("You may only choose a number between 1 and 10 and are not allowed to change your number. Please re-run program and try again");
                        break;
                    }
                }
            }
        }
    }
}
