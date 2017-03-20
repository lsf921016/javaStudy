package javaIO;

import java.io.*;
import java.util.RandomAccess;

/**
 * Created by lenovo on 2017/3/20.
 */
public class test {
    public static void main(String[] args) throws IOException {
        RandomAccessFile raf=new RandomAccessFile("E:\\javaStudy\\src\\javaIO\\when you are old","r");
        System.out.println(raf.readLine());
        System.out.println(raf.readLine());

        BufferedReader bufr=new BufferedReader(new FileReader("E:\\javaStudy\\src\\javaIO\\when you are old"));
        System.out.println(bufr.readLine());
        System.out.println(bufr.readLine());
    }
}
