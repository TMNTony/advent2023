package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class Day3Part2 {

    List<String> list = new ArrayList<>();

    public static void main(String[] args) {
        Day3Part2 app = new Day3Part2();
        app.run();
    }

    private void run() {
        File file = new File("inputs/input3.txt");
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                list.add(scanner.nextLine());
            }
            int total = validParts();
            System.out.println(total);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private int validParts() {
        int total = 0;

        for (int lineNumber = 0; lineNumber < list.size(); lineNumber++) {
            String line = list.get(lineNumber);

            for (int j = 0; j < line.length(); j++) {
                char ch = line.charAt(j);
                String regex = ".*\\*.*";

                if (String.valueOf(ch).matches(regex)) {
                    total += checkForNums(j, lineNumber);
                }
            }
        }
        return total;
    }

    private int checkForNums(int asterisk, int lineNum) {
        List<Integer> nums = new ArrayList<>();
        String regex = "-?\\d+(\\.\\d+)?";
        int total = 0;

        // Define directions: [row, column]
        int[][] directions = {
                {-1, -1}, {-1, 1},
                {0, -1}, {0, 1},
                {1, -1}, {1, 1}
        };

        for (int[] direction : directions) {
            try {
                int newRow = lineNum + direction[0];
                int newCol = asterisk + direction[1];
                String value = list.get(newRow).charAt(newCol) + "";

                if (value.matches(regex)) {
                    int fullNumber = getFullNum(newRow, newCol);
                    nums.add(fullNumber);
                }
            } catch (IndexOutOfBoundsException e) {
                // Handle the exception if needed
            }
        }

        if (nums.size() == 2) {
            total = nums.stream().reduce(1, (a, b) -> a * b);
        }
        return total;
    }

    private int getFullNum(int lineNum, int index) {
        String line = list.get(lineNum);

        int left = index;
        int right = index;

        while (left > 0 && Character.isDigit(line.charAt(left - 1))) {
            left--;
        }

        while (right < line.length() - 1 && Character.isDigit(line.charAt(right + 1))) {
            right++;
        }

        return Integer.parseInt(line.substring(left, right + 1));
    }
}

