package app;

import javax.swing.JFrame;

public class SwingUI extends JFrame
{
    public static void main(String[] args) 
    {
        SwingUI frame = new SwingUI();

        frame.setTitle("TicTacToe");
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);
    }

    public SwingUI()
    {
        TicTacToeBoard board = new TicTacToeBoard();
        add(board);
    }
}