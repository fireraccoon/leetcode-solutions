// @algorithm @lc id=1000033 lang=java 
// @title find-longest-subarray-lcci
package _____17_05_Find_Longest_Subarray_LCCI;
// @test(["A","1","B","C","D","2","3","4","E","5","F","G","6","7","H","I","J","K","L","M"])=["A","1","B","C","D","2","3","4","E","5","F","G","6","7"]
// @test(["A","A"])=[]
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public String[] findLongestSubarray(String[] array) {
        int n = array.length;
        int numOfDigits = 0;
        int start = 0, end = 0;
        Map<Integer, Integer> diffsMap = new HashMap<>();
        diffsMap.put(0, -1);
        for (int i = 0; i < n; i++) {
            if (isAlpha(array[i])) {
                numOfDigits++;
            }
            int numOfAlphas = i - numOfDigits + 1;
            Integer diffIndex = diffsMap.putIfAbsent(numOfAlphas - numOfDigits, i);
            if (diffIndex != null && i - diffIndex > end - start) {
                start = diffIndex + 1;
                end = i + 1;
            }
        }
        return Arrays.copyOfRange(array, start, end);
    }
    private boolean isAlpha(String s) {
        return (s.charAt(0) & 0x40) != 0;
    }
};