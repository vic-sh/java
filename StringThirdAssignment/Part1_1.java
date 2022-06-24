
/**
 * Write a description of Part1_1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part1_1 {
    
    public int findStopCodon(String dna, int startIndex, String stopCodon) {
        int stopIndex = dna.indexOf(stopCodon, startIndex);
        /*System.out.println("stopIndex " + stopIndex);*/
        int deltaIndex = stopIndex - startIndex - 3;
        /*System.out.println("deltaIndex " + deltaIndex);
        System.out.println("deltaIndex mod 3 " + deltaIndex%3);*/
        if (stopIndex != -1 && deltaIndex%3 == 0 ) {
            return stopIndex;
        }
        else {
            return dna.length();            
        }
    }
    public void testFindStopCodon() {
        String dna = "GTTAATGTAGCTTAAACCTTTAAAGCAAGGCACTGAAAATGCCTAGATGA";
        int dnalength = findStopCodon(dna, 4, "TAA");
        System.out.println(dnalength);
        String dna1 = "ATGATACTATAA";
        int dnalength1 = findStopCodon(dna1, 0, "TAA");
        System.out.println(dnalength1);
        String dna2 = "ATGATACTATA";
        int dnalength2 = findStopCodon(dna2, 0, "TAA");
        System.out.println(dnalength2);
        String dna3 = "AACCTTTAA";
        int dnalength3 = findStopCodon(dna3, 0, "TAA");
        System.out.println(dnalength3);
        String dna4 = "ATGAGCTCACTCATAGACACAAAGGTTTGGTCCTGGCCTTCTTATTAGT";
        int dnalength4 = findStopCodon(dna4, 0, "ATA");
        System.out.println(dnalength4);
        String dna5 = "ATGATACTTAA";
        int dnalength5 = findStopCodon(dna5, 0, "TAA");
        System.out.println(dnalength5);
    }
    public String findGene(String dna) {
        String startCodon = "ATG";
        int startCodonIndex = dna.indexOf(startCodon);
        if (startCodonIndex == -1) {
            return "";
        }
        int taaIndex = findStopCodon(dna, startCodonIndex+3, "TAA");
        int tagIndex = findStopCodon(dna, startCodonIndex+3, "TAG");
        int tgaIndex = findStopCodon(dna, startCodonIndex+3, "TGA");
        
        int temp = Math.min(taaIndex, tagIndex);
        int minIndex = Math.min(temp, tgaIndex);
        
        if (minIndex == dna.length()) {
            return "";
        }
        return dna.substring(startCodonIndex, minIndex + 3);
        /*
        if (dna.length() == taaIndex && dna.length() == tagIndex && dna.length() == tgaIndex) {
            return "";
        }
        int minIndex = 0;
        if (taaIndex == -1 || 
            (tgaIndex != -1 && tgaIndex < taaIndex)) {
                minIndex = tgaIndex;
            }
        else {
            minIndex = taaIndex;
        }
        if (minIndex == -1 ||
            (tagIndex != -1 && tagIndex < minIndex)) {
                minIndex = tagIndex;
            }
        if (minIndex == -1) {
            return "";
        }
        return dna.substring(startCodonIndex, minIndex+3);*/
    }
    public void testFindGene() {
    String dna1 = "GTTATAGCTTAAACCTTTAAAGCAAGGCACTGAAAATCCTAGAA";
    String dna2 = "ATGCTTTGCAAGGCATGA";
    String dna3 = "ATTATACTACATGCTTTGCAAGGCACTGAAAATCCTATTATATAGCTATAATTTGCAAGGCACTGAAATCCTA";
    String dna4 = "ATTATACTACATGCTTTGATGCAAGGCACTGAAAATCCTATTATATAGCTATAATTTGCAAGGCACTGAAATCCTA";
    String dna5 = "ATGTTATACTACCTTTGCAAGGCACTGGAAAATCCTATTATACTACCTTTGCAAGGCACTGAAATCCTA";
    String dna6 = "TATTATACTACATGCTTTGATGCAAGGCACTGAAAATCCTATTATATTAGCTATAATTTGCAAGGCACTGAAATCCTA";
    String dna7 = "ATGCTTTGACTTATGTTTTGACTTATGTTTTTTTGA";
    System.out.println("DNA string is: " + dna1);
    String gene1 = findGene(dna1);
    printAllGenes(dna1);
    System.out.println("Gene string is: " + gene1);
    
    System.out.println("DNA string is: " + dna2);
    String gene2 = findGene(dna2);
    printAllGenes(dna2);
    System.out.println("Gene string is: " + gene2);
    
    System.out.println("DNA string is: " + dna3);
    String gene3 = findGene(dna3);
    printAllGenes(dna3);
    System.out.println("Gene string is: " + gene3);
    
    System.out.println("DNA string is: " + dna4);
    String gene4 = findGene(dna4);
    printAllGenes(dna4);
    System.out.println("Gene string is: " + gene4);
    
    System.out.println("DNA string is: " + dna5);
    String gene5 = findGene(dna5);
    printAllGenes(dna5);
    System.out.println("Gene string is: " + gene5);
    
    System.out.println("DNA string is: " + dna6);
    String gene6 = findGene(dna6);
    printAllGenes(dna6);
    System.out.println("Gene string is: " + gene6);
    
    System.out.println("DNA string is: " + dna7);
    String gene7 = findGene(dna7);
    printAllGenes(dna7);
    System.out.println("Gene string is: " + gene7);
    }

    public void printAllGenes(String dna) {
        int currIndex = 0;
        int count = 0;
        String currDna = dna;
        while(true) {
            String foundGene = findGene(currDna);
            if (foundGene.length() == 0) {
                break;
            }
            count = count + 1;
            System.out.println(count + " Gene found: " + foundGene);
            System.out.println("Gene length:" + foundGene.length());
            int tempInd = currDna.indexOf(foundGene);
            int tempIndLen = tempInd + foundGene.length();
            currDna = currDna.substring(tempIndLen);
        }
    }
}

