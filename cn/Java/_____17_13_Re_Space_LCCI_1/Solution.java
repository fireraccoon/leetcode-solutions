// @algorithm @lc id=1000020 lang=java 
// @title re-space-lcci
package _____17_13_Re_Space_LCCI_1;
// @test(["looked","just","like","her","brother"],"jesslookedjustliketimherbrother")=7
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Solution {
    public int respace(String[] dictionary, String sentence) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < dictionary.length; i++) {
            set.add(getHash(dictionary[i]));
        }

        int n = sentence.length();
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            int hash = 1;
            dp[i] = dp[i - 1] + 1;
            for (int j = i - 1; j >= 0; j--) {
                hash = getHash(hash, sentence.charAt(j));
                if (set.contains(hash)) {
                    dp[i] = Math.min(dp[i], dp[j]);
                } else {
                    dp[i] = Math.min(dp[i], dp[j] + i - j);
                }
            }
        }
        return dp[n];
    }
    private int getHash(String s) {
        int hash = 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            hash = getHash(hash, s.charAt(i));
        }
        return hash;
    }
    private int getHash(int hash, char c) {
        return Objects.hash(hash, c);
    }
}