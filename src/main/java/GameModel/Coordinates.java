package GameModel;

public class Coordinates {
    private int x;
    private int y;

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static Coordinates convertInput(String input){
        String[] position = input.split(",");
        return new Coordinates(Integer.parseInt(position[0])-1, Integer.parseInt(position[1])-1);
    }

    public static boolean isValidFormat(String input){
        return input.matches("([0-9]+),([0-9]+)");
        }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return x == that.x &&
                y == that.y;
    }

}
