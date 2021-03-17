package view;

import controller.Controller;
import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) throws Exception {
        int [] pessoas = new int [300];
        int compra = 0, venda = 0;
        Semaphore semaforo = new Semaphore(1); 

        for (int id = 1; id < 300; id ++) {
            Thread thread = new Controller(pessoas, compra, venda, semaforo);
            thread.start();
        }
    }
}