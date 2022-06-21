
/**
 * Write a description of Part4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
public class Part4 {
    public void test() {
        URLResource ur = new URLResource("http://www.dukelearntoprogram.com/course2/data/manylinks.html");
        for (String word : ur.words()) {
            String wordLowerCase = word.toLowerCase();
            int Occurence = word.indexOf("youtube.com");
            if (Occurence != -1) {
                int start = word.lastIndexOf("\"", Occurence);
                int stop = word.indexOf("\"", Occurence);
                System.out.println(word.substring(start, stop));
            }
        }
    }
}
