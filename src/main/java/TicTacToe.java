public class TicTacToe {

    public static void start(ConsoleReader reader){

        Game game = initializeGame(reader);

        while(game.getStatus().equals(GameState.PLAYING)){

            promptUser(game);
            String userChoice = reader.getInput();
            inputResponse(userChoice,game);
        }
    }

    private static Game initializeGame(ConsoleReader reader) {
        System.out.println("Welcome to Tic Tac Toe");
        Game game = null;
        System.out.println("Enter the size of board");
        try {
            int size = Integer.parseInt(reader.getInput());
            System.out.println("Here's the current board");
            game =  new Game(size);
            System.out.println(game.printBoard());

        } catch (NumberFormatException ex){
            System.out.println("Invalid format "  + ex.getMessage());
        }
        return game;
    }


    private static void promptUser(Game game) {
        System.out.printf("Player %d enter a coord x,y to place your %s or enter 'q' to give up:", game.getOrderOfCurrentPlayer(), game.getTokenOfCurrentPlayer());
    }

    private static void inputResponse(String userChoice, Game game){

        if(userChoice.equalsIgnoreCase("q")){
            System.out.println("The game is exiting");
            System.exit(0);
        }

        if(Coordinates.isValidFormat(userChoice)){
            Coordinates coordinates = Coordinates.convertInput(userChoice);

            if(game.isOutOfBound(coordinates)){
                System.out.println("\n Bounds exceeded! Marker is placed out of the board!");
                return;
            }

            if(game.isOccupied(coordinates)){
                System.out.println("\n Oh no, a piece is already at this place! Try again...");
                return;
            }

            else{
                game.play(coordinates);
                printGameStatus(game);
            }
        }

        else {
            System.out.println("Invalid input! Try x,y to place your marker or enter 'q' to give up:");
        }
    }

    private static void printGameStatus(Game game) {
        //game.play(coordinates);

        if (game.getStatus().equals(GameState.WIN)) {
            System.out.println("Move accepted, well done you've won the game!");
            //return;
        }
        if (game.getStatus().equals(GameState.DRAW)){
            System.out.println("Move accepted, It's a Draw!!");
            return;
        }
        else {
            System.out.println("Move accepted, here's the current board");
        }
        System.out.println(game.printBoard());

    }

}
