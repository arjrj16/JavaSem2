public class pg55Ex9 {

    public static void divider (){
        System.out.println("\"-\"-\'-\"-\'-\"-\"");
    }
    public static void upperHex(){
        System.out.println("  ________");
        System.out.println(" /        \\");
        System.out.println("/          \\");
    }
    public static void lowerHex(){
        System.out.println("\\          /");
        System.out.println(" \\        /");
        System.out.println("  ________");
    }
    public static void main (String args []){
        upperHex();
        lowerHex();
        divider();
        upperHex();
        lowerHex();
        divider();
        lowerHex();
        upperHex();
        divider();
        lowerHex();
    }
}