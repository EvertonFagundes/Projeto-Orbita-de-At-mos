package telas;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PainelOpcoes extends JPanel {
	
	private JLabel titulo1;
	private JLabel subtitulo1;
	private JButton btnHelio;
	private JButton btnHidro;
	
	public PainelOpcoes() {
		// Configura o painel
		setLayout(null); // posicionamento absoluto
		setBackground(Color.WHITE);

		// Adiciona os componentes
		add(getTitulo1());
		add(getSubtitulo1());
		add(getBtnHelio());
		add(getBtnHidro());
	}
	
	private JLabel getTitulo1() {
		if (titulo1 == null) {
			titulo1 = new JLabel("SIMULADOR DE ÓRBITAS ATÔMICAS");
			titulo1.setFont(new Font("Dialog", Font.BOLD, 20));
			titulo1.setBounds(101, 27, 400, 25);
		}
		return titulo1;
	}
	private JLabel getSubtitulo1() {
		if (subtitulo1 == null) {
			subtitulo1 = new JLabel("Selecione o elemento cuja órbita deseja visualizar");
			subtitulo1.setFont(new Font("Dialog", Font.BOLD, 14));
			subtitulo1.setBounds(113, 81, 370, 15);
		}
		return subtitulo1;
	}
	private JButton getBtnHelio() {
		if (btnHelio == null) {
			btnHelio = new JButton("<html>Hélio<br>(He)</html>");
			btnHelio.setFont(new Font("Dialog", Font.BOLD, 24));
			btnHelio.setBackground(new Color(50, 205, 50));
			btnHelio.setForeground(Color.WHITE);
			btnHelio.setBounds(175, 155, 250, 100);
		}
		return btnHelio;
	}
	private JButton getBtnHidro() {
		if (btnHidro == null) {
			btnHidro = new JButton("<html>Hidrogênio<br>(H)</html>");
			btnHidro.setFont(new Font("Dialog", Font.BOLD, 24));
			btnHidro.setBackground(new Color(0, 191, 255));
			btnHidro.setForeground(Color.WHITE);
			btnHidro.setBounds(175, 329, 250, 100);
		}
		return btnHidro;
	}
}
