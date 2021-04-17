import java.util.*;
import java.io.*;
public class printStreamInClassLesson {
    public static void main (String args[]) throws FileNotFoundException{
    //File myFile2 = new File("testing2.txt");
    PrintStream output = new PrintStream(new File ("testingFile.txt")); // could also us myfile2 here
    output.println("This is a test"); //all print functions work - just remove System (ie output.printf())
    output.println("This is my second Line");
    }
}
