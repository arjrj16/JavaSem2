public class pg127ex5 {
    public static final int size = 4;
    public static void coneThruster() {
        for (int line = 1; line <= 2*size-1; line++) {
            for (int spaces = 1; spaces <= -line + size*2; spaces++) {
                System.out.print(" ");
            }
            for (int slashes = 1; slashes <= line; slashes++) {
                System.out.print("/");
            }
            System.out.print("**");
            for (int slashes = 1; slashes <= line; slashes++) {
                System.out.print("\\");
            }
            System.out.println();
        }
    }
    public static void symLine() {
        System.out.print("+");
        for (int sym = 1; sym <= size*2; sym++) {System.out.print("=*");}
        System.out.println("+");
    }
    public static void upArrow() {
        for (int line = 1; line <= size; line++) {
            System.out.print("|");
            upDot(line);
            for(int dots = 1; dots<=-1*line+size; dots++){
                System.out.print(".");
            }
            upDot(line);
            for(int dots = 1; dots<=-1*line+size; dots++){
                System.out.print(".");
            }
            System.out.println("|");
        }
    }
 
    public static void upDot(int line) {
        for (int periods = 1; periods <= -1*line+size; periods++) {
            System.out.print(".");
        }
        for (int arrows = 1; arrows <= line; arrows++) {
            System.out.print("/\\");
        }
    }
 
    public static void downArrow() {
        for (int line = 1; line <= size; line++) {
            System.out.print("|");
            downDot(line);
            downDot(line);
            System.out.println("|");
        }
    }
 
    public static void downDot(int line) {
        for (int dots = 1; dots <= line-1; dots++) {
            System.out.print(".");
        }
        for (int arrows = 1; arrows <= -1*line+size+1; arrows++) {
            System.out.print("\\/");
        }
        for (int dots = 1; dots <= line-1; dots++) {
            System.out.print(".");
        }
    }
    public static void main(String[] args) {
        coneThruster();
        for(int reps = 1; reps<=size-1; reps++){
            symLine();
            upArrow();
            downArrow();
        }
        symLine();
        coneThruster();
    }
}
