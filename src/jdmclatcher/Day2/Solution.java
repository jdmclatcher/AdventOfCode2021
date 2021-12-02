package jdmclatcher.Day2;

import jdmclatcher.Utility;

import java.io.BufferedReader;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) {
        try {
            System.out.println(divePart1());
            System.out.println(divePart2());
        } catch (IOException e) {
            System.err.println("ERROR: IO Exception thrown");
        }
    }

    private static int divePart1() throws IOException {
        Utility util = new Utility();
        BufferedReader reader = util.getReader(2, false);
        if (reader == null) {
            System.err.println("ERROR: No reader.");
            return -1;
        }
        String line;
        int depth = 0;
        int position = 0;
        while ((line = reader.readLine()) != null) {
            // determine direction and update accordingly
            if (line.contains("forward")) {
                String[] args = line.split(" ");
                position += Integer.parseInt(args[1]);
            } else if (line.contains("down")) {
                String[] args = line.split(" ");
                depth += Integer.parseInt(args[1]);
            } else if (line.contains("up")) {
                String[] args = line.split(" ");
                depth -= Integer.parseInt(args[1]);
            }
        }
        return depth * position;
    }

    private static int divePart2() throws IOException {
        Utility util = new Utility();
        BufferedReader reader = util.getReader(2, false);
        if (reader == null) {
            System.err.println("ERROR: No reader.");
            return -1;
        }
        String line;
        int depth = 0;
        int position = 0;
        int aim = 0;
        while ((line = reader.readLine()) != null) {
            // determine direction and update accordingly
            if (line.contains("forward")) {
                String[] args = line.split(" ");
                position += Integer.parseInt(args[1]);
                depth += aim * Integer.parseInt(args[1]);
            } else if (line.contains("down")) {
                String[] args = line.split(" ");
                aim += Integer.parseInt(args[1]);
            } else if (line.contains("up")) {
                String[] args = line.split(" ");
                aim -= Integer.parseInt(args[1]);
            }
        }
        return depth * position;
    }
}
