import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLocks {

    private final ReentrantLock lock = new ReentrantLock();
    private int i=0;

    public int getCount() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " count: " + i);
            return i++;
        } finally {
            lock.unlock();
        }

    }

        public synchronized int getCountSynchronized(){
         return i++;
        }

}
