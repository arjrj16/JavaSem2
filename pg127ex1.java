public class pg127ex1{
    static int size = 14;
    static int line = 1;
    public static void apros1(){
        for(int a = 1; a <= -1*line+size; a++){
            System.out.print("*");
        }
    }
    public static void space1(){
        for(int b = 1; b <= line-1; b++){
            System.out.print(" ");
            
        }
    }
    public static void slash(){
        for(int c = 1; c <= -2*line+size*2; c++){
            System.out.print("/");
            
        }
    }
    public static void backSlash(){
        for(int d = 1; d <= 2*line-2; d++){
            System.out.print("\\");
            
        }
    }
    public static void space2(){
        for(int e = 1; e <= line-1; e++){
            System.out.print(" ");
        }
    }
    public static void apros2(){
        for(int f = 1; f <= -1*line+size; f++){
            System.out.print("*");
        }
    }
    public static void main (String args []){
        for(line = 1; line <= size; line++){
            apros1();
            space1();
            slash();
            backSlash();
            space2();
            apros2();
            System.out.println();
        }
    }
}