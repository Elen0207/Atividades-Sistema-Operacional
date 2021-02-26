package view;

import controller.ProcessosController;

public class Principal {

	public static void main(String[] args) {

		ProcessosController procController = new ProcessosController();   // criação de constructor
		
//		String os = procController.os();   				
//		System.out.println(os);							
		
// 		String process = "C:\\windows\\write.exe";	
//		String process = "C:\\windows\\regedit.exe";   // vai dar pau inicialmente por pede perfil de administrador
//		procController.callProcess(process);
		
//		String process = "TASKLIST /FO TABLE";			// Endereço do executavel no window
		// String process = "ping -t10 www.google.com.br";	    // -t10 força a realizar n leituras, forcar break manual
		//String process = " TRACERT www.uol.com.br";				// forçar break manual
//		String process = " ipconfig" ;
//		procController.readProcess(process);			// ler o processo que foi executado
		
		String param = "11376";
		procController.killProcess(param);
	}
}