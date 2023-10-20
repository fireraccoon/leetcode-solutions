// @algorithm @lc id=1000041 lang=java 
// @title rank-from-stream-lcci
package _____10_10_Rank_from_Stream_LCCI_1;
import java.util.TreeMap;

class StreamRank {

    TreeMap<Integer, Integer> treeMap;

    public StreamRank() {
        treeMap = new TreeMap<>();
    }

    public void track(int x) {
        treeMap.put(x, treeMap.getOrDefault(x, 0) + 1);
    }

    public int getRankOfNumber(int x) {
        int rank = 0;
        for (int v : treeMap.headMap(x, true).values()) {
            rank += v;
        }
        return rank;
    }
}

/**
 * Your StreamRank object will be instantiated and called as such:
 * StreamRank obj = new StreamRank();
 * obj.track(x);
 * int param_2 = obj.getRankOfNumber(x);
 */