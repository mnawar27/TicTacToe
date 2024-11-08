package rocks.zipcodewilmington.tictactoe;

/**
 * @author leon on 6/22/18.
 */
public class Board {
    private Character[][] matrix;

    public Board(Character[][] matrix) {
        this.matrix = matrix;
    }

    private Boolean checkWinner(char player) {
        for (int i = 0; i < 3; i++) {
            if ((matrix[i][0] == player && matrix[i][1] == player && matrix[i][2] == player) ||
                    (matrix[0][i] == player && matrix[1][i] == player && matrix[2][i] == player)) {
                return true;
            }
        }

        if ((matrix[0][0] == player && matrix[1][1] == player && matrix[2][2] == player) ||
                (matrix[0][2] == player && matrix[1][1] == player && matrix[2][0] == player)) {
            return true;
        }

        return false;
    }


    public Boolean isInFavorOfX() {

        return checkWinner('X');
    }

    public Boolean isInFavorOfO() {

        return checkWinner('O');
    }

    private Boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (matrix[i][j] == null) {
                    return false;
                }
            }
        }
        return true;
    }

    public Boolean isTie() {

        return !isInFavorOfX() && !isInFavorOfO() && isBoardFull();
    }

    public String getWinner() {

        if (isInFavorOfX()) {
            return "X";
        } else if (isInFavorOfO()) {
            return "O";
        } else {
            return "";
        }
    }

}
