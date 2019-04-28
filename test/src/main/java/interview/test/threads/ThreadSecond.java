package interview.test.threads;

/**
 * Created by lwx on 2019/2/17.
 */
public class ThreadSecond implements Runnable {
    @Override
    public void run() {
        System.out.println("second-thread");
    }

    public static void main(String[] args) {
        new Thread(new ThreadSecond()).start();
    }
}
