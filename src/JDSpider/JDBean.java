package JDSpider;

import org.jsoup.nodes.Document;

/**
 * Created by lenovo on 2017/3/25.
 */
public class JDBean {
    String url;
    String number;
    String pictureSrc;
    String name;
    double price;
    String detail;
    int commentCount;
    double goodRate;
    public JDBean(Document doc, String url,String number) {
        this.url=url;
        this.number=number;
    }

    
    public String getUrl() {
        return url;
    }

    public String getNumber() {
        return number;
    }

    public String getPictureSrc() {
        return pictureSrc;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getDetail() {
        return detail;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public double getGoodRate() {
        return goodRate;
    }
}
