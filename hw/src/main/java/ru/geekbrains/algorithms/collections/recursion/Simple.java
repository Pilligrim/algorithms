package ru.geekbrains.algorithms.collections.recursion;

public class Simple {
    private static void iterPrint(int i) {
        while (i >= 0) {
            System.out.print(i + " ");
            i--;
        }
        System.out.print(i + "h ");
    }

    private static void recPrint(int i) {
        if (i >= 0) {
            System.out.print(i + " ");
            recPrint(--i);
        }
        System.out.print(i + "h ");
    }

    private static int power(int a, int b) {
        int result = 1;
        for (int i = 0; i < b; i++) {
            result *= a;
        }
        return result;
    }

    private static int poweRec(int a, int b) {
        return (b == 0) ? 1 : poweRec(a, b - 1) * a;
    }

    public static void main(String[] args) {
        iterPrint(5);
        System.out.println();
        recPrint(5);
        System.out.println();


    }
}
