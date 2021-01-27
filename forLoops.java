public class forLoops {
    static int number = 1234;
    static int modem = number%100;
    public static void main(String args[])    
    {
        // for (int line = 1; line <=5; line++){
        //     frontDots(line);
        //     System.out.print(line);
        //     backDots(line);
        //     System.out.println();
        // }
        // for (int count = 1; count <=5; count++){
            
        //     System.out.println(-4*count+21);
        // }
        for (int i = 1; i <= 2; i++) {
            for (int j = 1; j <= 3; j++) {
                for (int k = 1; k <= 4; k++) {
                System.out.print("*");
                }
            }
            System.out.print("!");
            System.out.println();
            }
    }
    public static void frontDots(int line){
        for(int dots = 1; dots<= -line+5; dots++){
            System.out.print(".");
        }
    }
    public static void backDots(int line){
        for(int dots = 1; dots<= line-1; dots++){System.out.print(".");}
    }

}
