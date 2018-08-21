package ui;

public class checkers {
    public static void main(String[] args) {
        System.out.println("Welcome to checkers!");
        Board cboard = new Board();
        Interface info = new Interface(cboard);
        info.handleUserInput();
        //cboard.validMove(4,5,3,1);
        //cboard.validMove(4,5,3,2);
        //cboard.validMove(4,5,4,1);
        //testMoveValidation();



    }
    public static void testMoveValidation(){
        System.out.println("Welcome to checkers!");
        Board cboard = new Board();
        cboard.clearBlacks();
        cboard.setPiece(5,4,'b');
        cboard.setPiece(5,2,'b');
        cboard.setPiece(3,4,'b');
        cboard.setPiece(1,4,'b');
        cboard.setPiece(3,2,'b');
        cboard.print();


        if(cboard.validMove(6,5,6,1)){
            System.out.println("valid move!");
        }
        if(cboard.validMove(2,5,2,1)) {
            System.out.println("valid move!");
        }
        if(cboard.validMove(0,5,2,3)){
            System.out.println("valid move!");
        }
        if(cboard.validMove(0,5,4,1)){
            System.out.println("valid move!");
        }
        if(!cboard.validMove(0,5,0,6)){
            System.out.println("invalid move!");
        }
        if(!cboard.validMove(6,5,5,1)){
            System.out.println("invalid move!");
        }
        if(!cboard.validMove(6,7,5,6)){
            System.out.println("invalid move!");
        }

        cboard.setPiece(6,3,'w');
        cboard.print();
        cboard.setTurn('b');
        testMove(cboard,5,2,7,4);

    }
    public static void testMove(Board cboard, int startCol, int startRow, int endCol, int endRow){
        if (cboard.validMove(startCol,startRow,endCol,endRow)) {
            System.out.println("valid move!");
        }
        else{
            System.out.println("invalid move!");
        }
    }
}
