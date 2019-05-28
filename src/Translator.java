import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import java.io.IOException;
import java.util.Scanner;

public class Translator {
    Scanner sc = new Scanner(System.in);

    void getVocabulary(String baseUrl, String myClass,String myId) {
String id ;
        if(myId != null){
id =myId;
        }
        else{
            id = myClass;
        }
        System.out.println("Enter word to ");
        System.out.println("--------------------------");
        String input = sc.nextLine();
        System.out.println("");
        String url = null;
        if(myId != null){
            url = baseUrl + input + ".aspx";
            System.out.println("URL: " + url);
        }
        else{
             url = baseUrl + input;

            System.out.println("URL: " + url);
        }

        System.out.println("");
        Document doc = null;
        try {
            Connection connection = Jsoup.connect(url);

            //set user agent to Google Chrome
            connection.userAgent("Mozilla/5.0");

            //set timeout to 10 seconds
            connection.timeout(10 * 1000);

            //get the HTML document
            doc = connection.get();

String[] str = id.split(" ");
//        System.out.println("---------------------");
            for(String mc: str) {
               if(myId != null){ System.out.println(doc.getElementById(mc).text());}
               else{
                   System.out.println(doc.getElementsByClass(mc).text());
               }
            }
            System.out.println();
            System.out.println("=======================================================");

        } catch (IOException e) {
            System.out.println("io - " + e);
        }

//        String[] shortArray = doc.getElementsByClass("short").text().split(" ");
//        String[] longArray = doc.getElementsByClass("long").text().split(" ");
//
    }

    public static void main(String[] args) throws IOException {
        Translator tr = new Translator();
        int out = 1;
        Scanner sc = new Scanner(System.in);
        while (out != 0) {

            System.out.println("1. Vocabulary");
            System.out.println("2. Translate");
            System.out.println("3. Weather");
            System.out.println("0. Exit");

            out = sc.nextInt();

//            LinkedList shortList = new LinkedList();
//            LinkedList longList = new LinkedList();
            String url;
            String myClass;
            String myId;
            if (out == 1) {
                url = "https://www.vocabulary.com/dictionary/";
                myClass = "short long";
                myId = null;
                tr.getVocabulary(url, myClass,myId);
            }
            else if(out == 2){
                url = "http://dictionary.urduwire.com/english-urdu.aspx?word=";
                myClass = "TextClassBold";
                myId = null;
                tr.getVocabulary(url,myClass,myId);
            }
            else if(out == 3){
                url = "http://weather.urduwire.com/";
                myClass = null;
                myId = "celsius7 fahrenheit7";
                tr.getVocabulary(url,myClass,myId);
            }
//            for (String a : longArray)
//                longList.insert(longList, a);
//            shortList.printList(shortList);
//            System.out.println();
//            longList.printList(longList);
        }
    }
}