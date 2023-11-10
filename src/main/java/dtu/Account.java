package dtu;

public class Account {
    private int money;

    public Account(int startCapital){
        money = startCapital;
    }

    public int getMoney() {
        return money;
    }

    public boolean changeMoney(int money) {
        if (this.money >= money) {
            this.money += money;
            return true;
        }
        return false;
    }
}
