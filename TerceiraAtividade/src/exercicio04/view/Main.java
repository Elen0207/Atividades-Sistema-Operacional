package exercicio04.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.util.concurrent.Semaphore;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import exercicio03.controller.SapoController;
import javax.swing.JScrollPane;
import java.awt.Color;

public class Main extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    public static void main (String [] args) {
        EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
    }
    //Layout do frame
    public Main() {
		setResizable(false);

		Semaphore farol = new Semaphore(1);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 699);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel sapo1 = new JLabel("");
		sapo1.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\src\\exercicio03\\img\\sapo.gif"));
		sapo1.setBounds(10, 11, 100, 93);
		contentPane.add(sapo1);
		
		JLabel sapo2 = new JLabel("");
		sapo2.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\src\\exercicio03\\img\\sapo.gif"));
		sapo2.setBounds(10, 118, 100, 93);
		contentPane.add(sapo2);
		
		JLabel sapo3 = new JLabel("");
		sapo3.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\src\\exercicio03\\img\\sapo.gif"));
		sapo3.setBounds(10, 223, 100, 93);
		contentPane.add(sapo3);
		
		JLabel sapo4 = new JLabel("");
		sapo4.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\src\\exercicio03\\img\\sapo.gif"));
		sapo4.setBounds(10, 327, 100, 93);
		contentPane.add(sapo4);
		
		JLabel sapo5 = new JLabel("");
		sapo5.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\src\\exercicio03\\img\\sapo.gif"));
		sapo5.setBounds(10, 431, 100, 93);
		contentPane.add(sapo5);
		
		JLabel lbFim = new JLabel("");
		lbFim.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\src\\exercicio03\\img\\linha_de_chegada.png"));
		lbFim.setBounds(738, 11, 10, 526);
		contentPane.add(lbFim);
		
		JScrollPane areaPodio = new JScrollPane();
		areaPodio.setBounds(10, 548, 600, 101);
		contentPane.add(areaPodio);
		
		JTextArea textArea = new JTextArea();
		areaPodio.setViewportView(textArea);
		textArea.setEditable(false);
		
		
		JButton btnIniciar = new JButton("INICIAR");
		btnIniciar.setFont(new Font("Arial", Font.BOLD, 20));
		btnIniciar.setBounds(650, 548, 115, 101);
		contentPane.add(btnIniciar);
		String podio = "  *** PÓDIO ***\n";
		textArea.setText(podio);
		
		JTextArea textAreaSapo1 = new JTextArea();
        textAreaSapo1.setBackground(new Color(0, 0, 0));
		textAreaSapo1.setFont(new Font("Arial", Font.BOLD, 13));
		textAreaSapo1.setForeground(Color.white);
		textAreaSapo1.setLineWrap(true);
		textAreaSapo1.setWrapStyleWord(true);
		textAreaSapo1.setEditable(false);
		textAreaSapo1.setBounds(10, 11, 730, 93);
		contentPane.add(textAreaSapo1);
		
		JTextArea textAreaSapo2 = new JTextArea();
		textAreaSapo2.setBackground(new Color(0, 0, 0));
		textAreaSapo2.setFont(new Font("Arial", Font.BOLD, 13));
		textAreaSapo2.setForeground(Color.white);
		textAreaSapo2.setWrapStyleWord(true);
		textAreaSapo2.setLineWrap(true);
		textAreaSapo2.setEditable(false);
		textAreaSapo2.setBounds(10, 115, 730, 93);
		contentPane.add(textAreaSapo2);
		
		JTextArea textAreaSapo3 = new JTextArea();
		textAreaSapo3.setBackground(new Color(0, 0, 0));
		textAreaSapo3.setFont(new Font("Arial", Font.BOLD, 13));
		textAreaSapo3.setForeground(Color.white);
		textAreaSapo3.setLineWrap(true);
		textAreaSapo3.setWrapStyleWord(true);
		textAreaSapo3.setEditable(false);
		textAreaSapo3.setBounds(10, 223, 730, 93);
		contentPane.add(textAreaSapo3);
		
		JTextArea textAreaSapo4 = new JTextArea();
		textAreaSapo4.setBackground(new Color(0, 0, 0));
		textAreaSapo4.setFont(new Font("Arial", Font.BOLD, 13));
		textAreaSapo4.setForeground(Color.white);
		textAreaSapo4.setLineWrap(true);
		textAreaSapo4.setWrapStyleWord(true);
		textAreaSapo4.setEditable(false);
		textAreaSapo4.setBounds(10, 327, 730, 93);
		contentPane.add(textAreaSapo4);
		
		JTextArea textAreaSapo5 = new JTextArea();
		textAreaSapo5.setBackground(new Color(0, 0, 0));
		textAreaSapo5.setFont(new Font("Arial", Font.BOLD, 13));
		textAreaSapo5.setForeground(Color.white);
		textAreaSapo5.setLineWrap(true);
		textAreaSapo5.setWrapStyleWord(true);
		textAreaSapo5.setEditable(false);
		textAreaSapo5.setBounds(10, 431, 730, 93);
		contentPane.add(textAreaSapo5);

		SapoController sapoController = new SapoController(farol, sapo1, sapo2, sapo3, sapo4, sapo5, btnIniciar, textArea, lbFim, textAreaSapo1, textAreaSapo2, textAreaSapo3, textAreaSapo4, textAreaSapo5);
		btnIniciar.addActionListener(sapoController);
	}
}