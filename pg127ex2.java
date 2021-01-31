public class pg127ex2{
    static int size = 6;
    public static void symLine(){
        System.out.print("+");
        for(int a = 1; a<=size; a++){
            System.out.print("-");
        }
        System.out.println("+");
    }
    public static void topSym(){
        for(int line = 1; line<=size/2; line++){
            System.out.print("|");
            topSpace(line);
            System.out.print("^");
            for(int b = 1; b<=2*line-2; b++){
                System.out.print(" ");
            }
            System.out.print("^");
            topSpace(line);
            System.out.println("|");
        }
    }
    public static void topSpace(int line){
        for(int a = 1; a<=-1*line+size/2; a++){
            System.out.print(" ");
        }
    }
    public static void bottomSym(){
        for(int line = 1; line<=size/2; line++){
            System.out.print("|");
            bottomSpace(line);
            System.out.print("v");
            for(int a = 1; a<=-2*line+size; a++){
                System.out.print(" ");
            }
            System.out.print("v");
            bottomSpace(line);
            System.out.println("|");
        }
    }
    public static void bottomSpace(int line){
        for(int a = 1; a<=line-1; a++){
            System.out.print(" ");
        }
    }
    public static void main (String args[]){
        if(size % 6 == 0){
        symLine();
        topSym();
        topSym();
        symLine();
        bottomSym();
        bottomSym();
        symLine();
        }
        else{
            System.out.println("Error: Size must be multiple of 6 for proportions to be correct.");
        }

    }
}