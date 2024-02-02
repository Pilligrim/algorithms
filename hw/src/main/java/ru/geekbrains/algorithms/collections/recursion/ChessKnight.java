package ru.geekbrains.algorithms.collections.recursion;

public class ChessKnight {
    public static void main(String[] args) {
        int[][] desk = new int[8][8];
        knightMove(desk, 1, 0, 1);
        printDesk(desk);
        System.out.println(op);
    }
    private static int[][] kMoves = {
            {-2, 1}, {-1, 2}, {1, 2}, {2, 1},
            {2, -1}, {1, -2}, {-1, -2}, {-2, -1}
    };

    private static boolean isPossible(int[][] desk, int x, int y) {
        return x >= 0 && x < desk.length &&
                y >= 0 && y < desk[0].length &&
                desk[x][y] == 0;
    }

    private static int op = 0;
    private static boolean knightMove(int[][] desk, int currX, int currY, int move) {
        desk[currX][currY] = move;
        if (move > desk.length * desk[0].length - 1) return true;

        int nextX, nextY;
        for (int i = 0; i < 7; i++) {
            op++;
            nextX = currX + kMoves[i][1];
            nextY = currY + kMoves[i][0];
            if (isPossible(desk, nextX, nextY) && knightMove(desk, nextX, nextY, move + 1)) {
                return true;
            }
        }
        desk[currX][currY] = 0;
        return false;
    }

    private static void printDesk(int[][] desk) {
        for (int i = 0; i < desk.length; i++) {
            for (int j = 0; j < desk[0].length; j++) {
                System.out.printf("%3d", desk[i][j]);
            }
            System.out.println();
        }
    }
}
