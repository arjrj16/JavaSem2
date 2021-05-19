import java.io.*;
import java.util.*;
import java.lang.*;
public class test {
    public static void main (String args []) throws FileNotFoundException{
        Random rn = new Random ();
        for(int i = 0; i<1000; i++){
            System.out.println(rn.nextInt(50 - 30 + 1) + 30);
        }
    }
}