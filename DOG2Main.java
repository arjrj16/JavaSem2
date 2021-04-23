//package Classes and objects;
import java.util.*;
public class DOG2Main {
    public static void main (String [] args){
        Scanner input = new Scanner (System.in);
        DOG2 dog1 = new DOG2();
        DOG2 dog2 = new DOG2("fluffy", "terrier", 6, "black");
        // dog1.name = "fluffy";
        // dog1.breed = "terrier";
        // dog1.age = 6;
        // dog1.color="black";
        System.out.println(dog1);
        System.out.println(DOG2.toString(dog1)); //static
        System.out.println(dog1.toString()); //non static
        //you can use the same name as long as the setting (static, non static) or parameters are different.
        
        //you can still work with variables like  (when public)
        /*
        dog1.name = "peter";
        System.out.println(dog1.name);
        */
        //but we should use set and get as we don't want people to have direct access to it
        //so we can set the atributes to private:
        dog1.setName("peter");
        System.out.println(dog1.getName());

        DOG2 [] doggies = new DOG2[4];
        for(int i = 0; i<doggies.length; i++){
            System.out.println("Enter the name of the dog");
            String name = input.next();
            System.out.println("Enter the breed of the dog");
            String breed = input.next();
            System.out.println("Enter the age of the dog");
            int age = input.nextInt();
            System.out.println("Enter the color of the dog");
            String color = input.next();
            doggies [i] = new DOG2 (name,breed,age,color);
        }
        System.out.println(dog1.bark());
        System.out.println(Arrays.toString(doggies));
    }
}
