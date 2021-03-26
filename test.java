import java.awt.*;
import java.util.*;
public class test {
    // public static int methodA (int column, int row){
    //     int start = 0;
    //     int a = 1;
    //     while(start < row-column)
    //     {
    //         a *= (column+start)/(1+start);
    //         start++;
    //     }
    //     return a;
    // }
    // public static void main (String args[]){
    //     System.out.println("here it is ___"+methodA(3,3)+"_");
    // }
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("What would you like the size of Pascal's Triangle to be? (after 13 printf causes it to break)");
        int SIZE = sc.nextInt();
        Pascal(SIZE);
    }
 
    public static int GetNumber(int x) {
        int y;
        for(y = 1; x > 1; x--){
            y *= x;
        }
        return y;
    }
 
    public static void Pascal(int SIZE) {
        SIZE -= 1;
        int column, number, line, space;
        System.out.println();
        for(line = 0; line <= SIZE; line++) {
            for(space = 0; space <= SIZE-line; space++){
                System.out.printf("%2s","");
            }
            for(column = 0; column <= line; column++){
                number = GetNumber(line) / (GetNumber(line-column) * GetNumber(column));
                System.out.printf("%4s", number);
            }
            System.out.println();
        }
    }
}