import java.util.*;
public class pg395ex4 {
    public static void gcd(int num1, int num2){
        int gcd = 1;
        for(int i = 1; i <= num1 && i <= num2; i++) {
            if(num1%i==0 && num2%i==0) {
                gcd = i;
            }
        }
        System.out.println("The GCD of " + num1 + " and " + num2 + " is " + gcd);
    }
    
    public static void randomX(){
        Random randy = new Random();
        int x = randy.nextInt(15)+5;
        int loop = 1;
        while(x<16){
            loop=1;
            while(loop<=x){
                System.out.print("x");
                loop++;
            }
            System.out.println();
            x=randy.nextInt(15)+5;
        }
    }
    public static void makeGuesses(){
        Random randy = new Random();
        int guess=1;
        int loops = 0;
        while(guess<49){
            guess = randy.nextInt(50)+1;
            System.out.println("Guess = "+guess);
            loops++;
        }
        System.out.println("total guesses = "+loops);
    }
    public static void randomWalk(){
        Random randy = new Random();
        int pos=0;
        int move=0;
        int loops=0;
        int max =0;
        while(pos<3&&pos>-3){
            move = randy.nextInt(2);
            System.out.println(move);
            if(move == 0){
                move = -1;
            }
            if(pos+move>pos){
                max = pos+move;
            }
            pos=pos+move;
            System.out.println("Position = " + pos);
            loops++;
        }
        System.out.println("It took "+loops+" moves and the max position was "+ max);
    }
    public static void hopScotch(int HOPS){
        int current = 1;
        int total = 3 * HOPS+ 1;
        while(current < total){
            if((current - 1) % 3 == 0){
                System.out.println("   " + current);
                current++;
            }
            else{
                System.out.println(current + "     " + (current + 1));
                current += 2;
            }
            System.out.println("   " + current);
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
    public static void main (String args []){
        
        //randomX();
       // makeGuesses();
       // randomWalk();
      // gcd(24,6);
       //hopScotch(3);
       printAverage();
    }
}
