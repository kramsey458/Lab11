public class Account {
    int balance= 1000;

    public int getBal(){
        return balance;
    }

    public synchronized void withdraw(int bal){
        balance= balance-bal;
    }

    public synchronized void deposit(int bal){
        balance= balance+bal;
    }
}