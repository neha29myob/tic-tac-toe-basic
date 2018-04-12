import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        ConsoleReader reader = new ConsoleReader(new Scanner(System.in));
        TicTacToe.start(reader);
    }
}
