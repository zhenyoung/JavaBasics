package pers.yangzhen.classicexercises;

/**
 * 线程通信的经典应用：生产者/消费者问题
 * 生产者(Producer)将产品交给店员(Clerk)，
 * 而消费者(Customer)从店员处取走产品，店员一次只能持有固定数量的产品(比如:20)，
 * 如果生产者试图生产更多的产品，店员会叫生产者停一下，当店中有空位放产品了再通知生产者继续生产，
 * 如果店中没有产品了，店员会告诉消费者等一下，当店中有产品了再通知消费者来取走产品。
 * <p>
 * 分析：
 * 1.是否是多线程问题？是，生产者线程，消费者线程
 * 2.是否有共享数据？是，店员（或产品）
 * 3.如何解决线程安全问题？同步机制，有3中方法
 * 4.是否涉及线程的通信？是
 *
 * @author yangzhen
 * @create 2021-03-19 11:13
 */
class Clerk {
    private int productCount = 0;

    public synchronized void produceProduct() {
        if (productCount < 20) {//产品总数不高于20时，开始生产
            productCount++;
            System.out.println( Thread.currentThread().getName() + "：正在生产第" + productCount + "件产品");
            notify();//唤醒消费者线程消费
            // 由于消费者线程只有在产品为0时才进入阻塞状态并释放锁，所以这里的唤醒只有在产品为0时才有效果
            // 其他时候因为消费者线程没有阻塞，所以就没有唤醒一说，调用notify()是无效的
        } else {//产品总数高于20时，让生产者停止生产，调用wait()进入阻塞状态，直到消费者消费了产品时唤醒
            try {
                wait();//阻塞并释放锁，等待唤醒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public synchronized void consumeProduct() {

        if (productCount > 0) {//有产品时，消费者开始消费产品
            System.out.println( Thread.currentThread().getName() + "：正在消费第" + productCount + "件产品");
            productCount--;
            notify();//唤醒生产者线程
            // 由于生产者线程只有在产品高于20时才进入阻塞状态并释放锁，所以这里的唤醒只有在产品为20时才有效果
            // 其他时候因为生产者线程没有阻塞，所以就没有唤醒一说，调用notify()是无效的
        } else {//没有产品时，让消费者等待生产者生产，使用wait()进入阻塞状态，直到生产者生产出产品时唤醒
            try {
                wait();//阻塞并释放锁，等待唤醒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

}

class Producer extends Thread {//生产者
    private Clerk clerk;

    public Producer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(getName() + "开始生产产品...");
        while(true){//不断地生产，直到手动地结束
            clerk.produceProduct();
            try {
                Thread.sleep(10);//这里设置时间使得生产比消费快
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer extends Thread {
    private Clerk clerk;

    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(getName() + "开始消费产品...");
        while(true){//不断地消费，直到手动地结束
            clerk.consumeProduct();
            try {
                Thread.sleep(20);//这里设置时间使得消费比生产慢
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class ProducerAndConsumer {

    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Producer p1 = new Producer(clerk);
        p1.setName("生产者1");
        Consumer c1 = new Consumer(clerk);
        c1.setName("消费者1");

        p1.start();
        c1.start();

    }
}