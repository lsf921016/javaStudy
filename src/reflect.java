import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by lenovo on 2017/3/30.
 */
class Demo {
    int value;
    String name;

    Demo() {

    }

    Demo(String name, int value) {
        this.name = name;
        this.value = value;
    }
    public void show(int count){
        for (int i = 0; i < count; i++) {
            System.out.println(name);
        }
    }
}

public class reflect {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        //three ways to get class object
        //1
        Demo demo=new Demo();
        Class clazz1=demo.getClass();

        //2
        Class clazz2=Demo.class;

        //3
        Class clazz3=Class.forName("Demo");


        //通过类的class对象，调用空参构造函数创建对象
        Object obj=clazz1.newInstance();

        //通过class的getconstructor（）方法，获取类的构造器对象
        Constructor constructor=clazz1.getConstructor(String.class,int.class);
        Object obj1=constructor.newInstance("demo111",111);

        //通过Field类对该类对象的字段进行操作
        Field f1=clazz1.getField("name");//只能获取public的字段
        Field f2=clazz2.getDeclaredField("name");//获取所有字段

        Object obj2=clazz1.newInstance();
        f2.get(obj2);
        f2.set(obj,"new name");

        //获取并使用类的函数
        Method method=clazz1.getMethod("show",int.class);
        method.invoke(obj2,3);
    }


}
