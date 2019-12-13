package app;

/**
 *  Provides an interface with callback functions for use with
 *  a TicTacToeUI object.
 */
interface TicTacToeUIListener
{
    // Fired when a position on the board is clicked
    // position is an integer 0 - 8 representing the spot
    // that was clicked
    public void boardPositionClicked(int position);

    // Fired when a chat message is sent in the chat box
    // message is the message to be sent
    public void chatMessageSent(String message);

    // Fired when the user attempts to close the program
    // (such as clicking the red X)
    public void quitSignal();
}