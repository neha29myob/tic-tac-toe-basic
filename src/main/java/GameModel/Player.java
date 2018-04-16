package GameModel;

public class Player {
    //X("x"),
    //O("o");
    private String token;
    private int order;

    public Player(int order,String token){
        this.token = token;
        this.order = order;
    }

    public String getToken() {
        return token;
    }

    public int getOrder() {
        return order;
    }
}
