package gui;

import javax.swing.*;
import launcher.Launcher;
import java.awt.event.ActionListener;
import java.awt.Image;
import java.awt.event.ActionEvent;

public class SplashScreen extends JDialog{
	
	private static final long serialVersionUID = 1L;
	
	private JButton marioButton; 
	private JButton sonicButton;
	
	public SplashScreen() {
		super();
		this.setModal(true);		
		this.getContentPane().setLayout(null);
		crearBotonMario();
		crearBotonSonic();		
		setBounds(100, 0, 1500, 500);
		
	}

	
	private void crearBotonMario() {
		marioButton = new JButton("");
		marioButton.setBounds(328, 246, 125, 51);
		ImageIcon botonMario = new ImageIcon(this.getClass().getResource("/recursosMarioBros/botonPlayMario.png"));
		marioButton.setIcon(new ImageIcon(botonMario.getImage().getScaledInstance(marioButton.getWidth(), marioButton.getHeight(), Image.SCALE_DEFAULT)));
		marioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Launcher.crearDominioMarioBros();
				setVisible(false);
			}
		});
		this.getContentPane().add(marioButton);
		
		ImageIcon fotoMario = new ImageIcon(this.getClass().getResource("/recursosMarioBros/portadaMario.jpg"));
		JLabel lblFotoMario = new JLabel();
		lblFotoMario.setBounds(0, 0, 750, 500);
		lblFotoMario.setIcon(new ImageIcon(fotoMario.getImage().getScaledInstance(lblFotoMario.getWidth(), lblFotoMario.getHeight(), Image.SCALE_DEFAULT)));
		this.getContentPane().add(lblFotoMario);
	}

	private void crearBotonSonic() {
		sonicButton = new JButton("");
		sonicButton.setBounds(1078, 246, 125, 51);
		ImageIcon botonMemoji = new ImageIcon(this.getClass().getResource("/recursosSonic/botonPlaySonic.png"));
		sonicButton.setIcon(new ImageIcon(botonMemoji.getImage().getScaledInstance(sonicButton.getWidth(), sonicButton.getHeight(), Image.SCALE_DEFAULT)));
		sonicButton.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {
				Launcher.crearDominioSonic();
				setVisible(false);
			}
		});
		getContentPane().add(sonicButton);
				
		ImageIcon fotoMemoji = new ImageIcon(this.getClass().getResource("/recursosSonic/portadaSonic.jpg"));
		JLabel lblFotoMemoji = new JLabel();
		lblFotoMemoji.setBounds(750, 0, 750, 500);
		lblFotoMemoji.setIcon(new ImageIcon(fotoMemoji.getImage().getScaledInstance(lblFotoMemoji.getWidth(), lblFotoMemoji.getHeight(), Image.SCALE_DEFAULT)));
		getContentPane().add(lblFotoMemoji);
	}
	
}
