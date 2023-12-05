package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Day3Part2 {

    List<String> list = new ArrayList<>();

    public static void main(String[] args) {
        Day3Part2 app = new Day3Part2();
        app.run();
    }

    private void run() {
        File file = new File("input3.txt");
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

        for (String line : list) {
            int asterisk = 0;

            for (int j = 0; j < line.length(); j++) {
                char ch = line.charAt(j);
                String regex = ".*\\*.*";

                if (regex.matches(String.valueOf(ch))) {
                    asterisk = j;
                    total += checkForNums(asterisk);
                }
            }
        }
        return total;
    }

    private int checkForNums(int asterisk){
         List<Integer> nums = new ArrayList<>();
         int total = 0;




         if (nums.size() == 2){
             total = nums.get(0) * nums.get(1);
         }
    }

    private boolean checkForSymbol(int numStart, int numEnd, int lineNum) {
        String regex = ".*\\*.*";
        try {
            String left = list.get(lineNum).charAt(numStart - 1) + "";

            if (left.matches(regex)) {
                return true;
            }
        } catch (IndexOutOfBoundsException e) {
            //              No error handling needed
        }
        try {
            String right = list.get(lineNum).charAt(numEnd + 1) + "";

            if (right.matches(regex)) {
                return true;
            }
        } catch (IndexOutOfBoundsException e) {
            //              No error handling needed
        }
        try {
            String diagUpLeft = list.get(lineNum - 1).charAt(numStart - 1) + "";
            if (diagUpLeft.matches(regex)) {
                return true;
            }
        } catch (IndexOutOfBoundsException e) {
            //              No error handling needed
        }
        try {
            String diagUpRight = list.get(lineNum - 1).charAt(numEnd + 1) + "";
            if (diagUpRight.matches(regex)) {
                return true;
            }
        } catch (IndexOutOfBoundsException e) {
            //              No error handling needed
        }
        try {
            String diagDownLeft = list.get(lineNum + 1).charAt(numStart - 1) + "";
            if (diagDownLeft.matches(regex)) {
                return true;
            }
        } catch (IndexOutOfBoundsException e) {
            //              No error handling needed
        }
        try {
            String diagDownRight = list.get(lineNum + 1).charAt(numEnd + 1) + "";
            if (diagDownRight.matches(regex)) {
                return true;
            }
        } catch (IndexOutOfBoundsException e) {
            //              No error handling needed
        }
        // Check above and below number

        for (int i = numStart; i < numEnd + 1; i++) {
            try {
                String up = list.get(lineNum - 1).charAt(i) + "";
                if (up.matches(regex)) {
                    return true;
                }
            } catch (IndexOutOfBoundsException e) {
                //              No error handling needed
            }
            try {
                String down = list.get(lineNum + 1).charAt(i) + "";
                if (down.matches(regex)) {
                    return true;
                }
            } catch (IndexOutOfBoundsException e) {
                //              No error handling needed
            }
        }

        return false;
    }
}

