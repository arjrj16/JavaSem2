import java.io.*;
import java.util.*;

public class CalculatingEmployeesHoursV2 {
    public static void main (String args []) throws FileNotFoundException{
        File myFile = new File ("C:\\Users\\melwania24\\OneDrive - Greenhill School\\9th\\Java\\JavaSem2\\hours.txt");
        Scanner input = new Scanner(myFile);
        Scanner line; 
        int employeeNum = 0;
        String name = "";
        double hours = 0;
        int dayCount = 0;
        double avgHrs = 0;
        double temp = 0;
        while(input.hasNextLine()){ //while there is a line
            line =  new Scanner (input.nextLine()); //consume line
            while(line.hasNext()){ //while line has another token
            if(line.hasNextInt()){
                employeeNum = line.nextInt(); //consume first token
            }
            else{
                String trash = line.next();
            }
            if(line.hasNext()){
                name = line.next(); //consume second token
            }
            else{
                String trash = line.next();
            }
            while(line.hasNextDouble()){ //while there are tokens left
                    temp = line.nextDouble(); //consume
                    hours += temp;
                    dayCount++;
            }
            if(dayCount>0){ //if no other numbers enetered
                avgHrs = hours/dayCount;
            }
            else{
                avgHrs = -1;
            }
            System.out.print(name+" (#"+employeeNum+") worked ");
            System.out.printf("%.1f hours (%.2f hours/day) \n", hours,avgHrs);
            }
            hours = 0; //reset values
            dayCount = 0;
        }
    }
}