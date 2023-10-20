// @algorithm @lc id=1000043 lang=java 
// @title shortest-supersequence-lcci
package _____17_18_Shortest_Supersequence_LCCI;
// @test([7,5,9,0,2,1,3,5,7,9,1,1,5,8,8,9,7],[1,5,9])=[7,10]
// @test([1,2,3],[4])=[]
import java.util.HashSet;
import java.util.Set;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] shortestSeq(int[] big, int[] small) {
        int m = small.length, n = big.length;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            set.add(small[i]);
        }

        int minLength = Integer.MAX_VALUE, leftIndex = -1;
        Map<Integer, Integer> windows = new HashMap<>();
        for (int start = 0, end = 0; end < n; end++) {
            if (!set.contains(big[end])) {
                continue;
            }
            windows.merge(big[end], 1, Integer::sum);
            for (; windows.size() == m; start++) {
                if (!set.contains(big[start])) {
                    continue;
                }
                int length = end - start + 1;
                if (minLength > length) {
                    leftIndex = start;
                    minLength = length;
                }
                if (windows.put(big[start], windows.get(big[start]) - 1) == 1) {
                    windows.remove(big[start]);
                }
            }
        }
        return leftIndex == -1 ? new int[0]
            : new int[] { leftIndex, leftIndex + minLength - 1 };
    }
}