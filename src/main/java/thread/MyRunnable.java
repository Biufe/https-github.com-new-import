package thread;

public class MyRunnable implements Runnable {
    public void run() {
        while(true){
            System.out.println("123");
        }
    }

    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable,"t1");
        thread.start();
    }
}
