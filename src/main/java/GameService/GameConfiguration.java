package GameService;

import ConsoleUI.ConsoleReader;
import ConsoleUI.ConsoleWriter;
import ConsoleUI.IReader;
import ConsoleUI.IWriter;
import Constants.Command;
import Constants.Messages;
import GameModel.Board;
import GameModel.Game;
import GameModel.Player;

public class GameConfiguration {

    private IReader reader;
    private IWriter writer;
    private boolean isValidResponse;

    public GameConfiguration(IReader reader, IWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }

    public Game loadGame() {

        isValidResponse = false;

        while (!isValidResponse) {
            writer.write(Messages.CUSTOMIZE_GAME);
            String customizeGame = reader.getInput();

            if (customizeGame.equalsIgnoreCase(Command.NO)) {
                isValidResponse = true;
                return new Game();

            } else if (customizeGame.equalsIgnoreCase(Command.YES)) {

                try {
                    return getCustomizedGame();
                } catch (NumberFormatException ex) {
                    System.out.println("Invalid input " + ex.getMessage() + ". Must be an integer value\n");
                    isValidResponse = false;
                }

            } else {
                writer.write(Messages.INVALID_INPUT);
            }
        }
        return new Game();
    }

    private Game getCustomizedGame() {

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

        isValidResponse = true;
        return new Game(player1, player2, board, Integer.parseInt(firstPlayer));
    }
}
