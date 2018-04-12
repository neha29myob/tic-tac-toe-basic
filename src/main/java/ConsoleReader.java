import java.util.Scanner;

public class ConsoleReader {

    private Scanner scanner;

    public ConsoleReader(Scanner scanner) {
        this.scanner = scanner;
    }

    public String getInput(){
        return scanner.nextLine();

    }
}
