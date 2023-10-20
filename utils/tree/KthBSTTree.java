package utils.tree;

import java.util.Queue;
import java.util.LinkedList;
import java.util.function.Function;

/**
 * A BST tree easy to find the kth smallest element.
 */
public class KthBSTTree<T extends Comparable<T>> {

    private Node root;

    private class Node {

        public T val;

        public int size = 1;

        public Node parent, left, right;

        public Node(T val, Node parent) {
            this.val = val;
            this.parent = parent;
        }
    }

    /**
     * Add a unduplicated element to the tree.
     * @param val
     * @return added or not
     */
    public boolean add(T val) {
        Node node = search(val), parent = null;
        if (node != null) {
            return false;
        }
        node = root;
        while (node != null) {
            node.size++;
            parent = node;
            node = val.compareTo(node.val) < 0 ? node.left : node.right;
        }
        if (parent == null) {
            root = new Node(val, parent);
        } else if (val.compareTo(parent.val) > 0) {
            parent.right = new Node(val, parent);
        } else {
            parent.left = new Node(val, parent);
        }
        return true;
    }

    /**
     * Remove a existed element from the tree.
     * @param val
     * @return removed or not
     */
    public boolean remove(T val) {
        Node node = search(val);
        if (node == null) {
            return false;
        }
        node = root;
        while (val.compareTo(node.val) != 0) {
            node.size--;
            node = val.compareTo(node.val) < 0 ? node.left : node.right;
        }
        remove(node);
        return true;
    }

    /**
     * Get the kth smallest element from the tree.
     * @param k
     * @return {@code value}
     */
    public T kthSmallest(int k) {
        Node node = root;
        int index = node.left == null ? 1 : node.left.size + 1;
        while (k != index) {
            if (index < k) {
                node = node.right;
                index += node.left == null ? 1 : node.left.size + 1;
            } else {
                node = node.left;
                index -= node.right == null ? 1 : node.right.size + 1;
            }
        }
        return node.val;
    }

    /**
     * Searches the node for the value.
     * @param val
     * @return {@code null} or {@code Node}
     */
    public Node search(T val) {
        Node node = root;
        while (node != null && val.compareTo(node.val) != 0) {
            node = val.compareTo(node.val) < 0 ? node.left : node.right;
        }
        return node;
    }

    private void remove(Node node) {
        if (node.left == null && node.right == null) {
            if (node.parent == null) {
                root = null;
            } else if (node == node.parent.left) {
                node.parent.left = null;
            } else {
                node.parent.right = null;
            }
        } else if (node.left == null ^ node.right == null) {
            Node replaceNode = node.left != null ? node.left : node.right;
            replaceNode.parent = node.parent;
            if (node.parent == null) {
                root = replaceNode;
            } else if (node == node.parent.left) {
                node.parent.left = replaceNode;
            } else {
                node.parent.right = replaceNode;
            }
        } else {
            Node maxLeft = node.left;
            while (maxLeft.right != null) {
                maxLeft.size--;
                maxLeft = maxLeft.right;
            }
            node.size--;
            node.val = maxLeft.val;
            remove(maxLeft);
        }
    }

    private int height(Node root) {
        return root == null ? 0 : Math.max(height(root.left), height(root.right)) + 1;
    }

    /**
     * Print the view of the tree nodes' size.
     */
    public void printSize() {
        print(node -> node.size);
    }

    /**
     * Print the view of the tree.
     */
    public void print() {
        print(node -> node.val);
    }

    private void print(Function<Node, ?> targetFunction) {
        int MAX_VAL_SIZE = 3;
        int height = height(root);
        int m = (int) Math.pow(2, height - 1) * MAX_VAL_SIZE * 2;
        Queue<Node> queue = new LinkedList<>();
        Queue<Integer> rank = new LinkedList<>();
        if (root != null) {
            queue.add(root);
            rank.add(1);
        }
        for (int nodeSize = 1; !queue.isEmpty(); nodeSize <<= 1) {
            StringBuilder branches = new StringBuilder();
            StringBuilder vals = new StringBuilder();
            branches.append(" ".repeat(m / nodeSize / 2 - MAX_VAL_SIZE / 2));
            vals.append(" ".repeat(m / nodeSize / 2 - MAX_VAL_SIZE / 2));
            for (int i = 1, size = queue.size(); i <= nodeSize; i++) {
                if (size == 0 || i < rank.peek()) {
                    branches.append(" ".repeat(MAX_VAL_SIZE));
                    vals.append(" ".repeat(MAX_VAL_SIZE));
                } else {
                    size--;
                    Node node = queue.poll();
                    if (rank.poll() % 2 == 1) {
                        branches.append(String.format("%" + MAX_VAL_SIZE + "s", "/" + "-".repeat(MAX_VAL_SIZE - 1 >> 1)));
                        vals.append(String.format("%-" + MAX_VAL_SIZE + "s", targetFunction.apply(node)));
                    } else {
                        branches.append(String.format("%-" + MAX_VAL_SIZE + "s", "-".repeat(MAX_VAL_SIZE - 1 >> 1) + "\\"));
                        vals.append(String.format("%" + MAX_VAL_SIZE + "s", targetFunction.apply(node)));
                    }
                    if (node.left != null) {
                        queue.add(node.left);
                        rank.add(i * 2 - 1);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                        rank.add(i * 2);
                    }
                }
                if (i % 2 == 1) {
                    branches.append("-".repeat(m / nodeSize - MAX_VAL_SIZE));
                } else {
                    branches.append(" ".repeat(m / nodeSize - MAX_VAL_SIZE));
                }
                vals.append(" ".repeat(m / nodeSize - MAX_VAL_SIZE));
            }
            if (nodeSize == 1) {
                System.out.println(vals.toString());
            } else {
                System.out.println(branches.append('\n').append(vals).toString());
            }
        }
    }
}
