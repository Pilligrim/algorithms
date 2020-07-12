package ru.geekbrains.algorithms.recursion;

public class KingRoutes {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.printf("%6d", routes(i, j));
            }
            System.out.println();
        }
    }
    // F(x, 0) = 1
    // F(0, y) = 1
    // F(x, y) = F(x - 1, y) + F(x, y - 1)

    private static int routes(int x, int y) {
        if (x == 0 || y == 0) {
            return 1;
        } else {
            return routes(x - 1, y) + routes(x, y - 1);
        }
    }
}
