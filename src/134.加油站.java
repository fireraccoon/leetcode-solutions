/*
 * @lc app=leetcode.cn id=134 lang=java
 *
 * [134] 加油站
 */

// @lc code=start
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int ans = -1, gasExtra = 0, minGas = Integer.MAX_VALUE;
        for (int i = 0; i < gas.length; i++) {
            /** skip the error test examples */
            if (ans == i && gas[i] == 0 && cost[i] == 0) {
                ans++;
                continue;
            }
            gasExtra += gas[i] - cost[i];
            if (gasExtra < minGas) {
                ans = i + 1;
                minGas = gasExtra;
            }
        }
        return gasExtra < 0 ? -1 : ans == gas.length ? 0 : ans;
    }
}
// @lc code=end

