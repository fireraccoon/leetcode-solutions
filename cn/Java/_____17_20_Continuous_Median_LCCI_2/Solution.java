// @algorithm @lc id=1000028 lang=java 
// @title continuous-median-lcci
package _____17_20_Continuous_Median_LCCI_2;
import java.util.function.BiFunction;

class MedianFinder {

    private DuplicatedMedianAVLTree<Integer, Double> avlTree;

    /** initialize your data structure here. */
    public MedianFinder() {
        avlTree = new DuplicatedMedianAVLTree<>();
    }

    public void addNum(int num) {
        avlTree.add(num);
    }

    public double findMedian() {
        return avlTree.median((a, b) -> (a + b) / 2D);
    }

    public class DuplicatedMedianAVLTree<T extends Comparable<T>, E extends Comparable<E>> {

        private Node root;

        private Node lessThanEqualsMedian, greaterThanEqualsMedian;

        private int lessThanEqualsMedianCount = 1, greaterThanEqualsMedianCount = 1;

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
                refreshMedian(val);
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
            refreshMedian(val);
            return false;
        }

        /**
         * Get the middle element from the tree.
         * @return {@code value}
         */
        public E median(BiFunction<T, T, E> func) {
            return func.apply(lessThanEqualsMedian.val, greaterThanEqualsMedian.val);
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

        private void refreshMedian(T val) {
            if (root.size == 1) {
                lessThanEqualsMedian = root;
                greaterThanEqualsMedian = root;
            } else if (root.size % 2 == 0) {
                if (val.compareTo(lessThanEqualsMedian.val) >= 0) {
                    greaterThanEqualsMedianCount++;
                    if (greaterThanEqualsMedianCount > greaterThanEqualsMedian.count) {
                        greaterThanEqualsMedian = higher(greaterThanEqualsMedian);
                        greaterThanEqualsMedianCount = 1;
                    }
                } else {
                    lessThanEqualsMedianCount--;
                    if (lessThanEqualsMedianCount < 1) {
                        lessThanEqualsMedian = lower(lessThanEqualsMedian);
                        lessThanEqualsMedianCount = lessThanEqualsMedian.count;
                    }
                }
            } else {
                if (val.compareTo(lessThanEqualsMedian.val) >= 0) {
                    lessThanEqualsMedianCount++;
                    if (lessThanEqualsMedianCount > lessThanEqualsMedian.count) {
                        lessThanEqualsMedian = higher(lessThanEqualsMedian);
                        lessThanEqualsMedianCount = 1;
                    }
                }
                if (val.compareTo(greaterThanEqualsMedian.val) < 0) {
                    greaterThanEqualsMedianCount--;
                    if (greaterThanEqualsMedianCount < 1) {
                        greaterThanEqualsMedian = lower(greaterThanEqualsMedian);
                        greaterThanEqualsMedianCount = greaterThanEqualsMedian.count;
                    }
                }
            }
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

        private Node higher(Node node) {
            if (node.right != null) {
                node = node.right;
                while (node.left != null) {
                    node = node.left;
                }
            } else {
                while (node.parent != null && (node.parent.left == null || node.parent.left != node)) {
                    node = node.parent;
                }
                node = node.parent;
            }
            return node;
        }

        private Node lower(Node node) {
            if (node.left != null) {
                node = node.left;
                while (node.right != null) {
                    node = node.right;
                }
            } else {
                while (node.parent != null && (node.parent.right == null || node.parent.right != node)) {
                    node = node.parent;
                }
                node = node.parent;
            }
            return node;
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