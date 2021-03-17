package controller;
import java.util.concurrent.Semaphore;

public class Controller extends Thread {
    private int [] pessoas = new int [300];;
    private int compra = 0;
    private int venda;
    private Semaphore semaforo;

    public Controller (int [] pessoas, int compra, int venda, Semaphore semaforo) {
        this.pessoas = pessoas;
        this.compra = compra;
        this.venda = venda;
        this.semaforo = semaforo;
    }

    public void run () {
        try {
            semaforo.acquire();
            Login(pessoas, compra);
            Processo(pessoas, compra);
            Validacao(pessoas, compra);
        } 
        catch (InterruptedException e) {
		    e.printStackTrace();
		} 
        finally {
		    semaforo.release();
		} 
    }

    public int Login (int [] pessoas, int compra) {
       int tempo = (int)((Math.random() * 2000) + 500);

       for ( int i = 0; i <= 300; i ++) {
           if ( tempo > 1000 ) {
                try {
                    sleep(tempo);
                } 
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
               System.out.println("Erro na compra. Deu timeout");
           }
           else {
                try {
                    sleep(tempo);
                } 
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
                compra ++;
                pessoas[i] = pessoas[compra];
                Processo(pessoas, compra);
           }
       }
       return compra;
    }

    public int Processo(int [] pessoas, int compra) {
        int tempo = (int)((Math.random() * 3000) + 1000);

        for ( int i = 0; i <= 300; i ++) {
            if ( tempo > 2500 ) {
                try {
                    sleep(tempo);
                } 
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
                compra --;
                System.out.println("Erro na compra. Deu timeout");
            }
            else {
                try {
                    sleep(tempo);
                } 
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
                pessoas[i] = pessoas[compra];
                Validacao(pessoas, compra);
            }
        }
        return compra;
    }


    public void Validacao (int [] pessoas, int compra) {
        int ingressos = 0;
        for ( int i = 0; i <= 300; i ++) {
            while( ingressos > compra ) {
                venda = (int)((Math.random() * 4) + 1);
                if ( ingressos <= 100 ) { 
                    ingressos = ingressos + venda;
                    System.out.println("A pessoa #"+pessoas[i]+" comprou "+venda+" ingressos.\n"
                                            +"Ainda tem "+ingressos+"ingressos disponíveis.");;
                }
                else {
                    System.out.println("Os ingressos acabaram!");
                }
            }
        }
    }
}