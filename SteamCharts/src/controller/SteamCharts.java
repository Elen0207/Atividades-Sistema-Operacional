package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

public class SteamCharts implements ISteamCharts {

    public SteamCharts() {
        super();
    }

    public void createFile(int ano, String mes, String path, String name) throws IOException {
        File dir = new File(path);
        File arq = new File(path, name);
        if ( dir.exists() && dir.isDirectory() ) {
            boolean existe = false;
            if ( arq.exists() ) {
                existe = true;
            }
            String conteudo = geraTxt();
            FileWriter fileWriter = new FileWriter(arq, existe);
            PrintWriter print = new PrintWriter(fileWriter);
            print.write(conteudo);
            print.flush();
            print.close();
            fileWriter.close();
        }
        else {
            throw new IOException("Diretório inválido");
        }
    }

   
    private String geraTxt() {
        StringBuffer buffer = new StringBuffer();
        String linha = "";
        while(!linha.equalsIgnoreCase("fim")) {
            linha = JOptionPane.showInputDialog(null, "Digite um frase",
                    "Entrada de texto", JOptionPane.INFORMATION_MESSAGE);
            if ( !linha.equalsIgnoreCase("fim") ) {
                buffer.append(linha+"\r\n");
            }
        }
        return buffer.toString();
    }


    public void readFile(int ano, String mes, double media) throws IOException {
        String arquivo = "SteamCharts.csv";
        File arq = new File(arquivo);    
        

        if ( arq.exists() && arq.isFile() ) {
            FileInputStream fluxo = new FileInputStream(arq);
            InputStreamReader leitor = new InputStreamReader(fluxo);
            BufferedReader buffer = new BufferedReader(leitor);
            String line = buffer.readLine();

            while (line != null) {
                String [] phrase;
                phrase = line.split(",");
                
                for (String word: phrase) {
                    if ( word.equalsIgnoreCase(mes) ) {
                        int anos = Integer.parseInt(phrase[1]);
                        double medias = Double.parseDouble(phrase[3]);
                        if ( anos == ano && medias >= media ) {
                            System.out.println(phrase[0]+" | "+phrase[3]);
                        }
                    }
                }
                line = buffer.readLine();
            }
            
            buffer.close();
            leitor.close();
            fluxo.close();
        } 
        else {
            throw new IOException("Arquivo inválido");
        }
    }
}