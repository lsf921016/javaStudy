package test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 * Created by lenovo on 2017/3/21.
 */
public class generateData {
    public static void main(String[] args) throws IOException {
        final int MAX=3500000;
        File f=new File("E:\\javaStudy\\src\\test\\inputFile.txt");
        if (f.exists())
            f.delete();
        BufferedWriter bufw=new BufferedWriter(new FileWriter(f));
        for (int i=0;i<MAX;++i){
            bufw.write(getRandomString());
            bufw.newLine();
        }
        bufw.flush();
        bufw.close();
    }
    public static String getRandomString(){
        StringBuilder sb=new StringBuilder();
        Random random=new Random();
        for (int i = 0; i < 8; i++) {
            sb.append((char)(random.nextInt(26)+97));
        }
        sb.append(',');
        return sb.toString();
    }
}
