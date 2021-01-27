public class Rocket2{
    public static void main(String [] args){     //2 args  in  and out
             TOP(); // method
             Vshape();
             System.out.println();
             Vshape();
             TOP();
             System.out.println();
             TOP();
             box();
             System.out.println("+------+");
             System.out.println("|United|");
             System.out.println("|States|");
             System.out.println("+------+");
             box();
             TOP();
             }
        public static void TOP() {
            System.out.println("   /\\");
            System.out.println("  /  \\");
            System.out.println(" /    \\");
        }
        public static void Vshape(){
            System.out.println(" \\    /");
            System.out.println("  \\  /");
            System.out.println("   \\/");
        }
        public static void box(){
            System.out.println("|      |");
            System.out.println("|      |");
            System.out.println("+------+");
        }
}