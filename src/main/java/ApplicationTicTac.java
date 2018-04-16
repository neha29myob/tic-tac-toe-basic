import ConsoleUI.ConsoleReader;
import ConsoleUI.ConsoleWriter;
import Constants.Command;
import Constants.Messages;

public class ApplicationTicTac {

    private ConsoleReader reader;
    private ConsoleWriter writer;
    //private Game game;

    public ApplicationTicTac(ConsoleReader reader, ConsoleWriter writer, Game game) {
        this.reader = reader;
        this.writer = writer;
        //this.game = game;
    }

    public Game loadGame() {

        writer.write(Messages.CUSTOMIZE_GAME);
        String customizeGame = reader.getInput();

        if(customizeGame.equalsIgnoreCase(Command.NO)) {
            return new Game();
        }

        writer.write(Messages.DYNAMIC_BOARD);
        String dynamicBoardSize = reader.getInput();
        Board board = new Board();
        board.setBoard(board.createDynamicBoard(Integer.parseInt(dynamicBoardSize)));

        writer.write(Messages.PLAYER1_TOKEN);
        String player1Token = reader.getInput();
        Player player1 = new Player(1, player1Token);

        writer.write(Messages.PLAYER2_TOKEN);
        String player2Token = reader.getInput();
        Player player2 = new Player(2, player2Token);

        writer.write(Messages.CHOOSE_FIRST_PLAYER);
        String firstPlayer = reader.getInput();

        writer.write(Messages.END_CUSTOMISATION);
        return new Game(player1, player2, board, Integer.parseInt(firstPlayer));
    }

    public void start(Game game){

        writer.write(Messages.WELCOME);
        writer.write(game.printBoard());

        while(game.getStatus().equals(GameState.PLAYING)){
            promptUser(game);
            String userChoice = reader.getInput();
            inputResponse(userChoice, game);
        }
    }

    private void promptUser(Game game) {
        writer.write(String.format(Messages.MOVE_MESSAGE, game.getOrderOfCurrentPlayer(), game.getTokenOfCurrentPlayer()));
    }

    private void inputResponse(String userChoice, Game game){

        String responseMessage = Validator.validatePlayerChoice(userChoice,game);

        if(responseMessage.equals(Messages.ACCEPTED_MOVE)){
            Coordinates coordinates = Coordinates.convertInput(userChoice);
            game.play(coordinates);
            printGameStatus(game);
        }
        if (responseMessage.equals(Messages.QUIT_GAME)) System.exit(0);
        else {
            writer.write(responseMessage);
        }
    }

    private void printGameStatus(Game game) {

        if (game.getStatus().equals(GameState.WIN)) writer.write(Messages.WIN_MESSAGE);
        if (game.getStatus().equals(GameState.DRAW)) writer.write(Messages.DRAW_MESSAGE);
        writer.write(game.printBoard());

    }

    //
//    private Game initializeGame() {
//        writer.write(Messages.WELCOME);
//        Game game = null;
//        writer.write("Enter the size of board");
//
//        try {
//            int size = Integer.parseInt(reader.getInput());
//            System.out.println("Here's the current board");
//            game =  new Game();
//            writer.write(game.printBoard());
//
//        } catch (NumberFormatException ex){
//            writer.write("Invalid format "  + ex.getMessage());
//        }
//        return game;
//    }


//    public void initializeGame() {
//        Game game = loadGame();
//        writer.write(Messages.WELCOME);
//        writer.write(game.printBoard());
//    }

}
