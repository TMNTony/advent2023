package org.example;

import Inputs.Input;
import java.util.ArrayList;


public class Day5 {

    ArrayList<String> lines = new ArrayList<>();
    String url = "../inputs/input5.txt";

    public static void main(String[] args) {
        Day5 app = new Day5();
        app.run();
    }

    private void run(){
        Input input = new Input();
        lines = input.getLines(url);

        for (String line : lines){
            System.out.println(line);
        }
    }
}
