/*
pg. 299  Exercise 14 and 16
14:
Write a method called swapPairs that accepts a String as a parameter and returns that String with each pair of
adjacent letters reversed. If the String has an odd number of letters, the last letter is unchanged. For example, the
call swapPairs("example") should return "xemalpe" and the call swapPairs("hello there") should return
"ehll ohtree".
16:
Write a method called quadrant that accepts as parameters a pair of double values representing an (x, y) point and
returns the quadrant number for that point. Recall that quadrants are numbered as integers from 1 to 4 with the
upper-right quadrant numbered 1 and the subsequent quadrants numbered in a counterclockwise fashion:

pg. 370 Exercise 10 and 12
10:
. Write a method called hopscotch that accepts an integer number of “hops” as its parameter and prints a pattern of
numbers that resembles a hopscotch board. A “hop” is a three-number sequence where the output shows two numbers on a line, followed by one number on its own line. 0 hops is a board up to 1; one hop is a board up to 4; two
hops is a board up to 7; and so on. For example, the call of hopscotch(3); should print the following output:
1
2 3
4
5 6
7
8 9
10
12:
Write a method called printAverage that uses a sentinel loop to repeatedly prompt the user for numbers. Once the
user types any number less than zero, the method should display the average of all nonnegative numbers typed.
Display the average as a double. Here is a sample dialogue with the user:
Type a number: 7
Type a number: 4
Type a number: 16
Type a number: –4
Average was 9.0
If the first number that the user types is negative, do not print an average:
Type a number: –2
*/
import java.util.*;
public class ConditionalBranchingAndLooping {
    public static void hopScotch(int HOPS){
        int current = 1;
        int lines = 3 * HOPS+ 1;
        while(current < lines){
            if((current - 1) % 3 == 0){
                System.out.println("   " + current);
                current++;
            }
            else{
                System.out.println(current + "     " + (current + 1));
                current += 2;
            }
        }
    }
    public static void printAverage(){
        Scanner in = new Scanner (System.in);
        int uNum=0;
        int loop =0;
        int sum =0;
        while(uNum>-1){
            System.out.println("Type a number:");
            uNum = in.nextInt();
            if(uNum>-1){
            sum = sum + uNum;
            loop++;
            }
        }
        System.out.println("The average is "+((double)sum/loop));

    }
    public static int quadrant(double x, double y){
        if(x>0&&y>0){
            return 1;
        }
        else if(x<0&&y>0){
            return 2;
        }
        else if(x<0&&y<0){
            return 3;
        }
        else if(x>0&&y<0){
            return 4;
        }
        else{
            return 0;
        }
    }
    public static String swapPairs(String param){ //"example"
        String s = "";
        String c1 ="";
        String c2 = "";
        if(param.length()%2==0){
            for(int a = 0; a<param.length()-1;a=a+2){
                c1 = ""+param.charAt(a+1);
                c2 = ""+param.charAt(a);
                s = s+c1+c2;
            }
            System.out.println(s);
            return s;
        }
        else{
            for(int a = 0; a<param.length()-1;a=a+2){
                c1 = ""+param.charAt(a+1);
                c2 = ""+param.charAt(a);
                s = s+c1+c2;
            }
            s = s+param.charAt(param.length()-1);
            System.out.println(s);
            return s;
        }
    }
    public static void main(String args[]){
        //swapPairs("hello there");
        //System.out.println(quadrant(0,0));
        hopScotch(3);
        printAverage();
    }
    
}
