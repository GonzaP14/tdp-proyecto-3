package gui;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LoadingScreen extends JFrame {

	private JFrame frame;
	private JLabel loading;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoadingScreen window = new LoadingScreen();
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
	public LoadingScreen() {
		
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(300, 300, 515, 250);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		getContentPane().setLayout(null);
	
		loading = new JLabel("");
		loading.setBounds(0, 0, 500, 250);
    	ImageIcon ico = new ImageIcon(this.getClass().getResource("/recursosImagenes/loading.gif"));	
		ImageIcon img = new ImageIcon(ico.getImage().getScaledInstance(loading.getWidth(), loading.getHeight(), Image.SCALE_DEFAULT));
		loading.setIcon(img);
		frame.getContentPane().add(loading);
		
	}
}
