package pers.yangzhen.multithread;

import org.junit.Test;

/**
 * 多线程的创建：以穷举 100 以内的偶数为例
 *
 * @author yangzhen
 * @create 2021-03-15 18:32
 */
public class CreateThread1 {
    @Test
    public void test1() {
        // 2. 调用 start()
        new MyThread().start();
        // 如下操作仍然是在 test1 线程中执行的
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println("********** test1 **********");
            }
        }
    }
    
    @Test
    public void tes2() {
        Thread thread = new Thread(()->{
            for (int i = 0; i < 100; i++) {
                if (i % 2 == 0) {
                    System.out.println(Thread.currentThread().getName() + "\t" + i);
                }
            }
        });
        thread.setName("thread");
        // start() 启动线程
        thread.start();
    }
}

// 1. 继承 Thread 类，并重写 run()
class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() +
                        "：" + i + "********** test1 **********");
            }
        }
    }
}
