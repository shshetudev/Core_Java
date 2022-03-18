package methods;

public class Join extends Thread{
    private static int count = 0;
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            count++;
            System.out.println(i + ": Executed by-" + Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        Thread thread1 = new Join(); // Thread-0
        Thread thread2 = new Join(); // Thread-1

        // set name
        thread1.setName("Thread-0");
        thread2.setName("Thread-1");
        thread1.start();
        thread2.start(); // thread1 execution starts

        try {
            thread1.join(); // thread1 wait for thread2 to complete its task, and then it joins
            thread2.join(); // thread2 wait for thread1 to complete its task, and then it joins
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Current thread name: " + Thread.currentThread().getName());
        System.out.println("Result: " + count);
//        assert count == 10;
    }
}
