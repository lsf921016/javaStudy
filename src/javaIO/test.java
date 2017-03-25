package javaIO;

import java.io.*;
import java.util.Random;
import java.util.RandomAccess;

/**
 * Created by lenovo on 2017/3/20.
 */
public class test {
    public static void main(String[] args) throws IOException {
        BufferedReader bufr=new BufferedReader(new FileReader("E:\\javaStudy\\src\\outterSort\\outputFile.txt"));
        String line=null;
        int count=0;
        int n;
        while ((line=bufr.readLine())!=null){
           if (( line.lastIndexOf(",")!=-1))
               count++;
        }
        System.out.println(count);
    }
}
