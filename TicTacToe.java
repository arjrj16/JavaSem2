/*
Pseudo Code:
Creat Scanner - input
constand dimensions -> 3, basically since there will always be 3 by 3 board
main(){
    char array [] [] board that is a size of 3x3
    Place holder variables:
        X move - x cord of move
        Y move - y cord of move
    Counters:
        amt of x moves
        amt of o moves
        total moves
    Booleans:
        moveErrorX - tells us if the user does something wrong and specifies if we shld loop again or not
        moveErrorO - ""       ""

    Print Instructions: enter cords, 3 in a row, etc.

    fill board with spaces - func fillTacs
    while (no one has won [func winCheck()] and there has been less than 9 moves){
        while(move error x is false (while there is an error (error could be that the user hasn't gone yet))){
            if(no one has won and there is less than 9 moves(same as earlier, but this is an extra check in case soemone wins between the entire while sequence)){
                ask for input for cords of placing x
                if(there is a space in the spot){
                    assign value to the desired spot (-1 of what user enters as arrays start at 0)
                    set move error x to true, as the error that a user hasn't entered a value yet is now resolved, so we can leave this while loop.
                }
                else{
                    notify user to enter a new value
                    set move error x to false, indicating there is an error, causing the loop to repeat
                }
            }
            if(someone has won){
                set move error x to true, as someone has won which can be pecieved as an eror so to leave the while loop.
            }
        }
        move error x = false - because we want the loop to reset to check for errors.

        REPEAT ALL AGAIN EXCEPT WITH Y VALUES
    }
    if(move count is greater than 9){
        then stale mate
    }
    else{
        if x moves are greater than o
            x won
        else
            o won
    }
}

winCheck func (board){
    Add rows columns and diagonals together into single string
    If index of 0,1,2 are all x or all o, then return ture
    else, return false
}


*/
import java.util.*;
public class TicTacToe {
    public static Scanner input = new Scanner (System.in); //scanner
    public static final int dimensions = 3; //dimensions of tic tac toe board
    public static void main (String args[]){
        // defining variables:
        char [][] board = new char [dimensions][dimensions]; //tic tac toe board

        //place holders:
        int player1Xmove;
        int player1Ymove;

        //counters:
        int moveCount = 0;
        int xCounter = 0;
        int oCounter = 0;

        fillTacs(board); //setup tic tac toe board

        //error check variables
        boolean MoveErrorX = false;
        boolean MoveErrorO = false;

        //print user interface and instructions
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

        //begin actual game
        while(winCheck(board)== false&&moveCount<9){ //check no one has won and there isn't a stale mate
            while(MoveErrorX == false){ //loop while there is an error or nothing has been inputed yet
                if(moveCount<9&&winCheck(board)==false){ // if no one has won or stalemate

                    //getting input:
                    System.out.println("Please enter a move for X: ");
                    System.out.print("Row: ");
                    player1Xmove = input.nextInt();
                    System.out.print("Column: ");
                    player1Ymove = input.nextInt();
                    if(board[player1Xmove-1][player1Ymove-1] == ' '){ //only allows you to place in spot where no one has placed anything
                        board[player1Xmove-1][player1Ymove-1] = 'x';
                        moveCount++;
                        xCounter++;
                        graphic(board); //prints board
                        MoveErrorX = true; 
                    }
                    else{
                        System.out.println("An "+ board[player1Xmove-1][player1Ymove-1]+" is already in that spot. Please try again.");
                        MoveErrorX = false; //error - loop again
                        //System.out.println("moveX is false;");
                    }
                }
                if(winCheck(board)==true){
                    MoveErrorX =  true; //if somone wins, don't loop again
                    //System.out.println("moveX is true;");
                }
            }
            MoveErrorX=false; //reset error check
            
            //same thing except with O:
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
                        //System.out.println("moveO is false;");
                    }
                    //System.out.println(winCheck(board));
                }
                if(winCheck(board)==true){
                    MoveErrorO =  true;
                    //System.out.println("moveO is true;");
                }
            }
            MoveErrorO = false;
        }
        if(moveCount>=9){ // if there is a draw
            System.out.println("Draw. Neither X or O won.");
        }
        else{
            if(xCounter>oCounter){ //if there are more x plays
                System.out.println("X player wins.");
            }
            else{ //if same amount
                System.out.println("O player wins");
            }
        }
    }
    public static void fillTacs(char [][] board){ //just fills array
        for(int i = 0; i<dimensions; i++){

            for(int x = 0; x<dimensions; x++){
                board[i][x]=' ';
            }
        }
        
    }
    public static void graphic (char [][] board){  //just prints array
        String line = "---|---|---";
        System.out.println(" " + board[0][0] + " | " + board[0][1] + " | " + board[0][2]);
        System.out.println(line);
        System.out.println(" " + board[1][0] + " | " + board[1][1] + " | " + board[1][2]);
        System.out.println(line);
        System.out.println(" " + board[2][0] + " | " + board[2][1] + " | " + board[2][2]);
    }
    public static boolean winCheck(char board[][]){ //checks if someone won
       // int check =0;
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

            //if row had 3 x's or o's
            if((rowAppend(rc, board).charAt(0) == 'x' && rowAppend(rc, board).charAt(1) == 'x' && rowAppend(rc, board).charAt(2) == 'x') || (rowAppend(rc, board).charAt(0) == 'o' && rowAppend(rc, board).charAt(1) == 'o' && rowAppend(rc, board).charAt(2) == 'o')){
                check = 1;
                //System.out.println("row");
                return true;
            }
            //if column had 3 x's or o's
            if((columnAppend(rc, board).charAt(0) == 'x' && columnAppend(rc, board).charAt(1) == 'x' && columnAppend(rc, board).charAt(2) == 'x') || (columnAppend(rc, board).charAt(0) == 'o' && columnAppend(rc, board).charAt(1) == 'o' && columnAppend(rc, board).charAt(2) == 'o')){
                check = 1;
                //System.out.println("column");
                return true;
            }
            //if diagonals had 3 x's or o's
            if((diagonalLtR(board).charAt(0) == 'x' && diagonalLtR(board).charAt(1) == 'x' && diagonalLtR(board).charAt(2) == 'x') || (diagonalRtL(board).charAt(0) == 'o' && diagonalRtL(board).charAt(1) == 'o' && diagonalRtL(board).charAt(2) == 'o')){
                check =1; 
                //System.out.println("diagonal");
                return true;
            }
            //if diagonals had 3 x's or o's
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
    //puts row of x's and o's into a string so we can use string methods.
    public static String rowAppend(int row, char board[][]){
        String strRow = "";
        strRow = strRow+board[row][0]+board[row][1]+board[row][2];
        //System.out.println(strRow);
        return strRow;
    }
    //puts column of x's and o's into a string so we can use string methods.
    public static String columnAppend(int column, char board[][]){
        String strRow = "";
        strRow = strRow+board[0][column]+board[1][column]+board[2][column];
        //System.out.println(strRow);
        return strRow;
    }
    //puts diagonal of x's and o's into a string so we can use string methods.
    public static String diagonalLtR(char board[][]){
        String strRow = "";
        strRow = strRow+board[0][0]+board[1][1]+board[2][2];
        //System.out.println(strRow);
        return strRow;
    }
    //puts diagonal of x's and o's into a string so we can use string methods.
    public static String diagonalRtL(char board[][]){
        String strRow = "";
        strRow = strRow+board[0][2]+board[1][1]+board[2][0];
        //System.out.println(strRow);
        return strRow;
    }

}
