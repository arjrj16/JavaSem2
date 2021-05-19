package FinalProject.FinalProject.src;

import java.util.*;
import java.io.*;
public class test6 {
    public static void main (String args[]) throws FileNotFoundException{
        Scanner input = new Scanner(System.in);
        LMSstudent a = new LMSstudent(8642, 32528340, "Bruno", "Guito");
        LMSadmin admin = new LMSadmin();
        //System.out.println(a.booksOut(input));
        //a.checkIn(input);
        System.out.println(admin.toString(8642,input));
    }
}
