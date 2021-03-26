public class pascalsTriangleV2 {
    final static int pasLine = 10;
    public static void pascals(){
           for(int row = 1; row<=pasLine; row++){
            for(int space =1; space<=-1*row+11; space++){
                System.out.print("  ");
            }
            for(int column = 1; column<=row; column++){
                System.out.printf("%4d", 1);
            }
            System.out.println();
        }
    }
    public static int methodA (int column, int row){
        int value = 1;
        while(value < row-column)
        {
            value *= (column - row+1)/row;
        }
        return value;
    }
    public static void main (String args[]){
        pascals();
    }
}
