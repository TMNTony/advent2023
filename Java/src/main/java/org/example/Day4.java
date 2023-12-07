package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day4 {

    List<String> lines = new ArrayList<>();

    public static void main(String[] args) {
        Day4 app = new Day4();
        app.run();
    }

    public void run() {
        File file = new File("../inputs/input4.txt");
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                lines.add(scanner.nextLine());
            }
            int total = matchingNums();
            System.out.println(total);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private int matchingNums() {
        int total = 0;
        for (String line : lines) {
            int cardScore = 0;
            List<Integer> card1 = new ArrayList<>();
            List<Integer> card2 = new ArrayList<>();

            parseLine(line, card1, card2);

            for (int scratch : card1){
                if (card2.contains(scratch)){
                   cardScore = cardScore == 0 ? 1 : cardScore * 2;
                }
            }
            total += cardScore;
        }
        return total;
    }

    private void parseLine(String inputString, List<Integer> card1, List<Integer> card2) {
        // Split the string using "|" as the delimiter
        String[] cards = inputString.split("\\|");
        String[] removeGameNum = cards[0].split(":");

        // Convert the string values to integers and populate lists
        card1.addAll(parseNumbers(removeGameNum[1]));
        card2.addAll(parseNumbers(cards[1]));
    }

    private List<Integer> parseNumbers(String numbersString) {
        // Convert the string values to integers and create a list
        String[] numberArray = numbersString.trim().split("\\s+");
        List<Integer> numbersList = new ArrayList<>();

        for (int i = 0; i < numberArray.length; i++) {
            int num = Integer.parseInt(numberArray[i]);
            numbersList.add(num);

        }
        if (!(numbersList.size() == 10) && !(numbersList.size() == 25)){
            System.out.println("parsing error");
        }

        return numbersList;
    }
}
