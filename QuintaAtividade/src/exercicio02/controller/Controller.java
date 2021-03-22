package exercicio02.controller;

import java.util.concurrent.Semaphore;

public class Controller extends Thread {
    private int sentido;
    private int carro;
    private Semaphore semaforo;

    public Controller ( Semaphore semaforo ) {
        this.semaforo = semaforo;
    }
    
    public void Cruzamento () {
        for (carro = 1; carro < 5 ; carro ++ ) {
            
            sentido = (int)(Math.random() * 4);
            try {
                sleep(sentido);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            switch (sentido) {
                case 0: 
                    System.out.println("O #"+carro+" carro cruzou no sentido Norte > Sul");
                break;

                case 1:
                    System.out.println("O #"+carro+" carro cruzou no sentido Leste > Oeste");
                break;

                case 2:
                    System.out.println("O #"+carro+" carro cruzou no sentido Sul > Norte");
                break;

                case 3:
                    System.out.println("O #"+carro+" carro cruzou no sentido Oeste > Leste");
                break;

                default:
                    System.out.println("Desculpe! Ocorreu algum erro.");
            }
        }
    }
    
    public void run () {
        try {
			semaforo.acquire();
			Cruzamento();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();	
		}
    }
}
