// @algorithm @lc id=100197 lang=java 
// @title three-steps-problem-lcci
package _____08_01_Three_Steps_Problem_LCCI_1;
// @test(3)=4
// @test(5)=13
public class Solution {
    private final static int MOD = 1_000_000_007;
    public int waysToStep(int n) {
        if (n == 1) {
            return 1;
        }
        int one = 1, two = 1, three = 2; 
        while (n-- >= 3) {
            int steps = ((one + two) % MOD + three) % MOD;
            one = two;
            two = three;
            three = steps;
        }
        return three;
    }
}