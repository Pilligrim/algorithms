package ru.geekbrains.algorithms.list;

public class DoubleRelatedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private IteratorImpl iterator;

    public DoubleRelatedList() {
        head = null;
        tail = null;
        iterator = new IteratorImpl();
        iterator.reset();
    }

    private class IteratorImpl implements IteratorGB<T> {
        Node<T> current;

        @Override
        public void reset() {
            current = head;
        }

        @Override
        public boolean atEnd() {
            if (!isExists()) throw new RuntimeException("iterator is null");
            return current.next == null;
        }

        @Override
        public boolean atBegin() {
            if (!isExists()) throw new RuntimeException("iterator is null");
            return current.prev == null;
        }

        private boolean isExists() {
            return !(iterator == null);
        }

        @Override
        public T deleteCurrent() {
            if (!isExists()) throw new RuntimeException("iterator is null");
            T temp = current.elem;
            if (atBegin() && atEnd()) {
                head = null;
                tail = null;
                reset();
            } else if (atBegin()) {
                head = current.next;
                head.prev = null;
                reset();
            } else if (atEnd()) {
                tail = current.prev;
                tail.next = null;
                current = current.next;
            } else {
                current.prev.next = current.next;
                current.next.prev = current.prev;
            }
            return temp;

        }

        @Override
        public void insertAfter(T elem) {
            if (!isExists()) throw new RuntimeException("iterator is null");
            Node<T> temp = new Node<>(elem);
            if (!atEnd()) {
                temp.next = current.next;
                current.next.prev = temp;
            } else {
                tail = temp;
            }
            current.next = temp;
            temp.prev = current;
        }

        @Override
        public void insertBefore(T elem) {
            if (!isExists()) throw new RuntimeException("iterator is null");
            Node<T> temp = new Node<>(elem);
            if (!atBegin()) {
                temp.prev = current.prev;
                current.prev.next = temp;
            } else {
                head = temp;
            }
            current.prev = temp;
            temp.next = current;
        }

        @Override
        public T getCurrent() {
            if (!isExists()) throw new RuntimeException("iterator is null");
            return current.elem;
        }

        @Override
        public boolean hasNext() {
            if (!isExists()) throw new RuntimeException("iterator is null");
            return current.next != null;
        }

        @Override
        public T next() {
            if (!isExists()) throw new RuntimeException("iterator is null");
            current = current.next;
            return current.prev.elem;
        }
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void push(T elem) {
        Node<T> node = new Node<>(elem);
        node.next = head; // if (head == null) node.next = null;
        if (head == null) {
            tail = node;
        } else {
            head.prev = node;
        }
        head = node;
        iterator.reset();
    }

    public T pop() {
        if (isEmpty()) return null;
        T elem = tail.elem;
        if (tail.prev != null) {
            tail.prev.next = null;
            tail = tail.prev;
            iterator.reset();
        } else {
            tail = null;
            head = null;
            iterator = null;
        }
        return elem;
    }

    public boolean contains(T c) {
        Node<T> node = new Node<>(c);
        Node<T> current = head;
        while (!current.equals(node)) {
            if (current.next == null) return false;
            else current = current.next;
        }
        return true;
    }

    public T delete(T c) {
        Node<T> node = new Node<>(c);
        Node<T> current = head;
        Node<T> previous = head;

        while (!current.equals(node)) {
            if (current.next == null) return null;
            else {
                previous = current;
                current = current.next;
            }
        }
        if (current == head && current == tail) {
            head = null;
            tail = null;
            iterator = null;
        } else if (current == head) {
            head.next.prev = null;
            head = head.next;
        } else if (current == tail) {
            tail.prev.next = null;
            tail = tail.prev;
        } else {
            previous.next = current.next;
            current.next.prev = previous;
        }

        return current.elem;
    }

    @Override
    public String toString() {
        if (isEmpty()) return "[]";
        Node<T> current = head;
        StringBuilder sb = new StringBuilder("[ ");
        while (current != null) {
            sb.append(current);
            current = current.next;
            sb.append((current == null) ? " ]" : ", ");
        }
        return sb.toString();
    }

    public IteratorImpl getIterator() {
        return iterator;
    }

}
