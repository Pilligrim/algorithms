package ru.geekbrains.algorithms.queue;

import java.util.Comparator;

public class PriorityQueue<T> extends Queue<T> {
    private final Comparator<? super T> comparator;

    public PriorityQueue(int capacity, Comparator<? super T> comparator) {
        super(capacity);
        this.comparator = comparator;
    }

    @Override
    public T remove() { //O(1)
        if (isEmpty())
            throw new RuntimeException("Queue is empty");

        T temp = (T) queue[0];
        System.arraycopy(queue, 1, queue, 0, items);
        items--;
        return temp;
    }

    @Override
    public void insert(T newVal) { //O(n)
        if (isFull()) {
            throw new RuntimeException("Queue is full");
        }

        int i;
        for (i = 0; i < size(); i++)
            if (comparator.compare((T) queue[i], newVal) > 0) break;

        System.arraycopy(queue, i, queue, i + 1, size() - i);
        queue[i] = newVal;
        items++;
    }
}
