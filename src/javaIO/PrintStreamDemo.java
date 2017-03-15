package javaIO;

import java.io.FileNotFoundException;
import java.io.PrintStream;

/**
 * Created by lenovo on 2017/3/12.
 */
public class PrintStreamDemo {
    public static void main(String[] args) throws FileNotFoundException {
        PrintStream ps=new PrintStream("E:\\javaStudy\\src\\javaIO\\aFile");
        ps.print(111);
        ps.close();
    }
}
