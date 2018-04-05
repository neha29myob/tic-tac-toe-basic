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

        if(!checkForWin() && isSafeToPlaceMarker(x,y) ){
            board[x][y] = getTokenOfCurrentPlayer();
            changePlayers();
        }
    }

    private boolean isSafeToPlaceMarker(int x, int y){
        return (!isMoveOutOBounds(x,y) && board[x][y].equals("-"));
    }

    private boolean isMoveOutOBounds(int x, int y) {
        return (x < 0 && x > board.length && y < 0 && y > board.length);
    }

    private void changePlayers() {
        player = player.equals(Player.X)? Player.O : Player.X;

//        if (player.equals(Player.X)) {
//            player = Player.O;
//        } else {
//            player = Player.X;
//        }
    }

    private void updateBoard(String[][] currentBoard, int x, int y) {
        currentBoard = getBoard();
        placeMarker(x, y);
        setBoard(currentBoard);
    }

    public boolean isOver() {
        if(checkForWin() || isDraw()){
            return  true;
        }
        return false;
    }

    private boolean isDraw() {

        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board.length; column++) {
                if(!(board[row][column] == "-")){
                    return true;
                }
            }
        }
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
        return (checkForRowWin() || checkForColumnWin());
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
        for (int i = 0; i < board.length; i++) {
            if (checkRowColumn(board[0][i], board[1][i], board[2][i])) {
                return true;
            }
        }
        return false;
    }
}
