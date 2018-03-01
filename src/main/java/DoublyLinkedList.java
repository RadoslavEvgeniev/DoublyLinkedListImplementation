import java.util.Iterator;
import java.util.function.Consumer;

public class DoublyLinkedList<E> implements Iterable<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public int size() {
        return this.size;
    }

    private void setSize(int size) {
        this.size = size;
    }

    public void addFirst(E element) {
        if (this.size == 0) {
            Node<E> newHead = new Node<>(element);
            this.head = newHead;
            this.tail = this.head;
            this.size++;
        } else {
            Node<E> newHead = new Node<>(element);
            newHead.nextNode = this.head;
            this.head.prevNode = newHead;
            this.head = newHead;
            this.size++;
        }
    }

    public void addLast(E element) {
        if (this.size == 0) {
            Node<E> newTail = new Node<>(element);
            this.head = newTail;
            this.tail = this.head;
            size++;
        } else {
            Node<E> newTail = new Node<>(element);
            this.tail.nextNode = newTail;
            newTail.prevNode = this.tail;
            this.tail = newTail;
            size++;
        }
    }

    public E removeFirst() {
        if (this.size == 0) {
            throw new IllegalArgumentException();
        }
        E element = this.head.value;
        Node<E> newFirst = this.head.nextNode;
        size--;
        if (size == 0) {
            this.head = null;
            this.tail = null;
            return element;
        }
        newFirst.prevNode = null;
        this.head = newFirst;
        return element;
    }

    public E removeLast() {
        if (this.size == 0) {
            throw new IllegalArgumentException();
        }
        E element = this.tail.value;
        Node<E> newTail = this.tail.prevNode;
        size--;
        if (size == 0) {
            this.head = null;
            this.tail = head;
            return element;
        }
        newTail.nextNode = null;
        this.tail = newTail;
        return element;
    }

    @SuppressWarnings("unchecked")
    public E[] toArray() {
        E[] arr = (E[]) new Object[this.size];
        Node<E> currentNode = this.head;
        int index = 0;
        while (currentNode != null) {
            arr[index] = currentNode.value;
            currentNode = currentNode.nextNode;
            index++;
        }
        return arr;
    }

    @Override
    public Iterator<E> iterator() {
        return new MyIterator();
    }

    @Override
    public void forEach(Consumer<? super E> action) {
        Node<E> currentNode = this.head;
        while (currentNode != null) {
            action.accept(currentNode.value);
            currentNode = currentNode.nextNode;
        }
    }

    private class Node<T> {

        private T value;
        private Node<T> prevNode;
        private Node<T> nextNode;

        public Node(T value) {
            this.value = value;
        }
    }

    private class MyIterator implements Iterator<E> {

        private int index;
        private Node<E> node;

        MyIterator() {
            this.index = 0;
            this.node = head;
        }
        @Override
        public boolean hasNext() {
            if (this.index >= size) {
                return false;
            }
            return true;
        }

        @Override
        public E next() {
            E element = this.node.value;
            this.index++;
            this.node = this.node.nextNode;
            return element;
        }

        @Override
        public void remove() {

        }
    }
}
