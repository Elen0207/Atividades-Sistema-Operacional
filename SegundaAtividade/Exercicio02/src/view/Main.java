package view;

import controller.Controller;
import javax.swing.JOptionPane;
public class Main {
    public static void main(String[]args){

        Controller Processo = new Controller();
        int opcao = 0;
        String SO = System.getProperty("os.name");
        String processo = "";
        
        while(opcao != 9) {
            opcao = Integer.parseInt(JOptionPane.showInputDialog("1- Liste os processos ativos \n\n2 - Mate um processo pelo PID. \n\n3 - Mate um processo pelo Nome.\n\n9- Sair"));

            switch(opcao) {
                case 1:
                    Processo.listProcess(SO, processo);
                break;

                case 2:
                    int PID = Integer.parseInt(JOptionPane.showInputDialog("Digite o PID do processo que deseja encerrar: "));
                    Processo.killProcessPID(SO, processo, PID);
                break;

                case 3:
                    String Name = JOptionPane.showInputDialog("Digite o Nome do processo que deseja encerrar: ");
                    Processo.killProcessName(SO, processo, Name);
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