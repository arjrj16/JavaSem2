/*
Pseduo Code done in class on white board.
This is pure implementation.
do 3 miniprojects for hw
*/
import java.util.Scanner;
public class pseudoCodePractice {
    public static int size = 33;

    public static void dashLines(){
        System.out.print("#");
        for(int i = 1; i<=4*size; i++){
            System.out.print("=");
        }
        System.out.println("#");
    }
    public static void top(){
        for(int line = 1; line <= size; line++){
            System.out.print("|");
            spacesTop(line);
            System.out.print("<>");
            for(int dots = 1; dots<=4*line-4; dots++){
                System.out.print(".");
            }
            System.out.print("<>");
            spacesTop(line);
            System.out.println("|");
        }
    }
    public static void low(){

    }
    public static void spacesTop(int line){
        for(int space = 1; space <=-2*line+size*2; space++){
            System.out.print(" ");
        }
    }
    public static void main(String args []){
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter a size number:");
        size = input.nextInt();
        if(size>33){
            System.out.println("Number too large and cannot be displayed.");
        }
        else{
        dashLines();
        top();
        low();
        }
    }
}
