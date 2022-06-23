
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {
    public void howMany(String stringa, String stringb) {
        int currIndex = 0;
        int quantity = 0;
        int currLength = 0;
        String currStringB = stringb;
        while (true) {
            currIndex = currStringB.indexOf(stringa);
            if (currIndex == -1) {
                break;
            }
            quantity = quantity + 1;
            currLength = currIndex + stringa.length();
            currStringB = currStringB.substring(currLength);
        }
        System.out.println(stringa + " found in " + stringb + ": " + quantity + " times");
    }
    public void testHowMany() {
    howMany("GAA", "ATGAACGAATTGAATC"); /* returns 3 as GAA occurs 3 times.*/ 
    howMany("AA", "ATAAAA"); /*returns 2*/
    howMany("AA", "ATAAAAAAA");
    }
}
