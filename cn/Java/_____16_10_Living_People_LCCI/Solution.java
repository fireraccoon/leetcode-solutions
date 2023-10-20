// @algorithm @lc id=100351 lang=java 
// @title living-people-lcci
package _____16_10_Living_People_LCCI;
// @test([1900,1901,1950],[1948,1951,2000])=1901

public class Solution {
    private final static int MIN_YEAR = 1900;
    private final static int MAX_YEAR = 2000;
    public int maxAliveYear(int[] birth, int[] death) {
        int[] diffs = new int[MAX_YEAR - MIN_YEAR + 2];
        for (int i = 0; i < birth.length; i++) {
            diffs[birth[i] - MIN_YEAR]++;
            diffs[death[i] - MIN_YEAR + 1]--;
        }

        int ans = 0;
        int aliveCount = 0, maxAliveCount = 0;
        for (int i = 0; i < diffs.length; i++) {
            aliveCount += diffs[i];
            if (aliveCount > maxAliveCount) {
                ans = i;
                maxAliveCount = aliveCount;
            }
        }
        return MIN_YEAR + ans;
    }
}