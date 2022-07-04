
/**
 * Write a description of listExporters here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;

public class listExporters {
    public void tester() {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        /*String result = countryInfo(parser, "Germany");
        System.out.println(result);*/
        String result = countryInfo(parser, "Nauru");
        System.out.println("country Nauru. Which one of the following items is listed as an export from this country?");
        System.out.println(result);
        
        parser = fr.getCSVParser();
        System.out.println("Look for third country that exports fish and nuts: ");
        listExportersTwoProducts(parser, "fish", "nuts");
        
        parser = fr.getCSVParser();
        listExportersTwoProducts(parser, "gold", "diamonds");
        
        parser = fr.getCSVParser();
        System.out.println("Number of gold exporters: " + numberOfExporters(parser, "gold"));
        
        parser = fr.getCSVParser();
        
        // bigExporters(parser, "$999,999,999");
        System.out.println("What is the name of the second economy?");
        bigExporters(parser, "$999,999,999,999");
    }
    public String countryInfo(CSVParser parser, String country) {
        String info = "NOT FOUND";        
        for (CSVRecord record : parser) {
            if (record.get("Country").equals(country)) {
                info = record.get("Country") + ": " + record.get("Exports") + ": " + record.get("Value (dollars)"); 
        }
    }
    return info;
    }
    public void listExportersTwoProducts(CSVParser parser, String exportItem1, String exportItem2) {
        for (CSVRecord record : parser) {
            if (record.get("Exports").indexOf(exportItem1) != -1) {
                if (record.get("Exports").indexOf(exportItem2) != -1) {
                    System.out.println(record.get("Country"));
                }
            }
        }
    }
    public int numberOfExporters(CSVParser parser, String exportItem) {
        int numberOfCountries = 0;
        for (CSVRecord record : parser) {
            if (record.get("Exports").indexOf(exportItem) != -1) {
                numberOfCountries = numberOfCountries + 1;
            }
        }
    return numberOfCountries;
    }
    public void bigExporters(CSVParser parser, String amount) {
        for (CSVRecord record : parser) {
            if (record.get("Value (dollars)").length() > amount.length()) {
                 System.out.println(record.get("Country") + " " + record.get("Value (dollars)"));
            }
        }
    } 
}


