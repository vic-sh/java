
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part1 {

    public String findSimpleGene(String dna) {
        String gene = "";
        String startCodon = "ATG";
        String stopCodon = "TAA";
        int startCodonIndex = dna.indexOf(startCodon);
        if (startCodonIndex == -1) {
            return "";
        }
        int stopCodonIndex = dna.indexOf(stopCodon, startCodonIndex+3);
        if (stopCodonIndex == -1) {
            return "";
        }
        gene = dna.substring(startCodonIndex, stopCodonIndex+3);
        if (gene.length()%3 != 0) {
            return "";
        }
        System.out.println("The gene was found: " + gene);
        return gene;
    }
    public void testSimpleGene() {
        String DNA1 = "ATGTGTGTGTAA";
        String DNA2 = "ATGAAATAA";
        String DNA3 = "AAATAA";
        String DNA4 = "ATGAAA";
        String DNA5 = "ATGAATAA";
        String DNA6 = "AAATGCCCTAACTAGATTAAGAAACC";
        System.out.println("DNA string is: " + DNA1);
        findSimpleGene(DNA1);
        System.out.println("DNA string is: " + DNA2);
        findSimpleGene(DNA2);
        System.out.println("DNA string is: " + DNA3);
        findSimpleGene(DNA3);
        System.out.println("DNA string is: " + DNA4);
        findSimpleGene(DNA4);
        System.out.println("DNA string is: " + DNA5);
        findSimpleGene(DNA5);
        System.out.println("DNA string is: " + DNA6);
        findSimpleGene(DNA6);
    }
    
}
