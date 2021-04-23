//package Classes and objects;

public class DOG2 {

    //instance variables
    private String name;
    private String breed;
    private int age;
    private String color;

    //constructors
    public DOG2(){
        name = "";
        age = 0;
    }
    public DOG2(String name1, String breed1,int age1, String color1){
        if(name1.length() <= 10){
            name = name1;
        }
        else{
            name = name1.substring(0, 9);
        }
        breed = breed1;
        if(age1 <= 20){
            age = age1;
        }
        else{
            age = 0;
        }
        color = color1;
    }

    //getter methods (assesor Methods) - get values of your fields
    public String getName(){
        return name;
    }
    public String getBreed(){
        return breed;
    }
    public int getAge(){
        return age;
    }
    public String getColor(){
        return color;
    }
    //setter methods (mutator methods) - change values of your fields
    public void setName(String newName){
        name = newName;
    }
    public void setBreed(String newBreed){
        breed = newBreed;
    }
    public void setAge(int newAge){
        age = newAge;
    }
    public void setColor(String newColor){
        color = newColor;
    }

    public static String toString(DOG2 ob){ //static means we just needed to call the class in main - DOG2.toString(dog1));
        return ("The dog's name "+ob.name+"   "+ob.breed+"     "+ob.age+"    "+ob.color);
    }

    public String bark (){
        return (name + " is barking right now Guaua Guaua");
    }

    public String toString(){
        return("Hi my name is "+name+".\nMy breed, age and color are " + breed+","+age+","+color);
    }
}
