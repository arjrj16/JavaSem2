/*
1a.

1 11 21 31 41 51 61 71 81 91
b.
zero times - nothing
c.
zero times - nothing
d.
3
e.
4
f. 10 times
10 5 2 1 0 0 0
*/
import java.util.Random;
public class conditionalLoop {
    public static void main (String args []){
        boolean test = lessUseless(8,"Grade");
        uselessMethod(2,"Peter",test); //is static void method (It has object reference)
                                        //void methods (it does not return valuesd)
        System.out.println("jailjdsaklds");

    }
        
    public static boolean lessUseless(int num, String name){
        if(num>7&&name.equalsIgnoreCase("grade")){
            return true;
        }
        return false;
    }
    private static void uselessMethod(int num, String name, boolean test){
        while(test){
            System.out.println("I am useless");
            num++;
            if(num>5){
                test=false;
            }
        }
        //do while method: run program once before it checks condition
        do{
            System.out.println("I am who I am");
            num--;
        }
        while(num>9);
        double randomNum = (int)(Math.random()*1000);
        Random randy = new Random();
        int num1 = randy.nextInt(50);
        System.out.println(num1);
        
        
    }
}
