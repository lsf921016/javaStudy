package Proxy.proxyFactory;

/**
 * Created by lenovo on 2017/4/4.
 */
public class demo {
    public static void main(String[] args) {
        ProxyFactory factory=new ProxyFactory();
        factory.setTargetObject(new ManWaiter());
        factory.setBeforeAdvice(new BeforeAdvice() {
            @Override
            public void before() {
                System.out.println("this is before .........");
            }
        });
        factory.setAfterAdvice(new AfterAdvice() {
            @Override
            public void after() {
                System.out.println("this is after");
            }
        });

        Waiter waiter= (Waiter) factory.getProxy();
        waiter.serve();
        waiter.washing();
        waiter.cashing();
    }
}
