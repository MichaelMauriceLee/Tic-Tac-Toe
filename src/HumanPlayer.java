import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * HumanPlayer class and its instance methods and variables
 *
 * @author Michael Lee
 * @version 1.0
 * @since 2019/10/24
 */

public class HumanPlayer extends Player {
    ///////////////////////////////////////////////////////////
////////Constructor
    public HumanPlayer(String name, char mark) {
        super(name, mark);
    }

    ///////////////////////////////////////////////////////////
////////INSTANCE VARIABLES
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
        BufferedReader stdin;
        stdin = new BufferedReader(new InputStreamReader(System.in));
        boolean turnEnd = false;
        int row = 0;
        int col = 0;
        while (turnEnd == false) {
            System.out.println(name + " , which row to make a move?");
            String temp = "";
            try {
                temp = stdin.readLine();
            } catch (Exception e) {
                System.out.println("Invalid Entry");
            }
            row = Integer.parseInt(temp);
            System.out.println(name + " , which column to make a move?");
            try {
                temp = stdin.readLine();
            } catch (Exception e) {
                System.out.println("Invalid Entry");
            }
            col = Integer.parseInt(temp);
            turnEnd = checkValidMark(row, col);
        }
        board.addMark(row, col, mark);
    }
}
