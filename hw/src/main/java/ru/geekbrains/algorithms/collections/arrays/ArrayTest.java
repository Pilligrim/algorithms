package ru.geekbrains.algorithms.collections.arrays;

public class ArrayTest {
    public static void main(String[] args) {
        int[] arr; // int arr[]
        arr = new int[5];
        int[] arr2 = {1, 2, 3, 4};

        Array a0 = new Array(1, -2, -3, -4, 5);
        a0.sortBubble();
        System.out.println(a0);
    }
}
