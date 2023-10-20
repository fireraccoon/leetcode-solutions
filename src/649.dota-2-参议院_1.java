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
        int RCount = 0, DCount = 0;
        Queue<Character> queue = new LinkedList<>();
        for (int i = 0; i < senate.length(); i++) {
            char c = senate.charAt(i);
            if (c == 'R') {
                RCount++;
            } else {
                DCount++;
            }
            queue.offer(c);
        }
        int RWinTimes = 0;
        while (RCount > 0 && DCount > 0) {
            if (queue.poll() == 'R') {
                RWinTimes++;
                if (RWinTimes <= 0) {
                    RCount--;
                } else {
                    queue.offer('R');
                }
            } else {
                RWinTimes--;
                if (RWinTimes >= 0) {
                    DCount--;
                } else {
                    queue.offer('D');
                }
            }
        }
        return RCount > 0 ? "Radiant" : "Dire";
    }
}
// @lc code=end

