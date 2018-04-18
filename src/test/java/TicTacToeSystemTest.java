import Constants.Messages;
import GameService.ApplicationTicTac;
import Mocks.MockConsoleReader;
import Mocks.MockConsoleWriter;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class TicTacToeSystemTest {
    private MockConsoleReader mockConsoleReader;
    private MockConsoleWriter mockConsoleWriter;
    private ApplicationTicTac ticTac;

    @Before
    public void setUp(){
        mockConsoleReader = new MockConsoleReader();
        mockConsoleWriter = new MockConsoleWriter();
        ticTac = new ApplicationTicTac(mockConsoleReader,mockConsoleWriter);
    }

    @Test
    public void whenLoadDefaultGamePrintInitialMessages(){
        List<String> userInputs = new ArrayList<>();

        userInputs.add("n");// customize game
        userInputs.add("q"); // player give up
        userInputs.add("n"); // next round

        mockConsoleReader.setUserInput(userInputs);
        ticTac.start();
        assertTrue(mockConsoleWriter.isMessageWrittenOnConsole(Messages.CUSTOMIZE_GAME));
        assertTrue(mockConsoleWriter.isMessageWrittenOnConsole(Messages.WELCOME));
    }

    @Test
    public void whenLoadCustomGamePrintInitialMessages(){
        List<String> userInputs = new ArrayList<>();

        userInputs.add("n");// customize game
        userInputs.add("q"); // player give up
        userInputs.add("n"); // next round

        mockConsoleReader.setUserInput(userInputs);
        ticTac.start();
        assertTrue(mockConsoleWriter.isMessageWrittenOnConsole(Messages.CUSTOMIZE_GAME));
        assertTrue(mockConsoleWriter.isMessageWrittenOnConsole(Messages.WELCOME));
    }

    @Test
    public void whenInvalidMovesPrintAppropriateMessages(){
        List<String> userInputs = new ArrayList<>();

        userInputs.add("n"); // customize game
        userInputs.add("a,2"); // Invalid input
        userInputs.add("9,2"); // Out of Bound
        userInputs.add("1,2");
        userInputs.add("1,2"); //Spot taken
        userInputs.add("q"); // player give up
        userInputs.add("n"); // next round

        mockConsoleReader.setUserInput(userInputs);
        ticTac.start();
        assertTrue(mockConsoleWriter.isMessageWrittenOnConsole(Messages.INVALID_INPUT));
        assertTrue(mockConsoleWriter.isMessageWrittenOnConsole(Messages.OUT_OF_BOUND));
        assertTrue(mockConsoleWriter.isMessageWrittenOnConsole(Messages.OCCUPIED_SPOT));
        assertTrue(mockConsoleWriter.isMessageWrittenOnConsole(Messages.NEXT_ROUND));
    }

    @Test
    public void whenAcceptedMovesPrintMoveAcceptedMessage(){
        List<String> userInputs = new ArrayList<>();

        userInputs.add("n");
        userInputs.add("1,1");
        userInputs.add("2,1");
        userInputs.add("q");
        userInputs.add("n");

        mockConsoleReader.setUserInput(userInputs);
        ticTac.start();
        assertTrue(mockConsoleWriter.isMessageWrittenOnConsole(Messages.ACCEPTED_MOVE));
    }

    @Test
    public void whenWinningMovesPrintWinMessage(){
        List<String> userInputs = new ArrayList<>();

        userInputs.add("n");
        userInputs.add("1,1");
        userInputs.add("2,1");
        userInputs.add("1,2");
        userInputs.add("3,1");
        userInputs.add("1,3");
        userInputs.add("n");

        mockConsoleReader.setUserInput(userInputs);
        ticTac.start();
        assertTrue(mockConsoleWriter.isMessageWrittenOnConsole(Messages.WIN_MESSAGE));
    }

    @Test
    public void whenDrawPrintDrawMessage(){
        List<String> userInputs = new ArrayList<>();
        userInputs.add("n");
        userInputs.add("1,1");
        userInputs.add("1,3");
        userInputs.add("1,2");
        userInputs.add("2,1");
        userInputs.add("2,3");
        userInputs.add("2,2");
        userInputs.add("3,1");
        userInputs.add("3,2");
        userInputs.add("3,3");
        userInputs.add("n");

        mockConsoleReader.setUserInput(userInputs);
        ticTac.start();
        assertTrue(mockConsoleWriter.isMessageWrittenOnConsole(Messages.DRAW_MESSAGE));
    }
}
