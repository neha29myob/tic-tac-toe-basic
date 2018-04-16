import Constants.Messages;
import GameModel.Game;
import GameService.Validator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ValidatorTest {
    private Game game;

    @Before
    public void setUp(){
        game = new Game();
    }

    @Test
    public void whenQThenReturnExitMessage(){
        Assert.assertEquals(Validator.validatePlayerChoice("q", game), Messages.QUIT_GAME);
    }

    @Test
    public void whenInvalidChoiceThenReturnInvalidInputMessage(){
        Assert.assertEquals(Validator.validatePlayerChoice("bbb", game),Messages.INVALID_INPUT);
    }

    @Test
    public void whenValidMoveThenReturnMoveAcceptedMessage(){
        Assert.assertEquals(Validator.validatePlayerChoice("1,2", game),Messages.ACCEPTED_MOVE);
    }

    @Test
    public void whenMoveOutOfBoundsThenReturnOutOfBoundMessage(){
        Assert.assertEquals(Validator.validatePlayerChoice("8,9", game),Messages.OUT_OF_BOUND);
    }

    @Test
    public void whenMoveOnOccupiedSpotThenReturnSpotTakenMessage(){
        Assert.assertEquals(Validator.validatePlayerChoice("8,9", game),Messages.OUT_OF_BOUND);
    }

}
