import java.util.*;
public class PascalsTriangleFinal {
    public static void main(String [] args) {
        Scanner input = new Scanner(System.in); //defines object
        System.out.println("What would you like the size of your Pascal's Triangle to be? Please choose between 1 and 13."); //UI - asks for size
        int SIZE = input.nextInt(); //gets input
        if (SIZE <= 13) { //checks size was entered in right parameters
            pascals(SIZE); //main program is in method
        }
        else{ //if number is not in parameters
            System.out.println("Please re-run and choose a number between 1 and 13."); 
        }

    }
    
    public static int mathAlg(int x) { //algorith worked out on board but trying to get x number less than 1 and using y number in equation
        int y;
        for(y = 1; x > 1; x--) {
           y *= x;
        }
        return y;
    }

    public static void pascals(int SIZE) {
        System.out.println();
        //defines vars
        int line;
        int space;
        int number;
        SIZE -= 1; //for it to work needs one less of size
        for (line = 0; line <= SIZE; line++) {//prints lines
            for (space = 0; space <= SIZE-line; space++) { //prints spaces
                System.out.printf("%2s", " ");
            }
            for (space = 0; space <= line; space++) { //prints numbers as well as spacing
                number = mathAlg(line) / (mathAlg(line-space) * mathAlg(space)); //algorithm figured out on board - but suarez really aided us with the one from the book
                System.out.printf("%4s", number); //prints it formated
            }
            System.out.println(); //next line
        }
    }
}
