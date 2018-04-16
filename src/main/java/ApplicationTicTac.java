import ConsoleUI.ConsoleReader;
import ConsoleUI.ConsoleWriter;
import Constants.Messages;

public class ApplicationTicTac {

    private ConsoleReader reader;
    private ConsoleWriter writer;
    private Game game;

    public ApplicationTicTac(ConsoleReader reader, ConsoleWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }

    public void start(Game game){
        this.game = game;
        writer.write(Messages.WELCOME);
        writer.write(game.printBoard());

        while(game.getStatus().equals(GameState.PLAYING)){
            promptUser();
            String userChoice = reader.getInput();
            inputResponse(userChoice);
        }
    }

    private void promptUser() {
        writer.write(String.format(Messages.MOVE_MESSAGE, game.getOrderOfCurrentPlayer(), game.getTokenOfCurrentPlayer()));
    }

    private void inputResponse(String userChoice){

        String responseMessage = Validator.validatePlayerChoice(userChoice,game);

        if(responseMessage.equals(Messages.ACCEPTED_MOVE)){
            Coordinates coordinates = Coordinates.convertInput(userChoice);
            game.play(coordinates);
            printGameStatus();
        }
        if (responseMessage.equals(Messages.QUIT_GAME)) System.exit(0);
        else {
            writer.write(responseMessage);
        }
    }

    private void printGameStatus() {

        if (game.getStatus().equals(GameState.WIN)) writer.write(Messages.WIN_MESSAGE);
        if (game.getStatus().equals(GameState.DRAW)) writer.write(Messages.DRAW_MESSAGE);
        writer.write(game.printBoard());
    }

}
