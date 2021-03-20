package exercicio01.view;

import java.util.concurrent.Semaphore;
import exercicio01.controller.Controller;

public class Main {
    public static void main(String[] args) {

        Semaphore semaforo = new Semaphore(1);
        Thread thread = new Controller(semaforo);
        thread.start();
    }
}