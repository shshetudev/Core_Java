package methods;

public class Run implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        new Thread(new Run()).start();
        new Thread(new Run()).start();
    }
}
