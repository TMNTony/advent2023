package org.example;

import Inputs.Day2Input;
import java.util.HashMap;
import java.util.Map;

public class Day2 {

    public static void main(String[] args) {
        System.out.println(solution(games));

    }

    public static Day2Input day2Input = new Day2Input();
    public static String[] games = day2Input.gameResults;

    public static Map<String, Integer> colorMaxValue = new HashMap<>() {{
        put("red", 12);
        put("green", 13);
        put("blue", 14);
    }};

    public static int gameNumber(String game){
        String[] parts = game.split(":");

        return Integer.parseInt(parts[0].trim());
    }

    public static int solution(String[] array) {
        int result = 0;
        for (String game : array){
            if (isValid(mappedGame(game))){
                result += gameNumber(game);
            }
        }
        return result;
    }

    public static Map<String, Integer> mappedGame(String game) {
        String[] parts = game.split(":");
        Map<String, Integer> mappedGame = new HashMap<>();

        String[] colorInfo = parts[1].trim().split(",");
        for (String part : colorInfo) {
            String[] countColor = part.trim().split(" ");
            if (countColor.length == 2) {
                String color = countColor[1].toLowerCase();
                int count = Integer.parseInt(countColor[0]);
                mappedGame.put(color, count);
            } else {
                for(String s : countColor){
                    System.out.println(s);
                }
                System.out.println("Parsing Error in " + parts[0]);
            }
        }
        return mappedGame;
    }

    public static boolean isValid(Map<String, Integer> game) {
        for (String color : game.keySet()){
            if (colorMaxValue.containsKey(color)){
                if (game.get(color) > colorMaxValue.get(color)){
                    return false;
                }
            }
        }
        return true;
    }


}
