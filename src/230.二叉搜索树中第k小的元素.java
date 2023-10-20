/*
 * @lc app=leetcode.cn id=230 lang=java
 *
 * [230] 二叉搜索树中第K小的元素
 */

import java.util.ArrayList;
import java.util.List;

import utils.TreeNode;

// @lc code=start

import java.util.Collection;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> inorderList = new ArrayList<>();
        inorder(inorderList, root);
        KthAVLTree<Integer> avlTree = new KthAVLTree<>(inorderList);
        return avlTree.kthSmallest(k);
    }

    private void inorder(List<Integer> ans, TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(ans, root.left);
        ans.add(root.val);
        inorder(ans, root.right);
    }

    /**
     * A AVL tree easy to find the kth smallest element.
     */
    public class KthAVLTree<T extends Comparable<T>> {

        private Node root;

        private class Node {

            public T val;

            public int height = 1, size = 1;

            public Node parent, left, right;

            public Node(T val, Node parent) {
                this.val = val;
                this.parent = parent;
            }

            public int refreshSize() {
                size = size(left) + size(right) + 1;
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

        @SuppressWarnings("unchecked")
        public KthAVLTree(Collection<T> array) {
            this((T[]) array.toArray(new Comparable[array.size()]));
        }

        public KthAVLTree(T[] array) {
            root = buildWithOrderedList(array, 0, array.length - 1, null);
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
            int index = size(node.left) + 1;
            while (k != index) {
                if (index < k) {
                    node = node.right;
                    index += size(node.left) + 1;
                } else {
                    node = node.left;
                    index -= size(node.right) + 1;
                }
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

        private Node buildWithOrderedList(T[] array, int left, int right, Node parent) {
            int middle = left + (right - left >> 1);
            Node node = new Node(array[middle], parent);
            if (left < middle) {
                node.left = buildWithOrderedList(array, left, middle - 1, node);
            }
            if (right > middle) {
                node.right = buildWithOrderedList(array, middle + 1, right, node);
            }
            node.refreshSizeAndHeight();
            return node;
        }

        private void remove(Node node) {
            if (node.left == null && node.right == null) {
                if (node.parent == null) {
                    root = null;
                } else if (node == node.parent.left) {
                    node.parent.left = null;
                    rebalance(node.parent);
                } else {
                    node.parent.right = null;
                    rebalance(node.parent);
                }
            } else if (node.left == null ^ node.right == null) {
                Node replaceNode = node.left != null ? node.left : node.right;
                replaceNode.parent = node.parent;
                if (node.parent == null) {
                    root = replaceNode;
                } else if (node == node.parent.left) {
                    node.parent.left = replaceNode;
                    rebalance(node.parent);
                } else {
                    node.parent.right = replaceNode;
                    rebalance(node.parent);
                }
            } else {
                Node maxLeft = node.left;
                while (maxLeft.right != null) {
                    maxLeft = maxLeft.right;
                }
                node.val = maxLeft.val;
                remove(maxLeft);
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

        private int height(Node node) {
            return node == null ? 0 : node.height;
        }

        private int size(Node node) {
            return node == null ? 0 : node.size;
        }
    }
}
// @lc code=end
