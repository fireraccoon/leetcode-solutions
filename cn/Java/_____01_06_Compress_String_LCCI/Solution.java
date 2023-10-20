// @algorithm @lc id=100161 lang=java 
// @title compress-string-lcci
package _____01_06_Compress_String_LCCI;
// @test("aabcccccaaa")="a2b1c5a3"
// @test("abbccd")="abbccd"
public class Solution {
    public String compressString(String S) {
        int n = S.length();
        if (n <= 1) {
            return S;
        }
        StringBuilder sb = new StringBuilder();
        int times = 1;
        for (int i = 1; i <= n; i++) {
            if (i == n || S.charAt(i) != S.charAt(i - 1)) {
                sb.append(S.charAt(i - 1));
                sb.append(times);
                times = 1;
            } else {
                times++;
            }
        }
        return sb.length() < n ? sb.toString() : S;
    }
}