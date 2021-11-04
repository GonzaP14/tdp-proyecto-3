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
		this.setModal(true);		
		this.getContentPane().setLayout(null);
		
		
		marioButton = new JButton("");
		marioButton.setBounds(309, 244, 125, 51);
		ImageIcon botonMario = new ImageIcon(this.getClass().getResource("/recursosMarioBros/botonPlayMario.png"));
		marioButton.setIcon(new ImageIcon(botonMario.getImage().getScaledInstance(marioButton.getWidth(), marioButton.getHeight(), Image.SCALE_DEFAULT)));
		marioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dominioJuego.setDominioJuego(DominioJuego.dominioMarioBros);
				setVisible(false);
			}
		});
		this.getContentPane().add(marioButton);
		
		// Memoji
		memojiButton = new JButton("MEMOJI ");
		memojiButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dominioJuego.setDominioJuego(DominioJuego.dominioMemoji);
				setVisible(false);
			}
		});
		memojiButton.setBounds(700, 200, 89, 23);
		getContentPane().add(memojiButton);
		
		
		
		ImageIcon fotoMario = new ImageIcon(this.getClass().getResource("/recursosMarioBros/portada.jpg"));
		JLabel lblFotoMario = new JLabel();
		lblFotoMario.setBounds(0, 0, 700, 500);
		lblFotoMario.setIcon(new ImageIcon(fotoMario.getImage().getScaledInstance(lblFotoMario.getWidth(), lblFotoMario.getHeight(), Image.SCALE_DEFAULT)));
		this.getContentPane().add(lblFotoMario);
		
		JLabel lblFotoMemoji = new JLabel();
		lblFotoMemoji.setBounds(393, 102, 89, 98);
		getContentPane().add(lblFotoMemoji);
		
		
		this.setBounds(0, 0, 1001, 501);
		
	}
}
