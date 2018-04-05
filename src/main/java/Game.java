import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Game {

    private String[][] board;
    private Player player;

    public Game(int size) {
        board = new String[size][size];
        player = Player.X;
        initializeBoard(size);
    }

    private String getTokenOfCurrentPlayer() {
        return player.getToken();
    }

    private void setBoard(String[][] board) {
        this.board = board;
    }

    public String[][] getBoard() {
        return board;
    }

    private void initializeBoard(int size) {
        for (int row = 0; row < size; row++) {
            for (int column = 0; column < size; column++) {
                board[row][column] = "-";
            }
        }
    }

    public void placeMarker(int x, int y) {

        if (isOver()) {
            throw new IllegalArgumentException("Can't place the markers");
        }

        if (isMoveOutOBounds(x, y)) {
            throw new IndexOutOfBoundsException("Can't place the markers");

        } else {
            board[x][y] = getTokenOfCurrentPlayer();
            changePlayers();
        }
    }

    private boolean isSafeToPlaceMarker(int x, int y) {
        return (!isMoveOutOBounds(x, y) && board[x][y].equals("-"));
    }

    private boolean isMoveOutOBounds(int x, int y) {
        return (x < 0 && x > getBoardSize() && y < 0 && y > getBoardSize());
    }

    private void changePlayers() {
        player = player.equals(Player.X) ? Player.O : Player.X;
    }

    private void updateBoard(String[][] currentBoard, int x, int y) {
        currentBoard = getBoard();
        placeMarker(x, y);
        setBoard(currentBoard);
    }

    public boolean isOver() {
        return (checkForWin() || isDraw());
    }

    private boolean isDraw() {
        boolean isFull = true;
        for (int row = 0; row < getBoardSize(); row++) {
            for (int column = 0; column < getBoardSize(); column++) {
                if (board[row][column] == "-") {
                    isFull = false;
                }
            }
        }
        return isFull;
    }

    public boolean checkRowColumn(List<String> winningLine) {
        return ((winningLine.get(0) != "-") && Collections.frequency(winningLine, winningLine.get(0)) == getBoardSize());
    }

    private int getBoardSize() {
        return board.length;
    }

    public boolean checkForWin() {
        return (checkForRowWin() || checkForColumnWin()|| checkForDiagonalWin());
    }

    private boolean checkForRowWin() {

        for (int row = 0; row < getBoardSize(); row++) {
            List<String> rows = new ArrayList<>();
            for (int column = 0; column < getBoardSize(); column++)
                rows.add((board[row][column]));
            if (checkRowColumn(rows)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkForColumnWin() {
        for (int column = 0; column < getBoardSize(); column++) {
            List<String> columns = new ArrayList<>();
            for (int row = 0; row < getBoardSize(); row++)
                columns.add(board[row][column]);
            if (checkRowColumn(columns)) {
                return true;
            }
//
//            if (checkRowColumn(board[0][i], board[1][i], board[2][i])) {
//                return true;
        }
        return false;
    }

    private boolean checkForDiagonalWin() {
        for (int i = 0; i < getBoardSize(); i++) {
            List<String> diagonalsLR = new ArrayList<>();
            diagonalsLR.add(board[i][i]);
            if (checkRowColumn(diagonalsLR)) {
                return true;
            }
        }
            return false;
        }
}
