package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class ButtonGrid {

    JFrame frame = new JFrame();
    JPanel checkerBoard = new JPanel();
    JButton[][] grid;
    JButton currentlySelected = null;

    public ButtonGrid(int width, int length){
        //Create Overall GUI as a JFrame
        JFrame GUI = new JFrame();

        GUI.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 20));

        //Create Left Menu
        JPanel leftMenu = new JPanel();
        leftMenu.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
        leftMenu.setLayout(new BoxLayout(leftMenu, BoxLayout.Y_AXIS));

        //Create leftMenu->labelPanel
        JPanel labelPanel = new JPanel();
        JLabel positionLabel = new JLabel("", JLabel.CENTER);
        JPanel buttonLeftPanel = new JPanel();
        JButton resetButton = new JButton("Reset");
        resetButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                positionLabel.setText(currentlySelected.getText());
            }
        });


        //Add start button functionality

        labelPanel.add(positionLabel);
        buttonLeftPanel.add(resetButton);
        leftMenu.add(labelPanel);

        GUI.add(leftMenu);

        //Create leftMenu->labelPanel->startGame

        //Load Images for button grid
        ImageIcon black = new ImageIcon("black.png");
        ImageIcon red   = new ImageIcon("red.png");
        ImageIcon blank = new ImageIcon("blank.jpg");

        //Create button Grid
        checkerBoard.setLayout(new GridLayout(width,length));
        grid = new JButton[width][length];

        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                grid[i][j] = new JButton(i+","+j, blank);
                grid[i][j].setActionCommand(i + ", " + j);
                JButton button = grid[i][j];
                button.addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent ae)
                    {
                        //If currently selected equals the current button, clear the currently selected field
                        if (currentlySelected == button){
                            currentlySelected = null;
                        }
                        //If currentlySelected is null, select the button
                        else if (currentlySelected == null) {
                            currentlySelected = button;
                        }
                        //Currently selected not null, not current button, must be a new button. Now we have two coords
                        //Reset currentlySelected to null
                        else {
                            //JButton but = (JButton) ae.getSource();  not sure what this does
                            positionLabel.setText(
                                    currentlySelected.getText() + "--->" + button.getText());
                            currentlySelected = null;
                        }

                                //positionLabel.getText() + "," + but.getActionCommand());
                    }
                });
                checkerBoard.add(grid[i][j]);
            }
        }
        //Initialize all black pieces
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 8; j++){
                if ((i + j) % 2 == 1){
                    grid[i][j].setIcon(black);
                }
            }
        }
        //Initialize all white pieces
        for (int i = 5; i < 8; i++){
            for (int j = 0; j < 8; j++){
                if ((i + j) % 2 == 1){
                    grid[i][j].setIcon(red);
                }
            }
        }
        GUI.add(checkerBoard);
        GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GUI.pack();
        GUI.setVisible(true);
    }


}
