import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;

public class WebScraper {

    public static void main(String[] args) throws FileNotFoundException {

        //Redundant. File IO is done.
        File f = new File("Acceptance Rates.txt");
        File f1 = new File("Rankings.txt");
        FileOutputStream fos = new FileOutputStream(f,true);
        FileOutputStream fos1 = new FileOutputStream(f1);
        PrintWriter pw = new PrintWriter(fos);
        PrintWriter pw1 = new PrintWriter(fos1);

        try {
            Document doc = Jsoup.connect("https://www.niche.com/colleges/search/best-colleges-for-computer-science/").
                    userAgent("Mozilla").get();
            Elements collegeName = doc.select("h2");
            Elements satScore = doc.select("span");
            String[] collegeNames = new String[25];
            String[] satScores = new String[25];
            String[] acceptanceRates = new String[25];
            String[] nicheURL = new String[25];

            for(int i = 0; i < 25; i++) {
                Element college = collegeName.get(i);
                //System.out.println(college.getElementsByClass("search-result__title").text());
                collegeNames[i] = college.getElementsByClass("search-result__title").text();
            }
            int i = 0;
            for (Element xyz : satScore) {
                if (xyz.getElementsByClass("search-result-fact__value").text().contains("%")) {
                    //System.out.println(xyz.getElementsByClass("search-result-fact__value").text());
                }
               if (xyz.getElementsByClass("search-result-fact__value").text().contains("-")) {
                   satScores[i] = xyz.getElementsByClass("search-result-fact__value").text();
                   i++;
               }
                if (i==25) {
                    break;
                }
            }

            i = 0;
            for (Element xyz : satScore) {
                if (xyz.getElementsByClass("search-result-fact__value").text().contains("%")) {
                    acceptanceRates[i] = xyz.getElementsByClass("search-result-fact__value").text();
                    i++;
                }
                if (i==25) {
                    break;
                }

            }
            //Redundant
            for (i = 0; i < acceptanceRates.length; i++){
                pw.println(acceptanceRates[i]);
            }
            pw.close();


            for (i = 0; i < collegeNames.length; i++) {
               /* System.out.println(collegeNames[i]);
                System.out.println(acceptanceRates[i]);
                System.out.println(satScores[i]);
                System.out.println(); */
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}


