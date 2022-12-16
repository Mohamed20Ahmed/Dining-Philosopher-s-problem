import java.util.concurrent.Semaphore;

public class Tools {
    Semaphore fork = new Semaphore(1);
    int num;

    Tools(int num) {
        this.num = num;
    }
    public boolean use(){
        return fork.tryAcquire();
    }

    public void putDown(){
        fork.release();
    }
}
