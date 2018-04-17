package ConsoleUI;

import Constants.Messages;
import GameModel.Game;

public class ConsoleWriter implements IWriter {

    @Override
    public void write(String input){ System.out.println(input); }

    public void promptUser(Game game){
        System.out.println(String.format(Messages.MOVE_MESSAGE, game.getCurrentPlayer().getOrder(), game.getCurrentPlayer().getToken()));
    }

    public void startGame(Game game){
        System.out.println(Messages.WELCOME);
        System.out.println(game.printBoard());
    }

}
