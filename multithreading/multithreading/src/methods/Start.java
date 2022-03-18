package methods;

public class Start extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(i + ": Thread is running..");
        }
    }

    public static void main(String[] args) {
        Thread start = new Start();
        start.start();
    }
}
