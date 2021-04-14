import java.io.*;
import java.util.*;

public class UsingFilesDay2 {
    public static void main (String args[]) throws FileNotFoundException{
        File myFile = new File ("C:\\Users\\melwania24\\OneDrive - Greenhill School\\9th\\Java\\JavaSem2\\weather.txt");
        Scanner input = new Scanner(myFile);
        while(input.hasNextLine()){ //checks if there is a line in the file
            Scanner line = new Scanner(input.nextLine());
            while(line.hasNext()){ //while there is a token in the line - check not consume
                if(line.hasNextDouble()){ //if that is a double then (see next line)
                    System.out.println(line.next()); //then i consume it
                }
                else{
                    String trash = line.next(); //otherwise we throw it away - don't need it
                }
            }

        }
    }
    
}
