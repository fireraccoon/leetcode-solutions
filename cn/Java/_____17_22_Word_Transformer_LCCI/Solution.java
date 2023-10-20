// @algorithm @lc id=1000030 lang=java 
// @title word-transformer-lcci
package _____17_22_Word_Transformer_LCCI;
// @test("hit","cog",["hot","dot","dog","lot","log","cog"])=["hit","hot","dot","lot","log","cog"]
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class Solution {
    public List<String> findLadders(String beginWord, String endWord, List<String> wordList) {
        Map<String, String> preMap = new HashMap<>();
        Map<String, String> nextMap = new HashMap<>();
        String middleNode = bfs(preMap, nextMap, beginWord, endWord, wordList);
        if (middleNode == null) {
            return List.of();
        }

        LinkedList<String> prePath = tracePath(preMap, middleNode, beginWord);
        LinkedList<String> nextPath = tracePath(nextMap, middleNode, endWord);
        prePath.removeFirst();
        while (!prePath.isEmpty()) {
            nextPath.addFirst(prePath.removeFirst());
        }
        return nextPath;
    }
    private String bfs(Map<String, String> preMap, Map<String, String> nextMap, String beginWord, String endWord, List<String> wordList) {
        Set<String> queue1 = new HashSet<>();
        Set<String> queue2 = new HashSet<>();
        Set<String> words = new HashSet<>(wordList);
        queue1.add(beginWord);
        queue2.add(endWord);
        words.remove(beginWord);
        if (!words.remove(endWord)) {
            return null;
        }
        while (!queue1.isEmpty()) {
            Set<String> next = new HashSet<>();
            for (String word : queue1) {
                for (int i = 0; i < word.length(); i++) {
                    char[] chars = word.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        chars[i] = c;
                        String nextWord = new String(chars);
                        if (queue2.contains(nextWord)) {
                            preMap.put(nextWord, word);
                            return nextWord;
                        }
                        if (words.remove(nextWord)) {
                            next.add(nextWord);
                            preMap.put(nextWord, word);
                        }
                    }
                }
            }
            if (next.size() > queue2.size()) {
                queue1 = queue2;
                queue2 = next;
                Map<String, String> tmpMap = preMap;
                preMap = nextMap;
                nextMap = tmpMap;
            } else {
                queue1 = next;
            }
        }
        return null;
    }
    private LinkedList<String> tracePath(Map<String, String> nextMap, String source, String target) {
        LinkedList<String> path = new LinkedList<>();
        path.add(source);
        while ((source = nextMap.get(source)) != null) {
            path.add(source);
        }
        return path;
    }
}