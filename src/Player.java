/**
 * Player class and its instance methods and variables
 *
 * @author Michael Lee
 * @version 1.0
 * @since 2019/10/24
 */

abstract class Player {

///////////////////////////////////////////////////////////
////////INSTANCE VARIABLES
    /**
     * Represents the name of the Player object.
     */
    protected String name;
    /**
     * A 2D array of characters representing the board.
     */
    protected Board board;
    /**
     * A Player Object to be the current Player Object's opponent.
     */
    protected Player opponent;
    /**
     * The mark given to a player to denote their turn.
     */
    protected char mark;

///////////////////////////////////////////////////////////
////////CONSTRUCTORS

    /**
     * This constructs the Player object with the specified values for name and mark.
     *
     * @param name the Player object's name.
     * @param mark the Player object's mark.
     */
    public Player(String name, char mark) {
        setName(name);
        setMark(mark);
    }

///////////////////////////////////////////////////////////
////////INSTANCE METHODS

    /**
     * Checks to see if the game has ended.  If it hasn't ended yet, it will prompt the player to make a move,
     * display the board to the console and then allow the player's opponent to play.
     */
    abstract protected void play();

    /**
     * Prompts current player to input a row and column to place their mark in and checks to see if they can place
     * their mark at that location.
     * If the input is valid, a new mark that represents the player will be added to the board.
     * If the input is invalid, the player will be prompted to enter in a new location.
     */
    abstract protected void makeMove();

    /**
     * Outputs the name of the winner to the console display.
     *
     * @param name the name of the Player object.
     */
    protected void displayWinner(String name) {
        System.out.println(name + " has won the game!");
    }

    /**
     * Outputs the tie result to the console display.
     */
    protected void displayTie() {
        System.out.println("The game has ended in a tie");
    }

    /**
     * Checks the current board against all winning conditionals and ends the game if any one of them are met.
     * Otherwise, continues playing the game.
     *
     * @return true if any of the game ending conditions are met.  Otherwise returns false.
     */
    protected boolean checkGameEnd() {
        if (board.xWins() == true && mark == board.LETTER_X) {
            displayWinner(name);
            return true;
        }
        if (board.xWins() == true && mark == board.LETTER_O) {
            displayWinner(opponent.name);
            return true;
        }
        if (board.oWins() == true && mark == board.LETTER_O) {
            displayWinner(name);
            return true;
        }
        if (board.oWins() == true && mark == board.LETTER_X) {
            displayWinner(opponent.name);
            return true;
        }
        if (board.isFull() == true) {
            displayTie();
            return true;
        }

        return false;
    }

    /**
     * Checks to see if the player's inputs are within the play area and
     * if the location specified is not occupied already.
     *
     * @param row the row of the location on the board.
     * @param col the column of the location on the board.
     * @return true if the input is valid.  Otherwise, outputs error message and returns false.
     */
    protected boolean checkValidMark(int row, int col) {
        if (row < 0 || row > 2) {
            System.out.println("Inputted row out of range.  Try again.");
            return false;
        }
        if (col < 0 || col > 2) {
            System.out.println("Inputted column out of range.  Try again.");
            return false;
        }
        if (board.getMark(row, col) == board.LETTER_X || board.getMark(row, col) == board.LETTER_O) {
            System.out.println("That spot is already in place.  Choose another.");
            return false;
        }
        return true;
    }
///////////////////////////////////////////////////////////
////////GETTERS AND SETTERS

    /**
     * Returns the name of the Player object to the caller of this function
     *
     * @return the name of the Player object.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the Player object with the inputted String parameter
     *
     * @param name the name of the Player object.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the mark of the Player object to the caller of this function
     *
     * @return the mark of the Player object.
     */
    public char getMark() {
        return mark;
    }

    /**
     * Sets the mark of the Player object with the inputted char parameter
     *
     * @param mark the mark of the Player object.
     */
    public void setMark(char mark) {
        this.mark = mark;
    }

    /**
     * Sets the opponent of the Player object with the inputted Player object parameter
     *
     * @param opponent the mark of the Player object.
     */
    protected void setOpponent(Player opponent) {
        this.opponent = opponent;
    }

    /**
     * Sets the board of the Player object with the inputted Board object parameter
     *
     * @param theBoard the board which the Player object is playing on.
     */
    protected void setBoard(Board theBoard) {
        this.board = theBoard;
    }

}
