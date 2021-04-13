package pers.yangzhen.multiplethread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 多线程的创建，方式三：实现Callable接口 --->JDK 5.0新增
 *
 * @author yangzhen
 * @create 2021-03-19 13:57
 */

//1.创建一个实现Callable接口的实现类
class NumTest implements Callable {
    //2.实现call()，将此线程需要执行的操作声明在call()中
    @Override
    public Object call() throws Exception {
        int sum = 0;
        for (int i = 1; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
                sum += i;
            }
        }
        return sum;//自动装箱，Integer类是Object类的子类，多态
    }
}

public class ThreadTest3 {
    public static void main(String[] args) {
        //3.创建Callable接口实现类的对象
        NumTest numTest = new NumTest();

        //4.将此Callable接口实现类对象传递到FutureTask构造器中，创建FutureTask的对象
        FutureTask futureTask = new FutureTask(numTest);

        //5.将FutureTask的对象作为参数传递到Thread类的构造器中，创建Thread()对象，并调用start()
        new Thread(futureTask).start();

        try {
            //get()返回值即为FutureTask构造器形参Callable实现类重写的 call()方法的返回值
            Object sum = futureTask.get();
            System.out.println("总和为：" + sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

}
