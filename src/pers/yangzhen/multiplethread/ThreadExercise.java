package pers.yangzhen.multiplethread;

/**
 * 练习：创建两个线程，一个输出50以内的偶数，另一个输出50以内的奇数
 *
 * @author yangzhen
 * @create 2021-03-15 19:41
 */
public class ThreadExercise {
    public static void main(String[] args) {
        MyThread1 myThread1 = new MyThread1();
        MyThread2 myThread2 = new MyThread2();
        myThread1.start();
        myThread2.start();

        //如果子类只使用一次，可以考虑创建Thread类的匿名子类的方式
        new Thread(){
            @Override
            public void run() {
                System.out.println(currentThread().getName() + "\t匿名子类的线程2");
            }
        }.start();
        new Thread(){
            @Override
            public void run() {
                System.out.println(currentThread().getName() + "\t你名字类的线程3");
            }
        }.start();
    }
}

class MyThread1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            if (i % 2 == 0) {
                System.out.println(currentThread().getName() + "\t偶数" + i);
            }
        }
    }
}

class MyThread2 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            if (i % 2 == 1) {
                System.out.println(currentThread().getName() + "\t奇数" + i);
            }
        }
    }
}