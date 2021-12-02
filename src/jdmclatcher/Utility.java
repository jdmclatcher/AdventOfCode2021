package jdmclatcher;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Utility {
    public static BufferedReader getReader(int day, boolean test) {
        String testString = "";
        if (test) {
            testString = "test_";
        }
        File file = new File("/Users/jdmclatcher" +
                "/Documents/Code/AdventOfCode2021/src" +
                "/jdmclatcher/Day" + day + "" +
                "/" + testString + "input.txt");
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            System.err.println("ERROR: Cannot find file.");
            return null;
        }
        return reader;
    }
}
