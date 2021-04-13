package pers.yangzhen.multiplethread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 多线程的创建，方式四：使用线程池（最常用）--->JDK 5.0新增
 *
 * @author yangzhen
 * @create 2021-03-19 14:31
 */

class number1 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if (i % 2 != 0) {//打印奇数
                System.out.println(Thread.currentThread().getName() + "：" + i);
            }
        }
    }
}
class number2 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if (i % 2 == 0) {//打印偶数
                System.out.println(Thread.currentThread().getName() + "：" + i);
            }
        }
    }
}

public class ThreadTest4 {

    public static void main(String[] args) {
        //1.提供指定线程数量的线程池
        ExecutorService service = Executors.newFixedThreadPool(10);

        //设置线程池的属性
        //由于ExecutorService是一个接口，接口中只有常量，因此强转成ThreadPoolExecutor类
//        ThreadPoolExecutor service1 = (ThreadPoolExecutor) service;
//        service1.setCorePoolSize(10);
//        service1.setMaximumPoolSize(120);



        //2.执行指定的线程的操作，需要提供实现Runnable接口或Callable接口实现类的对象
        service.execute(new number1());//execute()适合用于Runnable
        service.execute(new number2());//execute()适合用于Runnable
//        service.submit();//submit()适合用于Callable

        //3.关闭连接池
        service.shutdown();

    }
}