// @algorithm @lc id=1000047 lang=java 
// @title t9-lcci
package _____16_20_T9_LCCI;
// @test("8733",["tree","used"])=["tree","used"]
// @test("2",["a","b","c","d"])=["a","b","c"]
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@SuppressWarnings("unchecked")
public class Solution {
    private Set<Character>[] t9_map = new Set[] {
        Set.of('_'), Set.of('!', '@', '#'), Set.of('a', 'b', 'c'),
        Set.of('d', 'e', 'f'), Set.of('g', 'h', 'i'), Set.of('j', 'k', 'l'),
        Set.of('m', 'n', 'o'), Set.of('p', 'q', 'r', 's'),
        Set.of('t', 'u', 'v'), Set.of('w', 'x', 'y', 'z')
    };
    public List<String> getValidT9Words(String num, String[] words) {
        int n = num.length();
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() == n && isValid(num, words[i])) {
                ans.add(words[i]);
            }
        }
        return ans;
    }
    private boolean isValid(String num, String word) {
        for (int j = 0; j < num.length(); j++) {
            if (!t9_map[num.charAt(j) - '0'].contains(word.charAt(j))) {
                return false;
            }
        }
        return true;
    }
}