package os2project;



public class DiningPhilosophersProblem {
    public static void main(String[] args) {
      Philosopher p0 = new Philosopher(0);
      Philosopher p1 = new Philosopher(1);
      Philosopher p2 = new Philosopher(2);
      Philosopher p3 = new Philosopher(3);
      Philosopher p4 = new Philosopher(4);
      
      p0.start();
      p1.start();
      p2.start();
      p3.start();
      p4.start();
   }
}
