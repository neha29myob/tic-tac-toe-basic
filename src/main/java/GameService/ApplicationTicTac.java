package GameService;

import ConsoleUI.IReader;
import ConsoleUI.IWriter;
import Constants.Messages;
import GameModel.Coordinates;
import GameModel.Game;
import GameModel.GameState;

public class ApplicationTicTac {

    private IReader reader;
    private IWriter writer;
    private Game game;
    private boolean isNextRound;
    private boolean isPlaying;

    public ApplicationTicTac(IReader reader, IWriter writer) {
        this.reader = reader;
        this.writer = writer;
        isNextRound = true;
        isPlaying = true;
    }

    public void start(){
        while(isNextRound){
            isNextRound = false;
            isPlaying = true;
            GameConfiguration gameConfiguration = new GameConfiguration(reader,writer);
            game = gameConfiguration.loadGame();
            run();
            nextRoundResponse();
        }
    }

    private void nextRoundResponse() {
        writer.write(Messages.NEXT_ROUND);
        String nextRoundResponse = reader.getInput();
        if(nextRoundResponse.equalsIgnoreCase("y")){
            isNextRound = true;
        }
    }

    private void run(){

       writer.write(Messages.WELCOME);
       writer.write(game.printBoard());

        while(isPlaying){
            writer.write(String.format(Messages.MOVE_MESSAGE, game.getCurrentPlayer().getOrder(), game.getCurrentPlayer().getToken()));
            String userChoice = reader.getInput();
            inputResponse(userChoice);
        }
    }

    private void inputResponse(String userChoice){

        String responseMessage = Validator.validatePlayerChoice(userChoice,game);

        if(responseMessage.equals(Messages.ACCEPTED_MOVE)){
            Coordinates coordinates = Coordinates.convertInput(userChoice);
            game.play(coordinates);
            printGameStatus();
        }
        if (responseMessage.equals(Messages.QUIT_GAME)){
            isPlaying = false;

        }
        else {
            writer.write(responseMessage);
        }
    }

    private void printGameStatus() {
        if (game.getStatus().equals(GameState.WIN)) {
            isPlaying =false;
            writer.write(Messages.WIN_MESSAGE);
        }
        if (game.getStatus().equals(GameState.DRAW)) {
            writer.write(Messages.DRAW_MESSAGE);
            isPlaying =false;
        }

        writer.write(game.printBoard());
    }
}
