package pers.yangzhen.multiplethread;

/**
 * 多线程的创建，方式二：实现Runnable接口
 *
 * @author yangzhen
 * @create 2021-03-16 15:16
 */

//1.创建一个实现了Runnable接口的类
class MThread implements Runnable {
    private int variable = 0;

    //2.实现类去实现Runnable接口中的抽象方法：run()
    @Override
    public void run() {
        System.out.println(variable);
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
        }
    }
}

public class ThreadTest2 {
    public static void main(String[] args) {
        //3.创建实现类的对象
        MThread mThread = new MThread();
//
//        //4.将此对象作为参数传递到Thread类的构造器，创建Thread类的对象
//        //将该对象通过Thread的一个构造器public Thread(Runnable target){}来创建Thread对象
//        //其中该构造器的形参使用runnable接口类型也从侧面体现了接口的多态性（即该接口的任何实现类的对象都可以传给形参）
//        Thread t1 = new Thread(mThread);

        //也可将第3、4步直接合并，创建实现类的匿名对象
        //Thread t1 = new Thread(new MThread());

        Thread t1 = new Thread(mThread);
        //5.通过Thread类的对象调用start()
        t1.setName("Thread1");
        t1.start();

        //再创建另一个线程
        Thread t2 = new Thread(mThread);
        t2.setName("Thread2");
        t2.start();

        //t1和t2线程共用实现类中的private int variable，因为传入的形参都是MThread类型的mThread对象，所以打印出的值是一致的

    }
}
