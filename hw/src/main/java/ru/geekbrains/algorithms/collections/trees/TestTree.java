package ru.geekbrains.algorithms.collections.trees;

public class TestTree {
    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<>();
        tree.insert(5);
        tree.insert(7);
        tree.insert(3);
        tree.insert(4);
        tree.insert(8);
        tree.insert(1);
        tree.insert(6);
        tree.displayTree();
    }
}
