package gui;

import javax.swing.*;

import entidadesLogicas.DominioJuego;
import java.awt.event.ActionListener;
import java.awt.Image;
import java.awt.event.ActionEvent;

public class SplashScreen extends JDialog{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton marioButton; 
	private JButton memojiButton;
	
	public SplashScreen(DominioJuego dominioJuego) {
		super();
		setModal(true);
		// constructor de JDialog & modal en true
		
		getContentPane().setLayout(null);
		
		// Mario Bros
		marioButton = new JButton("MARIO");
		marioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dominioJuego.setDominioJuego(DominioJuego.dominioMarioBros);
				setVisible(false);
			}
		});
		marioButton.setBounds(44, 211, 89, 23);
		getContentPane().add(marioButton);
		
		// Memoji
		memojiButton = new JButton("MEMOJI ");
		memojiButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dominioJuego.setDominioJuego(DominioJuego.dominioMemoji);
				setVisible(false);
			}
		});
		memojiButton.setBounds(272, 211, 89, 23);
		getContentPane().add(memojiButton);
		
		ImageIcon fotoMario = new ImageIcon(this.getClass().getResource("/recursosMarioBros/fotoMario.png"));

		JLabel lblFotoMario = new JLabel();
		lblFotoMario.setBounds(44, 102, 89, 98);
		lblFotoMario.setIcon(new ImageIcon(fotoMario.getImage().getScaledInstance(lblFotoMario.getWidth(), lblFotoMario.getHeight(), Image.SCALE_DEFAULT)));
		getContentPane().add(lblFotoMario);
		
		JLabel lblFotoMemoji = new JLabel();
		lblFotoMemoji.setBounds(288, 102, 89, 98);
		getContentPane().add(lblFotoMemoji);
		
	}
}
