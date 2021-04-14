import java.io.*;
import java.util.*;

public class WeatherFilesProgram {
    public static void main (String args[]) throws FileNotFoundException{
        File myFile = new File ("C:\\Users\\melwania24\\OneDrive - Greenhill School\\9th\\Java\\JavaSem2\\weather.txt");
        Scanner input = new Scanner(myFile);
        double t1 = 0;
        if(input.hasNextDouble()){ //needs initial value to be set
            t1 = input.nextDouble(); //consume
        }
        double t2 = 0;
        double change = 0; 
            while(input.hasNext()){ //while there is a token in the line - check not consume
                if(input.hasNextDouble()){ //if that is a double then (see next line)
                    t2 = input.nextDouble(); //consume
                    change = t2-t1;
                    System.out.printf("%.1f to  %.1f , change =  %.1f \n", t1, t2,change);
                    t1=t2;
                    
                }
                else{
                    String trash = input.next(); //otherwise we throw it away - don't need it
                }
    }
    }
}
