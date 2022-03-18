package methods;

public class Sleep extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i + ": executed by: " + Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        Thread sleepTest1 = new Sleep(); // Thread-0
        Thread sleepTest2 = new Sleep(); // Thread-1

        sleepTest1.start();
        sleepTest2.start();
    }
}
