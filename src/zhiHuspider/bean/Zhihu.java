package zhiHuspider.bean;

import zhiHuspider.Spider;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by lenovo on 2017/3/22.
 */
public class Zhihu {
    public String question;
    public String url;
    public String description;
    public ArrayList<String> answers;

    public Zhihu(String url) {
        question = "";
        url = "";
        description = "";
        answers = new ArrayList<>();
        if (getRealUrl(url)){
            System.out.println("正在抓取："+url);
        }
        //get details by the url
        String content= Spider.sendGet(url);
        Pattern pattern;
        Matcher matcher;
        //get questions
        pattern=Pattern.compile("data-react-helmet.+?(.+?)</title>");
        matcher=pattern.matcher(content);
        if (matcher.find()){
            question=matcher.group(1);
        }
        //get descriptions
//        pattern=Pattern.compile("<span class=\"RichText CopyrightRichText-richText\"><p>()</p>");
    }


    @Override
    public String toString() {
        return "问题：" + question + "\n"
                + "链接:" + url + "\n"
                + "描述:" + description + "\n"
                + "答案:" + answers + "\n";
    }

    public boolean getRealUrl(String url) {
        Pattern p = Pattern.compile("question/(.+?)/");
        Matcher m = p.matcher(url);
        if (m.find()) {
            this.url = "https://www.zhihu.com/question/" + m.group(1);
        } else
            return false;
        return true;
    }

}
