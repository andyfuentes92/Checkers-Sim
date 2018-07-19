package ui;
import java.util.Scanner;

public class Interface {

    private Scanner input;
    private Board board;
    boolean gameInProgress;

    public Interface(Board brd){
        input = new Scanner(System.in);
        this.board = brd;
        gameInProgress = true;
    }
    //EFFECTS: parses user input until user quits
    public void handleUserInput(){
        printInstructions();
        String str;

        while(gameInProgress    ){
            str = getUserInputString();
            parseInput(str);
        }
    }
    public void printInstructions(){
        System.out.println("Type in the coordinates of the piece you would like to move, " +
                "followed by the coordinates of location youd like to move too");
    }
}
