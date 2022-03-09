package pers.yangzhen.multithread;

/**
 * 测试 Thread 类中的常用方法
 * @author yangzhen
 * @create 2021-03-15 20:11
 */
class HelloThread extends Thread {
    public HelloThread(String name) {
        // 创建线程的同时，传入线程的名字
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                try {
                    // 延时 1ms ，1s 后如果 CPU 分配了资源，那么执行后面的代码，
                    // 若没有分配资源则不能执行
                    sleep(10);
                    // sleep() 在调用时会抛出中断异常，但是这里不能抛出异常，只能 try-catch 处理异常，
                    // 因为父类 Thread 类的 run() 没有抛出异常，所以子类的重写方法也不能抛
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
        }
    }
}
public class ThreadMethod {
    public static void main(String[] args) {
        // 通过 Thread 类的其中一个构造器给线程命名
        HelloThread helloThread = new HelloThread("Thread1");
        // 通过 setName() 给线程命名
//        helloThread.setName("线程2");
        helloThread.start();
        System.out.println(helloThread.isAlive());
        // 给主线程命名
        Thread.currentThread().setName("主线程");
        for (int i = 0; i < 100; i++) {
            if (i % 2 != 0) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            if(i == 19){
                try {
                    helloThread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        // Thread 线程在调用 run() 之后就死亡了
        System.out.println(helloThread.isAlive());
        // 主线程在 main() 结束前仍然存活
        System.out.println(Thread.currentThread().isAlive());
    }
}