package app;

/**
 *  Provides server-side networking to support an online
 *  multiplayer TicTacToe game. The networking uses a
 *  client-server architecture which means client code will
 *  be necessary to connect to this server (two servers cannot
 *  connect to each other)
 * 
 *  Network events are delivered to an external object through the
 *  TicTacToeHostListener interface and the setListener() method
 */
public class TicTacToeHost
{
    // Sets the listener for this object. The listener will
    // receive method calls when various events occur on the network
    // (such as messages being received)
    public void setListener(TicTacToeUIListener listener)
    {

    }

    // Starts listening for client connections on the given
    // address and port
    // address should be an internet address such as 127.0.0.1
    // port should be a port number such as 2000
    public void startListenServer(String address, int port)
    {

    }

    // Shuts down the listen server so that no further connections
    // will be accepted.
    public void stopListenServer()
    {

    }

    // Disconnect the connected client
    public void disconnect()
    {

    }

    // Sends a network message to the client indicating that the game is starting
    // isHostFirstPlayer indicates if the host is going first or if the opponent
    // is going first
    // isHostUsingXs indicates if the host will be using X symbols or if the opponent
    // will be using X symbols
    public void startGame(boolean isHostFirstPlayer, boolean isHostUsingXs)
    {

    }

    // Sends a network message to the client indicating that this player is
    // playing their symbol at the indicated position
    public void play(int position)
    {

    }

    // Sends a network message to the client indicating that the game is
    // over and who the winner is. 
    // The integer winner should be one of the following
    // 0 - Host won the game
    // 1 - Opponent won the game
    // 2 - The game was a draw
    public void endGame(int winner)
    {

    }

    // Sends a network message to the client indicating that a chat message
    // has been sent
    // message is the chat message
    public void chatMessage(String message)
    {

    }
}