package dtu.game;

public class TransactionImpossibleException extends Exception { 
    protected Player loser;
    public TransactionImpossibleException(Player player) {
        loser = player;
    };
}
