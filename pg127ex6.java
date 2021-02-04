public class pg127ex6 {
    public static final int size = 4;
    public static void needleTip(){
        for(int a = 1; a<=size; a++){
            for(int b = 1; b<=size*3; b++){
                System.out.print(" ");
            }
            System.out.println("||");
        }
    }
    public static void topSym(){
        for(int a =1; a<=size; a++){
            for(int b =1; b<=-3*a+(size*3); b++)
            {
                System.out.print(" ");
            }
            //spaces: 1: 9, 2:6, 3: 3; 0: 0
            System.out.print("__/");
            for(int colons =1; colons<=3*a-3; colons++){
                System.out.print(":");
            }
            System.out.print("||");
            for(int colons =1; colons<=3*a-3; colons++){
                System.out.print(":");
            }
            System.out.println("\\__");
        }
    }
    public static void midSymLine(){
        System.out.print("|");
        for(int quotes =1; quotes <=size*6; quotes++){
            System.out.print("\"");
        }
        System.out.println("|");
    }
    public static void lowSym(){
        for(int a =1; a<= size; a++){
            for(int b = 1; b<=2*a-2; b++){ System.out.print(" ");}
            System.out.print("\\_");
            for(int b =1; b<=-2*a+(3*size+1); b++){
                System.out.print("/\\");
            }
            System.out.println("_/");
            //"/\": 1: 11, 2: 9, 3: 7, 4: 5
        }
    }
    public static void vertSymLine(){
        double parethesisDotNum = size/2+.5;
        int parenthesisNum = (int) parethesisDotNum;
        for(int a =1; a<=4*size;a++){
            for(int spaces =1; spaces<=2*size+((size-parenthesisNum)-1); spaces++){
                System.out.print(" ");
            }
            System.out.print("|");
            for(int par =1; par<=parenthesisNum; par++){System.out.print("%");}
            System.out.print("||");
            for(int par =1; par<=parenthesisNum; par++){System.out.print("%");}
            System.out.println("|");
            //" ": 4: 9, 3:7, 2:5
        }
    }
    public static void main (String args []){
        needleTip();
        topSym();
        midSymLine();
        lowSym();
        needleTip();
        vertSymLine();
        topSym();
        midSymLine();
    }

}
