package utils.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.function.Function;

/**
 * A avl tree that allows duplicated elements. It is rapid to get
 * the count of the elements that are less than or equal to the given value.
 */
public class DuplicatedLEAVLTree<T extends Comparable<T>> {

    private Node root;

    private class Node {

        public T val;

        public int height = 1, size = 1, count = 1;

        public Node parent, left, right;

        public Node(T val, Node parent) {
            this.val = val;
            this.parent = parent;
        }

        public int refreshSize() {
            size = size(left) + size(right) + count;
            return size;
        }

        public int refreshHeight() {
            height = Math.max(height(left), height(right)) + 1;
            return height;
        }

        public void refreshSizeAndHeight() {
            refreshSize();
            refreshHeight();
        }

        public int getBalanceFactor() {
            return height(left) - height(right);
        }

    }

    /**
     * Add an element to the tree.
     * @param val
     * @return existed or not
     */
    public boolean add(T val) {
        Node node = search(val), parent = null;
        if (node != null) {
            node.count++;
            rebalance(node);
            return true;
        }

        node = root;
        while (node != null) {
            parent = node;
            node = val.compareTo(node.val) < 0 ? node.left : node.right;
        }

        if (parent == null) {
            root = new Node(val, parent);
        } else if (val.compareTo(parent.val) > 0) {
            parent.right = new Node(val, parent);
            rebalance(parent);
        } else {
            parent.left = new Node(val, parent);
            rebalance(parent);
        }
        return false;
    }

    /**
     * Get the count of the elements that are less than (or equals to, if
     * inclusive is {@code true}) the given value.
     * @param val
     * @param inclusive
     * @return {@code count}
     */
    public int headTreeSize(T val, boolean inclusive) {
        Node node = floor(val);
        if (node == null) {
            return 0;
        }

        int ans = size(root) - size(root.right);
        Node pointer = root;
        while (pointer != node) {
            if (node.val.compareTo(pointer.val) < 0) {
                ans -= pointer.count + size(pointer.left.right);
                pointer = pointer.left;
            } else {
                ans += pointer.right.count + size(pointer.right.left);
                pointer = pointer.right;
            }
        }

        if (!inclusive && node.val.equals(val)) {
            ans -= node.count;
        }
        return ans;
    }

    /**
     * Searches the node for the value.
     * @param val
     * @return {@code null} or {@code node}
     */
    public Node search(T val) {
        Node node = root;
        while (node != null && !node.val.equals(val)) {
            node = node.val.compareTo(val) > 0 ? node.left : node.right;
        }
        return node;
    }

    /**
     * Print the view of the tree.
     */
    public void print() {
        print(node -> node.val);
    }

    private void rebalance(Node node) {
        while (node != null) {
            int balanceFactor = node.getBalanceFactor();
            if (balanceFactor == 2) {
                if (height(node.left.left) < height(node.left.right)) {
                    rotateLeft(node.left);
                }
                node = rotateRight(node);
            } else if (balanceFactor == -2) {
                if (height(node.right.right) < height(node.right.left)) {
                    rotateRight(node.right);
                }
                node = rotateLeft(node);
            }

            node.refreshSizeAndHeight();
            if (node.parent == null) {
                root = node;
            }
            node = node.parent;
        }
    }

    private Node rotateLeft(Node node) {
        Node right = node.right;
        node.right = right.left;
        if (node.right != null) {
            node.right.parent = node;
        }
        right.left = node;
        right.parent = node.parent;
        node.parent = right;
        if (right.parent != null) {
            if (right.parent.left == node) {
                right.parent.left = right;
            } else {
                right.parent.right = right;
            }
        }

        node.refreshSizeAndHeight();
        right.refreshSizeAndHeight();
        return right;
    }

    private Node rotateRight(Node node) {
        Node left = node.left;
        node.left = left.right;
        if (node.left != null) {
            node.left.parent = node;
        }
        left.right = node;
        left.parent = node.parent;
        node.parent = left;
        if (left.parent != null) {
            if (left.parent.left == node) {
                left.parent.left = left;
            } else {
                left.parent.right = left;
            }
        }

        node.refreshSizeAndHeight();
        left.refreshSizeAndHeight();
        return left;
    }

    private Node floor(T val) {
        Node node = root;
        Node ans = null;
        while (node != null && !node.val.equals(val)) {
            if (node.val.compareTo(val) > 0) {
                node = node.left;
            } else {
                ans = node;
                node = node.right;
            }
        }
        return node == null ? ans : node;
    }

    private int height(Node node) {
        return node == null ? 0 : node.height;
    }

    private int size(Node node) {
        return node == null ? 0 : node.size;
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
