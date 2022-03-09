package pers.yangzhen.multithread;

/**
 * @Description 由店员阻塞和唤醒生产者消费者
 * @Author youngzhen
 * @Date 2022/3/5 21:08
 */
public class ProducerAndConsumer {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Producer producer = new Producer(clerk);
        Consumer consumer = new Consumer(clerk);
        producer.setName("生产者 ");
        consumer.setName("消费者 ");
        producer.start();
        consumer.start();
    }
}

class Clerk {
    private int productCount = 0;
    
    public synchronized void produceProduct() {
        // 产品总数不高于 20 时，开始生产
        if (productCount < 20) {
            productCount++;
            System.out.println(Thread.currentThread().getName() +
                    "：正在生产一件产品，剩余产品数为 " + productCount);
            // 唤醒消费者线程
            notify();
            // 由于消费者线程只有在产品为 0 时才进入阻塞状态并释放锁，
            // 所以这里的唤醒只有在产品为 0 时才有效果。
            // 其他时候因为消费者线程没有阻塞，所以就没有“唤醒”一说，调用 notify() 相当于无效操作，
            // 下面的消费者同理。
        } else {
            // 产品总数高于 20 时，停止生产，
            // 调用 wait() 进入阻塞状态，直到消费者消费了产品时唤醒
            try {
                // 阻塞并释放锁，等待唤醒
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
    public synchronized void consumeProduct() {
        // 有产品时，消费者开始消费产品
        if (productCount > 0) {
            productCount--;
            System.out.println(Thread.currentThread().getName() +
                    "：正在消费一件产品，剩余产品数为 " + productCount);
            // 唤醒生产者线程
            notify();
        } else {
            // 没有产品时，让消费者等待生产者生产，使用 wait() 进入阻塞状态，
            // 直到生产者生产出产品时唤醒
            try {
                // 阻塞并释放锁，等待唤醒
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Producer extends Thread {
    private final Clerk clerk;
    
    public Producer(Clerk clerk) {
        this.clerk = clerk;
    }
    
    @Override
    public void run() {
        System.out.println(getName() + "开始生产产品...");
        // 不断地生产，直到手动地结束
        while (true) {
            clerk.produceProduct();
            try {
                // 这里设置延迟时间使得生产比消费快
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer extends Thread {
    private final Clerk clerk;
    
    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }
    
    @Override
    public void run() {
        System.out.println(getName() + "开始消费产品...");
        // 不断地消费，直到手动地结束
        while (true) {
            clerk.consumeProduct();
            try {
                // 这里设置延迟时间使得消费比生产慢
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}