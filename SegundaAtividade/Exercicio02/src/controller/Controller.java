package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.swing.JOptionPane;
public class Controller {

    public Controller(){
        super();
    }
    //Chamando os processos ativos 
    private String callProcess(String SO, String processo) {
        
        if(SO.contains("indows")) {
                processo = "TASKLIST /FO TABLE";
                JOptionPane.showMessageDialog(null,"Seu Sistema Operacional é:\n"+SO);
        } else
            if(SO.contains("inux")) {
                processo = "ps -ef";
                JOptionPane.showMessageDialog(null,"Seu Sistema Operacional é:\n"+SO);
            } 

        try {
            Runtime.getRuntime().exec(processo);
        } 
        catch (Exception e) {
            String msgErro = e.getMessage();
            
            if (msgErro.contains("740")) {
                StringBuffer buffer = new StringBuffer();  
				buffer.append("cmd /c");					
				buffer.append(" ");						
				buffer.append(processo);	
            
                try {									
                    Runtime.getRuntime().exec(buffer.toString());
                } 
                catch (IOException e1) {	
                    e1.printStackTrace();
                }
            } else {
                JOptionPane.showMessageDialog(null,"Ocorreu um erro, veja detalhes no Console");
                System.err.println(msgErro);
            }
        }
        return processo;
    }

    //Listando os processos
    public void listProcess(String SO, String processo) {
        
        try {
            Process p = Runtime.getRuntime().exec(callProcess(SO, processo));
            InputStream fluxo = p.getInputStream();
            InputStreamReader leitor = new InputStreamReader(fluxo);
            BufferedReader buffer = new BufferedReader(leitor);
            String linha = buffer.readLine();
            JOptionPane.showMessageDialog(null,"Visualize a operação no Console");

            while (linha != null) {
                linha = buffer.readLine();
                System.out.println(linha);
            } 

            buffer.close();
            leitor.close();
            fluxo.close();
        } catch (Exception e) {
             e.printStackTrace();
        }
    }

    // Mate um processo pelo PID.
    public void killProcessPID(String SO, String processo, int PID) {
        String cmdPid = "";

		if(SO.contains("indows")) {
            cmdPid  = "TASKKILL /PID";
        } else
            if(SO.contains("inux")) {
                cmdPid  = "kill -9";
            } 
        							
		int pid = 0;									
		StringBuffer buffer= new StringBuffer();		
					
		try {    
			pid = PID;					
			buffer.append(cmdPid);							
			buffer.append(" ");								
			buffer.append(pid);	
            Runtime.getRuntime().exec(buffer.toString());	
            JOptionPane.showMessageDialog(null,"Visualize a operação no Console");						
		} 
		catch (Exception e){	
            JOptionPane.showMessageDialog(null,"Ocorreu um erro, veja detalhes no Console");				
            e.printStackTrace();
		}
		callProcess(SO, processo);
    }

    //Mate um processo pelo Nome.
    public void killProcessName(String SO, String processo, String Name) {
        String cmdNome = "";

		if(SO.contains("indows")) {
            cmdNome = "TASKKILL /IM";
        } else
            if(SO.contains("inux")) {
                cmdNome = "pkill -f";
            } 
        		
		String name = "";
		StringBuffer buffer= new StringBuffer();		
		
        try {
		    name = Name;
            buffer.append(cmdNome);							
            buffer.append(" ");								
            buffer.append(name);
            Runtime.getRuntime().exec(buffer.toString());
            JOptionPane.showMessageDialog(null,"Visualize a operação no Console");

		} 
		catch (Exception e) {	
            JOptionPane.showMessageDialog(null,"Ocorreu um erro, veja detalhes no Console");	
            e.printStackTrace();
        }
		callProcess(SO, processo);
    }
}
