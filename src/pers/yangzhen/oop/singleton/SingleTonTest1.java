package pers.yangzhen.oop.singleton;

//单例模式的饿汉式实现
public class SingleTonTest1 {
    public static void main(String[] args) {
        Bank bank1 = Bank.getInstance();
        Bank bank2 = Bank.getInstance();
        System.out.println(bank1 == bank2);
    }
}


//饿汉式
class Bank{
    //1.私有化类的构造器
    private Bank(){

    }

    //2.内部创建类的对象，对象也必须声明成static以被静态的方法调用
    private static Bank instance = new Bank();//先造好对象，饿

    //3.提供公共的方法，返回类的对象
    public static Bank getInstance(){
        return instance;
    }

}