package gui;

import javax.swing.*;

import entidadesLogicas.DominioJuego;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SplashScreen extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton marioBtn; 
	private JButton memojiBtn;
	
	public SplashScreen(DominioJuego dominioJuego) {
		getContentPane().setLayout(null);
		
		marioBtn = new JButton("MARIO =)");
		marioBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dominioJuego.setDominioJuego(0);
				setVisible(false);
			}
		});
		marioBtn.setBounds(44, 211, 89, 23);
		getContentPane().add(marioBtn);
		
		memojiBtn = new JButton("MEMOJI =(");
		memojiBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dominioJuego.setDominioJuego(1);
				setVisible(false);
			}
		});
		memojiBtn.setBounds(272, 211, 89, 23);
		getContentPane().add(memojiBtn);
		
	}
}
