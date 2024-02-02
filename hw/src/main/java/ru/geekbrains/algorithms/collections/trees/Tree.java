package ru.geekbrains.algorithms.collections.trees;

import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public class Tree<T> {
    Comparator<T> comparator = new NaturalComparator();

    private class NaturalComparator<T extends Comparable<T>> implements Comparator<T> {
        public int compare(T a, T b) {
            return a.compareTo(b);
        }
    }

    private class TreeNode {
        private T elem;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(T elem) {
            this.elem = elem;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "c=" + elem.toString() +
                    '}';
        }


    }
    TreeNode root;

    public void insert(T elem) {
        TreeNode node = new TreeNode(elem);
        if (root == null) {
            root = node;
        } else {
            TreeNode current = root;
            TreeNode parent = null;
            while (true) {
                parent = current;
                if (comparator.compare(elem, current.elem) < 0) {
                    current = current.left;
                    if (current == null) {
                        parent.left = node;
                        return;
                    }
                } else if (comparator.compare(elem, current.elem) > 0){
                    current = current.right;
                    if (current == null) {
                        parent.right = node;
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    public boolean isBalanced() {
        return Math.abs(getDepth(root.left) - getDepth(root.right)) <= 1;
    }

    public Tree() {
    }

    public Integer getDepth(TreeNode node) {
        if (node == null ){
            return 0;
        }
        int lDepth = getDepth(node.left);
        int rDepth = getDepth(node.right);

        return Math.max(lDepth,rDepth) + 1;
    }

    public Tree(List<T> nodes) {
        nodes.stream().forEach(a->insert(a));
    }

    private void preOrderTraverse(TreeNode current) {
        if (current != null) {
            System.out.print(current.elem.toString() + " ");
            preOrderTraverse(current.left);
            preOrderTraverse(current.right);
        }
    }

    public void displayTree() {
        preOrderTraverse(root);
    }

    public boolean delete(T elem) {
        TreeNode current = root;
        TreeNode parent = root;
        boolean isLeftChild = true;

        while (current.elem != elem) {
            parent = current;
            if (comparator.compare(elem, current.elem) < 0) {
                current = current.left;
                isLeftChild = true;
            } else {
                current = current.right;
                isLeftChild = false;
            }
            if (current == null) {
                return false;
            }
        }

        // leaf
        if (current.left == null && current.right == null) {
            if (current == root)
                root = null;
            else if (isLeftChild)
                parent.left = null;
            else
                parent.right = null;
        }
        // one ancestor
        else if (current.right == null) {
            if (isLeftChild)
                parent.left = current.left;
            else
                parent.right = current.left;
        } else if (current.left == null) {
            if (isLeftChild)
                parent.left = current.right;
            else
                parent.right = current.right;
        }
        // two ancestors
        else {
            TreeNode successor = getSuccessor(current);
            if (current == root) {
                root = successor;
            } else if (isLeftChild) {
                parent.left = successor;
            } else {
                parent.right = successor;
            }
            successor.left = current.left;
        }
        return true;
    }

    private TreeNode getSuccessor(TreeNode node) {
        TreeNode parent = node;
        TreeNode s = node;
        TreeNode curr = node.right;
        while (curr != null) {
            parent = s;
            s = curr;
            curr = curr.left;
        }

        if (s != node.right) {
            parent.left = s.right;
            s.right = node.right;
        }
        return s;
    }

}
