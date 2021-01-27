public class pg55Ex11 {
    public static void astricLine(){
        System.out.println("*****");
        System.out.println("*****");
    }
    public static void doubleAstric(){
        System.out.println(" * *");
    }
    public static void singleAstric(){
        System.out.println("  *");
    }
    public static void xAstric(){
        doubleAstric();
        singleAstric();
        doubleAstric();
    }
    public static void main (String args []){
        astricLine();
        xAstric();
        for(int i = 0; i<2; i++){
            System.out.println();
        }
        astricLine();
        xAstric();
        astricLine();
        for(int i = 0; i<2; i++){
            System.out.println();
        }
        for(int i = 0; i<3; i++){
            singleAstric();
        }
        astricLine();
        xAstric();
    }
}
