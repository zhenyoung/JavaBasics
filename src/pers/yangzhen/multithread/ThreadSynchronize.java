package pers.yangzhen.multithread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程同步
 *
 * @author yangzhen
 * @create 2021-03-17 10:51
 */
public class ThreadSynchronize {
    public static void main(String[] args) {
        SellTicket sellTicket = new SellTicket();
        Thread window1 = new Thread(sellTicket);
        Thread window2 = new Thread(sellTicket);
        Thread window3 = new Thread(sellTicket);
        window1.setName("窗口 1 ");
        window2.setName("窗口 2 ");
        window3.setName("窗口 3 ");
        window1.start();
        window2.start();
        window3.start();
    }
}

class SellTicket implements Runnable {
    // 3 个窗口剩下的总票数，ticket 被三个 Thread 实例共享
    private int ticket = 100;
    
    // 同步监视器
    private final Object obj = new Object();
    // 不带参数就默认是 false
    private final ReentrantLock seller = new ReentrantLock(true);

//    @Override
//    public void run() {
//        while(true){
//            // 重票问题
////            if(ticket > 0){
////                try {
////                    // 延时 50 ms
////                    Thread.sleep(50);
////                } catch (InterruptedException e) {
////                    e.printStackTrace();
////                }
////                System.out.println(Thread.currentThread().getName() +
////                        "卖票，票号为：" + ticket);
////                ticket--;
////            }else{
////                break;
////            }
//            // 解决方式一：synchronized 同步代码块
//            synchronized (obj){
//                if(ticket > 0){
//                    try {
//                        // 延时 50 ms
//                        Thread.sleep(50);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    System.out.println(Thread.currentThread().getName() +
//                            "卖票，票号为：" + ticket);
//                    ticket--;
//                }else{
//                    break;
//                }
//            }
//        }
//    }
    
    // 解决方式二：同步方法
//    private synchronized void show() {
//        if (ticket > 0) {
//            try {
//                // 延时 50 ms
//                Thread.sleep(50);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println(Thread.currentThread().getName() +
//                    "卖票，票号为：" + ticket);
//            ticket--;
//        }
//    }
//
//    @Override
//    public void run() {
//        while (true){
//            show();
//        }
//    }
    
    // 解决方式三：ReentrantLock 锁
        // 每个 SellTicket 实例都有各自的 ReentrantLock 实例
        // 不同的线程访问不同的 ReentrantLock 实例时，会得到不同的锁对象
    @Override
    public void run() {
        while (true) {
            // 上锁
            seller.lock();
            // try 块中的代码就是临界资源
            try {
                if (ticket > 0) {
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() +
                            "卖票，票号为：" + ticket);
                    ticket--;
                } else {
                    break;
                }
            } finally {
                // 释放锁。先释放锁，再执行 else 中的 break 跳出循环，
                // 这个过程由编译器去优化
                seller.unlock();
            }
        }
    }
}
