package javaIO;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by lenovo on 2017/3/11.
 */
public class FileReaderWtiter {
    public static void main(String[] args) throws IOException {
        //向一个txt文件写入数据
        FileWriter fw = new FileWriter("E:\\javaStudy\\src\\javaIO\\aFile");//创建字符输出对象
        fw.write("hello");//调用fileWriter对象的writer方法，将字符串写入流中
        fw.flush();//进行刷新，将数据写入目的地
        fw.close();//关闭资源


        //读取一个文本文件，将读取到的字符打印到控制台
        FileReader fr = new FileReader("E:\\javaStudy\\src\\javaIO\\aFile");

        //一次读一个字符,read(char ch)返回字符的数值
        int ch = fr.read();
        if (ch != -1) {
            System.out.println((char) ch);
        }
//        fr.close();

        //利用FileWriter的read(char[])重载，一次读入一个字符数组，即缓冲
        char[] buf = new char[1024];
        int num = fr.read(buf);//将读取到的字符存储至数组。返回读取到的字符个数
        System.out.println("读取到" + num + "个字符：" + new String(buf));

    }
}
