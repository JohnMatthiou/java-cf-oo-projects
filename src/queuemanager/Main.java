package queuemanager;

public class Main {
    public static void main(String[] args) {

        QueueManager queue = QueueManager.getInstance();

        for (int i = 0; i < 100; i++) {
            queue.enQueue(i + 1);
        }

        try{
            for (int i = 0; i <= 100; i++) {
                System.out.println("Next value in queue is: " + queue.deQueue() );
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println(e.getMessage());
        }

    }
}
