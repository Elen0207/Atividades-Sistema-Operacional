package exercicio01.controller;

import java.util.concurrent.Semaphore;

public class Controller extends Thread {
    private Semaphore semaforo;
    private int tempo = 0;
    private int passos;
    private int cruzar_porta;

    public Controller (Semaphore semaforo) {
        this.semaforo = semaforo;
    }
   
    public void Percurso() {
        int [] pessoa = new int [4];

        for ( int i = 0 ; i < 4 ; i ++ ) {
            
            passos = (int)(Math.random() * 4 + 6);
            tempo = (200 / passos);
            cruzar_porta = (int)(Math.random() * 1000 + 2000); 
            cruzar_porta = cruzar_porta + tempo;

            try {
                sleep(cruzar_porta);
            } catch (Exception e) {
                e.printStackTrace();
                System.err.println("Desculpe! Ocorreu algum erro");
            }

            pessoa[i] = cruzar_porta;
        }

        int aux = 0;

        for ( int i = 0; i < 4 ; i++ ) {
            for ( int j = i+1 ; j < 4 ; j++ ) {
             
                if ( pessoa[i] > pessoa[j] ) {  
                    aux = pessoa[i];
                    pessoa[i] =  pessoa[j];
                    pessoa[j] = aux;
                    aux = 0;             
                }
            }

            System.out.println("A "+(i+1)+"ª pessoa demorou "+pessoa[i]+".s para cruzar a porta");
        }
    }
    
    public void run () {
        try {
            semaforo.acquire();
            Percurso();
        } 
        catch (InterruptedException e) {
		    e.printStackTrace();
		} 
        finally {
		    semaforo.release();
		} 
    }
}