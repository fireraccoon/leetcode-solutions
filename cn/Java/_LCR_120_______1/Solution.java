// @algorithm @lc id=100275 lang=java 
// @title shu-zu-zhong-zhong-fu-de-shu-zi-lcof
// @test([2,5,3,0,5,0])=5
// @test([2,5,3,2,5,0])=2
// @test([0,1,2,3,4,5,6,7,8,9,10,11,12,13,1,15])=1
// @test([1,0,1,4,2,5,3])=1
package _LCR_120_______1;
public class Solution {
    public int findRepeatDocument(int[] documents) {
        for (int i = 0; i < documents.length; i++) {
            int index = documents[i];
            if (index < 0) {
                index = -index - 1;
            }
            if (documents[index] < 0) {
                return index;
            } else {
                documents[index] = -(documents[index] + 1);
            }
        }
        return 0;
    }
}