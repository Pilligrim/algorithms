package ru.geekbrains.algorithms.math;

public class SuperCalculator {
    // Сложность O(n)
    // Возведение в степень
    public static Double power(Double base, Double degree) {
        double result = 1;
        for (int i = 1; i <= degree; i++) {
            result = result * base;
        }
        return result;
    }

    // Сложность O(n)
    // Минимлаьный элемент
    public static int getMin(int[] array) {
        if (array.length == 0) {
            return -1;
        }
        int min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }
    // Сложность O(n)
    // Среднее арифмитичесикое
    public static double getAverage(int[] array){
        if (array.length == 0) {
            return -1;
        }
        int result = 0;
        for (int i = 0; i < array.length; i++) {
                result+= array[i];
        }
        return result/array.length;
    }



}
