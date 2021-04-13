package pers.yangzhen.multiplethread;

/**
 * 多线程的创建，方式一：继承于Thread类
 * 举例：穷举100以内的偶数
 *
 * @author yangzhen
 * @create 2021-03-15 18:32
 */
public class ThreadTest1 {
    public static void main(String[] args) {
        //3.创建Thread类的子类对象
        MyThread t1 = new MyThread();
        //4.通过此对象调用start()：①启动当前新建的线程	②调用当前线程的run()
        t1.start();
        //问题一：直接调用run()不能启动新建的线程
        //t1.run();

        //问题二：再启动一个线程，遍历100以内的偶数
//        t1.start();//报异常IllegalThreadStateException，所以不能让已经start()的线程去执行
        //我们需要重新创建一个线程的对象
        MyThread t2 = new MyThread();
        t2.start();

        //如下操作仍然是在main线程中执行的
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println("**********main**********");
            }
        }
    }
}

//1.创建一个继承于Thread类的子类
class MyThread extends Thread {
    //2.重写Thread类的run()
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + "：" + i + "**********main**********");
            }
        }

    }
}
