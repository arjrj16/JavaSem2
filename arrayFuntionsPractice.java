import java.util.*;

public class arrayFuntionsPractice {
   public static void main (String args[]){
    Scanner sc = new Scanner(System.in);
    System.out.println("How many numbers would you like to input?");
    int ArraySize = sc.nextInt();
    System.out.println();
    int Sum = 0;
    double SumAverage = 0;
    int[] arrays = new int[ArraySize];
    for (int i = 0; i < ArraySize; i++) {
        System.out.print("What : ");
        arrays[i] = sc.nextInt();
        Sum += arrays[i];
    }
    for (int j = 0; j < ArraySize; j++) {
        System.out.print(arrays[j] + " ");
    }
    SumAverage = (double)Sum/ArraySize;
    System.out.printf("The average is %f%n", SumAverage);
    String arrays2 = Arrays.toString(arrays);
    System.out.println(arrays);
    int [] otherNumber = Arrays.copyOf(arrays, ArraySize+2);
    // Arrays.fill(otherNumber, 7); Fills array
    Arrays.sort(otherNumber);
    System.out.println(Arrays.toString(otherNumber));
    if(Arrays.equals(arrays, otherNumber)){
        System.out.println("They are the same");
    }
    else{
        System.out.println("They are not the same");
    }
    for (int k = 0; k < otherNumber.length; k++) {

    }
   } 
}
