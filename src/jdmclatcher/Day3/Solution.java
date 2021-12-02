package jdmclatcher.Day3;

import jdmclatcher.Utility;

import java.io.BufferedReader;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) {
        try {
            System.out.println(day3());
        } catch (IOException e) {
            System.err.println("ERROR: IO Exception thrown");
        }
    }

    private static int day3() throws IOException {
        BufferedReader reader = Utility.getReader(3, false);
        if (reader == null) {
            System.err.println("ERROR: No reader.");
            return -1;
        }
        String line;
        while ((line = reader.readLine()) != null) {

        }
        return 0;
    }
}
