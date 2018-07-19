package ui;

public class checkers {
    public static void main(String[] args) {
        System.out.println("Welcome to checkers!");
        Interface info =
        testMoveValidation();
        //cboard.validMove(4,5,3,1);
        //cboard.validMove(4,5,3,2);
        //cboard.validMove(4,5,4,1);



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
    }
}
