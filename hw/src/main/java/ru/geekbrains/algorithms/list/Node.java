package ru.geekbrains.algorithms.list;

import java.util.Objects;

public class Node <T>{
    T elem;
    Node next;

    public Node(T elem) {
        this.elem = elem;
    }

    @Override
    public String toString() {
        return elem.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return elem.equals(node.elem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(elem);
    }
}
