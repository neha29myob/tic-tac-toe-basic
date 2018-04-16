import ConsoleUI.ConsoleReader;
import ConsoleUI.ConsoleWriter;

public class Main {

    public static void main(String[] args) {

        ConsoleReader consoleReader =  new ConsoleReader();
        ConsoleWriter consoleWriter = new ConsoleWriter();

        GameConfiguration gameConfiguration = new GameConfiguration(consoleReader, consoleWriter);

        ApplicationTicTac ticTacToe = new ApplicationTicTac(consoleReader, consoleWriter);
        Game game = gameConfiguration.loadGame();
        //ticTacToe.initializeGame();
        ticTacToe.start(game);
    }
}
