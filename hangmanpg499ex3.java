/*
Pseudo code:

int lives counter - amount of chances to get wrong
int letters remaining - purely as an integer version of the amount letters left to guess used for the while loop
User enters word - string word
Converts to lowercase for computation
while loop - runs while lives are greater than 0 and letters remaining are above 0 - basically while the game is still going on
{
asks user to guess a letter
Converts to lowercase for computation
Array "guessed" - to store the correctly guessed letters, filled in standard with '_'
Array - alphCount. 26 elements and the index of the alphabet a letter is, is added by one to count the ammount of times it is guessed
    needs seperate string of just alphabet letters - "abcdef", so we can use "indexOf" function to find which number we need to assign the counter to in the alphCount array.
    This is used for knowing if the user has already guessed
if the word CONTAINS the letter, 
    then for loop cycles through guessed array and word to replace each with the letter
else
    lowers life and prints graphic of Hang man - graphic()

graphic(int lives){
    Switch case - prints seperate graphic of hang man for different lives
}
} *While loop ends
then just print -
If lives remaining is >0, you win
else you lost

*/
import java.util.*;
public class hangmanpg499ex3 {

    public static void graphic (int lives){ //function that prints graphic depending on if you won
        switch(lives+1){
            case 6:
            head();
            break;
            case 5:
            Larm();
            break;
            case 4:
            torso();
            break;
            case 3:
            Rarm();
            break;
            case 2:
            Lleg();
            break;
            case 1:
            RLeg();
            break;
            default:
            System.out.println("Error in graphic.");
        }
    }

    //following functions literally just print the hang man
    public static void head (){
        System.out.println(" O");
    }
    public static void Larm(){
        System.out.println(" O");
        System.out.println("/");
    }
    public static void torso(){
        System.out.println(" O");
        System.out.println("/|");
    }
    public static void Rarm(){
        System.out.println(" O");
        System.out.println("/|\\");
    }
    public static void Lleg(){
        System.out.println(" O");
        System.out.println("/|\\");
        System.out.println("/ ");
    }
    public static void RLeg(){
        System.out.println(" O");
        System.out.println("/|\\");
        System.out.println("/ \\");
    }


    public static Scanner input = new Scanner (System.in);

    //finds index of character in an array.
    public static int ArrayIndexOf(char a[], char c){
        int i =0;
        while (i < a.length) {
            if (a[i] == c) {
                return i;
            }
            else {
                i = i + 1;
            }
        }
        return -1;
    }

    public static void main(String args[]){
        //char [] guessedLetters = new char [26];
        char guess; //character that user guesses
        char PrettyGuess; //keeps guess in original case
        String PrettyWord; //keeps word in orginal case
        int lives = 6; //lives counter
        //char [] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        int [] alphCount = new int [26]; //keeps track of how many times each letter is guessed so we can make sure they don't lose lives for guessing the same letter
        Arrays.fill(alphCount, 0); //fills it with 0's
        String alph = "abcdefghijklmnopqrstuvwxyz"; //allows us to know which index alph count corresponds to
        // gets input
        System.out.println("Please enter a word to be guessed for hangman: ");
        String word = input.nextLine();
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"); //moves word up so user can't see it
        PrettyWord = word; //stores the original case of the word
        word = word.toLowerCase(); //put in lower case for easier processing
        int lettersRemaing = word.length(); //allows us to know when they win
        char [] guessed = new char [word.length()]; //where we store the correctlyh guessed letters
        Arrays.fill(guessed, '_'); //fills with place holders in this case '_'
        for(int a = 0; a<guessed.length;a++){
            System.out.print(guessed[a]+" "); //prints amount of letters of the word
        }
        System.out.println();
        //word.contains(Character.toString(guess))
        while(lives>0 && lettersRemaing >0){ //starts the guessing - as long as they haven't won or lost
            System.out.println("Please enter a letter to guess.");
            guess = input.next().charAt(0); //input
            PrettyGuess = guess; //stores original case
            guess = Character.toLowerCase(guess); //lowercase for easier processing
            alphCount[alph.indexOf(guess)] +=1; //stores guess
            //System.out.println("guess: "+guess+" alphCount: "+Arrays.toString(alphCount)+"alph.indexOf " + alph.indexOf(guess));
            if(ArrayIndexOf(guessed, guess)==-1 && alphCount[alph.indexOf(guess)]<=1){ //check for earlier words being guessed
                if(word.contains(Character.toString(guess))){  //if the word has the guess
                    int counter = 0; 
                    for(int a = 0; a<word.length(); a++){ //cycle through the letters of the word
                        if(word.charAt(a)==guess){
                            guessed[a]=guess;  //all the times the user guessed the character are placed into the guessed array
                            lettersRemaing--; //this many letters closer to winning
                            counter++; //tells us how many times the letter was in the word
                        }
                    }
                    System.out.println("Good job, "+PrettyGuess+" was in the word "+counter+" times.");
                }
                else{ //otherwise, we take a way a life and tell them
                    lives--;
                    System.out.println("Unfortunately, "+PrettyGuess+" was not in the word.\n"+"You have "+lives+" left.");
                    System.out.println("Hangman: \n");
                    graphic(lives); //prints hangman with the amount of lives we have
                    System.out.println();
                    
                }
                for(int a = 0; a<guessed.length;a++){
                    System.out.print(guessed[a]+" "); //prints what u have guessed correctly of word so far
                }
                System.out.println();
            }
        else{
             System.out.println("You have already guessed this letter. Please enter a new one."); //if letter was already guessed this is run
             //NOTE: NO LIVES ARE TAKEN AWAY - JUST ALLOWS YOU TO RE-GUESS
        }
         }
        if(lives>0){
            System.out.println("Congratulations, you won!"); //if the while loop terminates and we get to this line and lives is greater than 0, they won.
        }
        else{
            System.out.println("You lost. The word was " + PrettyWord); //otherwise they lost.
        }
        
    }
}
