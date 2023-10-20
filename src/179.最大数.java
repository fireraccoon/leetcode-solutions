/*
 * @lc app=leetcode.cn id=179 lang=java
 *
 * [179] 最大数
 */

import java.util.Arrays;

// @lc code=start
class Solution {
    public String largestNumber(int[] nums) {
        StringBuilder sb = new StringBuilder();
        Arrays.stream(nums).boxed()
            .sorted((x, y) -> {
                long shiftX, shiftY;
                for (shiftX = 10; shiftX <= y; shiftX *= 10);
                for (shiftY = 10; shiftY <= x; shiftY *= 10);
                return Long.signum((shiftY * y + x) - (shiftX * x + y));
            })
            .forEach(sb::append);
        return sb.charAt(0) == '0' ? "0" : sb.toString();
    }
}
// @lc code=end

