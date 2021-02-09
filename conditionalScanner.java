/*
2-8-20
how to use Scanner class for user input
if/else
*/
import java.util.Scanner;
public class conditionalScanner {
    public static int age;
    public static void Vaccinate(){
        System.out.println("Please return in 1 month for vaccine. ");
    }
    public static void Vaccinate1a(){
        System.out.println("Vaccination issued immediately.");
    }
    public static void main (String args []){
        Scanner input = new Scanner (System.in);
        age = input.nextInt();
        if(age>= 50 && age< 80){
            Vaccinate();
        }
        else if(age>=80){
            Vaccinate1a();
        }
        else{
            System.out.println("Must wait till march to receive vaccine.");
        }
    }
}
