/*
Write a method called toBinary that accepts an integer as a parameter and returns a String containing that
integer’s binary representation. For example, the call of printBinary(44) should return "101100".
*/
import java.util.Scanner;
public class pg368ex3 {
    public static void toBinary(int n){
        String len = new String("");
        int l = n;
        while(l>0){
            len = len + l%2;
            l = l/2;
        }
        int binary[] = new int[len.length()+1];
        System.out.println("Length of binary is "+(len.length()+1)+" characters");
        int index =0;
        while(n>0){
            binary[index] = n%2;
            index++;
            n = n/2;
        }
        for(int i = index-1;i >= 0;i--){
            System.out.print(binary[i]);
          }
    }
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        System.out.print("please enter a number to be converted to binary: ");
        int uIn = in.nextInt();
        toBinary(uIn);
    }
}
