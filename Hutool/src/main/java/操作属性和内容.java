import java.io.File;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class 操作属性和内容 {

    static Document doc;
    public static void main(String[] args) throws Exception {

        File f = new File("a.html");
        if(!f.exists())
            return;

        doc = Jsoup.parse(f,"utf-8");

        System.out.println(doc);

        Element e = doc.select("p").first();
        e.attr("class", "class1");

        e.appendText(" Hello JSoup");
        System.out.println();
        System.out.println(doc);

    }

}

