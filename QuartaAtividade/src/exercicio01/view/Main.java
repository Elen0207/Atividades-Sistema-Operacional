package exercicio01.view;

import java.util.concurrent.Semaphore;
import exercicio01.controller.Controller;

public class Main {
    public static void main(String[] args) {
        Semaphore semaforo = new Semaphore(1); 

        for (int id = 1; id < 21; id ++) {
            Thread thread = new Controller (id, semaforo);
            thread.start();
        }
    } 
}