import java.util.Scanner;
public class BMIcalculator {
    
    public static double bmi(double weight, double height){
        return (weight/(height*height))*703;
    }
    public static void bmiCalc(double BMI){
        if(BMI<18.5){
            System.out.println("underweight");
        }
        else if(BMI>=18.5&&BMI<=24.9){
            System.out.println("normal");
        }
        else if(BMI>=25.0&&BMI<=29.9){
            System.out.println("overweight");
        }
        else if(BMI>=30){
            System.out.println("obese");
        }
    }
    public static void main (String args []){
        double weight1, height1, weight2, height2, BMI1, BMI2;
        Scanner input = new Scanner (System.in);
        System.out.println("Enter first person's information:");
        System.out.print("Eneter their weight: ");
        weight1 = input.nextDouble();
        System.out.print("Enter their height: ");
        height1 = input.nextDouble();
        BMI1 = bmi(weight1, height1);
        System.out.println();
        System.out.println("Enter second person's information:");
        System.out.print("Eneter their weight: ");
        weight2 = input.nextDouble();
        System.out.print("Enter their height: ");
        height2 = input.nextDouble();
        BMI2 = bmi(weight2, height2);
        System.out.println();

        System.out.printf("Person 1 BMI %.3f \n" , BMI1);
        System.out.print("They are ");
        bmiCalc(BMI1);
        System.out.printf("Person 2 BMI = %.3f \n" , BMI2);
        System.out.print("They are ");
        bmiCalc(BMI2);
        System.out.printf("Difference %.3f \n" , Math.abs((BMI1-BMI2)));
    }
}
