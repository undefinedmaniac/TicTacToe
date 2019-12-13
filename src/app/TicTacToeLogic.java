package app;

/**
 *  Provides the logic for TicTacToe. It keeps track of the game 
 *  state and provides the ability to determine when the game is
 *  complete.
 * 
 *  For the purposes of this class, the "host" refers to player 1
 *  and the "opponent" refers to player 2
 */
public class TicTacToeLogic
{
    // Starts a new game
    // isHostFirstPlayer should be true if the host will be the first player to play,
    // otherwise the opponent will be first
    public void startNewGame(boolean isHostFirstPlayer)
    {

    }

    // Plays a symbol on the gameboard (note this logic is unaware which symbol is 
    // used as it is irrelevant)
    // isOpponent must be true if the opponent is playing
    // position is a number 0 - 8 representing the position on the game board as shown
    // 0|1|2
    // 3|4|5
    // 6|7|8
    // The integer return value is the result of the operation
    // 0 - Success, the piece was played on the board
    // 1 - Failure, it is not the specified player's turn
    // 2 - Failure, the position is already occupied
    public int play(boolean isOpponent, int position)
    {
        return 0;
    }

    // Checks if there is a winner in the game
    // the integer return value is the result of the checks
    // 0 - The game is not finished yet
    // 1 - The host won the game
    // 2 - The opponent won the game
    // 3 - The game is a draw
    public int checkForWinner()
    {
        return 0;
    }
}