package pers.yangzhen.multiplethread;

/**
 * 线程之间的通信：使用两个线程打印1~100.线程1和线程2交替打印
 *
 * @author yangzhen
 * @create 2021-03-19 10:14
 */
public class Communication {
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
            synchronized (this) {//如果调用者是创建的一个对象如 Object obj ，那么下面调用时就必须加上obj，否则默认调用的是this当前对象

                //调用者默认是this
                notify();//唤醒优先级高的其他线程，notifyAll()唤醒所有线程
                if (number <= 100) {

                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + "：" + number);
                    number++;
                    try {
                        //this调用wait()的线程进入阻塞状态
                        wait();//wait()会抛出一个异常
                        // 一旦执行wait()，线程进入阻塞并释放锁；而执行sleep()后，线程进入阻塞时不会释放锁
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