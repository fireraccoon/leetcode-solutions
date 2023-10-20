/*
 * @lc app=leetcode.cn id=93 lang=java
 *
 * [93] 复原 IP 地址
 */

import java.util.ArrayList;
import java.util.List;

// @lc code=start
class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        dfs(ans, new String[4], 0, 0, s);
        return ans;
    }
    void dfs(List<String> ans, String[] node, int pointer, int deepth, String s) {
        if (deepth == 4) {
            ans.add(String.join(".", node));
            return;
        }
        for (int i = pointer + 1; i < pointer + 4 && i <= s.length(); i++) {
            if (s.length() - i >= 3 - deepth && s.length() - i <= (3 - deepth) * 3) {
                node[deepth] = s.substring(pointer, i);
                if (isLegalIpSegment(node[deepth])) {
                    dfs(ans, node, i, deepth + 1, s);
                }
            }
        }
    }
    boolean isLegalIpSegment(String s) {
        if (s.length() == 1) {
            return true;
        } else if (s.length() == 2) {
            return s.charAt(0) != '0';
        } else if (s.length() == 3) {
            int num = (s.charAt(0) - '0') * 100 + (s.charAt(1) - '0') * 10 + s.charAt(2) - '0';
            return num >= 100 && num <= 255;
        } else {
            return false;
        }
    }
}
// @lc code=end

