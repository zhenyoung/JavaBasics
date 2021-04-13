package pers.yangzhen.multiplethread;

/**
 * 练习，需求如下：
 * 银行有一个账户，有两个储户分别向同一个账户存3000元，每次存1000，存3次。每次存完打印账户余额
 * 问题：该程序是否有安全问题，如果有，该如何解决？
 * 提示：1.明确那些代码是多线程运行代码，须写入run()
 *      2.明确什么是共享数据
 *      3.明确多线程运行代码中那些语句是操作共享数据的
 * 拓展问题：可否实现两个储户交替存钱的操作
 *
 * @author yangzhen
 * @create 2021-03-17 17:10
 */

class Account{//账户
    private double balance;

    public Account(double balance) {//初始化余额
        this.balance = balance;
    }

    //存钱
    public synchronized void deposit(double amt){
        if(amt > 0){
            balance += amt;

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + "存钱成功，账户余额为：" + balance);
        }
    }
}

class Customer extends Thread{//储户
    private Account acct;
    public Customer(Account acct){
        this.acct = acct;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {//存3000元
            acct.deposit(1000);//每次存1000
        }
    }
}


public class Exercise {
    public static void main(String[] args) {
        Account acct = new Account(0);
        Customer c1 = new Customer(acct);
        Customer c2 = new Customer(acct);

        //两个储户c1、c2向同一个账户acct存钱

        c1.setName("甲");
        c2.setName("乙");

        c1.start();
        c2.start();
    }
}

