import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game {

    private Board board1;
    private String[][] board;
    private Player player;

    public Game(int size) {

        board1 = new Board(size);
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
    
    private int getBoardSize() {
        return board.length;
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

    private boolean isMoveOutOBounds(int x, int y) {
        return (x < 0 && x > getBoardSize() && y < 0 && y > getBoardSize());
    }

    private void changePlayers() {
        player = player.equals(Player.X) ? Player.O : Player.X;
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

    public boolean isWinningLine(List<String> winningLine) {
        return ((winningLine.get(0) != "-") && Collections.frequency(winningLine, winningLine.get(0)) == getBoardSize());
    }

    public boolean checkForWin() {
        return (checkForRowWin() || checkForColumnWin()|| checkForDiagonalWin());
    }



    private boolean checkForRowWin() {

        for (int row = 0; row < getBoardSize(); row++) {
            List<String> rows = new ArrayList<>();
            for (int column = 0; column < getBoardSize(); column++)
                rows.add((board[row][column]));

            if (isWinningLine(rows)) {
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
            if (isWinningLine(columns)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkForDiagonalWin() {
        List<String> diagonalsLR = new ArrayList<>();
        List<String> diagonalsRL = new ArrayList<>();

        for (int i = 0; i < getBoardSize(); i++) {
            diagonalsLR.add(board[i][i]);
            diagonalsRL.add(board[i][getBoardSize() - i - 1]);
            }

            if (isWinningLine(diagonalsLR)) {
                return true;
            }
            if (isWinningLine(diagonalsRL)) {
                return true;
            }
            return false;
        }

    private void updateBoard(String[][] currentBoard, int x, int y) {
        currentBoard = getBoard();
        placeMarker(x, y);
        setBoard(currentBoard);
    }
}
