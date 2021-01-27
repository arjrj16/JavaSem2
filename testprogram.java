public class testProgram {

    public static int MAX_ODD = 21;

    public static void writeOdds() {
        int count = 1;
        for (count = 1; count <= (MAX_ODD-2); count+=2) {
        System.out.print(count + " ");
        }
        // print the last odd number
        System.out.print(count + 2);
    }
    
    public static void main(String[] args) {
        writeOdds();
        MAX_ODD = 11;
        writeOdds();
    }
}
