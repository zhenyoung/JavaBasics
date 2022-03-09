package pers.yangzhen.multithread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 实现 Callable 接口创建线程
 *
 * @author yangzhen
 * @create 2021-03-19 13:57
 */
public class CreateThread2 {
    public static void main(String[] args) {
        FutureTask<Integer> futureTask = new FutureTask<>(() -> {
            int sum = 0;
            for (int i = 1; i < 100; i++) {
                if (i % 2 == 0) {
                    System.out.println(i);
                    sum += i;
                }
            }
            return sum;
        });
        new Thread(futureTask).start();
        try {
            // get() 返回值为 call() 的返回值
            int sum = futureTask.get();
            System.out.println("总和为：" + sum);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}