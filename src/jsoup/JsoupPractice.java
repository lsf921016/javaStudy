package jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Created by lenovo on 2017/3/23.
 */
public class JsoupPractice {
    public static void main(String[] args) throws IOException {
        String url = "http://www.zhihu.com/";
        Document doc = Jsoup.connect(url).get();
        Elements links=doc.select("img[src$=.png]");
        String linkHref = links.attr("href");
        String linkText = links.text();
        String inner = links.html();
        System.out.println(inner);

    }

}
