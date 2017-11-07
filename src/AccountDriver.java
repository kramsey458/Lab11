public class AccountDriver implements Runnable{

    Account acc = new Account();

    public static void main(String[] args) {
        AccountDriver test = new AccountDriver();
        Thread t1 = new Thread(test, "person 1");
        Thread t2 = new Thread(test, "person 2");
        Thread t3 = new Thread(test, "person 3");
        t1.start();
        t2.start();
        t3.start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 1; i++) {
            makeWithdraw(1);
            if (acc.getBal() < 0) {
                System.out.println("account is overdrawn!");
            }
            deposit(200);
        }
        System.out.println(Thread.currentThread().getName() + " has finished");
        System.out.println("Balance: " + acc.getBal());
    }


    private synchronized void makeWithdraw(int bal){
        if (acc.getBal()>=bal) {
            System.out.println(Thread.currentThread().getName()+" "+ "is try to withdraw");
            try {
                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }
            acc.withdraw(bal);
            System.out.println(Thread.currentThread().getName()+" "+ "has completed the withdraw");
        }else{
            System.out.println(Thread.currentThread().getName()+ " "+"doesn't have enough money for withdrawal");
        }
    }

    private synchronized void deposit(int bal){
        if (bal>0) {
            System.out.println(Thread.currentThread().getName()+" "+ " is trying to deposit");
            try {
                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }
            acc.deposit(bal);
            System.out.println(Thread.currentThread().getName()+" "+ "is complete the deposit");
        }else{
            System.out.println(Thread.currentThread().getName()+ " "+"doesn't have enough money for deposit");
        }
    }
}
