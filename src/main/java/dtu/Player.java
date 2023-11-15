package dtu;

public class Player {
    public final Account account;
    public final Piece piece;

    private int getOutOfJailCards = 0;
    private boolean uniqueCard = false;
    private String name;

    protected boolean inJail = false;

    public Player(String name, int startCapital){
        piece = new Piece();
        account = new Account(startCapital);

        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addGetOutOfJailCard() {
        getOutOfJailCards++;
    }

    public void goToJail(){
        inJail = true;
        piece.setPosition(6);
    }

    public boolean getOutOfJail(){
        inJail = false;
        if (getOutOfJailCards > 0) {
            getOutOfJailCards--;
            return true;
        }
        return false;
    }

    public void recieveUniqueCard() {
        uniqueCard = true;
    }

    public boolean useUniqueCard(){
        uniqueCard = false;
        return uniqueCard;
    }
}
