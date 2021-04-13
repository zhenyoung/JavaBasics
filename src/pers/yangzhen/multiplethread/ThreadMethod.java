package pers.yangzhen.multiplethread;

/**
 * 测试当Thread线程中的常用方法
 *
 * @author yangzhen
 * @create 2021-03-15 20:11
 */
class HelloThread extends Thread {


    public HelloThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                try {
                    sleep(10);//延时1ms，1s后如果CPU分配了资源，那么执行后面的代码，没有分配资源则不能执行
                    //sleep()在调用时会抛出中断异常，但是这里不能抛出异常，只能try-catch处理异常
                    //因为父类Thread类的run()没有抛出异常，所以子类的重写方法也不能抛
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

        //通过Thread类的其中一个构造器给线程命名
        HelloThread helloThread = new HelloThread("Thread1");
        //通过setName()给线程命名
//        helloThread.setName("线程2");
        helloThread.start();

        System.out.println(helloThread.isAlive());

        //给主线程命名
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
        System.out.println(helloThread.isAlive());//Thread线程在调用之后就死亡了
        System.out.println(Thread.currentThread().isAlive());//主线程在main()结束前仍然存活
    }
}