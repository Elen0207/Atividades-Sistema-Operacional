package exercicio04.controller;

import java.awt.Rectangle;
import java.util.Random;
import java.util.concurrent.Semaphore;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class ThreadCorrida extends Thread {

    Random r = new Random();

	private JLabel Sapo;
	private JButton btnIniciar;
	private static JTextArea textArea;
	private int n = 0;
	private int opcao;
	private JLabel lbFim;
	private Semaphore farol;
	private JTextArea textAreaSapo;

    public ThreadCorrida (Semaphore farol, JLabel Sapo, JButton btnIniicar, JTextArea textArea, final int f,
			JLabel lbFim, JTextArea textAreaSapo) {

		this.farol = farol;
		this.Sapo = Sapo;
		this.btnIniciar = btnIniicar;
		ThreadCorrida.textArea = textArea;
		this.f = f;
		this.lbFim = lbFim;
		this.textAreaSapo = textAreaSapo;

	}

	private void restart() {
		switch (opcao) {
            case 1:
                Sapo.setBounds(10, 11, 100, 93);
            break;

            case 2:
                Sapo.setBounds(10, 118, 100, 93);
            break;

            case 3:
                Sapo.setBounds(10, 223, 100, 93);
            break;

            case 4:
                Sapo.setBounds(10, 327, 100, 93);
                break;
            case 5:
                Sapo.setBounds(10, 431, 100, 93);
            break;

            default:
                throw new IllegalArgumentException("Ocorreu um erro, verifique o "+ opcao);
		}
	}

	private void podio() {
		System.out.println("Sapo " + opcao + " chegou!");
		textArea.setText(textArea.getText() + " Sapo " + opcao + "\n");
	}

	private void corrida () {
		
        btnIniciar.setEnabled(false);
		Rectangle position;
		position = Sapo.getBounds();
		Sapo.setBounds(position);
		Rectangle finish = lbFim.getBounds();
		
        while (position.x < finish.x) {
			try {
				Thread.sleep(600);
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}

			n = r.nextInt(50);
			position.x += n;
			textAreaSapo.setText(textAreaSapo.getText() + " " + position.x);
			Sapo.setBounds(position);

		}

		System.out.println();
		btnIniciar.setEnabled(true);
	}

	@Override
	public void run() {
		corrida ();

		try {
			farol.acquire();
			podio();
		} catch (InterruptedException e) {
			e.printStackTrace();
        } finally {
                farol.release();
            }

		restart();
	}
}