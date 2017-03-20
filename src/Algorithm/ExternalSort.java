package Algorithm;

import java.io.*;
import java.util.Random;

/**
 * Created by lenovo on 2017/3/19.
 */
public class ExternalSort {
    public static void main(String[] args) throws IOException {
        final long maxSize = 1024 *  50;
        File f = new File("E:\\javaStudy\\src\\Algorithm\\tempFile");
        BufferedWriter bufw = new BufferedWriter(new FileWriter("E:\\javaStudy\\src\\Algorithm\\tempFile"));
        Random random = new Random();
        while (f.length() < maxSize) {
            bufw.write(String.valueOf(random.nextInt()));
            bufw.newLine();
        }
        bufw.flush();
        bufw.close();

    }
}
