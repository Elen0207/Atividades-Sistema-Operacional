package exercicio02.view;

import java.util.concurrent.Semaphore;
import exercicio02.controller.Controller;

public class Main {
    public static void main(String[] args) {

        Semaphore semaforo = new Semaphore(1);  
		
        for (int id = 0; id < 5; id ++) {
			Thread Cozimento = new Controller (id, semaforo);
			Cozimento.start();
		}  
    }   
}