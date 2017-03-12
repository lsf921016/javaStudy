package javaIO;

import java.io.*;

/**
 * Created by lenovo on 2017/3/11.
 */
public class FileCopyByBuffered {
    public static void main(String[] args) throws IOException {
        BufferedReader bufr=new BufferedReader(new FileReader("E:\\javaStudy\\src\\javaIO\\when you are old"));
        BufferedWriter bufw=new BufferedWriter(new FileWriter("E:\\javaStudy\\src\\javaIO\\when you are old_Copy"));
        String line=null;
        while((line=bufr.readLine())!=null){
            bufw.write(line);
            bufw.newLine();
            bufw.flush();
        }
        bufr.close();
        bufw.close();


    }
}
