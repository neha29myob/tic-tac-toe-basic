import org.junit.Assert;
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
    public void whenPlayer1EnterCoordinatesThenPlaceXonBoard(){
      String[][] expected = {{"x","-","-"},{"-","-","-"},{"-","-","-"}};
      game.placeMarker(0,0);
      Assert.assertArrayEquals(expected,game.getBoard());
      }

    @Test
    public void whenPlayer2EnterCoordinatesThenPlaceOonBoard(){
        String[][] expected = {{"x","-","-"},{"o","-","-"},{"-","x","-"}};
        game.placeMarker(0,0);
        game.placeMarker(1,0);
        game.placeMarker(2, 1);
        Assert.assertArrayEquals(expected,game.getBoard());

    }

    @Test
    public void whenPlayerCapturedTheFirstRowReturnWinner(){
        String[][] expected = {{"x","x","x"},
                               {"o","-","o"},
                               {"-","-","-"}};
        game.placeMarker(0,0);
        game.placeMarker(1,0);
        game.placeMarker(0,1);
        game.placeMarker(1,2);
        game.placeMarker(0,2);
        Assert.assertArrayEquals(expected, game.getBoard());
        assertTrue(game.checkForWin());
    }

    @Test
    public void whenPlayerCapturedAColumnReturnWinner(){
        String[][] expected = {{"x","o","x"},
                               {"-","o","x"},
                               {"-","o","-"}};
        game.placeMarker(0,0);
        game.placeMarker(0,1);
        game.placeMarker(0,2);
        game.placeMarker(1,1);
        game.placeMarker(1,2);
        game.placeMarker(2,1);
        //game.placeMarker(2,0);
        Assert.assertArrayEquals(expected, game.getBoard());
       assertTrue(game.checkForWin());
    }

    @Test
    public void whenAPlayerWinsThenGameIsOver(){
        String[][] expected = {{"x","o","x"},
                               {"-","o","x"},
                               {"-","o","-"}};
        game.placeMarker(0,0);
        game.placeMarker(0,1);
        game.placeMarker(0,2);
        game.placeMarker(1,1);
        game.placeMarker(1,2);
        game.placeMarker(2,1);
        game.placeMarker(2,2);
        Assert.assertArrayEquals(expected, game.getBoard());
        assertTrue(game.isOver());
    }

    @Test
    public void whenMatchIsDrawThenGameIsOver(){
        String[][] expected = {{"x","o","x"},
                               {"o","o","x"},
                               {"x","x","o"}};
        game.placeMarker(0,0);
        game.placeMarker(0,1);
        game.placeMarker(0,2);
        game.placeMarker(1,0);
        game.placeMarker(1,2);
        game.placeMarker(1,1);
        game.placeMarker(2,1);
        game.placeMarker(2,2);
        game.placeMarker(2,0);
        Assert.assertArrayEquals(expected, game.getBoard());
       assertTrue(game.isOver());
    }

}
