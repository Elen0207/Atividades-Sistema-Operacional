package view;

import java.io.IOException;
import javax.swing.JOptionPane;
import controller.IReadFile;
import controller.ReadFile;

public class Main {
    public static void main(String[] args) {
        IReadFile GenericFood = new ReadFile();
        String path = "C:\\TEMP";
		String file = "generic_food.csv";
        int opcao = 0;
		
		while (opcao != 9) {
			opcao = Integer.parseInt(JOptionPane.showInputDialog(
                                                        "1 - Testar com path \n"+ 
                                                        "2 - Testar sem path\n"+ 
                                                        "9 - Sair "));
			
            switch (opcao) {
                case 1:
                    try {
                        GenericFood.ReadFileGenericFood(path, file);
                    } catch (IOException e) {
                        JOptionPane.showMessageDialog(null, "Arquivo não localizado!");
                    }
                break;
                case 2:
                    try {
                        GenericFood.ReadFileWithoutPath(file);
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