package com.sefrys.TyperHelper.Spellchecker;

import com.sefrys.DataStructures.Hash.HashCollection;
import com.sefrys.DataStructures.Hash.HashTable;

import java.util.*;

/**
 * Created by Ireneusz Zagan on 17.05.18, 14:58
 * Contact: sefrys@gmail.com
 */
public class SpellcheckImpl extends HashTable implements Spellcheck {

    private HashCollection dictionary;

    public SpellcheckImpl(HashTable map) {
        dictionary = map;
    }

    @Override
    public Set<String> gatherSuggestions(String value) {
        Set<String> suggestions = new HashSet<>() ;
        suggestions.addAll(adjacentLetterSwap(value));
        suggestions.addAll(adjacentLetterInsert(value));
        suggestions.addAll(letterDeletion(value));
        suggestions.addAll(letterReplacement(value));
        suggestions.addAll(wordSplitter(value));

        return suggestions;
    }

    @Override
    public List<String> adjacentLetterSwap(String value) {
        List<String> suggestions = new ArrayList<>();
        for (int i = 0; i < value.length() - 1; i++) {
            String swapped = swapAdjacent(value, i);
            if (dictionary.lookUp(swapped)) suggestions.add(swapped);
        }
        return suggestions;
    }

    @Override
    public List<String> adjacentLetterInsert(String value) {
        List<String> suggestions = new ArrayList<>();
        ArrayList<Character> characters = split(value);

        for (char character = 97; character < 123; character++) {
            for (int i = 0; i != value.length() + 1; i++) {
                ArrayList<Character> tempCharacters = new ArrayList<>(characters);
                String inserted = insertAdjacent(tempCharacters, i, character);
                if (dictionary.lookUp(inserted)) suggestions.add(inserted);
            }
        }
        return suggestions;
    }

    @Override
    public List<String> letterDeletion(String value) {
        List<String> suggestions = new ArrayList<>();
        ArrayList<Character> characters = split(value);

        for (int i = 0; i != value.length(); i++) {
            ArrayList<Character> tempCharacters = new ArrayList<>(characters);
            String deleted = deleteLetter(tempCharacters, i);
            if (dictionary.lookUp(deleted)) suggestions.add(deleted);
        }
        return suggestions;
    }

    @Override
    public List<String> letterReplacement(String value) {
        List<String> suggestions = new ArrayList<>();
        ArrayList<Character> characters = split(value);

        for (char character = 97; character < 123; character++) {
            for (int i = 0; i != value.length(); i++) {
                ArrayList<Character> tempCharacters = new ArrayList<>(characters);
                String replaced = replaceLetter(tempCharacters, i, character);
                if (dictionary.lookUp(replaced)) suggestions.add(replaced);
            }
        }
        return suggestions;
    }

    @Override
    public List<String> wordSplitter(String value) {
        List<String> suggestions = new ArrayList<>();
        ArrayList<Character> characters = split(value);

        for (int i = 0; i != value.length(); i++) {
            ArrayList<Character> tempCharacters = new ArrayList<>(characters);
            String[] spaced = spaceSplit(tempCharacters, i);
            if (dictionary.lookUp(spaced[0]) && dictionary.lookUp(spaced[1])) {
                suggestions.addAll(Arrays.asList(spaced));
            }
        }
        return suggestions;

    }

    public void setDictionary(HashCollection dictionary) {
        this.dictionary = dictionary;
    }

    private String[] spaceSplit(ArrayList<Character> characters, int position) {
        characters.add(position, ' ');
        return rebuildWord(characters).split(" ");
    }

    private String swapAdjacent(String value, int position) {
        value = value.toLowerCase();
        char[] chars = value.toCharArray();

        char tmp = chars[position];
        chars[position] = chars[position + 1];
        chars[position + 1] = tmp;

        return new String(chars);

    }

    private String replaceLetter(ArrayList<Character> characters, int position, char character) {
        characters.set(position, character);
        return rebuildWord(characters);

    }

    private String deleteLetter(ArrayList<Character> characters, int position) {
        characters.remove(position);
        return rebuildWord(characters);

    }

    private String insertAdjacent(ArrayList<Character> characters, int position, char character) {
        characters.add(position, character);
        return rebuildWord(characters);
    }


    private ArrayList<Character> split(String value) {
        value = value.toLowerCase();
        ArrayList<Character> characters = new ArrayList<>();

        for (int i = 0; i < value.length(); i++) {
            characters.add(value.charAt(i));
        }
        return characters;
    }

    private String rebuildWord(ArrayList<Character> characters) {
        StringBuilder sb = new StringBuilder();
        for (Character s : characters) {
            sb.append(s.toString());
        }
        return sb.toString();
    }
}
