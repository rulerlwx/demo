package interview.test.threads;

/**
 * Created by lwx on 2019/2/17.
 */
public class ThreadFirst extends Thread {
    @Override
    public void run() {
        System.out.println("FirstThread");
    }

    public static void main(String[] args) {
        new ThreadFirst().start();
    }
}
