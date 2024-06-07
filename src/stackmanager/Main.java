package stackmanager;

public class Main {
    public static void main(String[] args) {
        String s1 = "Hello World";

        StackManager stack = StackManager.getInstance();

        for (int i = 0; i < 100; i++) {
            stack.push(s1);
        }

        for (int i = 0; i <= 100; i++) {
            String popped = stack.pop();
            if (popped == null) break;
            System.out.printf("%d. Next string in stack is: %s\n",i , popped);
        }

    }
}
