package gui;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class LoadingScreen extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	private JLabel loading;

	/**
	 * Create the application.
	 */
	public LoadingScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setBounds(300, 300, 515, 250);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		getContentPane().setLayout(null);
	
		loading = new JLabel("");
		loading.setBounds(0, 0, 500, 250);
    	ImageIcon ico = new ImageIcon(this.getClass().getResource("/recursosImagenes/loading.gif"));	
		ImageIcon img = new ImageIcon(ico.getImage().getScaledInstance(loading.getWidth(), loading.getHeight(), Image.SCALE_DEFAULT));
		loading.setIcon(img);
		getContentPane().add(loading);
		
	}
}
