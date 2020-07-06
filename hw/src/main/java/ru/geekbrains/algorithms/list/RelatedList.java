package ru.geekbrains.algorithms.list;

public class RelatedList<T> {
    private Node<T> head;
    private int size;

    public RelatedList() {
        head = null;
        size = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void push(T element) {
        Node<T> n = new Node<>(element);
        n.next = head;
        head = n;
        size++;
    }

    public T pop() {
        if (isEmpty()) return null;
        T temp = (T) head.elem;
        head = head.next;
        size--;
        return temp;
    }

    @Override
    public String toString() {
        Node current = head;
        StringBuilder sb = new StringBuilder("[");
        while (current != null) {
            sb.append(current);
            current = current.next;
            sb.append((current == null) ? "]" : ", ");
        }
        return sb.toString();
    }

    public boolean contains(T element) {
        return find(element) == null;
    }

    private Node find(T element) {
        if (isEmpty()) return null;
        Node current = head;
        while (!current.elem.equals(element)) {
            if (current.next == null)
                return null;
            else
                current = current.next;
        }
        return current;
    }

    public boolean delete(T elem) {
        Node<T> current = head;
        Node<T> previous = head;
        while (!current.elem.equals(elem)) {
            if (current.next == null) {
                return false;
            } else {
                previous = current;
                current = current.next;
            }
        }
        if (current == head) {
            head = head.next;
        } else {
            previous.next = current.next;
        }
        return true;
    }
}
