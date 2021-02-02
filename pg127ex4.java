public class pg127ex4 {
    public static int numStairs = 5;
    public static void spaceLeft(int stairs){
        for(int space = 1; space<=(5*numStairs-5)-(5*stairs-5); space++){
            System.out.print(" ");
        }
    }
    public static void topLine(int stairs){
        System.out.print("******");
        for(int a = 1; a<=5*stairs-5; a++){
            System.out.print(" ");
        }
        System.out.println("*");
    }
    public static void endSpace(int stairs){
        System.out.print("*");
        for(int a = 0; a< 5*stairs; a++){
            System.out.print(" ");
        }
        System.out.println("*");
    }
    public static void visualStair(int stairs){
        spaceLeft(stairs);
        System.out.print("  "+"o"+"  ");
        topLine(stairs);
        spaceLeft(stairs);
        System.out.print(" "+"/"+"|"+"\\"+" ");
        endSpace(stairs);
        spaceLeft(stairs);
        System.out.print(" "+"/"+" "+"\\"+" ");
        endSpace(stairs);
    }
    public static void main(String args[]){
        for(int stairs = 1; stairs<=numStairs; stairs++){
            visualStair(stairs);
            
        }
        System.out.print("******");
        for(int a = 1; a<=5*numStairs; a++){
            System.out.print("*");
        }
        System.out.print("*");
        
    }
}
