package Mocks;

import ConsoleUI.IWriter;

import java.util.ArrayList;
import java.util.List;

public class MockConsoleWriter implements IWriter {
    private List<String> writtenMessages;

    public MockConsoleWriter() {
        writtenMessages = new ArrayList<>();
    }

    @Override
    public void write(String consoleOutput) {
        this.writtenMessages.add(consoleOutput);
    }

    public boolean isMessageWrittenOnConsole(String consoleMessage){
        for(String message : writtenMessages){
            if(message.equals(consoleMessage))
                return true;
        }
        return false;
    }
}
