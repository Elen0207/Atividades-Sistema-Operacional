package view;

import javax.swing.JOptionPane;

import controller.ArquivosController;
import controller.IArquivosController;

public class Main {
    public static void main (String[] args) {
        IArquivosController arqCont = new ArquivosController();
        String dirWin = " C:\\Windows";
        String path = "C:\\Users\\elenc\\Documents";
        String name = "test.txt";
        
        try {    
            int opcao = 0;
            while ( opcao != 9 ) {
                opcao = Integer.parseInt(JOptionPane.showInputDialog(" *** MENU *** \n"+
                "1 - Ler diretório\n 2 - Criar arquivo \n 3 - Ler arquivo \n 4 - Abrir arquivo \n 9 - Sair"));
                
                switch( opcao ) {
                    case 1:
                        arqCont.readDir(dirWin);
                    break;

                    case 2:
                        arqCont.createFile(path, name);
                    break;

                    case 3:
                        arqCont.readFile(path, name);
                    break;

                    case 4:
                        arqCont.openFile(path, name);
                    break;

                    case 9:
                        JOptionPane.showMessageDialog(null,"Saindo");
                    break;

                    default:
                        JOptionPane.showMessageDialog(null,"Opção Inválida");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}