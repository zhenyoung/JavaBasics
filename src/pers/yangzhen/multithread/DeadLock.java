package pers.yangzhen.multithread;

/**
 * 演示线程的死锁问题，经典的死锁问题还有哲学家进餐问题
 *
 * @author yangzhen
 * @create 2021-03-17 15:51
 */
public class DeadLock {
    public static void main(String[] args) {
        // StringBuffer 线程安全，StringBuilder 线程不安全
        StringBuffer s1 = new StringBuffer();
        StringBuffer s2 = new StringBuffer();
        new Thread(() -> {
            synchronized (s1) {
                s1.append("a");
                s2.append("1");
                try {
                    Thread.sleep(200);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                synchronized (s2) {
                    s1.append("b");
                    s2.append("2");
                    System.out.println(s1);
                    System.out.println(s2);
                }
            }
        }).start();
        
        new Thread(() -> {
            synchronized (s2) {
                s1.append("c");
                s2.append("3");
                try {
                    Thread.sleep(200);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                synchronized (s1) {
                    s1.append("d");
                    s2.append("4");
                    System.out.println(s1);
                    System.out.println(s2);
                }
            }
        }).start();
    }
}