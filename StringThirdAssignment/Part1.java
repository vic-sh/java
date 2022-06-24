
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;

public class Part1 {
    public int findStopCodon(String dna, int startIndex, String stopCodon) {
        int stopIndex = dna.indexOf(stopCodon, startIndex);
        /*System.out.println("stopIndex " + stopIndex);*/
        // if (stopIndex != -1 && deltaIndex%3 == 0 ) {
        if (stopIndex != -1) {
            int deltaIndex = stopIndex - startIndex - 3;
            /*System.out.println("deltaIndex " + deltaIndex);*/
            //if (deltaIndex%3 == 0) {
                System.out.println("deltaIndex: " + deltaIndex);
                System.out.println("deltaIndex mod 3: " + deltaIndex%3);
                return stopIndex;
            //}
            //else {
            //return dna.length();            
            //}
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
    String dna8 = "ATGCCTATTGGATCCAAAGAGAGGCCAACATTTTTTGAAATTTTTAAGACACGCTGCAACAAAGCAGATTTAGGACCAATAAGTCTTAATTGGTTTGAAGAACTTTCTTCAGAAGCTCCACCCTATAATTCTGAACCTGCAGAAGAATCTGAACATAAAAACAACAATTACGAACCAAACCTATTTAAAACTCCACAAAGGAAACCATCTTATAATCAGCTGGCTTCAACTCCAATAATATTCAAAGAGCAAGGGCTGACTCTGCCGCTGTACCAATCTCCTGTAAAAGAATTAGATAAATTCAAATTAGACTTAGGAAGGAATGTTCCCAATAGTAGACATAAAAGTCTTCGCACAGTGAAAACTAAAATGGATCAAGCAGATGATGTTTCCTGTCCACTTCTAAATTCTTGTCTTAGTGAAAGTCCTGTTGTTCTACAATGTACACATGTAACACCACAAAGAGATAAGTCAGTGGTATGTGGGAGTTTGTTTCATACACCAAAGTTTGTGAAGGGTCGTCAGACACCAAAACATATTTCTGAAAGTCTAGGAGCTGAGGTGGATCCTGATATGTCTTGGTCAAGTTCTTTAGCTACACCACCCACCCTTAGTTCTACTGTGCTCATAGTCAGAAATGAAGAAGCATCTGAAACTGTATTTCCTCATGATACTACTGCTAATGTGAAAAGCTATTTTTCCAATCATGATGAAAGTCTGAAGAAAAATGATAGATTTATCGCTTCTGTGACAGACAGTGAAAACACAAATCAAAGAGAAGCTGCAAGTCATGGATTTGGAAAAACATCAGGGAATTCATTTAAAGTAAATAGCTGCAAAGACCACATTGGAAAGTCAATGCCAAATGTCCTAGAAGATGAAGTATATGAAACAGTTGTAGATACCTCTGAAGAAGATAGTTTTTCATTATGTTTTTCTAAATGTAGAACAAAAAATCTACAAAAAGTAAGAACTAGCAAGACTAGGAAAAAAATTTTCCATGAAGCAAACGCTGATGAATGTGAAAAATCTAAAAACCAAGTGA";
    /*System.out.println("DNA string is: " + dna1);
    String gene1 = findGene(dna1);
    printAllGenes(dna1);
    System.out.println("Gene string is: " + gene1);*/
    testOn(dna1);
    
    /*System.out.println("DNA string is: " + dna2);
    String gene2 = findGene(dna2);
    printAllGenes(dna2);
    System.out.println("Gene string is: " + gene2);*/
    testOn(dna2);
    
    /*System.out.println("DNA string is: " + dna3);
    String gene3 = findGene(dna3);
    printAllGenes(dna3);
    System.out.println("Gene string is: " + gene3);*/
    testOn(dna3);
    
    /*System.out.println("DNA string is: " + dna4);
    String gene4 = findGene(dna4);
    printAllGenes(dna4);
    System.out.println("Gene string is: " + gene4);*/
    testOn(dna4);
    
    /*System.out.println("DNA string is: " + dna5);
    String gene5 = findGene(dna5);
    printAllGenes(dna5);
    System.out.println("Gene string is: " + gene5);*/
    testOn(dna5);
    
    /*System.out.println("DNA string is: " + dna6);
    String gene6 = findGene(dna6);
    printAllGenes(dna6);
    System.out.println("Gene string is: " + gene6);*/
    testOn(dna6);
    
    /*System.out.println("DNA string is: " + dna7);
    String gene7 = findGene(dna7);
    printAllGenes(dna7);
    System.out.println("Gene string is: " + gene7);*/
    testOn(dna7);
    
    String gene8 = findGene(dna8);
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
    public StorageResource getAllGenes(String dna) {        
        int count = 0;
        StorageResource geneList = new StorageResource();
        String currDna = dna;
        while(true) {
            System.out.println("Entering while(true) loop in getAllGenes");
            String foundGene = findGene(currDna);
            if (foundGene.length() == 0) {
                break;
            }
            geneList.add(foundGene);
            count = count + 1;
            //System.out.println(count + " Gene found: " + foundGene);
            //System.out.println("Gene length:" + foundGene.length());
            int tempInd = currDna.indexOf(foundGene);
            int tempIndLen = tempInd + foundGene.length();
            currDna = currDna.substring(tempIndLen);
        }
    return geneList;
    }
    public void testOn(String dna) {
        System.out.println("Testing getAllGenes");
        StorageResource genes = getAllGenes(dna);
        for (String s : genes.data()) {
            System.out.println(s);
        }
    }
    
    public float cgRatio(String dna) {
        int count = 0;
        int currInd = 0;
        float result = 0;
        String currDna = dna;
        while(true) {
            int indG = currDna.indexOf("G");
            int indC = currDna.indexOf("C");
            if (indG != -1 || indC != -1) {
                count = count + 1;
                if (indC != -1 && indG != -1) {
                    if (indC < indG) {
                        currInd = indC;
                    }
                    else {
                        currInd = indG;
                    }
                }
                else if (indC == -1) {
                    currInd = indG;
                }
                else {
                    currInd = indC;
                }
                }
            else {
                break;
            }
            currDna = currDna.substring(currInd+1);
        }
    System.out.println("Number of C and G: " + count);
    System.out.println("DNA length: " + dna.length());
    System.out.println("============================");
    result = (float) count/ dna.length();
    return result;
    }
    public void cgRatioTest() {
        float cg = cgRatio("ATGCCACGTTAG");
        System.out.println(cg);
    }
    public int countCTG(String dna) {
        int count = 0;
        int currIndex = 0;
        String codon = "CTG";
        String currDna = dna;
        currIndex = currDna.indexOf(codon);
        while (currIndex != -1) {
            count = count + 1;
            currDna = currDna.substring(currIndex+3);
            currIndex = currDna.indexOf(codon);
        }
        return count;
    }
    public void testCountCTG() {
        int ctg = countCTG("ATGCCACTGCTGTAGCTG");
        System.out.println(ctg);
    }
    public void processGenes(StorageResource sr) {
        int countMTN = 0;
        int countCGR = 0;
        float cgRatioNum = 0;
        String longestGene = "";
        for (String s : sr.data()) {
            if (s.length() >= 60) {
                countMTN = countMTN + 1;
                System.out.println("String with more than 60 characters: " + s);
            }
            cgRatioNum = cgRatio(s);
            if (cgRatioNum > 0.35) {
                countCGR = countCGR + 1;
                System.out.println("String with C-G-Ratio more than 0.35: " + s);
            }
            StorageResource allgenes = getAllGenes(s);
            for (String g : allgenes.data()) {
                if (g.length() > longestGene.length()) {
                    longestGene = g;
                }
            }
        }
        System.out.println("The number of genes found: " + sr.size());
        System.out.println("The number of strings with more than 9 characters: " + countMTN);
        System.out.println("The number of strings with C-G-Ratio more than 0.35: " + countCGR);
        System.out.println("The longest gene: " + longestGene);
        System.out.println("The longest gene length: " + longestGene.length());
    }
    public void testProcessGenes() {

        StorageResource geneList = new StorageResource();
        /*
        String dna1 = "GTTATAGCTTAAACCTTTAAAGCAAGGCACTGAAAATCCTAGAA";
        String dna2 = "ATGCTTTGCAAGGCATGA";
        String dna3 = "ATTATACTACATGCTTTGCAAGGCACTGAAAATCCTATTATATAGCTATAATTTGCAAGGCACTGAAATCCTA";
        String dna4 = "ATTATACTACATGCTTTGATGCAAGGCACTGAAAATCCTATTATATAGCTATAATTTGCAAGGCACTGAAATCCTA";
        String dna5 = "ATGTTATACTACCTTTGCAAGGCACTGGAAAATCCTATTATACTACCTTTGCAAGGCACTGAAATCCTA";
        String dna6 = "TATTATACTACATGCTTTGATGCAAGGCACTGAAAATCCTATTATATTAGCTATAATTTGCAAGGCACTGAAATCCTA";
        String dna7 = "ATGCTTTGACTTATGTTTTGACTTATGTTTTTTTGA";

        geneList.add(dna1);
        geneList.add(dna2);
        geneList.add(dna3);
        geneList.add(dna4);
        geneList.add(dna5);
        geneList.add(dna6);
        geneList.add(dna7);*/
        FileResource fr = new FileResource("GRch38dnapart.fa");
        String dna = fr.asString();
        System.out.println("DNA String: " + dna.toUpperCase());
        StorageResource allGenes = getAllGenes(dna.toUpperCase());
        for (String s : allGenes.data()) {
            System.out.println("gene found: " + s);
        processGenes(allGenes);
        }
    }
}