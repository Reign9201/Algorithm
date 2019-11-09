package main.com.yancy.linkedlist;

/**
 * 普通链表操作：插入，删除，查找
 */
@SuppressWarnings("unused")
public class IntLinkedList {
    private int size;
    private Node head;
    private Node last;

    public int size() {
        return size;
    }

    /**
     * 查找
     *
     * @param index 查找的位置
     * @return Node
     */
    public Node findByIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("指定的操作的位置超出链表范围");
        }
        if (index == 0/*如果刚好是头部位置*/) {
            return head;
        }
        if (index == size - 1/*如果刚好是尾部位置*/) {
            return last;
        }

        //其他情况
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }


    /**
     * 根据节点的内容来返回节点
     *
     * @param value 节点的内容，即data
     * @return 节点
     */
    public Node findByValue(int value) {
        Node temp = head;
        while (temp != null) {
            if (temp.getData() == value) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    /**
     * 根据指定索引进行插入
     *
     * @param data  插入的数据
     * @param index 插入的位置
     */
    public void insertByIndex(int data, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("指定的操作的位置超出链表范围");
        }
        Node node = new Node(data);
        if (size == 0/*最开始操作*/) {
            head = node;
            last = node;
        } else if (index == 0/*头部插入*/) {
            node.next = head;
            head = node;
        } else if (index == size/*尾部追加*/) {
            last.next = node;
            last = node;
        } else/*中间插入*/ {
            //先查找，再插入
            Node temp = findByIndex(index - 1);
            Node nextNode = temp.next;
            temp.next = node;
            node.next = nextNode;

        }
        size++;
    }

    /**
     * 根据指定索引进行删除
     *
     * @param index 索引
     * @return 返回删除的节点
     */
    public Node deleteByIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("指定的操作的位置超出链表范围");
        }
        Node removeNode;
        if (index == 0/*头部删除*/) {
            removeNode = head;
            head = removeNode.next;
        } else if (index == size - 1/*尾部删除*/) {
            removeNode = last;
            Node targetNode = findByIndex(index - 1);
            targetNode.next = null;
            last = targetNode;
        } else {
            //其他删除
            Node prevNode = findByIndex(index - 1);
            removeNode = prevNode.next;
            prevNode.next = removeNode.next;
        }

        size--;
        return removeNode;
    }

    /**
     * 根据元素进行删除
     * @param value 节点元素
     * @return 要删除的节点
     */
    public Node deleteByValue(int value) {
        Node temp = head;
        Node prevNode = null;

        while (temp != null && temp.getData() != value) {
            prevNode = temp;
            temp = temp.next;
        }
        //删除的头部
        if (prevNode == null) {
            head = head.next;
            return temp;
        }
        //表示没找到这个元素
        if (temp == null) {
            return null;
        }
        prevNode.next = prevNode.next.next;
        return temp;


        // 方法二
        /*while (temp != null) {
            if (temp.getData() == value) {

                if (prevNode == null*//*表示删除的元素在头部*//*) {
                    head = head.next;
                    size--;
                    return temp;
                }
                prevNode.next = temp.next;
                size--;
                return temp;
            }
            prevNode = temp;
            temp = temp.next;
        }
        return null;*/
    }

    public void printLinkedList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.getData() + " ");
            temp = temp.next;
        }
    }
}
