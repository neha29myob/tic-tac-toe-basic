package ConsoleUI;

import java.util.Scanner;

public class ConsoleReader implements IReader{

    private Scanner scanner;

    public ConsoleReader() {
        scanner = new Scanner(System.in);
    }

    @Override
    public String getInput(){
        return scanner.nextLine().trim();
    }
}
