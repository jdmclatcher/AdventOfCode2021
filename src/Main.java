import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            // System.out.println(sonarSweepPart1());
            System.out.println(sonarSweepPart2());
        } catch (IOException e) {
            System.err.println("ERROR: IO Exception thrown");
            return;
        }
    }
    // *** DAY1 ***
    // ** Sonar Sweep ***
    // https://adventofcode.com/2021/day/1
    public static int sonarSweepPart1() throws IOException {
        File file = new File("/Users/jdmclatcher/Documents/Code/AdventOfCode/src/day1_input.txt");
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            System.err.println("ERROR: Cannot find file.");
            return -1;
        }
        String line;
        int numIncreases = 0;
        int prevDepth = -1;
        while ((line = reader.readLine()) != null) {
            int depth = Integer.parseInt(line);
            // convert each line to an int
            if (prevDepth != -1) {
                if (depth > prevDepth) {
                    numIncreases++;
                }
            }
            prevDepth = depth;
        }
        return numIncreases;
    }

    public static int sonarSweepPart2() throws IOException {
        File file = new File("/Users/jdmclatcher/Documents/Code/AdventOfCode/src/day1_test_input.txt");
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            System.err.println("ERROR: Cannot find file.");
            return -1;
        }
        String line;
        int numIncreases = 0;
        int prevSumDepth = -1;
        int trackerThree = 3;
        int sumDepth = 0;
        while ((line = reader.readLine()) != null) {
            int depth = Integer.parseInt(line);
            // convert each line to an int
            if (trackerThree == 0) {
                if (prevSumDepth != -1) {
                    if (sumDepth > prevSumDepth) {
                        numIncreases++;
                    }
                }
                trackerThree = 3;
                prevSumDepth = sumDepth;
                sumDepth = 0;
            } else {
                trackerThree--;
            }
            sumDepth += depth;
        }
        return numIncreases;
    }
}
