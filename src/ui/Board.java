package ui;
public class Board {
    char[][] brd;
    int turn;

    public Board(){
        this.brd = new char[8][8];
        this.turn = 0;
        //Initialize all spots as empty
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                this.brd[i][j] = '-';
            }
        }
        //Initialize all black pieces
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 8; j++){
                if ((i+j)%2 == 1){
                    this.brd[i][j] = 'b';
                }
            }
        }
        //Initialize all white pieces
        for (int i = 5; i < 8; i++){
            for (int j = 0; j < 8; j++){
                if ((i+j)%2 == 1){
                    this.brd[i][j] = 'w';
                }
            }
        }
    }
    public void clearBlacks(){
        //Initialize all black pieces
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 8; j++){
                if ((i+j)%2 == 1){
                    this.brd[i][j] = '-';
                }
            }
        }
    }
    public void setPiece(int col, int row, char color){
        this.brd[row][col] = color;
    }
    public boolean validMove(int startCol, int startRow, int endCol, int endRow){
        char color = this.brd[startRow][startCol];
        char otherColor = color == 'w' ? 'b' : 'w';

        //Ensure endX,endY square is empty and in bounds
        if (this.brd[endRow][endCol] != '-' && (endRow >= 8 || endCol >= 9)){
            System.out.println("space not empty and in bounds!");
            return false;
        }
        //Check & validate simple move (no hop)
        if (java.lang.Math.abs(startRow - endRow) == 1 && java.lang.Math.abs(startCol - endCol) == 1){
            System.out.println("simple hop");
        }
        //Ensure move is up (for white), or down (for black) *only for non-kings*
        if (color == 'w'){
            if (startRow - endRow < 0){
                System.out.println(" not up (white)");
                return false;
            }
            return recMultiHop(color,startCol, startRow, endCol, endRow);
        }
        if (color == 'b'){
            if ((startRow - endRow) <= 0){
                System.out.println("not down (black) " + (startCol - endCol));
                return false;
            }
        }
        System.out.println("valid move!");
        return true;
    }

    public boolean recMultiHop(char color, int startC, int startR, int endC, int endR){

        //If out of bounds, return false
        if (startR >= 8 || startC >= 8){
            System.out.println("out of bounds");
            return false;
        }
        //Check if this is the actual spot!
        if (startC == endC && startR == endR){
            System.out.println("at the actual spot! returning true!");
            return true;
        }

        //Check to see if coords are in bounds if it hops over a B piece, and then hop right
        boolean path = false;
        if (startR - 1 >= 0 && startC + 1 >= 0){
            if (this.brd[startR - 1][startC + 1] == 'b'){
                path = recMultiHop(color,startC + 2, startR - 2, endC, endR) || path ? true : false;
            }
        }

        //Check to see if coords are in bounds if it hops over a B piece, and then hop left
        if (startR - 1 >= 0 && startC -1 >= 0){
            if (this.brd[startR -1][startC - 1] == 'b'){
                path = recMultiHop(color,startC -2, startR - 2, endC, endR) || path ? true : false;
            }
        }

            return path;


    }
    public void print(){
        System.out.print("   ");
        for (int i = 0; i < 8; i++){
            System.out.print(i + " ");
        }
        System.out.print("\n");
        for (int i = 0; i < 8; i++){
            System.out.print(i + "| ");
            for (int j = 0; j < 8; j++){
                System.out.print(this.brd[i][j] + " ");
            }


            System.out.print("\n");
        }
    }

}