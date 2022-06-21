
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {
    public String findSimpleGene(String dna, String startCodon, String stopCodon) {
        String gene = "";
        String dnaUpperCase = dna.toUpperCase();
        int startCodonIndex = dnaUpperCase.indexOf(startCodon);
        if (startCodonIndex == -1) {
            return "";
        }
        int stopCodonIndex = dnaUpperCase.indexOf(stopCodon, startCodonIndex+3);
        if (stopCodonIndex == -1) {
            return "";
        }
        gene = dnaUpperCase.substring(startCodonIndex, stopCodonIndex+3);
        if (gene.length()%3 != 0) {
            return "";
        }
        if (dna.substring(startCodonIndex).startsWith("a")) {
            gene = gene.toLowerCase();
        }
        System.out.println("The gene was found: " + gene);
        return gene;
    }
    public void testSimpleGene() {
        String start = "ATG";
        String stop = "TAA";
        String DNA1 = "ATGTGTGTGTAA";
        String DNA2 = "ATGAAATAA";
        String DNA3 = "AAATAA";
        String DNA4 = "ATGAAA";
        String DNA5 = "ATGAATAA";
        String DNA6 = "atgaaataa";
        String DNA7 = "tagatgaaataatta";
        System.out.println("DNA string is: " + DNA1);
        findSimpleGene(DNA1, start, stop);
        System.out.println("DNA string is: " + DNA2);
        findSimpleGene(DNA2, start, stop);
        System.out.println("DNA string is: " + DNA3);
        findSimpleGene(DNA3, start, stop);
        System.out.println("DNA string is: " + DNA4);
        findSimpleGene(DNA4, start, stop);
        System.out.println("DNA string is: " + DNA5);
        findSimpleGene(DNA5, start, stop);
        System.out.println("DNA string is: " + DNA6);
        findSimpleGene(DNA6, start, stop);
        System.out.println("DNA string is: " + DNA7);
        findSimpleGene(DNA7, start, stop);
    }
}
