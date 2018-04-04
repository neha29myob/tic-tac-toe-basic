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

        //String[][] currentBoard = getBoard();
        //for (int row = 0; row < board.length; row++) {
        //for (int column = 0; column < board.length; column++) {
        board[x][y] = getTokenOfCurrentPlayer();
        changePlayers();
        // }
        //}
    }

    private void changePlayers() {
        if (player.equals(Player.X)) {
            player = Player.O;
        } else {
            player = Player.X;
        }
    }

    private void updateBoard(String[][] currentBoard, int x, int y) {
        currentBoard = getBoard();
        placeMarker(x, y);
        setBoard(currentBoard);
    }

    public boolean isOver() {
        return false;
    }

//    public String[] getRow(){
//        for (int i = 0; i < board.length; i++){
//
//        }
//    }

    public boolean checkRowColumn(String s1, String s2, String s3) {
        if (!s1.equals("-") && (s1 == s2) && (s2 == s3)) {
            return true;
        }
            return false;
    }

    public boolean checkForWin() {
        return (checkForColumnWin() || checkForColumnWin());
    }

    private boolean checkForRowWin() {
        for (int i = 0; i < board.length; i++) {
            if (checkRowColumn(board[i][0], board[i][1], board[i][2])) {
                return true;
            }
        }
        return false;
    }

    private boolean checkForColumnWin() {
        for (int i = 0; i < 3; i++) {
            if (checkRowColumn(board[0][i], board[1][i], board[2][i])) {
                return true;
            }
        }
        return false;
    }
}
