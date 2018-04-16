import ConsoleUI.ConsoleReader;
import ConsoleUI.ConsoleWriter;
import Constants.Command;
import Constants.Messages;

public class GameConfiguration {

    private ConsoleReader reader;
    private ConsoleWriter writer;

    public GameConfiguration(ConsoleReader reader, ConsoleWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }

    public Game loadGame() {

        writer.write(Messages.CUSTOMIZE_GAME);
        String customizeGame = reader.getInput();

        if(customizeGame.equalsIgnoreCase(Command.NO)) {
           return new Game();
        }

        writer.write(Messages.DYNAMIC_BOARD);
        String dynamicBoardSize = reader.getInput();
        Board board = new Board(Integer.parseInt(dynamicBoardSize));

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
}
