public class pg125ex7 {
        public static void main (String args[]){
            int line = 1;
            int space;
            int linecount = 5;
            for(line = 1; line<=linecount; line++)
            {
                for(space= linecount-line; space>=0; space--){
                    System.out.print(" ");
                }
                System.out.println(line);
            }
        }

}
