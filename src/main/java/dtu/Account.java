package dtu;

public class Account {
    private int money;

    public Account(int startCapital){
        money = startCapital;
    }

    public int getMoney() {
        return money;
    }

    public void changeMoney(int money) {
        this.money += money;
    }
}
