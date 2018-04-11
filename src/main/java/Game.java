public class Game {

    private Board board;
    private Player player;
    private GameState status;

    public Game(int size) {

        status = GameState.PLAYING;
        board = new Board(size);
        player = Player.X;
    }

    public String printBoard() {
        return board.toString();
    }

    public void play(Coordinates coordinates) {

        board.placeMarker(coordinates, getTokenOfCurrentPlayer());
        updateGameStatus();
        changePlayers();
    }

    public boolean isValid(Coordinates coordinates) {

        if (board.isMoveOutOBounds(coordinates)) {
            throw new IndexOutOfBoundsException("Can't place the markers");
        }

        if (board.isOccupied(coordinates)) {
            throw new IllegalArgumentException("Oh no, a piece is already at this place! Try again...");
        }

        return true;
    }


    private void updateGameStatus() {
        status = board.hasWinner() ? GameState.WIN : board.isFull() ? GameState.DRAW : GameState.PLAYING;
    }

    private void changePlayers() {
        player = player.equals(Player.X) ? Player.O : Player.X;
    }

    public GameState getStatus() {
        return status;
    }

    public String getTokenOfCurrentPlayer() {
        return player.getToken();
    }

}
