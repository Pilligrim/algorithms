package ru.geekbrains.algorithms.collections.stack;

public class Brackets {
    public static boolean check(String input) {
        int size = input.length();
        Stack<String> stack = new Stack<String>(size);
        String[] arr = input.split("");
        for (int i = 0; i < size; i++) {
            String ch = arr[i];
            if ("[".equals(ch) || "{".equals(ch) || "(".equals(ch)) {
                stack.push(ch);
            } else if ("]".equals(ch) || "}".equals(ch) || ")".equals(ch)) {
                if (stack.isEmpty()) {
                    System.out.printf("Error: %s at %d\n", ch, i);
                    return false;
                }
                String c = stack.pop();
                if (!("]".equals(ch) && "[".equals(c) || "}".equals(ch) && "{".equals(c) ||
                        ")".equals(ch) && "(".equals(c))) {
                    System.out.printf("Error: %s at %d\n", ch, i);
                    return false;
                }
            }
        }
        if (!stack.isEmpty()) {
            System.out.printf("Error: %s at %d\n", stack.peek(), size - 1);
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(check("()"));
        System.out.println(check("(bababa)[[])"));
    }
}
