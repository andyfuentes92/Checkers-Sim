package ui;
public class Board {
    char[][] brd;
    int turn;
    boolean whiteMove;

    public Board(){
        this.brd = new char[8][8];
        this.turn = 0;
        this.whiteMove = true;
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

    //Moves a piece on the board. Takes 2 pairs of coordinates, start and end row/column. Returns void.
    public void handleMove(int[] move){
        int startCol = move[0];
        int startRow = move[1];
        int endCol   = move[2];
        int endRow   = move[3];
        if (validMove(startCol, startRow, endCol, endRow)){
            char color = this.brd[startRow][startCol];
            System.out.println("Setting " + endCol + ":" + endRow + " to " + color);
            this.brd[endRow][endCol] = color;
            this.brd[startRow][startCol] = '-';

            //Change whiteMove to true if false, and vice versa
            whiteMove = whiteMove ? false : true;
        }

    }

    //Validates a move. Returns true if valid, false if invalid. Takes 2 pairs of coordinates, start and end
    //row/column.
    public boolean validMove(int startCol, int startRow, int endCol, int endRow){

        //Ensure endX,endY square is empty and in bounds
        if ((endRow >= 8 || endCol >= 8 || startRow >= 8 || endRow >= 8)){
            System.out.println("Move out of bounds!");
            return false;

        }
        if (this.brd[endRow][endCol] != '-'){
            System.out.println("End Col/Row not empty!");
            return false;
        }

        char color      = this.brd[startRow][startCol];
        char otherColor = color == 'w' || color == 'W' ? 'b' : 'w';
        //Ensure the white is playing on whites turn, and vice versa.
        if ((whiteMove && (color != 'w' && color != 'W') || (!whiteMove && (color == 'w' || color == 'W')))){
            return false;
        }

        //Ensure a piece is being moved! BW
        if(this.brd[startRow][startCol] == '-'){
            System.out.println("space is empty!");
            return false;
        }
        //Check if its a King move! If so, send to validateKingMove
        if (color == 'W' || color == 'B'){
            return validKingMove(color,startCol, startRow, endCol, endRow);
        }

        //Check & validate simple move (no hop) BW
        if (java.lang.Math.abs(startRow - endRow) == 1 && java.lang.Math.abs(startCol - endCol) == 1){
            System.out.println("simple hop");
            return true;
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
            if ((endRow - startRow) <= 0){
                System.out.println("not down (black) ");
                return false;
            }
        }
        System.out.println("valid move!");
        return true;
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
        if (whiteMove){
            System.out.println("Whites turn!");
        }
        else{
            System.out.println("Blacks turn!");
        }
    }

    public void setTurn(char color){
        this.whiteMove = color == 'b' ? false : true;
    }
    private boolean validKingMove(char color, int startC, int startR, int endC, int endR){

        return false;
    }
    //Private helper function used by validMove. Recursively checks all possible hopping paths from
    // [startC,startR] -> [endC,endR]
    // Updated to work for both white and black moves
    private boolean recMultiHop(char color, int startC, int startR, int endC, int endR){
        char otherColor = color == 'w' ? 'b' : 'w';
        //If out of bounds, return false
        if (startR >= 8 || startC >= 8){
            System.out.println("out of bounds");
            return false;
        }
        //Check if this is the actual spot!
        if (startC == endC && startR == endR){
            return true;
        }

        // Set which direction to hop: -2 corresponds to white moves (up the board)
        // +2 corresponds to black moves (down the board)
        int rowChange = (color == 'w' || color == 'W') ? -2 : 2;
        // Check to see if coords are in bounds if it hops over a B piece, and then hop
        // RIGHT
        boolean path = false;
        if (startR - 1 >= 0 && startC + 1 >= 0){
            if (this.brd[startR - 1][startC + 1] == otherColor){
                path = recMultiHop(color,startC + 2, startR + rowChange, endC, endR) || path ? true : false;
            }
        }

        // Check to see if coords are in bounds if it hops over a B piece, and then hop
        // LEFT
        if (startR - 1 >= 0 && startC -1 >= 0){
            if (this.brd[startR - 1][startC - 1] == otherColor){
                path = recMultiHop(color,startC -2, startR + rowChange, endC, endR) || path ? true : false;
            }
        }

        return path;
    }



}