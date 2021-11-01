package gui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import entidadesLogicas.Grilla;
import entidadesGraficas.Laberinto;

public class Ventana {

	private JFrame frame;
	private Grilla grillaLogica;
	private Laberinto miLaberinto;
	private JLayeredPane capasGraficas;

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
		
		//capasGraficas = new JLayeredPane();
		//capasGraficas.setBounds(0,0,1280,720);
		
		grillaLogica = new Grilla();
		
		miLaberinto = new Laberinto(grillaLogica);
		miLaberinto.setLocation(10, 26);
		miLaberinto.setSize(1370, 794);
		
		// capasGraficas.add(miLaberinto, Integer.valueOf(0));
		
		initialize();
	
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		
		frame.setBounds(0, 0, 1280, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		frame.getContentPane().add(miLaberinto);
		
	}
}
