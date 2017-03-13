package File;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.List;

/**
 * Created by lenovo on 2017/3/11.
 */
public class test {
    public static void main(String[] args) throws IOException {
        //Path类

        //定义一个Path对象
        Path path= Paths.get("E:\\javaStudy\\src\\File\\a.txt");
        System.out.println(path.toString());
        //获得path的父级路径
        Path pParent=path.getParent();
        System.out.println(pParent);
        //使用path获得一个File对象
        File f=path.toFile();
        System.out.println(f.toString());





        //使用Files类的静态方法读写：

        //将文件以字符串的形式读出
        byte[] bytes= Files.readAllBytes(path);
        String content=new String(bytes);
        System.out.println(content);

        //将文件当作行序列读入
        List<String> lines=Files.readAllLines(path);
        System.out.println(lines);

        //写出一个字符串到文件中
        Files.write(path,"this is write by nio write".getBytes());

        //向指定文件中追加内容,第三个参数规定了操作是append
        Files.write(path, "\n append something by nio".getBytes(),StandardOpenOption.APPEND);

        //将一个行的集合写出到文件
        Path path2=Paths.get("E:\\javaStudy\\src\\File\\b.txt");
        Files.write(path2,lines);




//        //操作文件：
//
//        //移动文件
//         Files.move(fromPath,toPath);
//
//         //复制文件
//        Files.copy(fromPath,toPath);
//
//        //删除文件
//        Files.delete(path);
//
//        //创建文件
//        Files.createFile(path);
//
//        //创建目录
//        Files.createDirectory(path);



        //遍历路径下的文件
        Path dir=Paths.get("E:\\javaStudy\\src\\File");
        try (DirectoryStream<Path> files=Files.newDirectoryStream(dir)){
            for (Path file:files){
                System.out.println(file.getFileName());
            }
        }

        //使用正则表达式过滤文件
        try (DirectoryStream<Path> files=Files.newDirectoryStream(dir,"*.java")){
            for (Path file:files){
                System.out.println(file.getFileName());
            }
        }


    }

}
