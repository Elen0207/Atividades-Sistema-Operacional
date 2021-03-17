package controller;

import java.util.concurrent.Semaphore;
public class Controller extends Thread {
    private Semaphore semaforo;
    private int ingressos = 100;

    public Controller ( Semaphore semaforo) {
        this.semaforo = semaforo;
    }

    public void run () {
        try {
            semaforo.acquire();
            Validacoes();
        } 
        catch (InterruptedException e) {
		    e.printStackTrace();
		} 
        finally {
		    semaforo.release();
		} 
    }


    public void Validacoes () {      
        
        for ( int pessoas = 0; pessoas<= 300; pessoas ++) {
            int tempo = (int)(Math.random() * 2000 + 500);
            
            try {
                sleep(tempo);
            } 
            catch (InterruptedException e) {
                e.printStackTrace();
            }

            if ( tempo > 1000 ) {
                System.err.println("Erro na compra. Deu timeout");
            }
            else {
                System.out.println("A pessoa #"+pessoas+" se logou");
                tempo = (int)(Math.random() * 3000 + 1000);
            
                try {
                    sleep(tempo);
                } 
                    catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if ( tempo > 2500 ) {
                    System.err.println("Erro na compra. Deu timeout");
                }
                else {

                    System.out.println("A pessoa #"+pessoas+" passou pelo processo de compra");

                    while( ingressos > 0 ) {
                        
                        int venda = (int)(Math.random() * 4 + 1);
                        ingressos = ingressos - venda;
        
                        if ( ingressos > 0 ) { 
                            System.out.println("A pessoa #"+pessoas+" comprou "+venda+" ingressos.\n"
                                                    +"Ainda tem "+ingressos+" ingressos disponíveis.");;
                        }
                        else {
                            System.out.println("Os ingressos acabaram!");
                        }
                    }
                }
            }
        }
    }
}