import org.junit.jupiter.api.Test;

public class TestReentrantLocks {

    @Test
    public void testReentrantLock(){
        final ReentrantLocks reentrantLocks = new ReentrantLocks();
        Thread t1 = new Thread("first Thread"){
            @Override
            public void run(){
                System.out.println("starting first thread : "+reentrantLocks.getCount());
                while(reentrantLocks.getCount()<6){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                };
            }
        };

      Thread t2 = new Thread("second thread"){
          @Override
          public void run(){
              System.out.println("starting second thread : "+reentrantLocks.getCount());
            while(reentrantLocks.getCountSynchronized()<6){
                try{
                    Thread.sleep(100);
                } catch(Exception e){
                    e.printStackTrace();
                }

            };
          };
      };


      t1.start();
      t2.start();

    }
}
