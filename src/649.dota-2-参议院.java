/*
 * @lc app=leetcode.cn id=649 lang=java
 *
 * [649] Dota2 参议院
 */

import java.util.LinkedList;
import java.util.Queue;

// @lc code=start
class Solution {
    public String predictPartyVictory(String senate) {
        int n = senate.length();
        Queue<Integer> RQueue = new LinkedList<>();
        Queue<Integer> DQueue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (senate.charAt(i) == 'R') {
                RQueue.offer(i);
            } else {
                DQueue.offer(i);
            }
        }
        while (!RQueue.isEmpty() && !DQueue.isEmpty()) {
            if (RQueue.peek() < DQueue.peek()) {
                RQueue.offer(RQueue.poll() + n);
                DQueue.poll();
            } else {
                DQueue.offer(DQueue.poll() + n);
                RQueue.poll();
            }
        }
        return DQueue.isEmpty() ? "Radiant" : "Dire";
    }
}
// @lc code=end

