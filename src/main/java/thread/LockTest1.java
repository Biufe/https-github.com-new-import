package thread;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest1 {
    ArrayList<Integer> arrayList = new ArrayList<Integer>();
    Lock lock = new ReentrantLock();
    public static void main(String[] args) {
        final LockTest1 lockTest = new LockTest1();

        new Thread(){
          public void run(){
                lockTest.insert(this.currentThread());
          }
        }.start();

        new Thread(){
            @Override
            public void run() {
                lockTest.insert(this.currentThread());
            }
        }.start();


    }

    private  void insert(Thread currentThread) {
//        Lock lock = new ReentrantLock();
//        lock.lock();
        if(lock.tryLock()) {
            try {
                System.out.println(currentThread.getName() + "get...lock");
                for (int i = 0; i < 5; i++) {
                    arrayList.add(i);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                System.out.println(currentThread.getName() + "out...lock");
                lock.unlock();
            }
        }else{
            System.out.println("get...lock...fail");
        }
    }
}
