package queuemanager;

public class QueueManager {
    private static final int[] QUEUE = new int[100];
    private static int pivot = -1;
    private static final QueueManager INSTANCE = new QueueManager();

    private QueueManager() {

    }

    public static QueueManager getInstance() {
        return INSTANCE;
    }

    public void enQueue(int num) {
        if (isFull()) {
            System.out.println("Queue is full");
            return;
        }
        QUEUE[++pivot] = num;
    }

    public static int deQueue() {
        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("Queue is empty");
        }
        int valueToReturn = QUEUE[0];
        pivot--;
        shiftQueueLeft();
        return valueToReturn;
    }

    private static void shiftQueueLeft() {
        for (int i = 0; i <= pivot; i++) {
            QUEUE[i] = QUEUE[i+1];
        }
    }

    private static boolean isEmpty() {
        return pivot == -1;
    }

    private static boolean isFull() {
        return pivot == QUEUE.length - 1;
    }
}
