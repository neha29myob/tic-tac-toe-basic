public enum Player {
    X("x"),
    O("o");
    private final String token;

    Player(String token){
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
