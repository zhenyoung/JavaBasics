package pers.yangzhen.multithread;

/**
 * 使用两个线程交替打印 1~100
 *
 * @author yangzhen
 * @create 2021-03-19 10:14
 */
public class ThreadCommunicate {
    public static void main(String[] args) {
        Number number = new Number();
        Thread t1 = new Thread(number);
        Thread t2 = new Thread(number);
        t1.setName("线程1");
        t2.setName("线程2");
        t1.start();
        t2.start();
    }
}

class Number implements Runnable {
    private int number = 1;
    
    @Override
    public void run() {
        while (true) {
            // 如果调用者是创建的一个对象如 Object obj ，
            // 那么下面调用时就必须加上 obj ，否则默认调用的是 this 当前对象
            synchronized (this) {
                // 调用当前对象 this 的 notify() 随机唤醒一个阻塞线程
                // notifyAll() 则唤醒所有线程
                notify();
                if (number <= 100) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()
                            + "：" + number);
                    number++;
                    try {
                        // 当前对象 this 调用 wait() 阻塞当前线程，并且抛出一个异常
                        wait();
                        // 一旦执行 wait()，线程进入阻塞并释放锁；
                        // 而执行 sleep() 后，线程进入阻塞时不会释放锁
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    break;
                }
            }
        }
    }
}