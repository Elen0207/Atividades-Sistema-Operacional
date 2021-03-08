package exercicio04.controller;

import java.awt.Rectangle;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class ThreadCorrida extends Thread {

    Random r = new Random();

	private int Sapo;
	private int btnIniciar;
	private static int textArea;
	private int n = 0;
	private int opcao;
	private int lbFim;
	private Semaphore farol;
	private int textAreaSapo;

    public ThreadCorrida (Semaphore farol, int Sapo, int btnIniicar, int textArea, int opcao,
	int lbFim, int textAreaSapo) {

		this.farol = farol;
		this.Sapo = Sapo;
		this.btnIniciar = btnIniicar;
		ThreadCorrida.textArea = textArea;
		this.opcao = opcao;
		this.lbFim = lbFim;
		this.textAreaSapo = textAreaSapo;

	}

	private void restart() {
		textArea = 600;
		switch (opcao) {
            case 1:
                Sapo(textArea);
            break;

            case 2:
                Sapo(textArea);
            break;

            case 3:
				Sapo(textArea);
            break;

            case 4:
				Sapo(textArea);
            break;

            case 5:
                Sapo(textArea);
            break;

            default:
                throw new IllegalArgumentException("Ocorreu um erro, verifique o "+ opcao);
		}
	}

	private void Sapo(int textArea2) {
	}

	private void podio() {
		System.out.println("Sapo " + opcao + " chegou!");
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