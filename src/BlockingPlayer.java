/**
 * BlockingPlayer class and its instance methods and variables
 *
 * @author Michael Lee
 * @version 1.0
 * @since 2019/10/24
 */

public class BlockingPlayer extends RandomPlayer {
    ///////////////////////////////////////////////////////////
////////CONSTRUCTOR
    public BlockingPlayer(String name, char mark) {
        super(name, mark);
    }

    protected boolean testForBlocking(int row, int col) {
        Board copyOfBoard = createCopyOfBoard(board);
        if (checkValidMark(row, col)) {
            copyOfBoard.addMark(row, col, opponent.mark);
        }
        if (checkOpponentWin(copyOfBoard)) {
            return true;
        }
        return false;
    }

    ///////////////////////////////////////////////////////////
////////INSTANCE METHODS
    protected void makeMove() {
        int play_count = 0;
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++) {
                if (testForBlocking(i, j) && super.checkValidMark(i, j) && play_count == 0) {
                    board.addMark(i, j, mark);
                    play_count++;
                }
            }
        if (play_count == 0) {
            super.makeMove();
        }
    }

    protected Board createCopyOfBoard(Board board) {
        Board copyOfBoard = new Board();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                copyOfBoard.addMark(i, j, board.getMark(i, j));
            }
        }
        return copyOfBoard;
    }

    ///////////////////////////////////////////////////////////
////////HELPER METHODS
    private boolean checkOpponentWin(Board copyOfBoard) {
        if (copyOfBoard.xWins() && opponent.mark == board.LETTER_X) {
            return true;
        }
        if (copyOfBoard.oWins() && opponent.mark == board.LETTER_O) {
            return true;
        }
        return false;
    }
}
