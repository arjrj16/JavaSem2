import java.io.*;
import java.util.*;

import jdk.nashorn.api.tree.WhileLoopTree;
public class UsingFiles {
    public static void main (String args[]) throws FileNotFoundException{
        File myFile = new File ("C:\\Users\\melwania24\\OneDrive - Greenhill School\\9th\\Java\\JavaSem2\\example.txt");
        Scanner input = new Scanner(myFile);
        while(input.hasNextLine()){
            Scanner line = new Scanner(input.nextLine());
            while(line.hasNext()){
                System.out.println(line.next());
            }
            System.out.println("end of line");
        }
    }
    
}
