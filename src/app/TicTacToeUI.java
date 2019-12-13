package app;

/**
 *  Provides a graphical user interface for playing
 *  TicTacToe which features a game board, chat message box,
 *  turn indicator, etc.
 * 
 *  UI events are delivered to an external object through the
 *  TicTacToeUIListener interface and the setListener() method
 */
public class TicTacToeUI
{
    // Sets the listener for this UI. The listener will
    // receive method calls when various events occur on the UI
    // (such as buttons being clicked)
    public void setListener(TicTacToeUIListener listener)
    {

    }

    // Sets the local players symbol to Xs or Os
    // isX should be true if the local player will use Xs or false if they will use Os
    public void setSymbol(boolean isX)
    {

    }

    // Updates a spot on the game board
    // position is a number 0 - 8 representing the position on the game board
    // isOpponent should be true if the opponent caused the board update
    public void updateBoard(boolean isOpponent, int position)
    {

    }

    // Updates the message that indicates whose turn it is
    // isOpponent should be true if it is the opponents turn
    public void updateTurnIndicator(boolean isOpponent)
    {

    }

    // Display the win / lose / tie messages
    // messageType should be one of the following values
    // 0 - Display the win message
    // 1 - Display the loss message
    // 2 - Display the tie message
    public void displayGameOverMessage(int messageType)
    {

    }

    // Increments the score counter by one
    // isOpponent should be true if the opponent's score counter
    // should be incremented, otherwise the local player's
    // counter will be incremented
    public void incrementScoreCounter(boolean isOpponent)
    {

    }

    // Appends the given message to the end of the chat box
    public void appendChatMessage(String message)
    {

    }

    // Clears the game board to a blank state
    // 
    // Does NOT edit the score indicators, chat box, or any
    // other indicators
    public void resetGameBoard()
    {

    }
}