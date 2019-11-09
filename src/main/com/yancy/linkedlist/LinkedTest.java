package main.com.yancy.linkedlist;

public class LinkedTest {
    public static void main(String[] args) {
        IntLinkedList linkedList = new IntLinkedList();

        linkedList.insertByIndex(9, 0);
        linkedList.insertByIndex(7, 1);
        linkedList.insertByIndex(5, 2);
        linkedList.insertByIndex(3, 3);

        Node node = linkedList.deleteByValue(7);
        System.out.println(node.getData());
        linkedList.printLinkedList();
        System.out.println("size = "+linkedList.size());

        System.out.println("------------------");
//
//        Node node1 = linkedList.deleteByValue(7);
//        System.out.println(node1.getData());
//        linkedList.printLinkedList();
//        System.out.println("size = "+linkedList.size());
//        System.out.println(linkedList.findByValue(5).getData());
//
//
//        Node node = linkedList.findByIndex(0);
//        System.out.println(node.getData());
//
//        Node del = linkedList.deleteByIndex(3);
//        System.out.println(del.next);
//
//
//        linkedList.printLinkedList();
    }
}
