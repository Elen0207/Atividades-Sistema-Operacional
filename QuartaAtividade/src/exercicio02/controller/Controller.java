package exercicio02.controller;

import java.util.concurrent.Semaphore;

public class Controller extends Thread {
	
	private int id;
	private Semaphore semaforo;
	
	public Controller ( int id, Semaphore semaforo) {
		this.id = id;
		this.semaforo = semaforo;
	} 
	

	public void Cozimento() {

		int tempoTotal = 0;
		int incremento = 100;
		double cont = 0.0;

		if ( id % 2 != 0 ) {		

			tempoTotal = (int) (Math.random() * 601 + 200 );
			
			while (incremento < tempoTotal) {
				cont = (incremento * 100) / tempoTotal;  
				System.out.println("Percentual do prato de Sopa de Cebola " + id + " é de " + cont + " %");
				incremento += incremento;			
			} 
			System.out.println("Prato de Sopa de Cebola " + id + " está pronto");
		} 
		else {		
			tempoTotal = (int) (Math.random() * 601 + 600 );

			while (incremento < tempoTotal) {
				cont = (incremento * 100) / tempoTotal ;  
				System.out.println("Percentual do prato de Lazanha a Bolonhesa " + id+ " é de " + cont + " %");
				incremento += incremento;			
			} 

			System.out.println("Prato Lazanha a Bolonhesa " + id + " está pronto");
		} 	
	} 
	
	public void Entrega() {
		int tempo = 500;

		if ( id % 2 != 0 ) {
			try {
				sleep(tempo);
			} 
            catch (InterruptedException e) {
				e.printStackTrace();
			} 
			
            System.out.println("Prato de Sopa de Cebola " + id + " foi entregue");
		}
		else {
			try {
				sleep(tempo);
			} 
            catch (InterruptedException e) {
				e.printStackTrace();
			} 
            
			System.out.println("Prato de Lazanha a Bolonhesa " + id + " foi entregue");
		}
	}

    @Override
	public void run() {
		Cozimento();

		try {
			semaforo.acquire();
			Entrega();
		} 
        catch (InterruptedException e) {
			e.printStackTrace();
		} 
        finally {
			semaforo.release();
		}
	} 
}