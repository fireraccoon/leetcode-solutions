// @algorithm @lc id=100275 lang=java 
// @title shu-zu-zhong-zhong-fu-de-shu-zi-lcof
// @test([2,5,3,0,5,0])=0
package _LCR_120_______2;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int findRepeatDocument(int[] documents) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < documents.length; i++) {
            if (!set.add(documents[i])) {
                return documents[i];
            }
        }
        return -1;
    }
}