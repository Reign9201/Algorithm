package main.com.yancy.linkedlist;

/**
 * 普通链表
 */
public class Node {
    private int data;
    public Node next = null;


    public Node(int data) {
        this.data = data;
    }

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    public int getData() {
        return data;
    }
}
