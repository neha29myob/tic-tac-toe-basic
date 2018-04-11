import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Tic Tac Toe");
        System.out.println("Enter the size of board");
        int size = Integer.parseInt(scanner.nextLine());
        System.out.println("Here's the current board");
        Game game =  new Game(size);
        System.out.println(game.printBoard());

        //initializeGame(scanner);


        while(game.getStatus().equals(GameState.PLAYING)){

            System.out.printf("Player %d enter a coord x,y to place your %s or enter 'q' to give up:", game.getOrderOfCurrentPlayer(), game.getTokenOfCurrentPlayer());

            String coordinates = scanner.nextLine();
            Coordinates input = Coordinates.convertInput(coordinates);

            if(game.isValid(input)) {
                game.play(input);
                if (game.getStatus().equals(GameState.WIN)) {
                    System.out.println("Move accepted, well done you've won the game!");
                } else {
                    System.out.println("Move accepted, here's the current board");

                }
                System.out.println(game.printBoard());
            }

        }

    }


}
