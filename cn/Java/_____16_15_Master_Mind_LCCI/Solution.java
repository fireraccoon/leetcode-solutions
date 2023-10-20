// @algorithm @lc id=100355 lang=java 
// @title master-mind-lcci
package _____16_15_Master_Mind_LCCI;
// @test("RGBY", "GGRR")=[1,1]
public class Solution {
    public int[] masterMind(String solution, String guess) {
        int[] ans = new int[2];
        int[] frequencies = new int[4];
        for (int i = 0; i < 4; i++) {
            char x = solution.charAt(i), y = guess.charAt(i);
            if (x == y) {
                ans[0]++;
            } else {
                frequencies[code(x)]++;
            }
        }
        for (int i = 0; i < 4; i++) {
            char c = guess.charAt(i);
            int code = code(c);
            if (frequencies[code] > 0 && c != solution.charAt(i)) {
                ans[1]++;
                frequencies[code]--;
            }
        }
        return ans;
    }
    int code(char c) {
        return switch(c) {
            case 'R' -> 0;
            case 'G' -> 1;
            case 'Y' -> 2;
            default -> 3;
        };
    }
}