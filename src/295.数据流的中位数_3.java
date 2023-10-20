/*
 * @lc app=leetcode.cn id=295 lang=java
 *
 * [295] 数据流的中位数
 */

// @lc code=start。
class MedianFinder {

    private DuplicatedKthAVLTree<Integer> avlTree;

    public MedianFinder() {
        avlTree = new DuplicatedKthAVLTree<>();
    }

    public void addNum(int num) {
        avlTree.add(num);
    }

    public double findMedian() {
        int size = avlTree.size();
        if (size % 2 == 1) {
            return avlTree.kthSmallest(size / 2 + 1);
        } else {
            return (avlTree.kthSmallest(size / 2) + avlTree.kthSmallest(size / 2 + 1)) / 2D;
        }
    }

    public class DuplicatedKthAVLTree<T extends Comparable<T>> {

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
         * Get the kth smallest element from the tree.
         * @param k
         * @return {@code value}
         */
        public T kthSmallest(int k) {
            Node node = root;
            int leftBound = size(node.left) + 1;
            int rightBound = leftBound + node.count - 1;
            while (k < leftBound || k > rightBound) {
                if (rightBound < k) {
                    leftBound += node.count + size(node.right.left);
                    node = node.right;
                } else {
                    node = node.left;
                    leftBound -= size(node.right) + node.count;
                }
                rightBound = leftBound + node.count - 1;
            }
            return node.val;
        }

        /**
         * Searches the node for the value.
         * @param val
         * @return {@code null} or {@code node}
         */
        public Node search(T val) {
            Node node = root;
            while (node != null && val.compareTo(node.val) != 0) {
                node = val.compareTo(node.val) < 0 ? node.left : node.right;
            }
            return node;
        }

        /**
         * get the number of the elements.
         * @return size
         */
        public int size() {
            return size(root);
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

        private int height(Node node) {
            return node == null ? 0 : node.height;
        }

        private int size(Node node) {
            return node == null ? 0 : node.size;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
// @lc code=end

