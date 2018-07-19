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
        int[] move;

        while(gameInProgress){
            move = getUserMove();
        }

    }

    public void printInstructions(){
        System.out.println("Type in the coordinates of the piece you would like to move, " +
                "followed by the coordinates of location youd like to move too");
    }

    //Takes no parameters, returns user input as an array of 4 ints. Called by handleUserInput
    private int[] getUserMove(){
        String in = "";
        String[] str;
        int[] move = new int[4];
        //Split the comma seperated move into an array of 4 ints.
        if(input.hasNext()){
            in = input.next();
            str = in.split(",");
            if (str.length != 4) {
                int[] error = {-1, 0, 0, 0};
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
                    int [] error = {-1,0,0,0};
                    return error;
                }


            }
        }
        for(int i = 0; i < move.length; i++){
            System.out.println(move[i]);
        }
        return move;
    }
}
