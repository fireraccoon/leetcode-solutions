/*
 * @lc app=leetcode.cn id=133 lang=java
 *
 * [133] 克隆图
 */

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import utils.graph.Node;

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Node newNode = new Node(node.val);
        Queue<Node> queue = new LinkedList<>();
        HashMap<Node, Node> nodeAdded = new HashMap<>();
        queue.offer(node);
        nodeAdded.put(node, newNode);
        while (!queue.isEmpty()) {
            for (int i = queue.size(); i > 0; i--) {
                node = queue.poll();
                for (Node neighbor : node.neighbors) {
                    if (nodeAdded.containsKey(neighbor)) {
                        nodeAdded.get(node).neighbors.add(nodeAdded.get(neighbor));
                    } else {
                        Node newNeighbor = new Node(neighbor.val);
                        nodeAdded.get(node).neighbors.add(newNeighbor);
                        nodeAdded.put(neighbor, newNeighbor);
                        queue.offer(neighbor);
                    }
                }
            }
        }
        return newNode;
    }
}
// @lc code=end

