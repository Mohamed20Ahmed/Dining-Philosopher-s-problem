package os2project;



public class DiningPhilosophersProblem {
    public static void main(String[] args) {
      Chopstick[] chopstick = new Chopstick[5];
      Philosopher[] philosopher = new Philosopher[5];
      
    for (int i = 0; i < chopstick.length; i++) {
        chopstick[i] = new Chopstick(i);
    }
    
    for (int i = 0; i < philosopher.length; i++) {

            philosopher[i] = new Philosopher(chopstick[i], chopstick[(i+1)%5],i);
            philosopher[i].start();
        }
    
      
   }
}
