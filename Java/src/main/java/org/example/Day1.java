package org.example;

import Inputs.Day1Input;

import java.util.HashMap;
import java.util.Map;

public class Day1 {
    public static void main(String[] args) {
        System.out.println(decipherDocument(lines));

    }
    static int decipheredLine(String string){
        int[] nums = new int[2];

        for (int i = 0; i < string.length(); i++) {
            if (nums[0] == 0 && Character.isDigit(string.charAt(i))) {
                nums[0] = string.charAt(i) - '0';
                nums[1] = string.charAt(i) - '0';
            } else if (Character.isDigit(string.charAt(i))) {
                nums[1] = string.charAt(i) - '0';
            }
        }
        return (nums[0] * 10) + nums[1];
    }

    static int decipheredLineV2(String string){
        Map<Integer, Integer> nums = new HashMap<>();

        for (String number : stringNumbers.keySet()){
            int index = string.indexOf(number);
            while (index != -1) {
                nums.put(index, stringNumbers.get(number));
                index = string.indexOf(number, index + 1);
            }
        }

        for (int i = 0; i < string.length(); i++) {
            if (Character.isDigit(string.charAt(i))) {
                nums.put(i, string.charAt(i) - '0');
            }
        }

        int lowestIndex = Integer.MAX_VALUE;
        int highestIndex = Integer.MIN_VALUE;

        for (int index : nums.keySet()){
            lowestIndex = Math.min(lowestIndex, index);
            highestIndex = Math.max(highestIndex, index);
        }
        return nums.get(lowestIndex) * 10 + nums.get(highestIndex);
    }

    static int decipherDocument(String[] linesArray){
        int result = 0;
        for (String line : linesArray){
            result += decipheredLineV2(line);
        }
        return result;
    }

    static Map<String, Integer> stringNumbers = new HashMap<>(){{
        put("one", 1);
        put("two", 2);
        put("three", 3);
        put("four", 4);
        put("five", 5);
        put("six", 6);
        put("seven", 7);
        put("eight", 8);
        put("nine", 9);
    }};
    static Day1Input day1Input = new Day1Input();
    static String input = day1Input.input;
    static String[] lines = input.split("\n");
}
