package com.sefrys.TyperHelper.Spellchecker;

import com.sefrys.DataStructures.Hash.HashTable;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by Ireneusz Zagan on 17.05.18, 17:43
 * Contact: sefrys@gmail.com
 */
public class App {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        HashTable map = new HashTable();
        Path dictionaryPath = new File("/home/adonalsium/Documents/Codecool/Java SE/Data Structures/DataStructures/src/main/resources/dictionary.txt").toPath();
        List<String> wordList = Files.readAllLines(dictionaryPath);

        for (String word : wordList) {
            map.add(word);
        }

        SpellcheckImpl spellcheck = new SpellcheckImpl(map);
        runMenu(spellcheck);



    }


    private static void runMenu(SpellcheckImpl spellcheck) {
        System.out.println("\nPress '1' to enter spellchecker. Press '0' to exit");

        String choice = scanner.next();

        switch (choice) {
            case "1": {
                printOutSuggestions(spellcheck);
                runMenu(spellcheck);
                break;
            }

            case "0": {
                scanner.close();
                System.exit(0);
                break;
            }
            default: {
                runMenu(spellcheck);
            }

        }

    }

    private static void printOutSuggestions(SpellcheckImpl spellcheck) {
        System.out.print("Enter value to spellcheck: ");
        String value = scanner.next();
        Set<String> suggestions = spellcheck.gatherSuggestions(value);

        if (suggestions.isEmpty()) {
            System.out.println("No suggestions");
        } else {
            System.out.println("Found: " + suggestions.size() + " suggestion(s)");
            for (String suggestion : suggestions) {
                System.out.print(suggestion + ", ");
            }
        }
    }
}
