package javaIO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by lenovo on 2017/3/11.
 */
public class ByteBasedStream {
private static void copy() throws IOException {
    //用字节流拷贝一个文件
    FileInputStream fis=new FileInputStream("E:\\javaStudy\\src\\javaIO\\when you are old");
    FileOutputStream fos=new FileOutputStream("E:\\javaStudy\\src\\javaIO\\when you are old_copy2");
    byte[] buf=new byte[1024];
    int len=0;
    while ((len=fis.read(buf))!=-1){
        fos.write(buf,0,len);
    }
    fis.close();
    fos.close();
}
    public static void main(String[] args) throws IOException {
        //创建字节输出流对象，用以操作文件
        FileOutputStream fos = new FileOutputStream("E:\\javaStudy\\src\\javaIO\\aFile");
        fos.write("byte based io".getBytes());
        fos.close();

        //创建字节读取流，与指定文件关联
        FileInputStream fis = new FileInputStream("E:\\javaStudy\\src\\javaIO\\aFile");
        //获得fis读取到的字节数来创建缓冲数组
        byte[] buf=new byte[1024];
        int len=0;
        while((len=fis.read(buf))!=-1){
            System.out.println(new String(buf,0,len));
        }
        fis.close();
        //一个小demo，写在copy函数里了
        copy();

    }
}
