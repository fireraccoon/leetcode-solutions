// @algorithm @lc id=100159 lang=java 
// @title check-permutation-lcci
package _____01_02_Check_Permutation_LCCI;
// @test("abc","bca")=true
// @test("abc","bad")=false
public class Solution {
    public boolean CheckPermutation(String s1, String s2) {
        int n = s1.length();
        if (n != s2.length()) {
            return false;
        }
        int[] counts = new int[26];
        for (int i = 0; i < n; i++) {
            counts[s1.charAt(i) - 'a']++;
            counts[s2.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (counts[i] != 0) {
                return false;
            }
        }
        return true;
    }
}