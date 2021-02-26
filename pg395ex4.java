import java.util.Random;
public class pg395ex4 {
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
    public static void main (String args []){
        
        //randomX();
       // makeGuesses();
        randomWalk();
    }
}
