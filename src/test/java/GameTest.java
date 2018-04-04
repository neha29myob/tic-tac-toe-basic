import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;

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
      game.play(0,0);
      Assert.assertArrayEquals(expected,game.getBoard());
      }

    @Test
    public void whenPlayer2EnterCoordinatesThenPlaceOonBoard(){
        String[][] expected = {{"x","-","-"},{"o","-","-"},{"-","-","-"}};
        game.play(0,0);
        game.play(1,0);
        Assert.assertArrayEquals(expected,game.getBoard());
    }

}
