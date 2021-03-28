/*
2. Write a method called range that returns the range of values in an array of integers. The range is defined as 1 more
than the difference between the maximum and minimum values in the array. For example, if an array called list
contains the values {36, 12, 25, 19, 46, 31, 22}, the call of range(list) should return 35 (46  12  1). You may
assume that the array has at least one element.


4. Write a method called isSorted that accepts an array of real numbers as a parameter and returns true if the list is in
sorted (nondecreasing) order and false otherwise. For example, if arrays named list1 and list2 store {16.1, 12.3,
22.2, 14.4} and {1.5, 4.3, 7.0, 19.5, 25.1, 46.2} respectively, the calls isSorted(list1) and isSorted(list2)
should return false and true respectively. Assume the array has at least one element. A one-element array is considered to be sorted.
*/
import java.util.*;
public class Pg496Ex2and4 {
    public static int range (int [] a){
        //sorts a
        Arrays.sort(a);
        //subtracts last element of sorted array by first element (max-min) and then adds 1
        return ((a[a.length-1]-a[0])+1);
    }
    public static boolean isSorted(double[] a){
        //copys array to sort
        double [] sorted = Arrays.copyOf(a, a.length);
        //sorts array
        Arrays.sort(sorted);
        //if sorted array and original array are the same, then return true
        if(Arrays.equals(sorted,a)){
            return true;
        }
        //otherwise return false
        else{
            return false;
        }
    }
    //some test arrays for the functions
    public static int [] test = {36, 12, 25, 19, 46, 31, 22};
    public static double [] test1 = {16.1, 12.3, 22.2, 14.4};
    public static double [] test2 = {1.5, 4.3, 7.0, 19.5, 25.1, 46.2};
    public static double [] test3 = {1};
    public static void main (String args[]){
        //test functions:
        System.out.println(range(test));
        System.out.println(isSorted(test1)+" "+isSorted(test2)+" "+isSorted(test3));
    }
}
