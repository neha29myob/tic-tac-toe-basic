import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Tic Tac Toe");
        System.out.println("here's the current board");
        Game game =  new Game(3);
        System.out.println(game.printBoard());

        while(game.getStatus().equals(GameState.PLAYING)){
            System.out.println(game.getTokenOfCurrentPlayer() + "enter a coord x,y to place your X or enter 'q' to give up:");
            String coordinates = scanner.next();
            Coordinates input = Coordinates.convertInput(coordinates);

            if(game.isValid(input)) {
                game.play(input);
                if (game.getStatus().equals(GameState.WIN)) {
                    System.out.println("Move accepted, Well Done");
                } else {
                    System.out.println("Move accepted, here's the current board");

                }
                System.out.println(game.printBoard());
            }

        }


    }


}
