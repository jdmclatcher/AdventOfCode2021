import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println(sonarSweepPart1());
            System.out.println(sonarSweepPart2());
        } catch (IOException e) {
            System.err.println("ERROR: IO Exception thrown");
            return;
        }
    }
    private static BufferedReader getReader(int day, boolean test) {
        String testString = "";
        if (test) {
            testString = "_test";
        }
        File file = new File("/Users/jdmclatcher" +
                "/Documents/Code/AdventOfCode/src" +
                "/day" + day + "" + testString + "_input.txt");
        System.out.println(file.getAbsolutePath());
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            System.err.println("ERROR: Cannot find file.");
            return null;
        }
        return reader;
    }

    //region *** DAY1 - Sonar Sweep ***
    // https://adventofcode.com/2021/day/1
    public static int sonarSweepPart1() throws IOException {
        BufferedReader reader = getReader(1, false);
        if (reader == null) {
            System.err.println("ERROR: No reader.");
            return -1;
        }
        String line;
        int numIncreases = 0;
        int prevDepth = -1;
        while ((line = reader.readLine()) != null) {
            // convert each line to an int
            int depth = Integer.parseInt(line);
            // check if greater depth than previous (and not first entry)
            if (prevDepth != -1) {
                if (depth > prevDepth) {
                    numIncreases++;
                }
            }
            // update previous depth to current depth
            prevDepth = depth;
        }
        return numIncreases;
    }

    public static int sonarSweepPart2() throws IOException {
        BufferedReader reader = getReader(1, false);
        if (reader == null) {
            System.err.println("ERROR: No reader.");
            return -1;
        }
        String line;
        int numIncreases = 0;
        boolean firstPass = true;
        // use map to hold values
        HashMap<Integer, Integer> map = new HashMap();
        int loopTracker = 0;
        while ((line = reader.readLine()) != null) {
            int depth = Integer.parseInt(line);
            map.put(loopTracker, depth);
            // checks to wait for first 4 values to be added to map
            if (firstPass) {
                if (loopTracker % 3 == 0 && loopTracker != 0) {
                    // compare current depth with depth 3 places back (the difference)
                    if (map.get(loopTracker) > map.get(loopTracker - 3)) {
                        numIncreases++;
                    }
                    firstPass = false;
                }
            } else {
                // compare current depth with depth 3 places back (the difference)
                if (map.get(loopTracker) > map.get(loopTracker - 3)) {
                    numIncreases++;
                }
            }
            loopTracker++;
        }
        return numIncreases;
    }
    //endregion
}
