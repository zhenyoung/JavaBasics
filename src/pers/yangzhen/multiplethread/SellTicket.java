package pers.yangzhen.multiplethread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 3个窗口卖票（涉及线程安全）
 *
 * @author yangzhen
 * @create 2021-03-17 10:51
 */
public class SellTicket {
    public static void main(String[] args) {
        Window window = new Window();

        Thread thread1 = new Thread(window);
        Thread thread2 = new Thread(window);
        Thread thread3 = new Thread(window);
        thread1.setName("窗口1");
        thread2.setName("窗口2");
        thread3.setName("窗口3");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}

//iostream Window implements Runnable {
//    private int ticket = 100;//3个窗口剩下的总票数，ticket被三个Thread类型的对象共享
//    Object obj = new Object();
//    @Override
//    public void run() {
//        while (true) {
//            synchronized (obj) {
//                if (ticket > 0) {
//                    try {
//                        Thread.sleep(100);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    System.out.println(Thread.currentThread().getName() + "卖票，票号为：" + ticket);
//
//                    ticket--;
//                } else {
//                    break;
//                }
//            }
//        }
//    }
//}


/**
 * 通过Lock锁的方式
 */
class Window implements Runnable {
    private int ticket = 100;//3个窗口剩下的总票数，ticket被三个Thread类型的对象共享

    private ReentrantLock lock = new ReentrantLock(true);//不带参数就默认是false

    @Override
    public void run() {
        while (true) {
            try {
                //调用锁定方法lock()
                lock.lock();
                if (ticket > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "卖票，票号为：" + ticket);
                    ticket--;
                } else {
                    break;
                }
            } finally {
                //调用解锁方法unlock()
                lock.unlock();
            }
        }
    }
}