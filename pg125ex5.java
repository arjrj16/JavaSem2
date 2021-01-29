public class pg125ex5 {

    public static void NestedFor(){
        for(int i = 1; i<=5; i++){
            for(int a=1; a<=i; a++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void main(String args[]){
        NestedFor();
    }
}
