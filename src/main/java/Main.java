import ConsoleUI.ConsoleReader;
import ConsoleUI.ConsoleWriter;

public class Main {

    public static void main(String[] args) {

        ApplicationTicTac ticTacToe = new ApplicationTicTac(new ConsoleReader(), new ConsoleWriter(), new Game());
        Game game = ticTacToe.loadGame();
        //ticTacToe.initializeGame();
        ticTacToe.start(game);
    }
}
