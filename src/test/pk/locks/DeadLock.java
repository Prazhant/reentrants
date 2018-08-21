package test.pk.locks;


public class DeadLock {
    public static void main(String[] args) {
        TreeNode parent  = new TreeNode();
        TreeNode child = new TreeNode();

        Thread t1 = new Thread("Thread 1"){
            @Override
            public void run(){

                parent.addChild(child);

            }
        };


        Thread t2 = new Thread("Thread 2"){
            @Override
            public void run(){
                child.setParent(parent);
            }
        };


        t1.start();
        t2.start();
    }


}
