import java.io.*;
import java.util.Arrays;

/**
 * Created by lenovo on 2017/3/9.
 */
public class test {
    public static void main(String[] args) throws IOException {
        FileInputStream fis=new FileInputStream("E:\\javaStudy\\src\\File\\a.txt");
        FileOutputStream fos=new FileOutputStream("E:\\javaStudy\\src\\socket\\aCopy.txt");

        byte[] buf=new byte[1024];
        int len=0;
        while ((len=fis.read(buf))!=-1){
            fos.write(buf,0,len);
            fos.flush();
        }
        fis.close();
        fos.close();
    }
}
