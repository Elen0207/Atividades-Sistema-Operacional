package controller;

public class OperacoesController {
    
    public OperacoesController() {
        super();
    }

    public void concatenaString () {
        // Concatena 32768 caracteres, 1 a 1, em uma variável String

        String cadeia = "";
        double tempoInicial = System.nanoTime();

        for (int i = 0; i < 1000 ; i++ ) {
            cadeia = cadeia + "a";
        }
        double tempoFinal = System.nanoTime();
        double tempoTotal = tempoFinal - tempoInicial;
        System.out.println("String ==> "+ tempoTotal +" nano");
        tempoTotal = tempoTotal / Math.pow(10, 9); // Transformando nano segundo em segundos

        System.out.println("String ==> "+ tempoTotal +" segundos");
    }

    public void concatenaBuffer () {
         // Concatena 32768 caracteres, 1 a 1, em um buffer de String
         StringBuffer buffer = new StringBuffer();
         double tempoInicial = System.nanoTime();

        for (int i = 0; i < 1000 ; i++ ) {
            buffer.append("a");
        }
        double tempoFinal = System.nanoTime();
        double tempoTotal = tempoFinal - tempoInicial;
        System.out.println("Buffer ==> "+ tempoTotal +" nano");
        tempoTotal = tempoTotal / Math.pow(10, 9); // Transformando nano segundo em segundos

        System.out.println("Buffer ==> "+ tempoTotal +" segundos");
            
    }

    public void vetorFrase() {
         // Concatena 32768 caracteres, 1 a 1, em um vetor String
        String [] vetor = new String[1000];
         double tempoInicial = System.nanoTime();
 
         for (int i = 0; i < 1000 ; i++ ) {
             vetor[i] = new String();
         }
         double tempoFinal = System.nanoTime();
         double tempoTotal = tempoFinal - tempoInicial;
         System.out.println("Vetor ==> "+ tempoTotal +" nano");
         tempoTotal = tempoTotal / Math.pow(10, 9); // Transformando nano segundo em segundos
 
         System.out.println("Vetor ==> "+ tempoTotal +" segundos");
        
         //String[] vetor = frase.split(" ");
            //int len = vetor.length;
            //for (int i = 0; i < len ; i ++) {
            //    System.out.println(vetor[i]);
            //}
            //Foreach
            //for (Tipo variável: coleção)
        
        //for (String palavra : vetor) {
            //  System.out.println(palavra);
        //}
    }
    // split quebra um String a partir de um valor, transformando em pedaços
    // Recebe uma frase, divide em palavras, imprime cada palavra
}
