package os2project;
import java.util.concurrent.locks.ReentrantLock;

public class Chopstick {
    ReentrantLock fork = new ReentrantLock();
    int num;
    
    Chopstick(int num) {
        this.num = num;
    }
    public boolean pickUp(){
            return fork.tryLock();
    }
    
        public void putDown(){
            fork.unlock();
    }
}
