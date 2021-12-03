package jdmclatcher.Day3;

import jdmclatcher.Utility;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

public class Solution {
    public static void main(String[] args) {
        try {
            // System.out.println(binaryDiagnosticPart1());
            System.out.println(binaryDiagnosticPart2());
        } catch (IOException e) {
            System.err.println("ERROR: IO Exception thrown");
        }
    }

    private static int binaryDiagnosticPart1() throws IOException {
        BufferedReader reader = Utility.getReader(3, false);
        if (reader == null) {
            System.err.println("ERROR: No reader.");
            return -1;
        }
        String line = reader.readLine();
        int[] onesCounts = new int[line.length()];
        int totalCount = 0;
        while (line != null) {
            for (int i = 0; i < line.length(); i++) {
                if (line.charAt(i) == '1') {
                    onesCounts[i]++;
                }
            }
            line = reader.readLine();
            totalCount++;
        }
        StringBuilder gammaRateString = new StringBuilder();
        StringBuilder epsilonRateString = new StringBuilder();
        for (int i = 0; i < onesCounts.length; i++) {
            if (onesCounts[i] > totalCount - onesCounts[i]) {
                gammaRateString.append("1");
                epsilonRateString.append("0");
            } else {
                gammaRateString.append("0");
                epsilonRateString.append("1");
            }
        }
        int gammaRate = Integer.parseInt(String.valueOf(gammaRateString), 2);
        int epsilonRate = Integer.parseInt(String.valueOf(epsilonRateString), 2);
        return gammaRate * epsilonRate;
    }

    private static int binaryDiagnosticPart2() throws IOException {
        BufferedReader reader = Utility.getReader(3, false);
        if (reader == null) {
            System.err.println("ERROR: No reader.");
            return -1;
        }
        String line = reader.readLine();
        int lineLength = line.length();
        ArrayList<String> oxygenSet = new ArrayList<>();
        ArrayList<String> co2Set = new ArrayList<>();
        while (line != null) {
            oxygenSet.add(line);
            co2Set.add(line);
            line = reader.readLine();
        }
        for (int i = 0; i < lineLength; i++) {
            int onesCount = 0;
            int totalCount = oxygenSet.size();
            char bitToKeep;
            for (int j = 0; j < oxygenSet.size(); j++) {
                if (oxygenSet.get(j).charAt(i) == '1') {
                    onesCount++;
                }
            }
            if (onesCount >= totalCount - onesCount) {
                bitToKeep = '1';
            } else {
                bitToKeep = '0';
            }
            // remove all invalid nums
            ArrayList<String> toRemove = new ArrayList<>();
            for (String s : oxygenSet) {
                if (s.charAt(i) != bitToKeep) {
                    toRemove.add(s);
                }
            }
            oxygenSet.removeAll(toRemove);
            if (oxygenSet.size() == 1) {
                break;
            }
        }

        for (int i = 0; i < lineLength; i++) {
            int onesCount = 0;
            int totalCount = co2Set.size();
            char bitToKeep;
            for (int j = 0; j < co2Set.size(); j++) {
                if (co2Set.get(j).charAt(i) == '1') {
                    onesCount++;
                }
            }
            if (onesCount >= totalCount - onesCount) {
                bitToKeep = '0';
            } else {
                bitToKeep = '1';
            }
            // remove all invalid nums
            ArrayList<String> toRemove = new ArrayList<>();
            for (String s : co2Set) {
                if (s.charAt(i) != bitToKeep) {
                    toRemove.add(s);
                }
            }
            co2Set.removeAll(toRemove);
            if (co2Set.size() == 1) {
                break;
            }
        }
        int oxygen = Integer.parseInt(oxygenSet.get(0), 2);
        int co2 = Integer.parseInt(co2Set.get(0), 2);
        return oxygen * co2;
    }
}
