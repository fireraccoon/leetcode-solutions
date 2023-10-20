// @algorithm @lc id=100242 lang=java 
// @title sparse-array-search-lcci
package _____10_05_Sparse_Array_Search_LCCI;
// @test(["at","","","","ball","","","car","","","dad","",""],"ta")=-1
// @test(["at","","","","ball","","","car","","","dad","",""],"ball")=4
// @test(["DirNnILhARNS hOYIFB", "SM ", "YSPBaovrZBS", "evMMBOf", "mCrS", "oRJfjw gwuo", "xOpSEXvfI"], "mCrS")=4
// @test(["E jgeVQIZI", "EMuBXhHEDpDOS", "HhYVhpQjIaEsZtHQKy", "IOBAEIbBnjO", "MyHjLicHnzyrvRxvtw", "WYt DPvcv", "c"], "EMuBXhHEDpDOS")=1
public class Solution {
    public int findString(String[] words, String s) {
        int left = 0, right = words.length - 1;
        while (left <= right) {
            int middle = left + (right - left >> 1);
            if (!words[middle].isEmpty()) {
                int compare = words[middle].compareTo(s);
                if (compare == 0) {
                    return middle;
                } else if (compare < 0) {
                    left = middle + 1;
                } else {
                    right = middle - 1;
                }
                continue;
            }

            int leftNotEmpty = middle - 1, rightNotEmpty = middle + 1;
            while (leftNotEmpty >= left && words[leftNotEmpty].isEmpty()) {
                leftNotEmpty--;
            }
            while (rightNotEmpty <= right && words[rightNotEmpty].isEmpty()) {
                rightNotEmpty++;
            }

            int leftCompare = leftNotEmpty < left ? 1 : words[leftNotEmpty].compareTo(s);
            int rightCompare = rightNotEmpty > right ? -1 : words[rightNotEmpty].compareTo(s);
            if (leftCompare == 0) {
                return leftNotEmpty;
            } else if (rightCompare == 0) {
                return rightNotEmpty;
            } else if (leftCompare < 0) {
                left = rightNotEmpty + 1;
            } else if (rightCompare > 0) {
                right = leftNotEmpty - 1;
            } else {
                return -1;
            }
        }
        return -1;
    }
}