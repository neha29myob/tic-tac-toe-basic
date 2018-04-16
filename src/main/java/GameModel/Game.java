package GameModel;

public class Game {

    private Board board;
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private GameState status;
    private boolean isRunning;

    public Game() {
        status = GameState.PLAYING;
        board = new Board();
        establishPlayOrder();
    }

    public Game(Player player1, Player player2, Board board, int firstPlayer) {
        status = GameState.PLAYING;
        this.player1 = player1;
        this.player2 = player2;
        this.board = board;
        currentPlayer = (firstPlayer == player1.getOrder() ? player1 : player2);
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
        board.placeMarker(coordinates, currentPlayer.getToken());
        updateGameStatus();
        changePlayers();
    }

    public boolean isOccupied(Coordinates coordinates) {
        return board.isOccupied(coordinates);
    }

    public boolean isOutOfBound(Coordinates coordinates){
        return board.isMoveOutOBounds(coordinates);
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

    public Player getCurrentPlayer(){
        return currentPlayer;
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

}
