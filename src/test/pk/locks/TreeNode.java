package test.pk.locks;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class TreeNode {

    TreeNode parent = null;
    List<TreeNode> children = new ArrayList();

    ReentrantLock lockParent = new ReentrantLock();
    ReentrantLock lockChild = new ReentrantLock();


    public  void addChild(TreeNode child){
        synchronized (lockParent){
            synchronized (lockChild){
                if(!this.children.contains(child)) {
                    this.children.add(child);
                    try {
                        Thread.sleep(100);
                    }
                    catch (InterruptedException e) {
                        System.out.println("Thread 01 InterruptedException occured");
                    }
                    child.setParentOnly(this);
                    System.out.println("Added child");
                }
            }

        }

    }


    public  void setParent(TreeNode parent){

        synchronized (lockParent){
            synchronized (lockChild){
                this.parent = parent;
                try {
                    Thread.sleep(100);
                }
                catch (InterruptedException e) {
                    System.out.println("Thread 01 InterruptedException occured");
                }
                parent.addChildOnly(this);
                System.out.println("set parent");
            }
        }

    }

    public synchronized  void addChildOnly(TreeNode child){
        if(!this.children.contains(child)) {
            this.children.add(child);
        }
        System.out.println("Added child only");
    }

    public synchronized void setParentOnly(TreeNode parent) {
        this.parent=parent;
        System.out.println("set parent only");
    }
}
