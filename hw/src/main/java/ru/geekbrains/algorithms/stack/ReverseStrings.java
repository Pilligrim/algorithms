package ru.geekbrains.algorithms.stack;

public class ReverseStrings {
    public static String reverse(String s) {
        Stack<String> stack = new Stack<String>(s.length());
        String[] arr = s.split("");
        for (int i = 0; i < s.length(); i++) {
            stack.push(arr[i]);
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverse( "Hasta la vista baby"));
    }
}
