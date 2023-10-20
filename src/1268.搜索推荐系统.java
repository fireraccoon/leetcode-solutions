/*
 * @lc app=leetcode.cn id=1268 lang=java
 *
 * [1268] 搜索推荐系统
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// @lc code=start
class Solution {
    private final static int LIMIT = 3;
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        int n = searchWord.length();
        List<List<String>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ans.add(new ArrayList<>());
        }

        int left, right = 0;
        Arrays.sort(products);
        for (int i = 0; i < n; i++) {
            left = right;
            right = products.length - 1;
            String prefix = searchWord.substring(0, i + 1);
            while (left < right) {
                int middle = left + (right - left >> 1);
                int compare = products[middle].compareTo(prefix);
                if (compare >= 0) {
                    right = middle;
                } else {
                    left = middle + 1;
                }
            }
            for (int j = right; j < right + LIMIT && j < products.length; j++) {
                if (products[j].startsWith(prefix)) {
                    ans.get(i).add(products[j]);
                } else {
                    break;
                }
            }
        }
        return ans;
    }
}
// @lc code=end

