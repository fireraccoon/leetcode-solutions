// @algorithm @lc id=1000035 lang=java 
// @title baby-names-lcci
package _____17_07_Baby_Names_LCCI;
// @test(["John(15)","Jon(12)","Chris(13)","Kris(4)","Christopher(19)"],["(Jon,John)","(John,Johnny)","(Chris,Kris)","(Chris,Christopher)"])=["John(27)","Chris(36)"]
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

public class Solution {
    public String[] trulyMostPopular(String[] names, String[] synonyms) {
        int n = names.length;
        List<Integer> counts = new ArrayList<>();
        List<String> allNames = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            NameCounter nc = new NameCounter(names[i]);
            counts.add(nc.count);
            allNames.add(nc.name);
            map.put(nc.name, i);
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < synonyms.length; i++) {
            int[] indices = new int[2];
            String[] pairs = getSynonymsPairs(synonyms[i]);
            for (int j = 0; j < pairs.length; j++) {
                Integer index = map.get(pairs[j]);
                if (index == null) {
                    index = map.size();
                    map.put(pairs[j], index);
                    graph.add(new ArrayList<>());
                    counts.add(0);
                    allNames.add(pairs[j]);
                }
                indices[j] = index;
            }
            graph.get(indices[0]).add(indices[1]);
            graph.get(indices[1]).add(indices[0]);
        }

        n = allNames.size();
        boolean[] visited = new boolean[n];
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                NameCounter nc = dfs(graph, visited, allNames, counts, i);
                ans.add(getSynonyms(nc.name, nc.count));
            }
        }
        return ans.toArray(new String[0]);
    }
    private NameCounter dfs(List<List<Integer>> graph, boolean[] visited, List<String> names, List<Integer> counts, int node) {
        visited[node] = true;
        NameCounter ans = new NameCounter(names.get(node), counts.get(node));
        for (int next : graph.get(node)) {
            if (!visited[next]) {
                NameCounter nc = dfs(graph, visited, names, counts, next);
                ans.count += nc.count;
                ans.name = minString(ans.name, nc.name);
            }
        }
        return ans;
    }
    private String minString(String a, String b) {
        return a.compareTo(b) < 0 ? a : b;
    }
    private String getSynonyms(String name, int count) {
        return new StringBuilder().append(name).append('(')
            .append(count).append(')').toString();
    }
    private String[] getSynonymsPairs(String synonyms) {
        String[] pairs = new String[2];
        int i = 1;
        while (synonyms.charAt(i++) != ',');
        pairs[0] = synonyms.substring(1, i - 1);
        pairs[1] = synonyms.substring(i, synonyms.length() - 1);
        return pairs;
    }
    private class NameCounter {
        public int count;
        public String name;
        public NameCounter(String name, int count) {
            this.name = name;
            this.count = count;
        }
        public NameCounter(String name) {
            int i = 0;
            while (name.charAt(i++) != '(');
            this.name = name.substring(0, i - 1);
            this.count = name.charAt(i) - '0';
            while (name.charAt(++i) != ')') {
                this.count = this.count * 10 + (name.charAt(i) - '0');
            }
        }
    }
}