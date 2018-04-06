import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GameTest {
    private Game game;

    @Before
    public void setUp(){
        game = new Game(3);
    }

    @Test
    public void gameBoardIsInitialised(){
      assertFalse(game.isOver());
    }


    @Test
    public void whenPlayerCapturedARowReturnWinner(){
        game.play(2,0);
        game.play(1,0);
        game.play(2,1);
        game.play(1,2);
        game.play(2,2);
        assertTrue(game.isOver());
    }

    @Test
    public void whenPlayerCapturedAColumnReturnWinner(){

        game.play(0,0);
        game.play(0,1);
        game.play(0,2);
        game.play(1,1);
        game.play(1,2);
        game.play(2,1);
       assertTrue(game.isOver());
    }

    @Test
    public void whenPlayerCapturedADiagonalLeftToRightReturnWinner(){
        game.play(0,0);
        game.play(0,1);
        game.play(1,1);
        game.play(2,1);
        game.play(2,2);
       assertTrue(game.isOver());
    }

    @Test
    public void whenPlayerCapturedADiagonalRightToLeftReturnWinner(){
        game.play(0,2);
        game.play(0,1);
        game.play(1,1);
        game.play(2,1);
        game.play(2,0);
       assertTrue(game.isOver());
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenMarkerIsPlacedAfterTheGameIsWon(){
        game.play(0,0);
        game.play(1,0);
        game.play(0,1);
        game.play(1,2);
        game.play(0,2); //player already won here
        game.play(2,0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenMarkerIsPlacedAfterTheGameIsDraw(){
        game.play(0,0);
        game.play(0,1);
        game.play(0,2);
        game.play(1,0);
        game.play(1,2);
        game.play(1,1);
        game.play(2,1);
        game.play(2,2);
        game.play(2,0); // Match is draw here
        game.play(2,0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void shouldThrowExceptionWhenMarkerIsPlacedOutOfBoard(){
        game.play(0,0);
        game.play(1,0);
        game.play(0,1);
        game.play(8,2);

    }

}
