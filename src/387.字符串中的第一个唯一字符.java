/*
 * @lc app=leetcode.cn id=387 lang=java
 *
 * [387] 字符串中的第一个唯一字符
 */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// @lc code=start
class Solution {
    public int firstUniqChar(String s) {
        int n = s.length();
        int[] map = new int[26];
        Arrays.fill(map, -2);
        Queue<IndexWithValue> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            int key = s.charAt(i) - 'a';
            if (map[key] == -2) {
                map[key] = i;
                queue.offer(new IndexWithValue(i, key));
            } else {
                map[key] = -1;
                while (!queue.isEmpty() && map[queue.peek().value] == -1) {
                    queue.poll();
                }
            }
        }
        return queue.isEmpty() ? -1 : queue.peek().index;
    }
    private class IndexWithValue {
        public int index;
        public int value;
        public IndexWithValue(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
}
// @lc code=end

