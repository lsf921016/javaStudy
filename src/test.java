import Algorithm.selection.Test;

/**
 * Created by lenovo on 2017/4/1.
 */
class B{
    class C{
        private int a=2;
        void print(){
            System.out.println(this.a);
        }
    }
    private int a=4;
    void print(){
        C cc=new C();
        cc.print();
        System.out.println(this.a);
    }

    public static void main(String[] args) {

    }
}
