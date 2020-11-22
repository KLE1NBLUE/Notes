import java.io.File;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Test01 {

    public static void main(String[] args) throws Exception {
        String html1 = "<html><body><p>Hello HTML</p></body></html>";
        Document doc1 = Jsoup.parse(html1);
        System.out.println("基于字符串方式得到的 Document:\r\n"+ doc1);


            File input = new File("/tmp/input.html");
            Document doc2 = Jsoup.parse(input, "UTF-8", "http://baidu.com/");;
            System.out.println("基于文件方式得到的 Document:\r\n"+ doc2);


        String url = "http://www.baidu.com";
        Document doc3 = Jsoup.parse(new URL(url),5000); //超过5秒就报错
        System.out.println("基于URL方式得到的 Document:\r\n"+ doc3);

    }
}

