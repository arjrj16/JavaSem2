public class PlayingWithNumbers {
    // public static final doule tax = 8.0/100; //static constant (final)
    // public static final doule tip = 15.0/100; //static constant (final)
    public static void main (String args []){
        // int num1 = 1342791424;
        // int num2 = 3;
        // for(int i=0; i<7; i++)
        // {
        //     System.out.println("The number is = "+ num1);
        //     System.out.println("The last number is "+ (num1%100));
        //     num1 = num1/10;
        // }
        // System.out.println(2+1+ " I am happy "+(2+3));
        // double bill1 = 23.89;
        // double bill2 = 34.45;
        // double bill3= 41.29;
        // double sum = bill1+bill2+bill3;
        // System.out.println(" The total is "+sum);
        // taxes(sum);
        // System.out.println(" The Tips: " + sum*tip);

        for(int line = 0; line<=5; line++){
            for(int i = 0; i<line; i++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void taxes (double sum){
        double taxes = sum*tax;
        System.out.print(" The taxes:     "+taxes);
    }
}
