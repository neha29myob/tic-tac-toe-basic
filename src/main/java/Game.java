public class Game {

    private Board board;
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private GameState status;

    public Game(int size) {

        status = GameState.PLAYING;
        board = new Board(size);
        establishPlayOrder();
//        player1 = new Player(1, "X");
//        player2 = new Player(2, "O");
//        currentPlayer = player1;
    }

    private void establishPlayOrder() {
        player1 = new Player(1, "X");
        player2 = new Player(2, "O");
        currentPlayer = player1;

    }

    public String printBoard() {
        return board.toString();
    }

    public void play(Coordinates coordinates) {

        board.placeMarker(coordinates, getTokenOfCurrentPlayer());
        updateGameStatus();
        changePlayers();
    }


    public boolean isOccupied(Coordinates coordinates) {
        return board.isOccupied(coordinates);
    }

    public boolean isOutOfBound(Coordinates coordinates){
        return board.isMoveOutOBounds(coordinates);
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
        currentPlayer = currentPlayer.getOrder() == 1 ? player2 : player1;
    }

    public GameState getStatus() {
        return status;
    }

    public String getTokenOfCurrentPlayer() {
        return currentPlayer.getToken();
    }

    public int getOrderOfCurrentPlayer() {
        return currentPlayer.getOrder();
    }

}
