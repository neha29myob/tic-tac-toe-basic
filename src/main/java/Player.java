public class Player {
    //X("x"),
    //O("o");
    private String token;
    private int order;

    Player(int order,String token){
        this.token = token;
        this.order = order;
    }

    public String getToken() {
        return token;
    }

    public void setOrder(int order){
        this.order = order;
    }
    public int getOrder() {
        return order;
    }
}
