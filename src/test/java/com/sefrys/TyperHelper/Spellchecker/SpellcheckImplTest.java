package com.sefrys.TyperHelper.Spellchecker;

import com.sefrys.DataStructures.Hash.HashCollection;
import com.sefrys.DataStructures.Hash.HashTable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Ireneusz Zagan on 17.05.18, 15:19
 * Contact: sefrys@gmail.com
 */
class SpellcheckImplTest {

    private HashTable map;
    private SpellcheckImpl spellcheck;

    @BeforeEach
    void setUp() throws IOException {
        this.map = new HashTable();
        this.spellcheck = new SpellcheckImpl(map);
        Path dictionaryPath = new File("/home/adonalsium/Documents/Codecool/Java SE/Data Structures/DataStructures/src/main/resources/dictionary.txt").toPath();
        List<String> wordList = Files.readAllLines(dictionaryPath);

        for (String word : wordList) {
            map.add(word);
        }
    }

    @Test
    void testAdjacentLetterSwap() {
        assertTrue(spellcheck.adjacentLetterSwap("thikn").contains("think"));
        assertTrue(spellcheck.adjacentLetterSwap("phoen").contains("phone"));
        assertTrue(spellcheck.adjacentLetterSwap("bga").contains("bag"));
    }

    @Test
    void testAdjacentLetterSwapCaseInsensitive() {
        assertTrue(spellcheck.adjacentLetterSwap("Thikn").contains("think"));
        assertTrue(spellcheck.adjacentLetterSwap("pHoen").contains("phone"));
        assertTrue(spellcheck.adjacentLetterSwap("BGA").contains("bag"));

    }

    @Test
    void testAdjacentLetterInsert() {
        assertTrue(spellcheck.adjacentLetterInsert("thin").contains("thing"));
        assertTrue(spellcheck.adjacentLetterInsert("ilk").contains("milk"));
        assertTrue(spellcheck.adjacentLetterInsert("watr").contains("water"));
    }

    @Test
    void testAdjacentLetterInsertCaseInsensitive() {
        assertTrue(spellcheck.adjacentLetterInsert("THin").contains("thing"));
        assertTrue(spellcheck.adjacentLetterInsert("ilK").contains("milk"));
        assertTrue(spellcheck.adjacentLetterInsert("WATR").contains("water"));
    }

    @Test
    void testDeleteLetter() {
        assertTrue(spellcheck.letterDeletion("watter").contains("water"));
        assertTrue(spellcheck.letterDeletion("imilk").contains("milk"));
        assertTrue(spellcheck.letterDeletion("silkk").contains("silk"));
    }

    @Test
    void testDeleteLetterCaseInsensitive() {
        assertTrue(spellcheck.letterDeletion("WaTTer").contains("water"));
        assertTrue(spellcheck.letterDeletion("ImilK").contains("milk"));
        assertTrue(spellcheck.letterDeletion("sILKk").contains("silk"));
    }

    @Test
    void testReplaceLetter() {
        assertTrue(spellcheck.letterReplacement("bater").contains("water"));
        assertTrue(spellcheck.letterReplacement("boot").contains("book"));
        assertTrue(spellcheck.letterReplacement("appre").contains("apple"));
    }

    @Test
    void testReplaceLetterCaseInsensitive() {
        assertTrue(spellcheck.letterReplacement("BATEr").contains("water"));
        assertTrue(spellcheck.letterReplacement("BOOT").contains("book"));
        assertTrue(spellcheck.letterReplacement("appRe").contains("apple"));
    }

    @Test
    void testWordSplitter() {
        List<String> splitWords_1 = spellcheck.wordSplitter("appleboot");
        List<String> splitWords_2 = spellcheck.wordSplitter("milksilk");
        List<String> splitWords_3 = spellcheck.wordSplitter("tomatoalgorithm");

        assertTrue(splitWords_1.contains("apple") && splitWords_1.contains("boot"));
        assertTrue(splitWords_2.contains("milk") && splitWords_2.contains("silk"));
        assertTrue(splitWords_3.contains("tomato") && splitWords_3.contains("algorithm"));
    }

    @Test
    void testGatherSuggestions() {
        assertTrue(spellcheck.gatherSuggestions("smewhere").contains("somewhere"));
        assertTrue(spellcheck.gatherSuggestions("tomatoalgorithm").contains("algorithm"));
        assertTrue(spellcheck.gatherSuggestions("BOOT").contains("book"));
    }
}