package pers.yangzhen.multithread;

/**
 * 练习，需求如下：
 * 银行有一个账户，有两个储户(假设是你妈和你媳妇儿)，交替地向你的账户存 10000 元，
 * 每次存 1000，存 10 次。每次存完打印账户余额。
 *
 * @author yangzhen
 * @create 2021-03-17 17:10
 */
public class ThreadExercise {
    public static void main(String[] args) {
        Account me = new Account(0);
        Customer wife = new Customer(me);
        Customer mom = new Customer(me);
        // 两个储户 wife 、 mom 向同一个账户 me 存钱
        wife.setName("老婆");
        mom.setName("妈妈");
        wife.start();
        mom.start();
    }
}

class Account {
    private double balance;
    
    public Account(double balance) {//初始化余额
        this.balance = balance;
    }
    
    // 存钱
    public synchronized void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() +
                    "存钱成功，账户余额为 " + balance);
        }
    }
}

class Customer extends Thread {
    private final Account account;
    
    public Customer(Account account) {
        this.account = account;
    }
    
    @Override
    public void run() {
        // 总共存 10000 元
        for (int i = 0; i < 10; i++) {
            // 每次存 1000，存 10 次
            account.deposit(1000);
        }
    }
}