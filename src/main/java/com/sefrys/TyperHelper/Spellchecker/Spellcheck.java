package com.sefrys.TyperHelper.Spellchecker;

import java.util.List;
import java.util.Set;

/**
 * Created by Ireneusz Zagan on 17.05.18, 15:15
 * Contact: sefrys@gmail.com
 */
public interface Spellcheck {
    Set<String> gatherSuggestions(String value);
    List<String> adjacentLetterSwap(String value);
    List<String> adjacentLetterInsert(String value);
    List<String> letterDeletion(String value);
    List<String> letterReplacement(String value);
    List<String> wordSplitter(String value);
}
