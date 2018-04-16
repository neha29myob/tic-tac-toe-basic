import ConsoleUI.ConsoleReader;
import ConsoleUI.ConsoleWriter;
import GameService.ApplicationTicTac;

public class Main {

    public static void main(String[] args) {

        ConsoleReader consoleReader =  new ConsoleReader();
        ConsoleWriter consoleWriter = new ConsoleWriter();

        ApplicationTicTac ticTacToe = new ApplicationTicTac(consoleReader, consoleWriter);

        ticTacToe.start();
    }
}
