package zhiHuspider;

import zhiHuspider.bean.Zhihu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by lenovo on 2017/3/22.
 */
public class Spider {
    public static String sendGet(String url) {
        String result = "";
        BufferedReader in = null;
        try {
            URL realURL = new URL(url);
            URLConnection conn = realURL.openConnection();
            conn.connect();
            in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            String line = null;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送get请求出现异常");
            e.printStackTrace();
        } finally {
            try {
                if (in != null)
                    in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public static ArrayList<Zhihu> parsePost(String source) {
        ArrayList<Zhihu> results = new ArrayList<>();
        //urlPattern
        Pattern urlPattern = Pattern.compile("question_link.+?href=\"(.+?)\"");
        Matcher urlMatcher = urlPattern.matcher(source);
        while (urlMatcher.find()) {
            Zhihu zh = new Zhihu(urlMatcher.group(1));
            results.add(zh);
        }
        return results;
    }
}
