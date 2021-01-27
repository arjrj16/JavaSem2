/* this is our first program
we will learn how to print using print and print ln
we will use strings
*/
public class Hello{
    public static void main (String [] args){
        System.out.print("Hello there! \t");
        System.out.print(" \"\\Peter\""); // "\" implies special characters
        System.out.println("kaljdfla"); // println prints on a seperate line
        int chairs = 5;
        int price = 10;
        //concatenation:
        System.out.println("I have " + chairs + " at " + price + "$");
        System.out.println("I have " + (chairs + price) +"$");
    }
}