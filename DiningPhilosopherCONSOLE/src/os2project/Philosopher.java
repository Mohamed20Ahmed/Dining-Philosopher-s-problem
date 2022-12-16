package os2project;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Philosopher extends Thread{
    int ph_id;
    Chopstick left;
    Chopstick right;
    String state;
    
    Philosopher(Chopstick left,Chopstick right,int ph_id){
        this.ph_id = ph_id;
        this.left = left;
        this.right = right;
                           }

private void Start(){
        state = "hungry";
        if(left.pickUp()){
            if(right.pickUp()){
                eat();

                think();
                right.putDown();
                left.putDown();
                              }
             else{
                 left.putDown();
                }
    }
    
}

    @Override
    public void run(){
        String oldState = "state";
        think();
        while(true){
            
           if(!oldState.equals(state)){
              hungry();
              oldState = state;
           }
           
           Start();
           
            }
}
   void eat(){
        System.out.println("ph " + ph_id + " is eating");
        try {
            Thread.sleep((long) Math.round(Math.random() * 1000));
        } catch (InterruptedException ex) {
            Logger.getLogger(Philosopher.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    void think(){
        System.out.println("ph " + ph_id + " is Thinking");
        state = "Thinking";
    }
    
    void hungry(){
        
        try {
            Thread.sleep((long) Math.round(Math.random() * 1000));
        } catch (InterruptedException ex) {
            Logger.getLogger(Philosopher.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("ph " + ph_id + " is hungry");
        state = "hungry";
    }
}
