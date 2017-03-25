import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/3/23.
 */
public class test {
    public static void main(String[] args) throws IOException {
        String homePage="http://jiadian.jd.com/";
        Document doc=Jsoup.connect(homePage).get();
        Elements channels=doc.select("a[href~=item.jd.com/.*?]");
        for (Element channel:channels){
            System.out.println(channel.attr("abs:href"));
        }
//        }
    }
}
