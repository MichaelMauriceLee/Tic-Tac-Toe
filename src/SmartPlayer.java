/**
 * SmartPlayer class and its instance methods and variables
 *
 * @author Michael Lee
 * @version 1.0
 * @since 2019/10/24
 */

public class SmartPlayer extends BlockingPlayer {
    ///////////////////////////////////////////////////////////
////////CONSTRUCTOR
    public SmartPlayer(String name, char mark) {
        super(name, mark);
    }

    ///////////////////////////////////////////////////////////
////////INSTANCE METHODS
    protected boolean testForWinning(int row, int col) {
        Board copyOfBoard = createCopyOfBoard(board);
        if (checkValidMark(row, col)) {
            copyOfBoard.addMark(row, col, mark);
        }
        if (checkPlayerWin(copyOfBoard)) {
            return true;
        }
        return false;
    }

    protected void makeMove() {
        int play_count = 0;
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++) {
                if (testForWinning(i, j) && super.checkValidMark(i, j) && play_count == 0) {
                    board.addMark(i, j, mark);
                    play_count++;
                }
            }
        if (play_count == 0) {
            super.makeMove();
        }
    }

    ///////////////////////////////////////////////////////////
////////HELPER METHODS
    private boolean checkPlayerWin(Board copyOfBoard) {
        if (copyOfBoard.xWins() && mark == board.LETTER_X) {
            return true;
        }
        if (copyOfBoard.oWins() && mark == board.LETTER_O) {
            return true;
        }
        return false;
    }

}
