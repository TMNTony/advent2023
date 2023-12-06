package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day6 {
    ArrayList<String> lines = new ArrayList<>();


    public static void main(String[] args) {
        Day6 app = new Day6();
        app.run();
    }

    private void run() {
        File file = new File("input6.txt");
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                lines.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
