package pers.yangzhen.multithread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 使用线程池创建线程
 *
 * @author yangzhen
 * @create 2021-03-19 14:31
 */
public class CreateThread3 {
    public static void main(String[] args) {
        // 1. 提供固定线程数量的线程池
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        // 单独设置线程池的属性
//        ThreadPoolExecutor poolField = (ThreadPoolExecutor) threadPool;
//        poolField.setCorePoolSize(10);
//        poolField.setMaximumPoolSize(120);
        
        // 2. 执行指定的线程的操作，需要提供实现 Runnable 接口或 Callable 接口实现类的对象
        threadPool.execute(new Number1());
        threadPool.execute(new Number2());
        // execute() 适合用于 Runnable ，submit() 适合用于 Callable
//        service.submit();
        
        // 3. 关闭连接池
        threadPool.shutdown();
    }
}
class Number1 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            // 打印奇数
            if (i % 2 != 0) {
                System.out.println(Thread.currentThread().getName() + "：" + i);
            }
        }
    }
}
class Number2 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            // 打印偶数
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + "：" + i);
            }
        }
    }
}