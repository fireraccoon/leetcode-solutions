/*
 * @lc app=leetcode.cn id=433 lang=java
 *
 * [433] 最小基因变化
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

// @lc code=start
class Solution {

    char[] charsets = new char[] { 'A', 'T', 'C', 'G' };

    @SuppressWarnings("unchecked")
    public int minMutation(String startGene, String endGene, String[] bank) {
        Map<String, Integer> map = new HashMap<>();
        map.put(startGene, 0);
        for (int i = 0; i < bank.length; i++) {
            map.putIfAbsent(bank[i], map.size());
        }
        if (!map.containsKey(endGene)) {
            return -1;
        }

        int n = map.size();
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        updateGraph(graph, map, startGene);
        for (int i = 0; i < bank.length; i++) {
            updateGraph(graph, map, bank[i]);
        }

        return bfs(graph, map.get(startGene), map.get(endGene));
    }
    int bfs(List<Integer>[] graph, int beginOfState, int endOfState) {
        boolean[] visited = new boolean[graph.length];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(beginOfState);
        visited[beginOfState] = true;
        for (int count = 1; !queue.isEmpty(); count++) {
            for (int i = queue.size(); i > 0; i--) {
                int node = queue.poll();
                for (int next : graph[node]) {
                    if (next == endOfState) {
                        return count;
                    }
                    if (!visited[next]) {
                        queue.offer(next);
                        visited[next] = true;
                    }
                }
            }
        }
        return -1;
    }
    void updateGraph(List<Integer>[] graph, Map<String, Integer> map, String s) {
        int node = map.get(s);
        char[] chars = s.toCharArray();
        for (int i = 0; i < 8; i++) {
            char oldChar = chars[i];
            for (int j = 0; j < charsets.length; j++) {
                if (charsets[j] != oldChar) {
                    chars[i] = charsets[j];
                    Integer next = map.get(new String(chars));
                    if (next != null) {
                        graph[node].add(next);
                    }
                }
            }
            chars[i] = oldChar;
        }
    }
}
// @lc code=end

