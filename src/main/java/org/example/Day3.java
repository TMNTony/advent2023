package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Day3 {

    List<String> list = new ArrayList<>();

    public static void main(String[] args) {
        Day3 app = new Day3();
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

        for (int lineNumber = 0; lineNumber < list.size(); lineNumber++) {
            String line = list.get(lineNumber);

            String numStr = "";
            int num = 0;
            int numStart = -1;
            int numEnd = -1;

            for (int j = 0; j < line.length(); j++) {
                char ch = line.charAt(j);
                if (ch > 47 && ch < 58) {
                    numStr += ch;
                    if (numStart < 0) {
                        numStart = j;
                    }

                } else {
                    if (!numStr.isEmpty()) {
                        num = Integer.parseInt(numStr);
                        numEnd = j - 1;
                        boolean symbolFound = checkForSymbol(numStart, numEnd, lineNumber);
                        if (symbolFound) {
                            total += num;
                        }
                        numStr = "";
                        num = 0;
                        numStart = -1;
                        numEnd = -1;
                    }
                }
            }
        }
        return total;
    }

    private boolean checkForSymbol(int numStart, int numEnd, int lineNum) {
        String regex = "[^A-Za-z0-9. ]";
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
