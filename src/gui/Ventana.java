package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;

import entidadesGraficas.GrillaGrafica;

public class Ventana {

	private JFrame frame;
	private GrillaGrafica miGrilla;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana window = new Ventana();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Ventana() {
		miGrilla= new GrillaGrafica();
		miGrilla.setSize(300, 500);
		miGrilla.setLocation(172, 27);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1500, 800);
		frame.getContentPane().add(miGrilla);	
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
