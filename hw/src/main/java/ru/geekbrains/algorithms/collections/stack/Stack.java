package ru.geekbrains.algorithms.collections.stack;


import java.util.NoSuchElementException;

public class Stack<T> {
    private int capacity;
    private Object[] stack;
    private int head;

    public Stack(int capacity) {
        this.capacity = capacity;
        this.stack = new Object[capacity];
        this.head = -1;
    }

    public boolean isEmpty() {
        return this.head == -1;
    }

    public boolean isFull() {
        return this.head == this.capacity - 1;
    }

    public void push(T value) {
        if (isFull()) {
            capacity *= 2;
            Object[] newStack = new Object[capacity];
            System.arraycopy(stack, 0, newStack, 0, stack.length);
            stack = newStack;
        }
        stack[++head] = value;
    }

    public T pop() {
        if (isEmpty()) throw new NoSuchElementException("Stack is empty");
        return (T) stack[head--];
    }

    public T peek() {
        return (T) stack[head];
    }
}
