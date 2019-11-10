package main.com.yancy.stack;

public class StackTest {
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(4);
        stack.push(9);

        stack.printStack();
        System.out.println("\n-----------------");


        System.out.print(stack.pop());
        System.out.print(stack.pop());
        System.out.print(stack.pop());
        System.out.print(stack.pop());
//        System.out.print(stack.pop());

        System.out.println("\nsize = "+stack.size());
        //System.out.print(stack.pop());
    }
}
