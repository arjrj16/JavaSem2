public class pg127ex3 {
    public static int size = 8;
    public static void symLine(){
        System.out.print("+");
        for(int a = 1; a<=size+1; a++){
            System.out.print("-");
        }
        System.out.println("+");
    }
    public static void symTopUp(){
        for(int line = 1; line<=size/2; line++){
            System.out.print("|");
            for(int a=1; a<=-1*line+5; a++){
                System.out.print(" ");
            }
            for(int a = 1; a<=line-1; a++){
                System.out.print("/");
            }
            System.out.print("*");
            for(int a = 1; a<=line-1; a++){
                System.out.print("\\");
            }
            for(int a=1; a<=-1*line+5; a++){
                System.out.print(" ");
            }
            System.out.println("|");
        }
    }
    public static void symTopBottom(){
        for(int line = 1; line<=size/2; line++){
            System.out.print("|");
            for(int a=1; a<=line; a++){
                System.out.print(" ");
            }
            for(int a = 1; a<=-1*line+4; a++){
                System.out.print("\\");
            }
            System.out.print("*");
            for(int a = 1; a<=-1*line+4; a++){
                System.out.print("/");
            }
            for(int a=1; a<=line; a++){
                System.out.print(" ");
            }
            System.out.println("|");
        }
    }
    public static void main(String args []){
        symLine();
        symTopUp();
        symTopBottom();
        symLine();
        symTopBottom();
        symTopUp();
        symLine();
    }
}
