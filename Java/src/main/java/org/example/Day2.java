package org.example;

import Inputs.Day2Input;

import java.util.HashMap;
import java.util.Map;

public class Day2 {

    public static void main(String[] args) {
        System.out.println(solutionV2(games));
    }

    public static Day2Input day2Input = new Day2Input();
    public static String[] games = day2Input.gameResults;

    public static Map<String, Integer> colorMaxValue = new HashMap<>() {{
        put("red", 12);
        put("green", 13);
        put("blue", 14);
    }};

    public static int gameNumber(String game) {
        String[] parts = game.split(" ");
        String[] gameNum = parts[1].split(":");

        return Integer.parseInt(gameNum[0]);
    }

    public static int solution(String[] array) {
        int result = 0;
        for (String game : array) {
            String[] parts = game.split(":");
            String[] rounds = parseRound(parts[1]);
            int validRounds = 0;

            for (String round : rounds) {
                if (isValid(mappedRound(round))) {
                    validRounds++;
                }
            }
            if (validRounds == rounds.length) {
                result += gameNumber(game);
            }
        }
        return result;
    }

    public static int solutionV2(String[] array) {
        int result = 0;
        for (String game : array) {
            int power = 1;
            String[] parts = game.split(":");
            String[] rounds = parseRound(parts[1]);
            Map<String, Integer> mappedGame = new HashMap<>(){{
                put("red", 0);
                put("blue", 0);
                put("green", 0);
            }};

            for (String round : rounds) {
                Map<String, Integer> mappedRound = mappedRound(round);
                for (String value : mappedRound.keySet()){
                    if( mappedRound.get(value) > mappedGame.get(value)){
                        mappedGame.put(value, mappedRound.get(value));
                    }
                }
            }
            for (String value : mappedGame.keySet()){
                power = power * mappedGame.get(value);
            }
            result = result + power;
        }
        return result;
    }

    public static Map<String, Integer> mappedRound(String round) {
        Map<String, Integer> mappedRound = new HashMap<>();

        String[] colorInfo = round.trim().split(",");
        for (String part : colorInfo) {
            String[] countColor = part.trim().split(" ");
            if (countColor.length == 2) {
                String color = countColor[1].toLowerCase();
                int count = Integer.parseInt(countColor[0]);
                mappedRound.put(color, count);
            }
        }
        return mappedRound;
    }

    public static String[] parseRound(String game) {
        return game.trim().split(";");
    }

    public static boolean isValid(Map<String, Integer> mappedGame) {
        for (String color : mappedGame.keySet()) {
            if (mappedGame.get(color) > colorMaxValue.get(color)) {
                return false;
            }
        }
        return true;
    }


}
