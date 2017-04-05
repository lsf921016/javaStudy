package Proxy.proxyFactory;

/**
 * Created by lenovo on 2017/4/4.
 */
public class ManWaiter implements Waiter {
    @Override
    public void serve() {
        System.out.println("serving");
    }

    @Override
    public void washing() {
        System.out.println("washing dishes");
    }

    @Override
    public void cashing() {
        System.out.println("cashing money");
    }

}
