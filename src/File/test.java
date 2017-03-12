package File;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by lenovo on 2017/3/11.
 */
public class test {
    public static void main(String[] args) throws IOException {
        File f=new File("E:\\javaStudy\\src\\File\\a.txt");
        FileWriter fw=new FileWriter(f);
        fw.write("this is a test");
        fw.close();

        System.out.println(f);
    }

}
