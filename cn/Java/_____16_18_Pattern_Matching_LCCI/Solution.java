// @algorithm @lc id=1000004 lang=java 
// @title pattern-matching-lcci
package _____16_18_Pattern_Matching_LCCI;
// @test("abba","dogcatcatdog")=true
// @test("abba","dogcatcatfish")=false
// @test("aaaa","dogcatcatdog")=false
// @test("abba","dogdogdogdog")=true
public class Solution {
    public boolean patternMatching(String pattern, String value) {
        int m = pattern.length(), n = value.length();
        if (m == 0) {
            return n == 0;
        }

        int countA = 0, countB = 0;
        for (int i = 0; i < m; i++) {
            if (pattern.charAt(i) == 'a') {
                countA++;
            } else {
                countB++;
            }
        }

        if (n == 0) {
            return countA == 0 ^ countB == 0;
        }
        if (countA == 0) {
            return n % countB == 0 && check(pattern, value, 0, n / countB);
        }
        if (countB == 0) {
            return n % countA == 0 && check(pattern, value, n / countA, 0);
        }

        for (int lenA = 0; lenA <= n / countA; lenA++) {
            if ((n - countA * lenA) % countB != 0) {
                continue;
            }
            int lenB = (n - countA * lenA) / countB;
            if (check(pattern, value, lenA, lenB)) {
                return true;
            }
        }
        return false;
    }
    boolean check(String pattern, String value, int lenA, int lenB) {
        int m = pattern.length();
        String a = null, b = null;
        int i = 0, j = 0;
        while (i < m) {
            if (pattern.charAt(i) == 'a') {
                if (a == null) {
                    a = value.substring(j, j + lenA);
                } else if (!value.startsWith(a, j)) {
                    return false;
                }
                j += lenA;
            } else {
                if (b == null) {
                    b = value.substring(j, j + lenB);
                } else if (!value.startsWith(b, j)) {
                    return false;
                }
                j += lenB;
            }
            i++;
        }
        return a != b && (a != null && !a.equals(b) || b != null && !b.equals(a));
    }
}