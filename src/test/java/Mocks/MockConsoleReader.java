package Mocks;

import ConsoleUI.IReader;
import java.util.List;

public class MockConsoleReader implements IReader {

    private List<String> userInputs;
    private int count = 0;

    @Override
    public String getInput() {
        String input = userInputs.get(count);
        count ++;
        return input;
    }

    public void setUserInput(List<String> userInputs) {
        this.userInputs = userInputs;
    }
}
