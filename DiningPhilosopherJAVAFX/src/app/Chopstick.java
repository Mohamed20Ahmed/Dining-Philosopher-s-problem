package app;

import javafx.application.Platform;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class Chopstick extends ReentrantLock {

    private int num;
    Semaphore fork = new Semaphore(1);


    private ImageView chopstickView;
    private TextArea loggingConsole;

    public Chopstick(int id, TextArea loggingConsole) {
        this.num = id;
        this.loggingConsole = loggingConsole;
    }

    public void setChopstickView(ImageView chopstickView) {
        this.chopstickView = chopstickView;
    }



    boolean Pickup() {
        if (fork.tryAcquire()) {

            Platform.runLater(()-> {
                chopstickView.setVisible(false);

            });
            return true;
        }
        return false;
    }
    void Putdown() {
            fork.release();
            Platform.runLater(() -> {
                chopstickView.setVisible(true);
            });
    }

}
