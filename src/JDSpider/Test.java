package JDSpider;

/**
 * Created by lenovo on 2017/3/24.
 */
public class Test {
    public static void main(String[] args) {
        String homePage="http://www.jd.com/";
        final JDspider js=new JDspider();
        js.parseHomePage(homePage);
        long start=System.currentTimeMillis();
        System.out.println("开始爬。。。。。。。");
        js.begin();


    }
}
