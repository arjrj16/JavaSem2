import java.awt.*;
import java.util.*;
/*
binarySearch(array, value) - returns value of the given value in a sorted array (or <0 if not found)
copyOf(array,length) - returns copy of array
equals(array1, array2) - returns TRUE if the two arrays contain same elements in same order
fil(array, value) - sets every elemtn to the given value
sort (array) -  arranges the elements into sorted order
toString(array) - returns a string representing the array, such as "[10,30,-25,17]"
*/
public class test {
    public static void main(String [] args) {
        String a = "3";
        System.out.println(stringDoubleCheck(a));
    }
    public static boolean stringDoubleCheck(String a){
        try
        {
            Double.parseDouble(a);
        }
        catch(NumberFormatException e)
        {
            //not a double
            return false;
        }
        return true;
    }
 
    
}