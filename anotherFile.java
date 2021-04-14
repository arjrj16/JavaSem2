import java.io.*;
import java.util.*;

public class anotherFile {
    public static void main (String args []) throws FileNotFoundException{
    File myFile = new File ("C:\\Users\\melwania24\\OneDrive - Greenhill School\\9th\\Java\\JavaSem2\\textFile.txt");
    Scanner input = new Scanner (myFile);

    while(input.hasNextLine()){
        Scanner line = new Scanner (input.nextLine());
        while (line.hasNext()){
            if(line.hasNextDouble()){
                String trash = line.next();
            }
            else{
                String trash = line.next();
            }
        }
        System.out.println();
    }
    }
}
