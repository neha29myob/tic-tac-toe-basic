import GameModel.Game;
import GameService.GameConfiguration;
import Mocks.MockConsoleReader;
import Mocks.MockConsoleWriter;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class GameConfigurationTest {
    private MockConsoleReader mockConsoleReader;
    private MockConsoleWriter mockConsoleWriter;
    private GameConfiguration gameConfiguration;

    @Before
    public void setUp(){
        mockConsoleReader = new MockConsoleReader();
        mockConsoleWriter = new MockConsoleWriter();
        gameConfiguration = new GameConfiguration(mockConsoleReader, mockConsoleWriter);
    }

    @Test
    public void whenNoCustomizationReturnDefaultGame(){
        List<String> userInputs = new ArrayList<>();
        userInputs.add("n");
        mockConsoleReader.undecided(userInputs);

        Game expectedGame = new Game();

        Game actualGame = gameConfiguration.loadGame();

        assertEquals(expectedGame.getCurrentPlayer().getToken(), actualGame.getCurrentPlayer().getToken());
        assertEquals(expectedGame.getCurrentPlayer().getOrder(), actualGame.getCurrentPlayer().getOrder());
        assertEquals(expectedGame.printBoard(), actualGame.printBoard());
    }

    @Test
    public void whenReturnGame(){
        List<String> userInputs = new ArrayList<>();

        userInputs.add("y");
        userInputs.add("4");
        userInputs.add("P1");
        userInputs.add("P2");
        userInputs.add("2");

        mockConsoleReader.undecided(userInputs);

        Game actualGame = gameConfiguration.loadGame();

        assertEquals(4, actualGame.getBoard().getBoardSize());
        assertEquals("P1", actualGame.getPlayer1().getToken());
        assertEquals("P2", actualGame.getPlayer2().getToken());
        assertEquals("P2", actualGame.getCurrentPlayer().getToken());
        assertEquals(2, actualGame.getCurrentPlayer().getOrder());
    }
}
