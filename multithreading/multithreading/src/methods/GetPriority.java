package methods;

public class GetPriority extends Thread{
    @Override
    public void run() {
        System.out.println("Running thread name is: " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        Thread thread1 = new GetPriority(); // Thread-0
        Thread thread2 = new GetPriority(); // Thread-1

        // set name:
        thread1.setName("Thread-0");
        thread2.setName("Thread-1");
        System.out.println("Thread-0 priority:" + thread1.getPriority());
        System.out.println("Thread-1 priority:" + thread2.getPriority());
        thread1.start();
        thread2.start();
    }
}
