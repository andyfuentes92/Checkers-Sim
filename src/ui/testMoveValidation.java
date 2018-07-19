package ui;

public class testMoveValidation {
    public static void testMoveValidation(){
        System.out.println("Welcome to checkers!");
        Board cboard = new Board();
        cboard.clearBlacks();
        cboard.print();

        if(cboard.validMove(4,5,6,3)){
            System.out.println("valid move!");
        }
        if(cboard.validMove(4,5,6,3)){
            System.out.println("valid move!");
        }
        if(cboard.validMove(4,5,6,3)){
            System.out.println("valid move!");
        }
    }



}
