package GameService;

import ConsoleUI.ConsoleReader;
import ConsoleUI.ConsoleWriter;
import Constants.Messages;
import GameModel.Coordinates;
import GameModel.Game;
import GameModel.GameState;

public class ApplicationTicTac {

    private ConsoleReader reader;
    private ConsoleWriter writer;
    private Game game;
    private boolean isNextRound;

    public ApplicationTicTac(ConsoleReader reader, ConsoleWriter writer) {
        this.reader = reader;
        this.writer = writer;
        isNextRound = true;
    }

    public void start(){

        while(isNextRound){
            isNextRound = false;
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

    public void run(){

        writer.startGame(game);
        while(game.getStatus().equals(GameState.PLAYING)){
            writer.promptUser(game);
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
