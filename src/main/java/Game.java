public class Game {

    private Board board;
    private Player player;

    public Game(int size) {

        board = new Board(size);
        player = Player.X;
    }

    private String getTokenOfCurrentPlayer() {
        return player.getToken();
    }

    public void play(int x, int y) {

        if (board.isOver()) {
            throw new IllegalArgumentException("Can't place the markers");
        }

        if (board.isMoveOutOBounds(x, y)) {
            throw new IndexOutOfBoundsException("Can't place the markers");

        } else {
            board.placeMarker(x, y, getTokenOfCurrentPlayer());
            changePlayers();
        }
    }

    private void changePlayers() {
        player = player.equals(Player.X) ? Player.O : Player.X;
    }

    public boolean isOver() {
        return board.isOver();
    }

//    private void updateBoard(String[][] currentBoard, int x, int y) {
//        currentBoard = getBoard();
//        placeMarker(x, y);
//        setBoard(currentBoard);
//    }
}
