import sun.plugin.javascript.navig.Array;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lenovo on 2017/4/2.
 */
public class Test {
    public static void main(String[] args) throws NoSuchMethodException {
        //得到作用目标,类
        Class clazz=A.class;

        //得到作用目标，方法
        Method method=clazz.getMethod("show");

        //获取指定类型的注解
        MyAnno myAnno1= (MyAnno) clazz.getAnnotation(MyAnno.class);
        System.out.println(myAnno1.name()+","+myAnno1.age());

        MyAnno myAnno2=method.getAnnotation(MyAnno.class);
        System.out.println(myAnno2.name()+","+myAnno2.age());
    }
}
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnno{
    int age();
    String name();
}

@MyAnno(age=1,name="lin")
class A{

    @MyAnno(age=2,name="li")
    public void show(){

    }
}



