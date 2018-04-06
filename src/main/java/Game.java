public class Game {

    private Board board;
    private Player player;
    private GameState status;

    public Game(int size) {

        status = GameState.PLAYING;
        board = new Board(size);
        player = Player.X;
    }

    private String getTokenOfCurrentPlayer() {
        return player.getToken();
    }

    public void play(int x, int y) {

        if (board.isMoveOutOBounds(x, y)) {
            throw new IndexOutOfBoundsException("Can't place the markers");
        }

        if (board.isOccupied(x, y)) {
            throw new IllegalArgumentException("Oh no, a piece is already at this place! Try again...");
        }
        board.placeMarker(x, y, getTokenOfCurrentPlayer());
        updateGameStatus();
        changePlayers();
    }

    private void updateGameStatus() {
       status =  board.hasWinner() ? GameState.WIN : board.isFull() ? GameState.DRAW : GameState.PLAYING;
    }

    private void changePlayers() {
        player = player.equals(Player.X) ? Player.O : Player.X;
    }

    public GameState getStatus() {
        return status;
    }

}
