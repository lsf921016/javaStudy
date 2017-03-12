package javaIO;

import java.io.*;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by lenovo on 2017/3/11.
 */
public class StreamTransfer {
    public static void main(String[] args) throws IOException {
//        ReadKeyboardToTerminal();//从键盘读入数据并打印到控制台
//        ReadFileToTermial();//将文件输出到控制台
        SortArrayToFile();//将一组整数排序，并输出到文件
//        ReadKeyboardToFile();//从键盘读到文件
    }

    private static void ReadKeyboardToFile() throws IOException {
        BufferedReader bufr=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufw=new BufferedWriter(new FileWriter("E:\\javaStudy\\src\\javaIO\\aFile"));
        String line=null;
        while((line=bufr.readLine())!=null){
            bufw.write(line);
            bufw.flush();
        }
        bufr.close();
        bufw.close();
    }

    private static void SortArrayToFile() throws IOException {
        //获得一个随机数组成的数组
        Random random=new Random();//上限100
        int[] arr=new int[100];
        for(int i=0;i<100;++i){
            arr[i]=random.nextInt(100);
        }
        Arrays.sort(arr);

        //直接写入文件
        BufferedWriter bufw=new BufferedWriter(new FileWriter("E:\\javaStudy\\src\\javaIO\\aFile"));
        bufw.write(Arrays.toString(arr));
        bufw.flush();
        bufw.close();
    }

    private static void ReadFileToTermial() throws IOException {
        //FileReader 是OutputStreamRead的子类，也具有将字节流转换为字符流的功能
        BufferedReader bufr=new BufferedReader(new FileReader("E:\\javaStudy\\src\\javaIO\\when you are old"));
        BufferedWriter bufw=new BufferedWriter(new PrintWriter(System.out));//将字符流转换为标准输出流（即字节流）；

        String line=null;
        while ((line=bufr.readLine())!=null){
            bufw.write(line);
            bufw.flush();
        }
    }

    private static void ReadKeyboardToTerminal() throws IOException {
        BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(System.out));
        String line = null;
        while ((line = bufr.readLine()) != null) {
            bufw.write(line);
            bufw.flush();

        }
        bufr.close();
        bufw.close();
    }
}
