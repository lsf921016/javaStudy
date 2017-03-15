package socket.MultiThread;

/**
 * Created by lenovo on 2017/3/14.
 */
class Resource {
    private String name;
    int count;
    boolean flag = false;

    public synchronized void produce(String name) {
        if (flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.name = name + count;
        ++count;
        System.out.println(Thread.currentThread().getName() + name+count + "+1");
        flag = true;
        notify();
    }

    public synchronized void consume() {
        if (!flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + name +count+ "-1");
        flag = false;
        notify();
    }
}

class Producer implements Runnable {
    Resource r;

    public Producer(Resource r) {
        this.r = r;
    }

    @Override
    public void run() {
        while (true) {
            r.produce("烤鸭");
        }

    }
}

class Consumer implements Runnable {
    Resource r;

    public Consumer(Resource r) {
        this.r = r;
    }

    @Override
    public void run() {
        while(true){
            r.consume();
        }
    }
}

public class ProducerConsumer {
    public static void main(String[] args) {
        Resource r=new Resource();
        Producer producer=new Producer(r);
        Consumer consumer=new Consumer(r);
        Thread t1=new Thread(producer);
        Thread t2=new Thread(consumer);
        t1.start();
        t2.start();
    }
}
