package os2project;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.concurrent.Semaphore;  

public class Philosopher extends Thread{
    int pnum;
    static Chopstick chopsticks[] = {new Chopstick(),new Chopstick(),new Chopstick(),new Chopstick(),new Chopstick()};  
    static Semaphore room = new Semaphore(4); 
    
    Philosopher(int pnum){
        this.pnum = pnum;
                           }

    void Start(){
        think();
        while(true){
            hungery();
        
            try {
                room.acquire(1);
            } catch (InterruptedException ex) {
                Logger.getLogger(Philosopher.class.getName()).log(Level.SEVERE, null, ex);
            }
        chopsticks[pnum].Pickup();
        chopsticks[ (pnum + 1) % 5].Pickup();
 
        eat();
            
        chopsticks[pnum].Putdown();
        chopsticks[ (pnum + 1) % 5].Putdown();
        room.release(1);
        
        think();
        }
    }
    
    @Override
    public void run(){  
        while (true){
            Start();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Philosopher.class.getName()).log(Level.SEVERE, null, ex);
            }
                    }
                     }
    
    void eat(){
        System.out.println("ph " + pnum + " is eating");
        try {
            Thread.sleep((long) Math.round(Math.random() * 1000));
        } catch (InterruptedException ex) {
            Logger.getLogger(Philosopher.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void think(){
        System.out.println("ph " + pnum + " is Thinking");
        try {
            Thread.sleep((long) Math.round(Math.random() * 1000));
        } catch (InterruptedException ex) {
            Logger.getLogger(Philosopher.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void hungery(){
        System.out.println("ph " + pnum + " is hungery");
     }
}
