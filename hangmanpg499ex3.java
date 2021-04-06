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
    public static void graphic (int lives){
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
        char guess;
        char PrettyGuess;
        String PrettyWord;
        int lives = 6;
        //char [] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        int [] alphCount = new int [26];
        Arrays.fill(alphCount, 0);
        String alph = "abcdefghijklmnopqrstuvwxyz";
        System.out.println("Please enter a word to be guessed for hangman: ");
        String word = input.nextLine();
        System.out.println("\n\n\n\n\n\n\n\n\n\n");
        PrettyWord = word;
        word = word.toLowerCase();
        int lettersRemaing = word.length();
        char [] guessed = new char [word.length()];
        Arrays.fill(guessed, '_');
        for(int a = 0; a<guessed.length;a++){
            System.out.print(guessed[a]+" ");
        }
        System.out.println();
        //word.contains(Character.toString(guess))
        while(lives>0 && lettersRemaing >0){
            System.out.println("Please enter a letter to guess.");
            guess = input.next().charAt(0);
            PrettyGuess = guess;
            guess = Character.toLowerCase(guess);
            alphCount[alph.indexOf(guess)] +=1;
            //System.out.println("guess: "+guess+" alphCount: "+Arrays.toString(alphCount)+"alph.indexOf " + alph.indexOf(guess));
            if(ArrayIndexOf(guessed, guess)==-1 && alphCount[alph.indexOf(guess)]<=1){ //check for earlier words being guessed
            if(word.contains(Character.toString(guess))){
                int counter = 0;
                for(int a = 0; a<word.length(); a++){
                    if(word.charAt(a)==guess){
                        guessed[a]=guess;
                        lettersRemaing--;
                        counter++;
                    }
                }
                System.out.println("Good job, "+PrettyGuess+" was in the word "+counter+" times.");
            }
            else{
                lives--;
                System.out.println("Unfortunately, "+PrettyGuess+" was not in the word.\n"+"You have "+lives+" left.");
                System.out.println("Hangman: \n");
                graphic(lives);
                System.out.println();
                
            }
            for(int a = 0; a<guessed.length;a++){
                System.out.print(guessed[a]+" ");
            }
            System.out.println();
        }
        else{
             System.out.println("You have already guessed this letter. Please enter a new one.");
        }
         }
        if(lives>0){
            System.out.println("Congratulations, you won!");
        }
        else{
            System.out.println("You lost. The word was " + PrettyWord);
        }
        
    }
}
