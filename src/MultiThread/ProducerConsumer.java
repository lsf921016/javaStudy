package MultiThread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by lenovo on 2017/3/14.
 */
class Item{
    public int value;

    public Item(int value) {
        this.value = value;
    }
}
class Buffer {
    Lock lock = new ReentrantLock();

    Condition notFull = lock.newCondition();
    Condition notEmpty = lock.newCondition();

    final int Max = 100;
    int putIndex=0;
    int takeIndex=0;
    int count = 0;
    final Item[] items = new Item[Max];

    public void produce() {
        lock.lock();
        try {
            while (count == Max) {
                try {
                    notFull.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Item x=new Item(putIndex);
            items[putIndex] = x;
            System.out.println(x.value+"has been produced");
            if (++putIndex == Max)
                putIndex = 0;
            ++count;
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    public Item consume() {
        lock.lock();
        try {
            while (count == 0) {
                try {
                    notEmpty.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Item x = items[takeIndex];
            System.out.println(x.value+"has been consumed");
            if (++takeIndex == Max)
                takeIndex = 0;
            --count;
            notFull.signal();
            return x;
        } finally {
            lock.unlock();
        }
    }
}

class Producer implements Runnable {
    Buffer r;

    public Producer(Buffer r) {
        this.r = r;
    }

    @Override
    public void run() {
        while (true) {
            r.produce();
        }

    }
}

class Consumer implements Runnable {
    Buffer r;

    public Consumer(Buffer r) {
        this.r = r;
    }

    @Override
    public void run() {
        while (true) {
            r.consume();
        }
    }
}

public class ProducerConsumer {
    public static void main(String[] args) {
        Buffer r = new Buffer();
        Producer producer = new Producer(r);
        Consumer consumer = new Consumer(r);
        Thread t0 = new Thread(producer);
        Thread t1 = new Thread(producer);
        Thread t2 = new Thread(producer);
        Thread t3 = new Thread(consumer);
        Thread t4 = new Thread(consumer);
        Thread t5 = new Thread(consumer);

        t0.start();
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}
