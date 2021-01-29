public class pg125ex11 {
    public static final int repeatNum = 3;
    public static final int bigNum = 5;
    public static void main(String[] args) {
           for(int i=1; i<=repeatNum; i++) {
               for(int a=0; a<(bigNum-1); a++){
                   System.out.print(" ");
               }
                   System.out.print("|");
               }
               System.out.println();
               for(int i = 1; i <=repeatNum*bigNum; i++){
                   System.out.print(i%bigNum);
               }
           }
}
