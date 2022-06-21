
/**
 * Write a description of Part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part3 {
    public boolean twoOccurences(String stringa, String stringb) {
        int firstOccurence = stringb.indexOf(stringa);
        if (firstOccurence != -1) {
            int secondOccurence = stringb.indexOf(stringa, firstOccurence+stringa.length());
            if (secondOccurence != -1) {
                return true;
            }
        }
        return false;
    }
    public void testing() {
        boolean callOccur1 = twoOccurences("by", "“A story by Abby Long");
        System.out.println(callOccur1);
        boolean callOccur2 = twoOccurences("a", "banana");
        System.out.println(callOccur2);
        boolean callOccur3 = twoOccurences("atg", "ctgtatgta");
        System.out.println(callOccur3);
        System.out.println("LastPart");
        System.out.println("an" + "banana");
        System.out.println(lastPart("an", "banana"));
        System.out.println("zoo" + "forest");
        System.out.println(lastPart("zoo", "forest"));
    }
    public String lastPart(String stringa, String stringb) {
        int occurenceIndex = stringb.indexOf(stringa);
        if (occurenceIndex == -1) {
            return stringb;
        }
        return stringb.substring(occurenceIndex+stringa.length());
    }
}
