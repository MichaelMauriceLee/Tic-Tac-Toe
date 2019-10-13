/**
 * Referee class and its instance methods and variables.
 *
 * @author Michael Lee
 * @version 1.0
 * @since 2019/09/24
 */

public class Referee {

///////////////////////////////////////////////////////////
////////INSTANCE VARIABLES
    /**
     * The Player object assigned to the "X" mark.
     */
    private Player xPlayer;
    /**
     * The Player object assigned to the "O" mark.
     */
    private Player oPlayer;
    /**
     * A 2D array of characters representing the board.
     */
    private Board board;

///////////////////////////////////////////////////////////
////////INSTANCE METHODS

    /**
     * Assigns {@link xPlayer} and {@link oPlayer} as each other's opponents, populates {@link board} and starts
     * the game.
     */
    public void runTheGame() {
        xPlayer.setOpponent(oPlayer);
        oPlayer.setOpponent(xPlayer);
        setBoard(board);
        int turn_counter = 0;
        board.display();
        xPlayer.play();
    }

    /**
     * Initializes the Board object of the Referee object with the Board object passed in as an argument.
     *
     * @param board the Board object belonging to the Referee object.
     */
    public void setBoard(Board board) {
        this.board = board;
    }

    /**
     * Initializes the {@link oPlayer} variable of the Referee object with the Player object passed in as an argument.
     *
     * @param oPlayer the Player object with the "O" mark belonging to the Referee object.
     */
    public void setoPlayer(Player oPlayer) {
        this.oPlayer = oPlayer;
    }

    /**
     * Initializes the {@link xPlayer}  variable of the Referee object with the Player object passed in as an argument.
     *
     * @param xPlayer the Player object with the "X" mark belonging to the Referee object.
     */
    public void setxPlayer(Player xPlayer) {
        this.xPlayer = xPlayer;
    }
}
