package exercicio01.controller;

import java.util.concurrent.Semaphore;

public class Controller extends Thread {
    private int id;
	private int tempo;
	private Semaphore semaforo;
	
	
	public Controller ( int id, Semaphore semaforo ) {
		this.id = id;
		this.semaforo = semaforo;
	}

	public void Calculos() {
        if (id % 3 == 0) {
			tempo = (int) ((Math.random() * 2001) + 1000);

            try {
                sleep(tempo);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

		    System.out.println("Threads com ID dividido por 3 resultando em resto igual a 0: " + id);
		} 

		else if (id % 3 == 1) {
			tempo = (int) ((Math.random() * 1001) + 200);

            try {
                sleep(tempo);
            } 
            catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Threads com ID dividido por 3 resultando em resto igual a 1: " + id);
	    } 
		
		else if (id % 3 == 2) {
			tempo = (int) ((Math.random() * 1501) + 500);
            
            try {
                sleep(tempo);
            } 
            catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Threads com ID dividido por 3 resultando em resto igual a 2: " + id);
		} 

        else {
            System.out.println("Não temos um cálcula para esse Id: " + id); 
        }
	}  
	
	
	private void Transacao() {
        if (id % 3 == 0 || id % 3 == 2) {
			tempo = 1500;

            try {
                sleep(tempo);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

		    System.out.println("Transição para o BD de ID dividido por 3 resultando em resto igual a 0 ou 2: " + id);
		} 

		else if (id % 3 == 1) {
			tempo = 1000;

            try {
                sleep(tempo);
            } 
            catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Transição para o BD de ID dividido por 3 resultando em resto igual a 1: " + id);
	    }  

        else {
            System.out.println("Não temos um cálcula para esse Id: " + id); 
        }
	} 


    @Override
	public void run() {

        try {
            semaforo.acquire();
            Calculos();
        } 
        catch (InterruptedException e) {
		    e.printStackTrace();
		} 
        finally {
		    semaforo.release();
		} 
		    
		try {
			semaforo.acquire();
			Transacao();
		} 
        catch (InterruptedException e) {
		    e.printStackTrace();
		} 
        finally {
		    semaforo.release();
		} 
	} 

}