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
public class pg127ex7 {
    public static final int size = 10;
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
    }
    public static void main (String args[]){
        topEdge();
        cover();
    }

}
