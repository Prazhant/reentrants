package practice.pk.multithreads;

import org.junit.jupiter.api.Test;

class MultiThreadsTest {

    @Test
    public void testMultiThread_whenMultiThread_createsMultipleReadButOnlyOneWriteThread(){
        MultiThreads threads = new MultiThreads();


        Thread t1 = getReadThread("t1",threads);

        Thread t2 = getReadThread("t2", threads);

        Thread t3 = getReadThread("t3", threads);

        Thread t4 = getReadThread("t4", threads);

        Thread t5 = getReadThread("t5", threads);


        Thread tw1 = getWriteThread("tw1",threads);

        Thread tw2 = getWriteThread("tw2", threads);

        Thread tw3 = getWriteThread("tw3", threads);

        tw1.start();
        tw2.start();
        tw3.start();
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();


    }

    private Thread getWriteThread(String tw1, MultiThreads threads) {
        return new Thread(tw1){
            @Override
            public void run() {
                threads.saveId("id");
            }
        };
    }

    private Thread getReadThread(String t1, MultiThreads threads) {
        return new Thread(t1){
            @Override
            public void run() {
                threads.getId();
            }
        };
    }

}