// @algorithm @lc id=1000006 lang=java 
// @title one-away-lcci
package _____01_05_One_Away_LCCI;
// @test("pale","ple")=true
// @test("pales","pl")=false
public class Solution {
    public boolean oneEditAway(String first, String second) {
        int m = first.length(), n = second.length();
        if (Math.abs(m - n) > 1) {
            return false;
        }
        boolean option = false;
        for (int i = 0, j = 0; i < m && j < n;) {
            if (first.charAt(i) == second.charAt(j)) {
                i++;
                j++;
                continue;
            }
            if (option) {
                return false;
            }
            if (m >= n) {
                i++;
            }
            if (m <= n) {
                j++;
            }
            option = true;
        }
        return true;
    }
}