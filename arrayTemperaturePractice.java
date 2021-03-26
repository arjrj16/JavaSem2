import java.util.*;
public class arrayTemperaturePractice {
    //main method
    public static void main(String args[]){
    //scanner object - used for temps and amount of days
    Scanner input = new Scanner (System.in);
    //get amt of days
    System.out.print("How many days' temperatures? ");
    int amt = input.nextInt();
    //htemp stores values of each of the days Hi temps
    int htemp[] = new int [amt]; 
    Double sum = 0.0;
    Double average = 0.0;
    //gets day hi temps from user and stores them
    for(int day = 0; day <amt; day++){
        System.out.println("Day "+(day+1)+"'s high temp: ");
        htemp [day] = input.nextInt();
        sum += htemp[day];
    }
    //averages out (also using other data collected in for loop - sum)
    average = (double) sum/amt;
    //print out average
    System.out.printf("The average is %.1f",average);
    System.out.println();
    int counter = 0;
    //counts amount of days above average
    for(int comp = 0; comp<amt; comp++){
        if(average<htemp[comp]){
            counter++;
        }
    }
    //says how many days above average
    System.out.println("There were " + counter + " days above the average.");
    }

}
