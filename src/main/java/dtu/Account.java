package dtu;

public class Account {
    private int money;

    //Constructor of account, only keeps track of money in account
    public Account(int startCapital){
        money = startCapital;
    }

    //getMoney method
    public int getMoney() {
        return money;
    }

    //Changemoney method, positive or negative
    public boolean changeMoney(int money) {
        if (this.money + money >= 0) {
            this.money += money;
            return true;
        }
        this.money = 0;
        return false;
    }
}
