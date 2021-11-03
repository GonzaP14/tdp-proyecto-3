package gui;

import javax.swing.*;

import entidadesLogicas.DominioJuego;
import java.awt.event.ActionListener;
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
		marioButton = new JButton("MARIO =)");
		marioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dominioJuego.setDominioJuego(DominioJuego.dominioMarioBros);
				setVisible(false);
			}
		});
		marioButton.setBounds(44, 211, 89, 23);
		getContentPane().add(marioButton);
		
		// Memoji
		memojiButton = new JButton("MEMOJI =(");
		memojiButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dominioJuego.setDominioJuego(DominioJuego.dominioMemoji);
				setVisible(false);
			}
		});
		memojiButton.setBounds(272, 211, 89, 23);
		getContentPane().add(memojiButton);
		
	}
}
