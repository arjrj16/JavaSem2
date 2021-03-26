import java.util.*;
public class arrays {
    public static void main (String [] args){
        Scanner input = new Scanner (System.in);
        System.out.println("How many numbers are you giving me? ");
        int size = input.nextInt();
        int [] numbers = new int [size];
        int sum = 0;
        for(int i=0; i<12; i++){
            //How do we go about asking the user for each value
            System.out.println("What is the number are you giving me? ");
            numbers [i] = input.nextInt();
            System.out.println(numbers[i]);
            sum = sum + numbers[i];
        }
        d
        for(int j =0; j<size; j++){
            System.out.print(numbers[j]+",");
        }
    }
}
