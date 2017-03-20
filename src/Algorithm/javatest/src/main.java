package Algorithm.javatest.src;

import java.io.File;

/**
 * Created by lenovo on 2017/3/19.
 */
public class main {
    public static void main(String[] args) throws Exception {
        long start=System.currentTimeMillis();
        File inputFile=new File("E:\\javaStudy\\src\\Algorithm\\javatest\\data\\input.data");
        File outputFile=new File("E:\\javaStudy\\src\\Algorithm\\javatest\\data\\outputFile");
        File tempFile=new File("E:\\javaStudy\\src\\Algorithm\\javatest\\data\\temp");
        ProgramTest3.test(inputFile,outputFile,tempFile);
        long end=System.currentTimeMillis();
        System.out.println(end-start);
    }
    private static String smaller(String s1,String s2){
        if (s1.compareTo(s2)<=0){
            return s1;
        }
        else {
            return s2;
        }
    }
}
