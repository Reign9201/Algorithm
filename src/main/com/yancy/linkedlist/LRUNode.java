package main.com.yancy.linkedlist;

public class LRUNode<T> {
    public T element;
    public LRUNode<T> next;

    public LRUNode(T element) {
        this.element = element;
    }

    public LRUNode(T element, LRUNode<T> next) {
        this.element = element;
        this.next = next;
    }
}
