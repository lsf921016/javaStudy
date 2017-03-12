package javaIO;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * //E:\javaStudy\src\javaIO\when you are old
 * TO
 * E:\javaStudy\src\javaIO\destination
 */

public class Demo_CopyFile {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("//E:\\javaStudy\\src\\javaIO\\when you are old");
        FileWriter fw = new FileWriter("E:\\javaStudy\\src\\javaIO\\destination");
        char[] buf = new char[1024];
        int num = 0;
        //判断fr.read()的返回值，返回-1时，表示读取不到了
        while ((num = fr.read(buf)) != -1) {
            fw.write(buf,0,num);
        }
        fw.close();
        fr.close();
    }

}
