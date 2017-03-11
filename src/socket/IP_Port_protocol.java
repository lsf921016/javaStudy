package socket;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by lenovo on 2017/3/9.
 *
 * 1.I
 */

public class IP_Port_protocol {
    public static void main(String[] args) throws UnknownHostException {
        //获取本地主机ip地址对象
        InetAddress ip=InetAddress.getLocalHost();

        System.out.println(ip.getHostName());
        System.out.println(ip.getHostAddress());

        //获取其他主机 ip地址对象
        InetAddress ip2=InetAddress.getByName("www.baidu.com");//host 可以是ip地址，主机名，域名
        System.out.println(ip2.getHostName());
        System.out.println(ip2.getHostAddress());

    }
}
