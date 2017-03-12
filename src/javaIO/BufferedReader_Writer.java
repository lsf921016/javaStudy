package javaIO;

import java.io.*;

/**
 * Created by lenovo on 2017/3/11.
 */
public class BufferedReader_Writer {
    public static void main(String[] args) throws IOException {
        //BufferedWriter:
        //创建一个写入缓冲区，并和指定被缓冲的流对象相关联
        FileWriter fw=new FileWriter("E:\\javaStudy\\src\\javaIO\\aFile");
        BufferedWriter bufw=new BufferedWriter(fw);
        //使用缓冲区方法将数据写入缓冲区
        bufw.write("buffered hello");
        //换行
        bufw.newLine();
        //使用缓冲区的刷新方法将数据刷新到目的地中
        bufw.flush();
        //关闭缓冲区的同时就关闭的inputStream
        bufw.close();

        //BufferedReader:
        FileReader fr=new FileReader("E:\\javaStudy\\src\\javaIO\\when you are old");
        BufferedReader bufr=new BufferedReader(fr);
        String line=null;
        while((line=bufr.readLine())!=null){
            System.out.println(line);
        }
        bufr.close();

    }
}
