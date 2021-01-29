
public class pg125ex3 {
    static int num1 = 1;
    static int num2 = 1;
    static int num3;

    public static void fibSeq(){
        num3 = num1+num2;
        System.out.print(num3+" ");
        num1=num2;
        num2=num3;     
    }
    public static void main (String args[]){
        System.out.print(num1+" "+num2+" ");
        for(int i = 0; i<=9; i++){
            fibSeq();
        }

    }
}
