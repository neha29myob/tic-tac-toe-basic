import GameModel.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GameTest {
    private Game game;

    @Before
    public void setUp(){
        game = new Game();
    }

    @Test
    public void defaultGameInitialized(){
        assertEquals("- - - \n- - - \n- - - \n", game.printBoard());
        assertEquals("X", game.getPlayer1().getToken());
        assertEquals("O", game.getPlayer2().getToken());
    }

    @Test
    public void customGameInitialized(){
        Player player1 = new Player(1,"A");
        Player player2 = new Player(2, "B");
        Board board = new Board(4);
        game = new Game(player1, player2, board,2);
        assertEquals("- - - - \n- - - - \n- - - - \n- - - - \n", game.printBoard());
        assertEquals("B", game.getCurrentPlayer().getToken());
    }

    @Test
    public void whenPlayerPlaceMarkersUpdateBoard(){
        game.play(new Coordinates(2,0));
        game.play(new Coordinates(1,0));
        assertEquals("- - - \nO - - \nX - - \n", game.printBoard());
    }

    @Test
    public void whenPlayerPlaceMarkersChangePlayers(){
        game.play(new Coordinates(2,0));
        game.play(new Coordinates(1,0));
        assertEquals("X", game.getCurrentPlayer().getToken());
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

    @Test
    public void whenSpotTakenReturnTrueForIsOccupied(){
        game.play(new Coordinates(2,0));
        game.play(new Coordinates(1,0));
        assertTrue(game.isOccupied(new Coordinates(1,0)));
    }

    @Test
    public void whenOutOfBoundReturnTrueForIsOccupied(){
        game.play(new Coordinates(0,0));
        game.play(new Coordinates(1,0));
        game.play(new Coordinates(0,1));
        game.isOutOfBound(new Coordinates(8,2));
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

}
