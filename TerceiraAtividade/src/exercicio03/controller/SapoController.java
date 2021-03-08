package exercicio03.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Semaphore;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class SapoController implements ActionListener {

    private JLabel sapo1;
	private JLabel sapo2;
	private JLabel sapo3;
	private JLabel sapo4;
	private JLabel sapo5;
    private JLabel lbFim;

	private JButton btnIniciar;
	private JTextArea textArea;
	
	private final int f1 = 1;
	private final int f2 = 2;
	private final int f3 = 3;
	private final int f4 = 4;
	private final int f5 = 5;

	private Semaphore farol;

	private JTextArea textAreaSapo1;
	private JTextArea textAreaSapo2;
	private JTextArea textAreaSapo3;
	private JTextArea textAreaSapo4;
	private JTextArea textAreaSapo5;
	
	public SapoController (Semaphore farol, JLabel sapo1, JLabel sapo2, JLabel sapo3, JLabel sapo4, JLabel sapo5,JButton btnIniciar, JTextArea textArea, JLabel lbFim, JTextArea textAreaSapo1, JTextArea textAreaSapo2, JTextArea textAreaSapo3, JTextArea textAreaSapo4, JTextArea textAreaSapo5) {
		this.farol = farol;
        this.btnIniciar = btnIniciar;
		this.sapo1 = sapo1;
		this.sapo2 = sapo2;
		this.sapo3 = sapo3;
		this.sapo4 = sapo4;
		this.sapo5 = sapo5;
		this.textArea = textArea;
		this.lbFim = lbFim;
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