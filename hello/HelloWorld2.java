
/**
 * Write a description of HelloWorld2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.FileResource;

public class HelloWorld2 {
    public void runHello() {
        FileResource f;
        f = new FileResource("file.txt");
        for(String line : f.lines()) {
            System.out.println(line);
        }
    }
    public static void main(String[] args){
        HelloWorld hw = new HelloWorld();
        hw.runHello();
    }    
}
