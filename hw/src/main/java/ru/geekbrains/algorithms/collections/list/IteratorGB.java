package ru.geekbrains.algorithms.collections.list;

public interface IteratorGB<T> {
    void reset();
    boolean atEnd();
    boolean atBegin();
    boolean hasNext();
    T next();
    T deleteCurrent();
    void insertAfter(T c);
    void insertBefore(T c);
    T getCurrent();
}
