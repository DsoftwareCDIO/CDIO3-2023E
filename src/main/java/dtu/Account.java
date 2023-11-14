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
        if (this.money + money >= 0) {
            this.money += money;
            return true;
        }
        this.money = 0;
        return false;
    }
}
