package app;

/**
 *  Provides an interface with callback functions for use with
 *  a TicTacToeHost object.
 */
interface TicTacToeHostListener
{
    // Fired when a client connects to this host
    public void clientConnected();

    // Fired when a client disconnects from this host
    public void clientDisconnected();

    // Fired when a client plays their symbol at
    // a specified position
    public void symbolPlayed(int position);

    // Fired when a client sends a chat message
    public void chatMessage(String message);
}