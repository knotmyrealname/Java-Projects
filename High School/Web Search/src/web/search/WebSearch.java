package web.search;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class WebSearch {
    
    
    
    public static void main(String[] args) throws IOException {
        Scanner userIn = new Scanner(System.in);
        System.out.println("Website Url: ");
        String html = userIn.nextLine();
        System.out.println();
        
        
        Document doc = Jsoup.connect(html)
                .userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/78.0.3904.87 Safari/537.36")
                .referrer("https://duckduckgo.com")
                .get();
        Elements paragraphs = doc.select("div.paragraph");
            for (Element paragraph : paragraphs ) {
                System.out.println(paragraph.text());
            }
        System.out.println("done");
    }
    
}
