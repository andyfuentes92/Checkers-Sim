package ui;

import java.util.Scanner;


public class Interface {

    int[] error = {-1, 0, 0, 0};
    private Scanner input;
    private Board board;
    boolean gameInProgress;
    boolean whiteMove;
    ButtonGrid grid = new ButtonGrid(8,8);

    public Interface(Board brd){
        input = new Scanner(System.in);
        this.board = brd;
        gameInProgress = true;
    }

    //EFFECTS: parses user input until user quits
    public void handleUserInput(){
        initializeGraphics();
        board.print();
        printInstructions();
        int[] move;

        while(gameInProgress){
            move = getUserMove();
            if (move != error){
                board.handleMove(move);
                board.print();
            }

        }
    }

    public void printInstructions(){
        System.out.println("Type in the coordinates of the piece you would like to move, " +
                "followed by the coordinates of location youd like to move too");
        System.out.println("For example: 0,5,1,4 moves the white piece at [0,5] to [1,4]!");
    }

    //Takes no parameters, returns user input as an array of 4 ints. Called by handleUserInput
    //If the user gives an invalid move, it returns an the error array.

    public void initializeGraphics(){
        ButtonGrid grid = new ButtonGrid(8,8);
    }

    private int[] getUserMove(){
        String in = "";
        String[] str;
        int[] move = new int[4];
        //Split the comma seperated move into an array of 4 ints.
        if(input.hasNext()){
            in = input.next();
            str = in.split(",");
            if (str.length != 4) {

                System.out.println("Input must be 4 long!");
                return error;
            }
            //Turn input into an array of four integers
            for (int i = 0; i < str.length; i++){
                try{
                    move[i] = Integer.parseInt(str[i]);
                }
                //Ensure input are integers
                catch (Exception e){
                    System.out.println("Input must be all integers1!");
                    return error;
                }


            }
        }
        return move;
    }
}
