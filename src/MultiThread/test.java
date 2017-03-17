package MultiThread;

/**
 * Created by lenovo on 2017/3/15.
 */
class Demo implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i <50 ; i++) {
            System.out.println(Thread.currentThread().getName()+i);
        }
    }
}
public class test {
    public static void main(String[] args) {
        Demo d=new Demo();
        Thread t1=new Thread(d);
        Thread t2=new Thread(d);

        t1.start();
        t2.start();
        for (int i = 0; i <50 ; i++) {
            System.out.println(Thread.currentThread().getName()+i);
        }
    }
}
