/**
 * RandomPlayer class and its instance methods and variables
 *
 * @author Michael Lee
 * @version 1.0
 * @since 2019/10/24
 */

public class RandomPlayer extends Player {
    ///////////////////////////////////////////////////////////
////////INSTANCE VARIABLES
    private RandomGenerator randomGenerator;

    ///////////////////////////////////////////////////////////
////////CONSTRUCTOR
    public RandomPlayer(String name, char mark) {
        super(name, mark);
        this.randomGenerator = new RandomGenerator();
    }

    ///////////////////////////////////////////////////////////
////////INSTANCE METHODS
    protected void play() {
        if (checkGameEnd() == false) {
            makeMove();
            board.display();
            opponent.play();
        } else {
            System.out.println("The game has ended");
        }
    }

    protected void makeMove() {
        boolean turnEnd = false;
        int row = 0;
        int col = 0;
        while (turnEnd == false) {
            row = randomGenerator.discrete(0, 2);
            col = randomGenerator.discrete(0, 2);
            turnEnd = checkValidMark(row, col);
        }
        board.addMark(row, col, mark);
    }

    /**
     * Checks to see if the player's inputs are within the play area and
     * if the location specified is not occupied already.
     *
     * @param row the row of the location on the board.
     * @param col the column of the location on the board.
     * @return true if the input is valid.  Otherwise, outputs error message and returns false.
     */
    @Override
    protected boolean checkValidMark(int row, int col) {
        if (board.getMark(row, col) == board.LETTER_X || board.getMark(row, col) == board.LETTER_O) {
            return false;
        }
        return true;
    }
}



