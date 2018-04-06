import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Board {
    private String[][] board;

    public Board(int size) {
        board = new String[size][size];
        initializeBoard(size);
        }

    private void initializeBoard(int size) {
        for (int row = 0; row < size; row++) {
            for (int column = 0; column < size; column++) {
                board[row][column] = "-";
            }
        }
    }

    private int getBoardSize() {
        return board.length;
    }

//    private List<String> getRow(){
//        List<String> rows = new ArrayList<>();
//        for (int row = 0; row < getBoardSize(); row++) {
//            for (int column = 0; column < getBoardSize(); column++)
//                rows.add((board[row][column]));
//        }
//        return rows;
//    }

    public void placeMarker(int x, int y, String token) {

        board[x][y] = token;
    }

    public boolean isMoveOutOBounds(int x, int y) {
        return (x < 0 && x > getBoardSize() && y < 0 && y > getBoardSize());
    }

    public boolean isEmpty(int x, int y) {
        return board[x][y].equals("-");
    }

    public boolean isDraw() {
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

        int boardSize = getBoardSize();

        for (int i = 0; i < boardSize; i++) {
            diagonalsLR.add(board[i][i]);
            diagonalsRL.add(board[i][boardSize - i - 1]);
        }

        if (isWinningLine(diagonalsLR)) {
            return true;
        }
        if (isWinningLine(diagonalsRL)) {
            return true;
        }
        return false;
    }






}
