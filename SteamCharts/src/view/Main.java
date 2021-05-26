package view;

import controller.ISteamCharts;
import controller.SteamCharts;

import java.io.IOException;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        ISteamCharts jogos = new SteamCharts();
        
        int opcao = 0;
		
		while (opcao != 9) {
			opcao = Integer.parseInt(JOptionPane.showInputDialog(
                                                        "1 - Primeiro método \n"+ 
                                                        "2 - Segundo método\n"+ 
                                                        "9 - Sair "));
			
            switch (opcao) {
                case 1:
                    int ano = Integer.parseInt(JOptionPane.showInputDialog("Digite o ano:"));
                    String mes = JOptionPane.showInputDialog("Digite o mes:");
                    double media = Double.parseDouble(JOptionPane.showInputDialog("Digite a media:"));
                    
                    try {
                        jogos.readFile(ano, mes, media);
                    } catch (IOException e) {
                        JOptionPane.showMessageDialog(null, "Arquivo não localizado!");
                    }
                break;

                case 2:
                    int anos = Integer.parseInt(JOptionPane.showInputDialog("Digite o ano:"));
                    String meses = JOptionPane.showInputDialog("Digite o mes:");
                    String path = "C:\\Users\\elenc\\Documents";
                    String name = "NovoArquivo.csv";

                    try {
                       jogos.createFile(anos, meses, path, name);
                    } catch (IOException e) {
                        JOptionPane.showMessageDialog(null, "Arquivo não localizado!");
                    }
                break;

                case 9:
					JOptionPane.showMessageDialog(null, "Finalizando o programa");
				break;
					
				default:
				    JOptionPane.showMessageDialog(null, "Opção inválida");
            }
        }
    }    
}