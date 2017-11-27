package com.codegile.university.victoria.week1.day1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        //readNumbersFromFile();
        // readNamesFromFile();
        //sortWordsLex();
        //readFromHtml();
        readFirstLineFromFile();

    }

    public static void readFirstLineFromFile(){
        //String filename = "tricouri.txt";
        //String workingDirectory = System.getProperty("user.dir");
        File file = new File("E:\\GitHub\\Codegile\\CodegileUniv\\src\\main\\java\\com\\codegile\\university\\victoria\\week1\\day1\\tricouri.txt");
        String[] words = null;

        try (Scanner input = new Scanner(file)) {
            if (input.hasNextLine()) {
                String line = input.nextLine();
                words = line.split(", ");
                System.out.println("ID: " + words[0]);
                System.out.println("Description: " + words[1]);
                System.out.println("Color: " + words[2]);
                System.out.println("Size: " + words[3]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void readFromHtml(){
        File file = new File("C:/Users/User/IdeaProjects/Test2/src/com/company/htmlFile.html");
        File file2 = new File("C:/Users/User/IdeaProjects/Test2/src/com/company/htmlFile2.html");

        String tagPattern = "<p>";
        String endTagPattern = "</p>";
        Pattern p = Pattern.compile(tagPattern);


        try {
            FileWriter writer = new FileWriter(file2);
            Scanner input = new Scanner(file);
            while (input.hasNextLine()) {
                String line = input.nextLine();
                Matcher m = p.matcher(line);
                line = m.replaceAll("<span>").replaceAll(endTagPattern, "</span>").replaceAll("\\s+", " ");
                writer.write(line);
                writer.write(System.getProperty("line.separator"));
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void sortWordsLex() {
        File file = new File("C:/Users/User/IdeaProjects/Test2/src/com/company/nume.txt");
        String[] words = null;
        String vowels = "AEIOUaeiou";

        try {
            Scanner input = new Scanner(file);

            while (input.hasNextLine()) {
                words = input.nextLine().split("; ");
                for (int i = 0; i < words.length - 1; ++i) {
                    for (int j = i + 1; j < words.length; ++j) {
                        if (words[i].compareTo(words[j]) > 0) {
                            String temp = words[i];
                            words[i] = words[j];
                            words[j] = temp;
                        }
                    }
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Sorted words: ");
        for (int i = 0; i < words.length; i++) {
            if (vowels.indexOf((words[i].charAt(0))) != -1) {
                words[i] = "" + words[i].length();
            }
            System.out.println(words[i]);
        }
    }

    public static void readNamesFromFile() {
        File file = new File("C:/Users/User/IdeaProjects/Test2/src/com/company/nume.txt");
        try {
            Scanner input = new Scanner(file);

            while (input.hasNextLine()) {
                String[] names = input.nextLine().split("; ");
                int count = 0;
                for (String name : names) {
                    int nameLength = name.length();

                    for (int i = 0; i < nameLength; i++) {
                        char c = name.charAt(i);
                        if (!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) && c != ' ') {
                            break;
                        }

                        if (i == nameLength - 1) {
                            count++;
                        }
                    }

                }

                System.out.println("Count= " + count);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }

    public static void readNumbersFromFile() {
        File file = new File("C:/Users/User/IdeaProjects/Test2/src/com/company/input.txt");
        List<Integer> integers = new ArrayList<>();
        List<Double> doubles = new ArrayList<>();
        try {
            Scanner input = new Scanner(file);

            while (input.hasNextLine()) {
                String[] numbers = input.nextLine().split(";");
                for (String number : numbers) {
                    double doubleNumber = Double.parseDouble(number);
                    if (doubleNumber % 1 == 0) {
                        integers.add((int) doubleNumber);
                    } else {
                        doubles.add(doubleNumber);
                    }
                }

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("The integer numbers are: ");
        System.out.println(integers);

        System.out.println("The double numbers are: ");
        System.out.println(doubles);
    }
}
