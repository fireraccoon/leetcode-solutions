/*
 * @lc app=leetcode.cn id=133 lang=java
 *
 * [133] 克隆图
 */

import utils.graph.Node;

import java.util.HashMap;
import java.util.Map;

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
    Map<Node, Node> nodeAddded = new HashMap<>();
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        if (nodeAddded.containsKey(node)) {
            return nodeAddded.get(node);
        }
        Node newNode = new Node(node.val);
        nodeAddded.put(node, newNode);
        for (Node neighbor : node.neighbors) {
            newNode.neighbors.add(cloneGraph(neighbor));
        }
        return newNode;
    }
}
// @lc code=end

