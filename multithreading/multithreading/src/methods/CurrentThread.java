package methods;

public class CurrentThread extends Thread{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        Thread current1 = new CurrentThread(); // Thread-0
        Thread current2 = new CurrentThread(); // Thread-1
        current1.start();
        current2.start();
    }
}
