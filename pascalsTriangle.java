public class pascalsTriangle {
    final static int pasLine = 10;
    public static void pascals(){
           for(int row = 1; row<=pasLine; row++){
            for(int space =1; space<=-1*row+11; space++){
                System.out.print("  ");
            }
            for(int column = 1; column<=row; column++){
                System.out.printf("%4d", methodA(column, row));
            }
            System.out.println();
        }
    }
    public static int methodA (int column, int row){
        int start = 0;
        int a = 1;
        while(start < row-column)
        {
            a *= (column+start)/(1+start);
            start++;
        }
        return a;
    }
    public static void main (String args[]){
        pascals();
    }
}
