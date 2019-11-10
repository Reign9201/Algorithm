package main.com.yancy.stack;

/**
 * 栈数据结构
 * 先进后出
 * 以数组形式实现
 */
@SuppressWarnings("unused")
public class Stack {
    private static final int DEFAULT_CAPACITY = 20;
    private int capacity = DEFAULT_CAPACITY;
    private int curLength = 0;

    private int[] elements;

    public Stack() {
        this(DEFAULT_CAPACITY);
    }

    public Stack(int capacity) {
        this.capacity = capacity;
        elements = new int[capacity];
    }

    public void push(int element) {
        if (curLength >= capacity) {
            throw new StackOverflowError("超出栈存储容量");
        }
        elements[curLength++] = element;
    }

    public int peek() {
        if (curLength <= 0) {
            throw new NullPointerException("栈中已经没有数据啦");
        }
        return elements[curLength - 1];
    }


    public int pop() {
        if (curLength <= 0) {
            throw new NullPointerException("栈中已经没有数据啦");
        }
        int target = elements[curLength - 1];
        elements[--curLength] = 0;
        return target;
    }

    public int size() {
        return curLength;
    }

    public void printStack() {
        for (int i = 0; i < curLength; i++) {
            System.out.print(elements[i] + " ");
        }
    }
}
