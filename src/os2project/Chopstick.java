package os2project;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.concurrent.Semaphore;

public class Chopstick {
    Semaphore fork;
    
    public Chopstick(){
         fork = new Semaphore(1);
    }
    public void Pickup(){
        try {
            fork.acquire(1);
        } catch (InterruptedException ex) {
            Logger.getLogger(Chopstick.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
        public void Putdown(){
            fork.release(1);
    }
}
