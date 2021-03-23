package exercicio04.controller;

import java.util.concurrent.Semaphore;

public class Controller extends Thread {
    private Semaphore semaforo;
    private int Saldo;

    public Controller ( Semaphore semaforo, int Saldo ) {
        this.semaforo = semaforo;
        this.Saldo = Saldo;
    }

    public void Transicao () {
        int transicao = (int)(Math.random() * 10);
        int SaldoInicial = (int)(Math.random() * 100 + 1000);
        int Valor = (int)(Math.random() * 100);
        int Codigo = (int)(Math.random() * 100 + 1000);

        if ( transicao % 2 == 0 ) {
            Saldo = SaldoInicial - Valor;
            System.out.println("A Conta: "+Codigo+" realizou um Saque de R$ "+Valor+" e ficou com Saldo de R$ "+Saldo);
        } 
        else {
            Saldo = SaldoInicial + Valor;
            System.out.println("A Conta: "+Codigo+" realizou um Depósito de R$ "+Valor+" e ficou com Saldo de R$ "+Saldo);
        }
    }

    public void run() {
		try {
			semaforo.acquire();
			Transicao();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();	
		}
    }
}