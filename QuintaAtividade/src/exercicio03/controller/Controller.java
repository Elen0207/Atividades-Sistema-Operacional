package exercicio03.controller;

import java.util.concurrent.Semaphore;

public class Controller extends Thread {
    private Semaphore semaforo;
    private int [] tempo = new int [3];
    private int [] colocacao = new int [35];
    private int posicao = 0;

    public Controller ( Semaphore semaforo ) {
        this.semaforo = semaforo;
    }

    public void Corrida () { 
        int i, j, a;

        for (i = 0 ; i < 5 ; i ++) {
            for (int equipe = 1 ; equipe < 8 ; equipe ++) {
                int carro = (int)(Math.random() * 14);

                System.out.println("O carro #"+carro+" da equipe #"+equipe+" entrou na pista");
                
                for (a = 0 ; a < 3; a ++) {
                    int Tempo = (int)(Math.random() * 1000);
                    try {
                        sleep(Tempo);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    tempo[a] = tempo[a] + Tempo;
                    colocacao[posicao] = tempo[a];
                }
                posicao++;
            }
        }

        int aux = 0;
        System.out.println("\n\n ** GRID **");

        for ( i = 0 ; i < posicao ; i ++ ) {
            for ( j = i + 1 ; j < posicao ; j ++ ) {               
                if ( colocacao[i] > colocacao[j] ) {  
                    aux = colocacao[i];
                    colocacao[i] =  colocacao[j];
                    colocacao[j] = aux;
                    aux = 0;             
                }
            }
            System.out.println("O "+(i+1)+"º colocado demorou "+colocacao[i]+".s para dar as 3 voltas.");
        }
    }

    public void run () {
        try {
            semaforo.acquire();
            Corrida();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaforo.release();	
        }
    }
}