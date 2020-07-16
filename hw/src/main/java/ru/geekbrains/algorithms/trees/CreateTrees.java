package ru.geekbrains.algorithms.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class CreateTrees {
    public static void main(String[] args) {
        int treesCount = 50;
        int balancedTrees = 0;
        for (int i = 0; i < treesCount; i++) {
             Tree  tree = new Tree(getRandomArray(15));
             boolean isBalanced= tree.isBalanced();
             balancedTrees += isBalanced ? 1 : 0;
             System.out.println(String.format("tree %s, depth - %s, balanced - %s", i, tree.getDepth(tree.root), isBalanced));
        }
        System.out.println(balancedTrees * 100f/treesCount +"%");

    }

    public static List<Integer> getRandomArray(int count) {
        ArrayList<Integer> mass = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            mass.add((int) (-100 + Math.random() * 200));
        }
        return mass;
    }
}
