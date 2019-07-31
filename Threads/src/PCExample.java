
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class PCExample {

    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(1);
        Producer p = new Producer(queue);
        Consumer c = new Consumer(queue);
        Thread t1 = new Thread(p);
        t1.start();
        
        Thread t2 = new Thread(c);
        t2.start();
    }

}
