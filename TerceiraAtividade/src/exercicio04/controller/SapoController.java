package exercicio04.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Semaphore;

public class SapoController implements ActionListener {

    private int sapo1;
	private int sapo2;
	private int sapo3;
	private int sapo4;
	private int sapo5;

	private Semaphore farol;
    private int lbFim;
	private int btnIniciar;
	
	private final int f1 = 1;
	private final int f2 = 2;
	private final int f3 = 3;
	private final int f4 = 4;
	private final int f5 = 5;

	private int textArea;
	private int textAreaSapo1;
	private int textAreaSapo2;
	private int textAreaSapo3;
	private int textAreaSapo4;
	private int textAreaSapo5;	

	public SapoController (Semaphore farol, int sapo1, int sapo2, int sapo3, int sapo4, int sapo5, int btnIniciar, int lbFim, int textArea, int textAreaSapo1, int textAreaSapo2, int textAreaSapo3, int textAreaSapo4,  int textAreaSapo5	) {
		
		this.farol = farol;
        this.btnIniciar = btnIniciar;
		this.lbFim = lbFim;

		this.sapo1 = sapo1;
		this.sapo2 = sapo2;
		this.sapo3 = sapo3;
		this.sapo4 = sapo4;
		this.sapo5 = sapo5;

		this.textArea = textArea;
		this.textAreaSapo1 = textAreaSapo1;
		this.textAreaSapo2 = textAreaSapo2;
		this.textAreaSapo3 = textAreaSapo3;
		this.textAreaSapo4 = textAreaSapo4;
		this.textAreaSapo5 = textAreaSapo5;
	}
	
	private void startCorrida() {

		Thread t1 = new ThreadCorrida(farol, sapo1, btnIniciar,textArea, f1, lbFim, textAreaSapo1);
		Thread t2 = new ThreadCorrida(farol, sapo2, btnIniciar,textArea, f2, lbFim, textAreaSapo2);
		Thread t3 = new ThreadCorrida(farol, sapo3, btnIniciar,textArea, f3, lbFim, textAreaSapo3);
		Thread t4 = new ThreadCorrida(farol, sapo4, btnIniciar,textArea, f4, lbFim, textAreaSapo4);
		Thread t5 = new ThreadCorrida(farol, sapo5, btnIniciar,textArea, f5, lbFim, textAreaSapo5);

		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		startCorrida();
	}
    
}