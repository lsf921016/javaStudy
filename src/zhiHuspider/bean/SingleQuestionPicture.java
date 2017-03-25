package zhiHuspider.bean;

import zhiHuspider.Spider;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by lenovo on 2017/3/23.
 */
public class SingleQuestionPicture {
    String question="";
    String url="";
    ArrayList<String> picUrls;
    String dir="E:\\javaStudy\\src\\zhiHuspider\\download";

    public SingleQuestionPicture(String url) {
        this.url = url;
        picUrls =new ArrayList<>();
        File download=new File(dir);
        if (!download.exists()){
            download.mkdir();
        }

        String content= Spider.sendGet(url);
        System.out.println(content);
        Pattern pattern;
        Matcher matcher;
        //match question
        pattern=Pattern.compile("\"QuestionHeader-title\".*?>(.+?)<.*?");
        matcher=pattern.matcher(content);
        if (matcher.find()){
            question=matcher.group(1);
        }

        //match picture urls
        pattern=Pattern.compile("</noscript>.+?<img.+?src=\"(https.+?jpg)\".+?");
        matcher=pattern.matcher(content);
        while (matcher.find()){
            picUrls.add(matcher.group(1));
        }
    }

    public  boolean downLoadPicture() throws MalformedURLException {
        File folder=new File(dir,question);
        if (!folder.exists()){
            folder.mkdir();
        }
        System.out.println("问题："+question);
        System.out.println("下载路径"+folder.getAbsolutePath());
        int count=1;
        for (String pic:picUrls
             ) {
            System.out.println("开始下载.....");
            URL url=new URL(pic);
            try {
                BufferedInputStream bufis = new BufferedInputStream(url.openStream());
                String childName=String.valueOf(count)+".jpg";
                BufferedOutputStream bufos=new BufferedOutputStream(new FileOutputStream(new File(folder,childName)));
                byte[] buffer=new byte[1024];
                int len=0;
                while ((len=bufis.read(buffer))!=-1){
                    bufos.write(buffer,0,len);
                }
                bufis.close();
                bufos.flush();
                bufos.close();
                System.out.println("第"+count+"张照片下载完毕");
                count++;
            } catch (IOException e) {
                System.out.println("传输失败");
                e.printStackTrace();
                return false;
            }
        }
        System.out.println("下载完成，共下载了"+count+"张图片");
        return true;
    }
}
