package main.com.yancy.linkedlist;

/**
 * 实现一个LRU 链表
 * 最近最少使用
 * 思路：一个单项链表，越靠近head位置，表示最近使用过，链表尾部表示最近最近最少使用
 */
public class LRULinkedList<T> {
    private static final int DEFAULT_MAX_CACHE_SIZE = 20;
    private int capacity = DEFAULT_MAX_CACHE_SIZE;
    private LRUNode<T> head;
    private LRUNode<T> last;
    private int currentLength;

    public LRULinkedList() {
    }

    public LRULinkedList(int capacity) {
        this.capacity = capacity;
    }

    /**
     * 查找对应元素前面一个节点的元素
     *
     * @param element 查找的元素
     * @return 查找的元素前一个节点
     */
    public LRUNode<T> findPreElement(T element) {
        if (head == null) {
            return null;
        }
        LRUNode<T> temp = head;
        LRUNode<T> preTemp = null;
        while (temp != null && temp.element.equals(element)) {
            preTemp = temp;
            temp = temp.next;
        }
        return preTemp;
    }

    /**
     * 查找对应元素的节点
     *
     * @param element 查找的元素
     * @return 查找的元素节点
     */
    public LRUNode<T> findElement(T element) {
        LRUNode<T> preElement = findPreElement(element);
        if (preElement == null) {
            return null;
        }
        return preElement.next;
    }

    public void insert(T element) {
        LRUNode<T> insertNode = new LRUNode<>(element);
        if (currentLength == 0) {
            head = insertNode;
            last = insertNode;
            return;
        }
        LRUNode<T> preElement = findPreElement(element);
        // 表示链表中存在0个或者一个元素
        if (preElement == null) {
            head = insertNode;
            last = insertNode;
            return;
        }
        //存在前者节点，删除对应元素，然后插入到头部
        LRUNode<T> targetNode = preElement.next;
        preElement.next = preElement.next.next;


    }


}
