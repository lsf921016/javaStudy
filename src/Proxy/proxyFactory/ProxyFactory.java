package Proxy.proxyFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**@author
 * 用来生成代理对象
 * 它需要所有的参数：
 * 1.目标对象
 * 2.增强内容
 *
 * 代理工厂使用过程：
 *
 * 1.创建代理工厂
 * 2.设置三个成员变量：
 *  目标对象
 *  前置增强
 *  后置增强
 * 3.调用getProxy得到代理对象
 *    执行代理对象的方法时：
 *    执行BeforeAdvice的before（）
 *    执行目标对象的目标方法
 *    执行AfterAdvice的after（）
 */
public class ProxyFactory {
    private Object targetObject;//目标对象
    private BeforeAdvice beforeAdvice;
    private AfterAdvice afterAdvice;

    //用来生成代理对象
    public Object getProxy(){
        //给出创建Proxy对象的三大参数
        ClassLoader classLoader=this.getClass().getClassLoader();
        Class[] interfaces=targetObject.getClass().getInterfaces();
        InvocationHandler h=new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //调用代理对象的方法时会执行这里的内容
                if (beforeAdvice!=null){
                    beforeAdvice.before();
                }
                Object res=method.invoke(targetObject,args);

                if (afterAdvice!=null)
                    afterAdvice.after();

                return res;

            }
        };
        Object proxyObject= Proxy.newProxyInstance(classLoader,interfaces,h);
        return proxyObject;
    }

    public Object getTargetObject() {
        return targetObject;
    }

    public void setTargetObject(Object targetObject) {
        this.targetObject = targetObject;
    }

    public BeforeAdvice getBeforeAdvice() {
        return beforeAdvice;
    }

    public void setBeforeAdvice(BeforeAdvice beforeAdvice) {
        this.beforeAdvice = beforeAdvice;
    }

    public AfterAdvice getAfterAdvice() {
        return afterAdvice;
    }

    public void setAfterAdvice(AfterAdvice afterAdvice) {
        this.afterAdvice = afterAdvice;
    }
}
