/**
 * Write a description of Part4_2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
public class Part4_2 {
    public void test() {
        FileResource fr = new FileResource("Computer Science Articles.html");
        for (String word : fr.words()) {
            String wordLowerCase = word.toLowerCase();
            int Occurence = wordLowerCase.indexOf("youtube.com");
            if (Occurence != -1) {
                int start = word.lastIndexOf("\"", Occurence);
                int stop = word.indexOf("\"", Occurence);
                System.out.println(word.substring(start, stop+1));
            }
        }
    }
}