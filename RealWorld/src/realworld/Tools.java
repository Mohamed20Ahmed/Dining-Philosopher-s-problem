package realworld;
import java.util.concurrent.locks.ReentrantLock;

public class Tools {
    ReentrantLock fork = new ReentrantLock();
    int num;
    
    Tools(int num) {
        this.num = num;
    }
    public boolean use(){
        return fork.tryLock();
    }

    public void end(){
        fork.unlock();
    }
}