public class Game {

    private String[][] board;
    private String currentPlayer;

    public Game(int size) {
        board = new String[size][size];
        currentPlayer = "x";
        initializeBoard(size);
    }

    public void setBoard(String[][] board) {
        this.board = board;
    }

    public String[][] getBoard() {
        return board;
    }

    private void initializeBoard(int size) {
        for (int row = 0; row < size; row++){
            for (int column = 0; column < size; column++){
                board[row][column] = "-";
            }
        }
    }

    public void play(int x, int y) {

        //String[][] currentBoard = getBoard();
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board.length; column++) {
                board[x][y] = currentPlayer;
                changePlayers();
            }
        }
    }

    public void changePlayers(){
        if (currentPlayer.equals("x")){
            currentPlayer = "o";
        } else {
            currentPlayer = "x";
        }
    }

    public void updateBoard(String[][] currentBoard, int x, int y ){
        currentBoard = getBoard();
        play(x,y);
        setBoard(currentBoard);
    }

    public boolean isOver() {
        return false;
    }
}
