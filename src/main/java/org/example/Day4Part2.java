package org.example;

import Inputs.Input;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day4Part2 {
    String url = "inputs/input4.txt";
    List<String> lines = new ArrayList<>();

    public static void main(String[] args) {
        Day4Part2 app = new Day4Part2();
        app.run();
    }

    public void run() {
        Input input = new Input();
        input.getlines(url);
        int total = matchingNums();
        System.out.println(total);

    }

    private int matchingNums() {
        Map<Integer, Integer> gameMatches = new LinkedHashMap<>();

        for (String line : lines) {
            int cardScore = 0;
            List<Integer> card1 = new ArrayList<>();
            List<Integer> card2 = new ArrayList<>();

            parseLine(line, card1, card2);
            cardScore = getCardMatches(card1, card2);
            gameMatches.put(cardScore, 1);
        }

        return makeCopies(gameMatches);
    }

    private int makeCopies(Map<Integer, Integer> games) {
        for (Map.Entry<Integer, Integer> game : games.entrySet()) {
            int matches = game.getKey();
            int copies = game.getValue();

        }
        return 0;
    }

    private int getCardMatches(List<Integer> card1, List<Integer> card2) {
        int cardScore = 0;
        for (int scratch : card1) {
            if (card2.contains(scratch)) {
                cardScore++;
            }
        }

        return cardScore;
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
        if (!(numbersList.size() == 10) && !(numbersList.size() == 25)) {
            System.out.println("parsing error");
        }

        return numbersList;
    }
}
