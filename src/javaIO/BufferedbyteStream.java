package javaIO;

import java.io.*;

/**
 * Created by lenovo on 2017/3/11.
 * 拷贝一个MP3文件
 *
 */
public class BufferedbyteStream {
    public static void main(String[] args) throws IOException {
        BufferedInputStream bufis=new BufferedInputStream(
                new FileInputStream("E:\\javaStudy\\src\\javaIO\\source.avi"));
        BufferedOutputStream bufos=new BufferedOutputStream(
                new FileOutputStream("E:\\javaStudy\\src\\javaIO\\sourceCopy.avi"));
        byte[] buf=new byte[1024];
        int len=0;
        while((len=bufis.read(buf))!=-1){
            bufos.write(buf,0,len);
        }
        bufis.close();
        bufos.close();

    }

}
