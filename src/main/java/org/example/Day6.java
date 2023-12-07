package org.example;

import Inputs.Input;

import java.util.ArrayList;


public class Day6 {
    ArrayList<String> lines = new ArrayList<>();
    String url = "inputs/input6.txt";

    public static void main(String[] args) {
        Day6 app = new Day6();
        app.run();
    }

    private void run() {
        Input input = new Input();
        lines = input.getlines(url);
        for (String line : lines){
            System.out.println(line);
        }


    }
}
