
/**
 * Write a description of Part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part3 {
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
    public String findGene(String dna) {
        String startCodon = "ATG";
        int startCodonIndex = dna.indexOf(startCodon);
        if (startCodonIndex == -1) {
            return "";
        }
        int taaIndex = findStopCodon(dna, startCodonIndex+3, "TAA");
        int tagIndex = findStopCodon(dna, startCodonIndex+3, "TAG");
        int tgaIndex = findStopCodon(dna, startCodonIndex+3, "TGA");
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
        return dna.substring(startCodonIndex, minIndex+3);
    }
    public void printAllGenes(String dna) {
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
    public int countGenes(String dna) {
        int numberOfGenes = 0;
        int currIndex = 0;
        String currDna = dna;
        while (true) {
            String geneFound = findGene(currDna);
            if (geneFound == "") {
                break;
            }
            numberOfGenes = numberOfGenes + 1;
            currIndex = currDna.indexOf(geneFound);
            currDna = currDna.substring(currIndex + geneFound.length());            
        }
        System.out.println("Number of genes found: " + numberOfGenes);
        return numberOfGenes;
    }
    public void testCountGenes() {
        countGenes("ATGTAAGATGCCCTAGT");
        printAllGenes("ATGTAAGATGCCCTAGT");
        String dna1 = "GTTATAGCTTAAACCTTTAAAGCAAGGCACTGAAAATCCTAGAA";
        String dna2 = "ATGCTTTGCAAGGCATGA";
        String dna3 = "ATTATACTACATGCTTTGCAAGGCACTGAAAATCCTATTATATAGCTATAATTTGCAAGGCACTGAAATCCTA";
        String dna4 = "ATTATACTACATGCTTTGATGCAAGGCACTGAAAATCCTATTATATAGCTATAATTTGCAAGGCACTGAAATCCTA";
        String dna5 = "ATGTTATACTACCTTTGCAAGGCACTGGAAAATCCTATTATACTACCTTTGCAAGGCACTGAAATCCTA";
        String dna6 = "TATTATACTACATGCTTTGATGCAAGGCACTGAAAATCCTATTATATTAGCTATAATTTGCAAGGCACTGAAATCCTA";
        String dna7 = "ATGCTTTGACTTATGTTTTGACTTATGTTTTTTTGA";
        countGenes(dna1);
        countGenes(dna2);
        countGenes(dna3);
        countGenes(dna4);
        countGenes(dna5);
        countGenes(dna6);
        countGenes(dna7);
    }
}
