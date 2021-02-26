/*
programs 2 - 12 even
2.
Write a method called gcd that accepts two integers as parameters and returns the greatest common divisor (GCD)
of the two numbers. The GCD of two integers a and b is the largest integer that is a factor of both a and b.
One efficient way to compute the GCD of two numbers is to use Euclid’s algorithm, which states the following:
GCD (a, b)  GCD (b, a % b)
GCD (a, 0)  Absolute value of a

*/
import java.util.*;
public class chapter4Hw1{
    public static int x =1;
    public static int y =1;
    // static int gcd=1;
    // public static int GCD(int a, int b){ //prgm 2
    //     // if(a == 0){
    //     //     gcd =b;
    //     // }
    //     // if(b==0){
    //     //     gcd =a;
    //     // }
    //     while(b!=0){
    //         a =b;
    //         b = a%b;
    //     }
    //     System.out.println(a);
    //     return b;
    // }
    // public static void main(String args[]){
    //     GCD(54,24);
    // }
    public static void main(String args[]){ //Enter two number whose GCD needs to be calculated. 
    Scanner scanner = new Scanner(System.in); 
    System.out.println("Please enter first number to find GCD"); 
    int number1 = scanner.nextInt(); 
    System.out.println("Please enter second number to find GCD"); 
    int number2 = scanner.nextInt(); 
    System.out.println("GCD of two numbers " + number1 +" and " + number2 +" is :" + findGCD(number1,number2)); 
} /* * Java method to find GCD of two number using Euclid's method * @return GDC of two numbers in Java */ 
    private static int findGCD(int number1, int number2) { //base case 
        while(number2!=0){
            
            number2 = number1%number2;
            numb
        }
        //if(number2 == 0){
            return number1; 
        //} 
        
        //return findGCD(number2, number1%number2);
     }
}