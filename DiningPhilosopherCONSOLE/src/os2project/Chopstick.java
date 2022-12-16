package os2project;
import java.util.concurrent.Semaphore;

public class Chopstick {
    Semaphore fork = new Semaphore(1);
    int num;
    
    Chopstick(int num) {
        this.num = num;
    }
    public boolean pickUp(){
            return fork.tryAcquire();
    }
    
        public void putDown(){
            fork.release();
    }
}
