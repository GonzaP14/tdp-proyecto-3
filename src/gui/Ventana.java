package gui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import entidadesLogicas.Grilla;
import javax.swing.JPanel;

public class Ventana {

	private JFrame frame;
	private Grilla grillaLogica;
	private JPanel miMapa;

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
		
		grillaLogica = new Grilla();
		
		miMapa = grillaLogica.getRepresentacionGrafica();
		miMapa.setSize(1280, 720);
		miMapa.setLocation(100, 100);
		
		initialize();
	
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		
		frame.setBounds(100, 100, 1280, 720);
		frame.getContentPane().add(miMapa);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
}
