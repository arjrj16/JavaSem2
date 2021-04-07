import java.util.*;
public class TicTacToe {
    public static Scanner input = new Scanner (System.in);
    public static final int dimensions = 3;
    public static void main (String args[]){
        char [][] board = new char [dimensions][dimensions];
        int player1Xmove;
        int player1Ymove;
        int moveCount = 0;
        int xCounter = 0;
        int oCounter = 0;
        fillTacs(board);
        boolean MoveErrorX = false;
        boolean MoveErrorO = false;
        
        System.out.println("Instructions: This is a 1v1 Tic Tac Toe game coded by Arjun Melwani.");
        System.out.println("Each player can place either an X or an O in the 3 by 3 grid. To win, they must get 3 X's or O's in a row.");
        System.out.println("In order to place the X or O in the desired grid box, please specify the row and column of the box you wish to place it, as shown below: ");
        System.out.println();
        String line = "-----|-----|-----";
        System.out.println(" 1,1 | 1,2 | 1,3");
        System.out.println(line);
        System.out.println(" 2,1 | 2,2 | 2,3");
        System.out.println(line);
        System.out.println(" 3,1 | 3,2 | 3,3");
        System.out.println();

        //boolean winCheck_ = winCheck(board);
        while(winCheck(board)== false&&moveCount<9){
            while(MoveErrorX == false){
                if(moveCount<9&&winCheck(board)==false){
                    System.out.println("Please enter a move for X: ");
                    System.out.print("Row: ");
                    player1Xmove = input.nextInt();
                    System.out.print("Column: ");
                    player1Ymove = input.nextInt();
                    if(board[player1Xmove-1][player1Ymove-1] == ' '){
                        board[player1Xmove-1][player1Ymove-1] = 'x';
                        moveCount++;
                        xCounter++;
                        graphic(board);
                        MoveErrorX = true;
                    }
                    else{
                        System.out.println("An "+ board[player1Xmove-1][player1Ymove-1]+" is already in that spot. Please try again.");
                        MoveErrorX = false;
                    }
                    
                }
            }
            MoveErrorX = false;
            while(MoveErrorO == false){
                if(moveCount<9&&winCheck(board)==false){
                    System.out.println("Please enter a move for O: ");
                    System.out.print("Row: ");
                    player1Xmove = input.nextInt();
                    System.out.print("Column: ");
                    player1Ymove = input.nextInt();

                    if(board[player1Xmove-1][player1Ymove-1] == ' '){
                        board[player1Xmove-1][player1Ymove-1] = 'o';
                        moveCount++;
                        oCounter++;
                        graphic(board);
                        MoveErrorO = true;
                    }
                    else{
                        System.out.println("An "+ board[player1Xmove-1][player1Ymove-1]+" is already in that spot. Please try again.");
                        MoveErrorO = false;
                    }
                    //System.out.println(winCheck(board));
                }
            }
            MoveErrorO = false;
        }
        if(moveCount>=9){
            System.out.println("Draw. Neither X or O won.");
        }
        else{
            if(xCounter>oCounter){
                System.out.println("X player wins.");
            }
            else{
                System.out.println("O player wins");
            }
        }
    }
    public static void fillTacs(char [][] board){
        for(int i = 0; i<dimensions; i++){

            for(int x = 0; x<dimensions; x++){
                board[i][x]=' ';
            }
        }
        
    }
    public static void graphic (char [][] board){
        String line = "---|---|---";
        System.out.println(" " + board[0][0] + " | " + board[0][1] + " | " + board[0][2]);
        System.out.println(line);
        System.out.println(" " + board[1][0] + " | " + board[1][1] + " | " + board[1][2]);
        System.out.println(line);
        System.out.println(" " + board[2][0] + " | " + board[2][1] + " | " + board[2][2]);
    }
    public static boolean winCheck(char board[][]){
        int check =0;
        for(int rc =0; rc <dimensions; rc++){
            // if((rowAppend(rc, board).contains("x") && rowAppend(rc, board).contains("o") || rowAppend(rc, board).contains(" "))&&check!=1){
            //     check = 1;
            //     System.out.println("row");
            // }
            // if((columnAppend(rc, board).contains("x") && columnAppend(rc, board).contains("o") || columnAppend(rc, board).contains(" "))&&check!=1){
            //     check = 1;
            //     System.out.println("column");
            // }
            // if((diagonalLtR(board).contains("x") && diagonalRtL(board).contains("o") || diagonalRtL(board).contains(" "))&&check!=1){
            //     check =1; 
            //     System.out.println("diagonal");
            // }
            /// else{
            ///    check = -1;
            //     System.out.println("-1");
            // }
            if((rowAppend(rc, board).charAt(0) == 'x' && rowAppend(rc, board).charAt(1) == 'x' && rowAppend(rc, board).charAt(2) == 'x') || (rowAppend(rc, board).charAt(0) == 'o' && rowAppend(rc, board).charAt(1) == 'o' && rowAppend(rc, board).charAt(2) == 'o')){
                check = 1;
                //System.out.println("row");
                return true;
            }
            if((columnAppend(rc, board).charAt(0) == 'x' && columnAppend(rc, board).charAt(1) == 'x' && columnAppend(rc, board).charAt(2) == 'x') || (columnAppend(rc, board).charAt(0) == 'o' && columnAppend(rc, board).charAt(1) == 'o' && columnAppend(rc, board).charAt(2) == 'o')){
                check = 1;
                //System.out.println("column");
                return true;
            }
            if((diagonalLtR(board).charAt(0) == 'x' && diagonalLtR(board).charAt(1) == 'x' && diagonalLtR(board).charAt(2) == 'x') || (diagonalRtL(board).charAt(0) == 'o' && diagonalRtL(board).charAt(1) == 'o' && diagonalRtL(board).charAt(2) == 'o')){
                check =1; 
                //System.out.println("diagonal");
                return true;
            }
            if((diagonalLtR(board).charAt(0) == 'o' && diagonalLtR(board).charAt(1) == 'o' && diagonalLtR(board).charAt(2) == 'o') || (diagonalRtL(board).charAt(0) == 'x' && diagonalRtL(board).charAt(1) == 'x' && diagonalRtL(board).charAt(2) == 'x')){
                check =1; 
                //System.out.println("diagonal");
                return true;
            }
        }
        // if (check == 1){
        //     System.out.println("false");
        //     return false;
            
        // }
        // else{
        //     System.out.println("true");
        //     return true; 
            
        // }
        //System.out.println("False");
        return false;
    }
    public static String rowAppend(int row, char board[][]){
        String strRow = "";
        strRow = strRow+board[row][0]+board[row][1]+board[row][2];
        //System.out.println(strRow);
        return strRow;
    }
    public static String columnAppend(int column, char board[][]){
        String strRow = "";
        strRow = strRow+board[0][column]+board[1][column]+board[2][column];
        //System.out.println(strRow);
        return strRow;
    }
    public static String diagonalLtR(char board[][]){
        String strRow = "";
        strRow = strRow+board[0][0]+board[1][1]+board[2][2];
        //System.out.println(strRow);
        return strRow;
    }
    public static String diagonalRtL(char board[][]){
        String strRow = "";
        strRow = strRow+board[0][2]+board[1][1]+board[2][0];
        //System.out.println(strRow);
        return strRow;
    }

}
