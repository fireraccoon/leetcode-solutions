// @algorithm @lc id=100351 lang=java 
// @title living-people-lcci
package _____16_10_Living_People_LCCI_1;
// @test([1900,1901,1950],[1948,1951,2000])=1901
import java.util.Arrays;

public class Solution {
    public int maxAliveYear(int[] birth, int[] death) {
        Arrays.sort(birth);
        Arrays.sort(death);
        int ans = 1900;
        int maxAliveCount = 0, aliveCount = 0;
        int birthIndex = 0, deathIndex = 0;
        while (birthIndex < birth.length) {
            if (birth[birthIndex] <= death[deathIndex]) {
                aliveCount++;
                if (aliveCount > maxAliveCount) {
                    ans = birth[birthIndex];
                    maxAliveCount = aliveCount;
                }
                birthIndex++;
            } else {
                aliveCount--;
                deathIndex++;
            }
        }
        return ans;
    }
}