package view;
import controller.RedesController;
import javax.swing.JOptionPane;

public class Main {
    public static void main(String[]args){

        RedesController Controller = new RedesController();
        int opcao = 0;
        String SO = System.getProperty("os.name");
        
        while(opcao != 9) {
            opcao = Integer.parseInt(JOptionPane.showInputDialog("1- Filtrar os Adaptadores Ethernet e o IPv4 \n\n2 - Fazer a chamada de ping com 10 iterações, filtra a saída. \nPegando apenas o tempo e dá a saída, em ms, do tempo médio do ping \n\n9- Sair"));

            switch(opcao) {
                case 1:
                    Controller.ip(SO);
                break;

                case 2:
                    Controller.ping(SO);
                break;

                case 9:
                    JOptionPane.showMessageDialog(null,"Saindo");
                    break;
                default:
                    JOptionPane.showMessageDialog(null,"Opção inválida");
            }
        }
    }   
}