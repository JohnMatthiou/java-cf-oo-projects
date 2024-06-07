package stackmanager;

public class StackManager {
    private static final String[] STACK = new String[100];
    private static int top = -1;
    private static final StackManager INSTANCE = new StackManager();

    private StackManager() {

    }

    public static StackManager getInstance() {
        return INSTANCE;
    }

    public void push(String input) {
        if (isFull()) {
            System.out.println("Stack is full");
            return;
        }
        STACK[++top] = input;
    }

    public String pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return null;
        }
        return STACK[top--];
    }

    private static boolean isFull() {
        return top == STACK.length - 1;
    }

    private static boolean isEmpty() {
        return top == -1;
    }
}
