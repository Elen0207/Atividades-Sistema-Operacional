package controller;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.swing.JOptionPane;
public class RedesController {
    public RedesController() {
        super();
    }

	public void ip (String SO) {
        String processo = "";
        String palavras[] = new String [0];

        if(SO.contains("indows")) {
                processo = "ipconfig";
                JOptionPane.showMessageDialog(null,"Seu Sistema Operacional é:\n"+SO);
        } else
            if(SO.contains("inux")) {
                processo = "ifconfig";
                JOptionPane.showMessageDialog(null,"Seu Sistema Operacional é:\n"+SO);
            } 

        try {
            Process p = Runtime.getRuntime().exec(processo);
            InputStream fluxo = p.getInputStream();
            InputStreamReader leitor = new InputStreamReader(fluxo);
            BufferedReader buffer = new BufferedReader(leitor);
            String linha = buffer.readLine();

            while (linha != null) {
                linha = buffer.readLine();
                palavras = linha.split(" ");
                for (int i = 0; i < palavras.length; i++) {
                    if (palavras[i].equalsIgnoreCase("adapter")) {
                        JOptionPane.showMessageDialog(null,"E o nome do Adaptador Ethernet:\n"+linha);
                    }
                    if (palavras[i].equalsIgnoreCase("IPv4")) {
                        JOptionPane.showMessageDialog(null,"E o IPv4 é:\n"+linha);
                    }
                }  
            } 
            buffer.close();
            leitor.close();
            fluxo.close();
        } catch (Exception e) {
             e.printStackTrace();
        }
    }  

    public void ping (String SO) {
        String processo = "";
        String palavras[] = new String [0];

        if(SO.equalsIgnoreCase("Windows 10")) {
            processo = "ping -n 10 www.google.com.br";
        } else 
            if(SO.equalsIgnoreCase("Linux")) {
                processo = "ping -c 10 www.google.com.br";
            } 

        try {
            Process p = Runtime.getRuntime().exec(processo);
            InputStream fluxo = p.getInputStream();
            InputStreamReader leitor = new InputStreamReader(fluxo);
            BufferedReader buffer = new BufferedReader(leitor);
            String linha = buffer.readLine();

            while (linha != null) {
                linha = buffer.readLine();
                palavras = linha.split(" ");
            
                for (int i = 0; i < palavras.length; i++) {
                    if (palavras[i].contains("time") || palavras[i].contains("tempo")) {
                        JOptionPane.showMessageDialog(null,palavras[i]);
                        System.out.println(palavras[i]);
                    }
                
                    if (palavras[i].contains("Media") || palavras[i].contains("Average")) {
                        JOptionPane.showMessageDialog(null,"E o tempo médio é: "+linha.lastIndexOf("=")+"ms");
                        System.out.println(linha); 
                    }
                }  
            }
            buffer.close();
            leitor.close();
            fluxo.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}