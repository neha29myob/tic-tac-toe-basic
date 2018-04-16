import Constants.Command;
import Constants.Messages;

public class Validator {

    public static String validatePlayerChoice(String playerChoice, Game game) {

        if (playerChoice.equalsIgnoreCase(Command.QUIT)) {
            return Messages.QUIT_GAME;
        } else {
            return validatePlayerMove(playerChoice, game);
        }
    }

    private static String validatePlayerMove(String playerMove, Game game) {
        if (Coordinates.isValidFormat(playerMove)) {
            Coordinates coordinates = Coordinates.convertInput(playerMove);

            if (game.isOutOfBound(coordinates)) return Messages.OUT_OF_BOUND;
            if (game.isOccupied(coordinates)) return Messages.OCCUPIED_SPOT;
            else {
                return Messages.ACCEPTED_MOVE;
            }

        } else {
            return Messages.INVALID_INPUT;
        }

    }
}
