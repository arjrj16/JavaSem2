/*
           +------------------------------+
          /                           ___/ 1:10:27
         /                        ___/__// 2:9:24
        /                     ___/__/__/// 3:8:21
       /                  ___/__/__/__////
      /               ___/__/__/__/__/////
     /            ___/__/__/__/__/__//////
    /         ___/__/__/__/__/__/__///////
   /      ___/__/__/__/__/__/__/__////////
  /   ___/__/__/__/__/__/__/__/__/////////
 /___/__/__/__/__/__/__/__/__/__//////////
+------------------------------+//////////
|    Building Java Programs    |//////////
|    Building Java Programs    |////////
|    Building Java Programs    |//////
|    Building Java Programs    |////
|    Building Java Programs    |//
+------------------------------+ 


*/
import java.util.Scanner;
public class pg127ex7 {

    public static int size = 8;
    public static void topEdge(){
        for(int a =1; a<=size+1; a++){System.out.print(" ");} 
        //prints spaces
        System.out.print("+");
        for(int dashes =1; dashes <=size*3; dashes++){System.out.print("-");}
        System.out.println("+");
    }
    public static void cover(){
        for(int line = 1; line <= size; line++){
            for(int spaceLeft = 1; spaceLeft<=-1*line+1+size;spaceLeft++){System.out.print(" ");}
            System.out.print("/");
            for(int spaceRight =1; spaceRight<=-3*line+size*3; spaceRight++){System.out.print(" ");}
            System.out.print("___/");
            for(int slash = 1; slash<=1*line-1; slash++){System.out.print("__/");}
            for(int cover =1; cover<=line-1; cover++){System.out.print("/");}
            System.out.println();
        }
    }
    public static void edge(){
        System.out.print("+");
        for(int dash =1; dash <= size*3; dash++){System.out.print("-");}
        System.out.print("+");
        for(int slash = 1; slash <=size; slash++){System.out.print("/");}
        System.out.println();
    }
    public static void bottomSide(){
        double EvenHalfDotSize = size/2+0.5;
        int evenHalfSize = (int) EvenHalfDotSize;
        int odd;
        // if(size%2 == 1){space=2}
        for(int line =1; line<=evenHalfSize; line++){
            System.out.print("|");
            if(size%2 == 1){
                odd=1;
            }
            else{
                odd=0;
            }
            for(int space =1; space<=((size*3-22)/2)+odd; space++){
                System.out.print(" ");
            }
            System.out.print("Building Java Programs");
            for(int space2=1; space2<=(size*3-22)/2; space2++){System.out.print(" ");}
            System.out.print("|");
            for(int slash =1; slash<=-2*line+size+2; slash++){System.out.print("/");}
            System.out.println();
        }
    }
    public static void edgeBot(){
        System.out.print("+");
        for(int dash =1; dash <= size*3; dash++){System.out.print("-");}
        System.out.print("+");
        System.out.println();
    }
    public static void main (String args[]){
        Scanner input = new Scanner (System.in);
        System.out.println("Please enter a sizeable number greater than 7:");
        size = input.nextInt();
        if(size>7){
        topEdge();
        cover();
        edge();
        bottomSide();
        edgeBot();
        }
        else{
            System.out.println();
            System.out.println("Size number must be greater than 7 or \"Building Java Programs\" cannot be printed correctly.");
            System.out.println();
        }
    }

}
