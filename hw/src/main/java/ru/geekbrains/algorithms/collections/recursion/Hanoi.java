package ru.geekbrains.algorithms.collections.recursion;

public class Hanoi {
    public static void move(int n, int from, int to) {
        if (n == 0) {
            return;
        }
        int temp = 6 - from - to;
        move(n-1, from, temp);
        System.out.printf("%d -> %d | ", from, to);
        move(n-1, temp, to);
    }
    public static void main(String[] args) {
        move(8, 1, 2);
    }
}
