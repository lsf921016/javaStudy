package test;

import Algorithm.javatest.src.ProgramTest3;

import java.io.File;

/**
 * Created by lenovo on 2017/3/19.
 */
public class testProgram {
    public static void main(String[] args) throws Exception {
        long start=System.currentTimeMillis();
        File inputFile=new File("E:\\javaStudy\\src\\test\\inputFile.txt");
        File outputFile=new File("E:\\javaStudy\\src\\test\\outputFile.txt");
        File tempFile=new File("E:\\javaStudy\\src\\test\\tempFile.txt");
        ProgramTest.test(inputFile,outputFile,tempFile);
        long end=System.currentTimeMillis();
        System.out.println(end-start);
    }
}
