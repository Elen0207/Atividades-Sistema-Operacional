package exercicio03.controller;

public class CalculaMatriz extends Thread {

    private int matriz[][] = new int [3][5];
    private int soma[] = new int [3];
    private int total = 0;

    public CalculaMatriz () {
        super();
    }

    public void SomaMatriz () {
        
        for (int i = 0; i < 3;) {				
			for (int j = 0; j < 5; j++) {

				matriz[i][j] = (int)(Math.random()*100);
				soma[i] = i + j;

			} 
            
            total = total + soma[i];
            i++;
            System.out.println("Linha: "+ i +" soma das Thread Id = "+ total);

		}

        System.out.println("Total da Soma é = "+ total);
    }
    
    public void run () {
        SomaMatriz();
    }
}