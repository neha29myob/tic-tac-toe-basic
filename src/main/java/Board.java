import java.util.ArrayList;
import java.util.List;

public class Board {
    private String[][] board;

    public Board(int size) {
        board = new String[size][size];
        initializeBoard(size);
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

    private int getBoardSize() {
        return board.length;
    }

    private List<String> getRow(){
        List<String> rows = new ArrayList<>();
        for (int row = 0; row < getBoardSize(); row++) {
            for (int column = 0; column < getBoardSize(); column++)
                rows.add((board[row][column]));
        }
        return rows;
    }

    private boolean isFull() {
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

    public void placeMarker(Coordinates coordinates, String token){

        board[coordinates.getX()][coordinates.getY()] = token;

    }




}
