package DataStructure_Stack;

import java.util.Arrays;

/**
 * Created by lenovo on 2017/3/12.
 */
public class Stack<T> {
    private T[] elements;
    private int len;
    private int size;
    Stack(int len){
        this.len=len;

    }

    public boolean push(T value ){//压栈
        if(len==elements.length) {
//            elements = Arrays.copyOf(elements, newElements);
            elements[len]=value;
            ++len;
        }
        return true;
    }
    public T pop(){//弹出
        --len;
        return elements[len];

    }
    public T peek(){//返回栈顶
        return elements[len];

    }
    public boolean empty(){//查空
        return false;

    }
}
