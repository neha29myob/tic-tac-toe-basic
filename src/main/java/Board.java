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



}
