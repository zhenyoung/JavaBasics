package pers.yangzhen.exercises;

public class AccountTest{
//    ①创建一个Customer，名字叫Jane Smith，他有一个账号，id为1000，余额为2000元，年利率为1.23%的账户
//    ②对Jane Smith操作：存入100元，再取出960元，再取出2000元，打印Jane Smith的基本信息
//    示例如下：
//    成功存入：100.0
//    成功取出：960.0
//    余额不足，取款失败
//    Customer Jane Smith has a account id is 1000, annualInterestRate is 1.23%, balance is 1140.0

    public static void main(String[] args) {
        Customer cust = new Customer("Jane","Smith");
        Account acct = new Account(1000,2000,0.0123);
        cust.setAccount(acct);
        cust.getAccount().deposit(100);//余额2000，存入100，余额为2100，成功存入
        cust.getAccount().withdraw(960);//余额2100，取出960，余额1140，成功取出
        cust.getAccount().withdraw(2000);//余额1140，取出2000，余额不足
        System.out.println("Customer " + cust.getFirstName() + cust.getLastName() + " has a account id is " + cust.getAccount().getId()
                + ", annualInterestRate is " + cust.getAccount().getAnnualInterestRate()*100 + "%, balance is " + cust.getAccount().getBalance() + "\n");

    }

}

/*关于银行账户，可以理解为：
银行有多个没有设置个人信息的空账户，只有一个id号来将所有的空账户区别开。账户里面有多项关于账户金额的属性，以及可对这些属性进行的一些操作（方法），但是都是默认值为0。
而从银行申请一张银行卡就相当于将账户的个人信息（姓名，年龄，手机号码等...）填上，并且根据存钱和取钱数来改变账户中的属性。
即 用户账号 = 用户个人信息 + 空账号

所以创建2个类，一个用于设置空账户应具有哪些属性，另一个用于设置用户的个人信息
*/

class Account {

    private int id;
    private double balance;
    private double annualInterestRate;

    public Account(int id, double balance, double annualInterestRate) {
        this.id = id;
        this.balance = balance;
        this.annualInterestRate = annualInterestRate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    //在withdraw方法中，需要判断用户余额是否能够满足提款数额的要求，如果不能，应给出提示
    public void withdraw(double amount) {//取钱
        if (balance < amount) {//余额小于取钱数
            System.out.println("您想取出" + amount + "元，但余额不足，取款失败");
        } else {
            balance -= amount;
            System.out.println("成功取出：" + amount);
        }
    }

    public void deposit(double amount) {//存钱
        if (amount > 0) {
            balance += amount;
            System.out.println("成功存入：" + amount);
        }
    }

}

//用户账号 = 用户个人信息 + 空账号
class Customer{
    private String firstName;
    private String lastName;
    private Account account;

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public Account getAccount() {
        return this.account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Customer(String f, String l) {
        this.firstName = f;
        this.lastName = l;
    }
}
