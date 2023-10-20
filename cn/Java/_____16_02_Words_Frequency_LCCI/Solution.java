// @algorithm @lc id=100259 lang=java 
// @title words-frequency-lcci
package _____16_02_Words_Frequency_LCCI;
import java.util.HashMap;
import java.util.Map;

class WordsFrequency {

    Map<String, Integer> frequencies;

    public WordsFrequency(String[] book) {
        frequencies = new HashMap<>();
        for (int i = 0; i < book.length; i++) {
            frequencies.merge(book[i], 1, Integer::sum);
        }
    }

    public int get(String word) {
        return frequencies.getOrDefault(word, 0);
    }
}

/**
 * Your WordsFrequency object will be instantiated and called as such:
 * WordsFrequency obj = new WordsFrequency(book);
 * int param_1 = obj.get(word);
 */