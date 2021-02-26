package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ProcessosController {
	

	public ProcessosController() {
		super ();
	}
		// retorna o SO que esta em uso na maquina
	public String os() {
		String os = System.getProperty("os.name"); 		 	// pega o nome do sistema operacional
		String arch = System.getProperty("os.arch");				// pegar a arquitetura do SO	
		String version = System.getProperty("os.version"); 	// pegar a versao da SO
		return os + " v." + version + " arch. " + arch ;
	}

	public void callProcess(String process) {
		try {
			Runtime.getRuntime().exec(process);      // processo java chamando outro processo 
		} catch (Exception e) {
			// e.printStackTrace();					// somente informa no display o erro que deu e encerra
			String msgErro = e.getMessage();		// pega mensagem de erro e aloca na variavel msgErro
//			System.err.println(msgErro);			// informa mensagem de erro da variavel 			
			if (msgErro.contains("740")) {			// comando para buscar dentro de msgErro uma informação especifica
				// cmd /c caminho do processo, chama a tela de validação
				StringBuffer buffer = new StringBuffer();  // criacao de um buffer
				buffer.append("cmd /c");					// informando o comand dentro do comand con
				buffer.append(" ");						// garantir espaço apos o /c
				buffer.append(process);					// informando o processo 
				try {									// try catch para tratamento de erro 
					Runtime.getRuntime().exec(buffer.toString());  // executando o buffer mas transformando em string
				} catch (IOException e1) {					// e1 porque vai tratar excluivamente essa excessao 
					e1.printStackTrace();					
				}
			}
			else {
				System.err.println(msgErro);			// se nao for 740 mostar qual erro foi
			}
		}		
	}
	
	public void readProcess(String process) {			// ler o conteudo de outro processo
		try {											// executar o processso "process" e vai armazenar em "p"
		Process p = Runtime.getRuntime().exec(process);  // crtl+1 ger
		InputStream fluxo = p.getInputStream();			// atencao para o import java.io.InputStrean.
		InputStreamReader leitor = new InputStreamReader(fluxo); 	// conversao do bit lidos na linha anterior para string
		BufferedReader buffer = new BufferedReader(leitor);			// devido ao volume deve ser armazenado em buffer
		String linha = buffer.readLine();							// pega a primeira linha do buffer e descarta
		while (linha != null) {							// ler as linhas do buffer até ficar vazia /// poderia ser feito um split
			System.out.println(linha);
			linha = buffer.readLine();
		}
		buffer.close();
		leitor.close();
		fluxo.close();
		} catch (IOException e) {						// tratamento de excessão
			e.printStackTrace();
		} 			
	}	
	
	public void killProcess (String param) {					// encerramento de processo 
		String cmdPid = "TASKKILL /PID";				// comando no Windows para "matar" process por PID
		String cmdNome = "TASKKILL /IM ";				// comando no Windows para "matar" process por Nome
		int pid = 0;									// variavel para PID
		StringBuffer buffer= new StringBuffer();		// buffer para armazenagem temporaria 
		
		// NumberFormatException 						// forca fazer um try/catch manual
		try {
			// TASKKILL /PID XXXX
			pid = Integer.parseInt(param);					// converter string em interior, com risco de erro
			buffer.append(cmdPid);							// carregar o string cmdPID
			buffer.append(" ");								// gerar espaço apos o cmdPID
			buffer.append(pid);								// carregar o pid lido
		} 
		catch (NumberFormatException e){					// tratamento de erro se nao for numerico (string)
			// TASKKILL /IM nomedo processo.exe
			buffer.append(cmdNome);							// carregar cmdNome
			buffer.append(" ");								// gerar espaço apoios /IM
			buffer.append(param);							// carregar o parametro recebido (nome do processo)
		}
		callProcess(buffer.toString()); 					// chamar o callProcess para rodar a procedure matar
	}
}

// crtl + shift + O => corrigir o import

