package exercicio01.view;

import javax.swing.JOptionPane;
import exercicio01.controller.ThreadVetor;

public class Main {
    public static void main (String[] args) {
        
        int numerico = Integer.parseInt(JOptionPane.showInputDialog("Digite um número: "));  
        int [] vetor = new int [1000];
        ThreadVetor vetorThread = new ThreadVetor();

        for (int i = 0 ; i < 1000 ; i ++) {
            vetor[i] = (int)((Math.random()*100));         
        }
        
        System.out.println("Tempo total:"+vetorThread.calcularTempo(vetor, numerico)+" seg.");

    }
}