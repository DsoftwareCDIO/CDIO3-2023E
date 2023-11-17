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
        UIController.updateMoneyInAccount(startCapital, this);

        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addGetOutOfJailCard() {
        getOutOfJailCards++;
        UIController.updateGetOutOfJailCards(getOutOfJailCards, true, this);
    }

    public void goToJail(){
        inJail = true;
        piece.setPosition(6);
    }

    //Method to check if a player has a get out of jail card, removed upon landing in jail
    public boolean getOutOfJail(){
        inJail = false;
        if (getOutOfJailCards > 0) {
            getOutOfJailCards--;
            UIController.updateGetOutOfJailCards(getOutOfJailCards, false, this);
            return true;
        }
        return false;
    }

    public void recieveUniqueCard() {
        uniqueCard = true;
        UIController.updateUniqueCards(true, this);
    }

    public boolean useUniqueCardIfPossible(){
        if (uniqueCard) { 
            uniqueCard = false;
            UIController.updateUniqueCards(false, this);
        }
        return uniqueCard;
    }
    
}
