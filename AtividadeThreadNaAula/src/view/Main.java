package view;

import controller.Controller;
import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) throws Exception {
        Semaphore semaforo = new Semaphore(1); 

        for (int i = 0; i < 300; i ++) {
            Thread thread = new Controller(semaforo);
            thread.start();
        }
    }
}