/**
 * Board class and its instance methods and variables.
 *
 * @author Michael Lee
 * @version 1.0
 * @since 2019/09/24
 */


public class Board implements Constants {

///////////////////////////////////////////////////////////
////////INSTANCE VARIABLES
    /**
     * A 2D array of characters representing the board.
     */
    private char theBoard[][];
    /**
     * A counter for the amount of marks on the board.
     */
    private int markCount;

///////////////////////////////////////////////////////////
////////CONSTRUCTORS

    /**
     * Constructs the Board object. It declares a fresh game and initializes a 3x3 board with blanks (spaces).
     */
    public Board() {
        markCount = 0;
        theBoard = new char[3][];
        for (int i = 0; i < 3; i++) {
            theBoard[i] = new char[3];
            for (int j = 0; j < 3; j++)
                theBoard[i][j] = SPACE_CHAR;
        }
    }

///////////////////////////////////////////////////////////
////////INSTANCE METHODS

    /**
     * Allows the caller of this function to get a specific position on the Board object.
     *
     * @param row the row the position belongs to.
     * @param col the column the position belongs to.
     * @return the (x,y) position on the Board object.
     */
    public char getMark(int row, int col) {
        return theBoard[row][col];
    }

    /**
     * Compares current {@link markCount} and returns true if the markCount
     * has reached the maximum amount of marks on the board.
     *
     * @return true if markCount matches 9.  Otherwise returns false.
     */
    public boolean isFull() {
        return markCount == 9;
    }

    /**
     * Calls the {@link checkWinner} function and returns true if the {@link checkWinner} returns true.
     *
     * @return true if the "X" player wins.  Otherwise returns false.
     */
    public boolean xWins() {
        if (checkWinner(LETTER_X) == 1)
            return true;
        else
            return false;
    }

    /**
     * Calls the {@link checkWinner} function and returns true if the {@link checkWinner} returns true.
     *
     * @return true if the "O" player wins.  Otherwise returns false.
     */
    public boolean oWins() {
        if (checkWinner(LETTER_O) == 1)
            return true;
        else
            return false;
    }

    /**
     * Outputs {@link theBoard} to the console display.
     */
    public void display() {
        displayColumnHeaders();
        addHyphens();
        for (int row = 0; row < 3; row++) {
            addSpaces();
            System.out.print("    row " + row + ' ');
            for (int col = 0; col < 3; col++)
                System.out.print("|  " + getMark(row, col) + "  ");
            System.out.println("|");
            addSpaces();
            addHyphens();
        }
    }

    /**
     * Adds the mark to the location on {@link theBoard}.
     *
     * @param row  the row of the location.
     * @param col  the column of the location.
     * @param mark the mark corresponding to the player
     */
    public void addMark(int row, int col, char mark) {

        theBoard[row][col] = mark;
        markCount++;
    }

    /**
     * Clears the entire board of marks to allow for a new game.
     */
    public void clear() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                theBoard[i][j] = SPACE_CHAR;
        markCount = 0;
    }

    /**
     * Checks the board to determine if there are three of the same marks in a row to determine the winner.
     *
     * @param mark the mark of the player to determine if this player has won or not.
     * @return true if the player has won.  Otherwise returns false.
     */
    int checkWinner(char mark) {
        int row, col;
        int result = 0;

        for (row = 0; result == 0 && row < 3; row++) {
            int row_result = 1;
            for (col = 0; row_result == 1 && col < 3; col++)
                if (theBoard[row][col] != mark)
                    row_result = 0;
            if (row_result != 0)
                result = 1;
        }

        for (col = 0; result == 0 && col < 3; col++) {
            int col_result = 1;
            for (row = 0; col_result != 0 && row < 3; row++)
                if (theBoard[row][col] != mark)
                    col_result = 0;
            if (col_result != 0)
                result = 1;
        }

        if (result == 0) {
            int diag1Result = 1;
            for (row = 0; diag1Result != 0 && row < 3; row++)
                if (theBoard[row][row] != mark)
                    diag1Result = 0;
            if (diag1Result != 0)
                result = 1;
        }
        if (result == 0) {
            int diag2Result = 1;
            for (row = 0; diag2Result != 0 && row < 3; row++)
                if (theBoard[row][3 - 1 - row] != mark)
                    diag2Result = 0;
            if (diag2Result != 0)
                result = 1;
        }
        return result;
    }

    /**
     * Outputs column headers to the console display.
     */
    void displayColumnHeaders() {
        System.out.print("          ");
        for (int j = 0; j < 3; j++)
            System.out.print("|col " + j);
        System.out.println();
    }

    /**
     * Outputs hyphens to the console display to create a tic-tac-toe board.
     */
    void addHyphens() {
        System.out.print("          ");
        for (int j = 0; j < 3; j++)
            System.out.print("+-----");
        System.out.println("+");
    }

    /**
     * Outputs blanks to the console display.
     */
    void addSpaces() {
        System.out.print("          ");
        for (int j = 0; j < 3; j++)
            System.out.print("|     ");
        System.out.println("|");
    }
}
