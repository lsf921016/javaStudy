package Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by lenovo on 2017/4/4.
 */
interface A{
public void a();
}
interface B{
    public void b();
}
public class Test
{
    public void function(){
        //参数一
        ClassLoader loader=this.getClass().getClassLoader();

        //参数二
        Class[] interfaces={A.class,B.class};

        //参数三
        InvocationHandler invocationHandler=new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("invocation");
                return null;
            }
        };

        //创建一个实现了A接口和B接口的代理对象
        Object proxy= Proxy.newProxyInstance(loader,interfaces,invocationHandler);

        //强转
        A a=(A)proxy;
        B b=(B)proxy;
        System.out.println(proxy.getClass().getName());

    }

    public static void main(String[] args) {
        new Test().function();
    }
}
