package ru.geekbrains.algorithms.queue;

public class Dequeue<T> extends Queue<T>{
    public Dequeue(int capacity) {
        super(capacity);
    }

    public void enqueueTail(T i) {
        super.insert(i);
    }

    public void enqueueHead(int i) {
        if (isFull())
            throw new RuntimeException("Queue is full");

        if (head == 0) {
            head = (capacity);
        }
        queue[--head] = i;
        items++;
    }

    public T dequeueHead() {
        return super.remove();
    }

    public T dequeueTail() {
        if (isEmpty())
            throw new RuntimeException("Queue is empty");

        T temp = (T) queue[tail];
        if (++tail == size()) {
            tail = 0;
        }
        items--;
        return temp;
    }
}
