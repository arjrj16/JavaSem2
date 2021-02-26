public class WedClass {
    public static void main (String args []){
        String name = "MAria Suarez";
        String anotherName = "Peter Paul & Mary";
        char letter = name.charAt(3);
        System.out.println(letter);
        int index = anotherName.indexOf("e");
        System.out.println(index);
        String temp = anotherName.substring(index+1);
        System.out.println(temp);
        int tempIndx = temp.indexOf("e")+1;
        tempIndx+=index;
        System.out.println(tempIndx);
        int num = 31;
        double result = Math.sqrt(num);
        System.out.printf("The answer is %.2f", result);

    }
}
