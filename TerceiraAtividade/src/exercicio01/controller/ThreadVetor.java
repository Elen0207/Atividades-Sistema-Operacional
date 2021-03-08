package exercicio01.controller;

import javax.swing.JOptionPane;

public class ThreadVetor extends Thread {

    public ThreadVetor() {
        super();
    }

    public static double calcularTempo(int [] vetor, int numerico) {
        double tempoTotal = 0;
        if (numerico % 2 == 0) {
            JOptionPane.showMessageDialog(null, "Valor numerico Par, veja vetor e o tempo no console");
            double tempoInicial = System.nanoTime();
            
            for (int i = 0 ; i < vetor.length; i++) {
                Thread thread = new ThreadVetor();
                thread.start();
            }

            double tempoFinal = System.nanoTime();
            tempoTotal = tempoFinal - tempoInicial;
            tempoTotal = tempoTotal / Math.pow(10, 9); 

        } else {
            JOptionPane.showMessageDialog(null, "Valor numerico Impar, veja vetor e o tempo no console");
            double tempoInicial = System.nanoTime();
            
            for(int vetorThread : vetor) {
                Thread thread = new ThreadVetor();
                thread.start();
            }

            double tempoFinal = System.nanoTime();
            tempoTotal = tempoFinal - tempoInicial;
            tempoTotal = tempoTotal / Math.pow(10, 9); 
        }
        return tempoTotal;
    }

    public void run() {
        super.run();
    }
}