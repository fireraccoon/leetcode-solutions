// @algorithm @lc id=100184 lang=java 
// @title palindrome-permutation-lcci
package _____01_04_Palindrome_Permutation_LCCI;
// @test("tactcoa")=true
// @test("abc")=false
// @test("AaBb//a")=false
public class Solution {
    public boolean canPermutePalindrome(String s) {
        int n = s.length();
        char[] chars = new char[128];
        for (int i = 0; i < n; i++) {
            chars[s.charAt(i)]++;
        }
        int oddCount = 0;
        for (int i = 0; i < 128 && oddCount <= 1; i++) {
            if (chars[i] % 2 != 0) {
                oddCount++;
            }
        }
        return n % 2 == 0 ? oddCount == 0 : oddCount == 1;
    }
}