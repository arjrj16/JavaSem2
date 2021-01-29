public class pg126ex15 {
    public static void main(String[] args) {

        printDesign();
 
    }
    public static void dashes(int i){
        for(int a=0; a<(11-i)/2; a++){
            System.out.print("-");
        }
    }
    public static void printDesign(){
        for(int i = 1; i <= 9; i+=2) {
            dashes(i);
            for(int a=0; a<i; a++){
                System.out.print(i);
            }
            dashes(i);
            System.out.println();
        }
    }
}
