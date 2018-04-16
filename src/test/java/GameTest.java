import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameTest {
    private Game game;

    @Before
    public void setUp(){
        game = new Game();
    }

    @Test
    public void gameBoardIsInitialised(){
      assertEquals(GameState.PLAYING, game.getStatus());
    }

    @Test
    public void whenPlayerCapturedARowReturnWinner(){
        game.play(new Coordinates(2,0));
        game.play(new Coordinates(1,0));
        game.play(new Coordinates(2,1));
        game.play(new Coordinates(1,2));
        game.play(new Coordinates(2,2));
        assertEquals(GameState.WIN, game.getStatus());
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenPlayerPlacesMarkerOverAnExistingMarkerShouldThrowException(){
        game.play(new Coordinates(2,0));
        game.play(new Coordinates(1,0));
        game.isValid(new Coordinates(1,0));
    }

    @Test
    public void whenPlayerCapturedAColumnReturnWinner(){
        game.play(new Coordinates(0,0));
        game.play(new Coordinates(0,1));
        game.play(new Coordinates(0,2));
        game.play(new Coordinates(1,1));
        game.play(new Coordinates(1,2));
        game.play(new Coordinates(2,1));
        assertEquals(GameState.WIN, game.getStatus());

    }

    @Test
    public void whenPlayerCapturedADiagonalLeftToRightReturnWinner(){
        game.play(new Coordinates(0,0));
        game.play(new Coordinates(0,1));
        game.play(new Coordinates(1,1));
        game.play(new Coordinates(2,1));
        game.play(new Coordinates(2,2));
       assertEquals(GameState.WIN, game.getStatus());

    }

    @Test
    public void whenPlayerCapturedADiagonalRightToLeftReturnWinner(){
        game.play(new Coordinates(0,2));
        game.play(new Coordinates(0,1));
        game.play(new Coordinates(1,1));
        game.play(new Coordinates(2,1));
        game.play(new Coordinates(2,0));
        assertEquals(GameState.WIN, game.getStatus());
    }

    @Test
    public void shouldSetStatusToDrawAfterGameIsDraw(){
        game.play(new Coordinates(0,0));
        game.play(new Coordinates(0,1));
        game.play(new Coordinates(0,2));
        game.play(new Coordinates(1,0));
        game.play(new Coordinates(1,2));
        game.play(new Coordinates(1,1));
        game.play(new Coordinates(2,1));
        game.play(new Coordinates(2,2));
        game.play(new Coordinates(2,0));// Match is draw here
        assertEquals(GameState.DRAW, game.getStatus());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void shouldThrowExceptionWhenMarkerIsPlacedOutOfBoard(){
        game.play(new Coordinates(0,0));
        game.play(new Coordinates(1,0));
        game.play(new Coordinates(0,1));
        game.isValid(new Coordinates(8,2));

    }

}
