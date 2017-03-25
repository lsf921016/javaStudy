package zhiHuspider;

import zhiHuspider.bean.SingleQuestionPicture;

import java.net.MalformedURLException;

/**
 * Created by lenovo on 2017/3/23.
 */
public class test {
    public static void main(String[] args) {
        String url="https://www.zhihu.com/question/31079801";
        SingleQuestionPicture p=new SingleQuestionPicture(url);
        try {
            p.downLoadPicture();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }


}
