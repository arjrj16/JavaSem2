import java.io.*;
import java.util.*;

public class CalculatingEmployeesHours {
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
    public static int employeeNum = 0;
    public static String name;
    public static int totalHours = 0;
    public static void main (String args []) throws FileNotFoundException{
    File myFile = new File ("C:\\Users\\melwania24\\OneDrive - Greenhill School\\9th\\Java\\JavaSem2\\hours.txt");
    Scanner input = new Scanner (myFile);
    
    while(input.hasNextLine()){
        Scanner line = new Scanner (input.nextLine());
        while (line.hasNext()){
            if(line.hasNextInt()){
                int temp = line.nextInt();
                if(String.valueOf(temp).length() == 3){
                    employeeNum = temp;
                    System.out.println(employeeNum);
                }
                else{
                    totalHours+=temp;
                }
            }
            // else{
            //     String trash = line.next();
            //     //System.out.println("hah");
            // }
            String tempName = line.next();
            if(!stringDoubleCheck(tempName)){
                name = tempName;
                System.out.println(name);
            }
            // else{
            //     String trash = line.next();
            // }
        }
        System.out.println(employeeNum+" and " + name);
    }
    }
}
