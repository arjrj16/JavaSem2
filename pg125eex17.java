public class pg125eex17 {
    static int height = 4;
    public static void main(String args []){
        for(int line = 1; line <=height; line++){
            for(int slash = 0; slash<(line*2)-2; slash++){
                System.out.print("\\");
            }
            for(int exMark = 0; exMark<=(-4*line)+18; exMark++){
                System.out.print("!");
            }
            for(int slash = 0; slash<(line*2)-2; slash++){
                System.out.print("/");
            }
            System.out.println();
        }
    }
}
