package ru.geekbrains.algorithms.recursion;

public class Queens {
    private static int[][] desk;
    private static int n;
    private static int queens_count;

    public static void main(String[] args) {
        n = 8;
        queens_count = 8;
        desk = new int[n][n];
        place_queens(queens_count);
        print();
    }

    private static void print() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%3d", desk[i][j]);
            }
            System.out.println();
        }
    }

    private static boolean checkPosition(int x, int y) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (desk[i][j] != 0) {
                    if (i != x || j != y) {
                        if (x == i || j == y) {//vertical or horizontal
                            return false;
                        }
                        if (Math.abs(i - x) == Math.abs(j - y)) {// diagonal
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    private static boolean checkDesk() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (desk[i][j] != 0 && !checkPosition(i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean place_queens(int count_queens) {
        if (!checkDesk()) {
            return false;
        }
        if (count_queens == 0) {
            return true;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (desk[i][j] == 0) {
                    desk[i][j] = count_queens;
                    if (place_queens(count_queens - 1)) {
                        return true;
                    }
                    desk[i][j] = 0;
                }
            }
        }
        return false;
    }
}
