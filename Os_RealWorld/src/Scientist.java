import java.util.logging.Level;
import java.util.logging.Logger;
public class Scientist extends Thread {
    int scientist_id;
    int pc_id;
    int microscope_id;
    Tools pc;
    Tools microscope;
    String state;
Scientist(Tools pc, Tools microscope, int scientist_id, int pc_id, int microscope_id) {
        this.scientist_id = scientist_id;
        this.pc = pc;
        this.microscope = microscope;
        this.microscope_id = microscope_id;
        this.pc_id = pc_id;
}


    public void Start() throws InterruptedException {

        state = "needPC&Microscope";
         if (pc.use()) {
             if (microscope.use()) {
                 work();
                 think();
                 microscope.putDown();
                 pc.putDown();
             } else {
                 pc.putDown();
             }
         }
     }


        @Override
    public void run () {
       String oldState = "state";
       think();
       while (true) {
           if (!oldState.equals(state)) {
                   needPcAndMicro();
                    oldState = state;
                }
           try {
               Start();
           } catch (InterruptedException e) {
               throw new RuntimeException(e);
           }
       }
        }
        void work() {
            System.out.println("Scientist " + scientist_id + " is working");
            try {
                Thread.sleep((long) Math.round(Math.random() * 800));
            } catch (InterruptedException ex) {
                Logger.getLogger(Scientist.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        void think() {
            System.out.println("scientist " + scientist_id + " is Thinking");
            state = "Thinking";
        }

//        void needPC() {
//
//            try {
//                Thread.sleep((long) Math.round(Math.random() * 1000));
//            } catch (InterruptedException ex) {
//                Logger.getLogger(Scientist.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            System.out.println("scientist " + scientist_id + " needs PC " + pc_id);
//            state = "needPC&Microscope";
//        }
//        void needMicroscope () {
//
//            try {
//                Thread.sleep((long) Math.round(Math.random() * 1000));
//            } catch (InterruptedException ex) {
//                Logger.getLogger(Scientist.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            System.out.println("scientist " + scientist_id + " needs Microscope " + microscope_id);
//            state = "needPC&Microscope";
//        }

    void needPcAndMicro(){
        try {
            Thread.sleep((long) Math.round(Math.random() * 1000));
        } catch (InterruptedException ex) {
            Logger.getLogger(Scientist.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("scientist " + scientist_id + " needs PC " + pc_id + " and Microscope " + microscope_id );
        state = "needPC&Microscope";


    }

    }
