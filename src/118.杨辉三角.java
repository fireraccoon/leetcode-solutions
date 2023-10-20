/*
 * @lc app=leetcode.cn id=118 lang=java
 *
 * [118] 杨辉三角
 */

import java.util.ArrayList;
import java.util.List;

// @lc code=start
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>(numRows);
        ans.add(new ArrayList<>(1) {{
            add(1);
        }});
        for (int i = 2; i <= numRows; i++) {
            List<Integer> row = new ArrayList<>(i);
            row.add(1);
            for (int j = 1; j < i - 1; j++) {
                row.add(ans.get(i - 2).get(j - 1) + ans.get(i - 2).get(j));
            }
            row.add(1);
            ans.add(row);
        }
        return ans;
    }
}
// @lc code=end

