package org.example;

import Inputs.Day2Input;

public class Day2 {

    public static void main(String[] args) {
        System.out.println(solution(games));

    }

    public static Day2Input day2Input = new Day2Input();
    public static String[] games = day2Input.gameResults;

    public static int solution(String[] array) {
        int result = 0;


        return result;
    }

    public static boolean isValid(String game) {
        int red = 12;
        int green = 13;
        int blue = 14;
       String[] parts = game.split(":");

       int gameNumber = Integer.parseInt(parts[0].trim());
       String[] colorInfo = parts[1].trim().split(",");
       for(String part : colorInfo){
           String[] countColor = part.trim().split(" ");
           if (countColor.length == 2){
               String color = countColor[1].toLowerCase();
               int count = Integer.parseInt(countColor[0]);

           } else {
               System.out.println("Parsing Error in" + parts[0]);
           }
       }
       return true;
    }

}
