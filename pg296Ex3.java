/*
Write a method called season that takes as parameters two integers representing a month and day and returns a
String indicating the season for that month and day. Assume that the month is specified as an integer between 1
and 12 (1 for January, 2 for February, and so on) and that the day of the month is a number between 1 and 31. If the
date falls between 12/16 and 3/15, the method should return "winter". 
If the date falls between 3/16 and 6/15, the
method should return "spring". 

If the date falls between 6/16 and 9/15, the method should return "summer". And
if the date falls between 9/16 and 12/15, the method should return "fall".
*/
import java.util.Scanner;
public class pg296Ex3 {
    public static String season (int m, int d){
        if((m==12&&(d>15&&d<31))||(m>=1&&m<=2)||(m==3&&d>=1&&d<=15)){
            return "Winter";
        }
        else if((m==3&&(d>15&&d<31))||(m>=4&&m<=5)||(m==6&&d>=1&&d<=15)){
            return "Spring";
        }
        else if((m==6&&(d>15&&d<31))||(m>=7&&m<=8)||(m==9&&d>=1&&d<=15)){
            return "Summer";
        }
        else if((m==9&&(d>15&&d<31))||(m>=10&&m<=11)||(m==12&&d>=1&&d<=15)){
            return "Fall";
        }
        else{
            return "Please enter a correct month and date.";
        }
    }
    public static void main(String args[]){
        Scanner input = new Scanner (System.in);
        int month, day;
        String user = new String();
        do{
        System.out.println("Please enter a month");
        month = input.nextInt();
        System.out.println("Please enter a date");
        day = input.nextInt();
        System.out.println("The date you entered is in: " + season(month, day));
        System.out.println("Would you like to check another date? ");
        user = input.nextLine();
        }
        while(user.contains("y")||user.contains("Y"));
        System.out.println("Thankyou for using the program. Coded by: Arjun Melwani");
    }
}
