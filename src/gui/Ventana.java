package gui;

import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.SwingConstants;

import entidadesGraficas.EntidadGrafica;
import entidadesGraficas.Laberinto;
import entidadesLogicas.Entidad;
import entidadesLogicas.Juego;
import java.awt.Color;

public class Ventana extends JFrame implements KeyListener{

    private static final long serialVersionUID = 1L;
    private Juego miJuego;
    private ArrayList<EntidadGrafica> misEntidadesGraficas;
    private Laberinto miLaberinto;
    private JLayeredPane layeredPane;
    private JLabel hub;
    private JLabel puntajeNum;
    private JLabel score;
    private JLabel level;
    private JLabel lifes;
    private JLabel leaderBoard;
    private JLabel gameOver;
    private JLabel vida1;
    private JLabel vida2;
    private JLabel vida3;
    
    
    public Ventana(Juego miJuego) {
        this.miJuego = miJuego;
        miJuego.setMiVentana(this);
        misEntidadesGraficas = new ArrayList<EntidadGrafica>();    
        miLaberinto = miJuego.getNivel().getLaberinto();
		initialize();
		miJuego.iniciarJuego();
    }
    
    private void initialize() {
    	gameOver = new JLabel("GAME OVER",SwingConstants.CENTER);
		gameOver.setFont(new Font("Power Red and Green", Font.BOLD, 75));
		gameOver.setForeground(Color.WHITE);
		gameOver.setBounds(150, 225, 400, 275);
		gameOver.setVisible(false);
		this.getContentPane().add(gameOver);
		
    	score = new JLabel("SCORE",SwingConstants.CENTER);
		score.setFont(new Font("Power Red and Green", Font.BOLD, 40));
		score.setForeground(Color.WHITE);
		score.setBounds(780, 0, 130, 50);
		this.getContentPane().add(score);
		
		
    	puntajeNum = new JLabel("0",SwingConstants.CENTER);
    	puntajeNum.setFont(new Font("Power Red and Green", Font.BOLD, 40));
		puntajeNum.setForeground(Color.WHITE);
		puntajeNum.setBounds(780, 50, 130, 50);
		this.getContentPane().add(puntajeNum);
						
		level = new JLabel("LEVEL",SwingConstants.CENTER);
		level.setFont(new Font("Power Red and Green", Font.BOLD, 40));
		level.setForeground(Color.WHITE);
		level.setBounds(780, 150, 130, 50);
		this.getContentPane().add(level);	
		
		lifes = new JLabel("LIFES",SwingConstants.CENTER);
		lifes.setFont(new Font("Power Red and Green", Font.BOLD, 40));
		lifes.setForeground(Color.WHITE);
		lifes.setBounds(780, 300, 130, 50);
		this.getContentPane().add(lifes);
			
		leaderBoard = new JLabel("LEADER BOARD",SwingConstants.CENTER);
		leaderBoard.setFont(new Font("Power Red and Green", Font.BOLD, 40));
		leaderBoard.setForeground(Color.WHITE);
		leaderBoard.setBounds(700, 450, 300, 50);
		this.getContentPane().add(leaderBoard);
		
		
		vida1 = new JLabel("", SwingConstants.CENTER);
		vida1.setBounds(775, 375, 50, 50);
    	ImageIcon icovida1 = new ImageIcon(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/recursosMarioBros/Mario.png")));	
		ImageIcon imgvida1 = new ImageIcon(icovida1.getImage().getScaledInstance(vida1.getWidth(), vida1.getHeight(), Image.SCALE_SMOOTH));
		vida1.setIcon(imgvida1);
		this.getContentPane().add(vida1);

		vida2 = new JLabel("", SwingConstants.CENTER);
		vida2.setBounds(825, 375, 50, 50);
    	ImageIcon icovida2 = new ImageIcon(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/recursosMarioBros/Mario.png")));	
		ImageIcon imgvida2 = new ImageIcon(icovida2.getImage().getScaledInstance(vida2.getWidth(), vida2.getHeight(), Image.SCALE_SMOOTH));
		vida2.setIcon(imgvida2);
		this.getContentPane().add(vida2);
		
		vida3 = new JLabel("", SwingConstants.CENTER);
		vida3.setBounds(875, 375, 50, 50);
    	ImageIcon icovida3 = new ImageIcon(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/recursosMarioBros/Mario.png")));	
		ImageIcon imgvida3 = new ImageIcon(icovida3.getImage().getScaledInstance(vida3.getWidth(), vida3.getHeight(), Image.SCALE_SMOOTH));
		vida3.setIcon(imgvida3);
		this.getContentPane().add(vida3);
		
		
    	hub = new JLabel("", SwingConstants.CENTER);
		hub.setBounds(700, 0, 300, 775);
    	ImageIcon ico = new ImageIcon(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/recursosImagenes/hudFondoPacman.png")));	
		ImageIcon img = new ImageIcon(ico.getImage().getScaledInstance(hub.getWidth(), hub.getHeight(), Image.SCALE_SMOOTH));
		hub.setIcon(img);
		this.getContentPane().add(hub);
		
		
		
    	layeredPane = new JLayeredPane();
	    layeredPane.setBounds(0,0,1250,850); 
	    layeredPane.add(miLaberinto,Integer.valueOf(0));
	    this.getContentPane().add(layeredPane);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.getContentPane().setLayout(null);
	    this.setVisible(true);
	    layeredPane.setFocusable(true);
		setBounds(0, 0, 1250, 850);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		layeredPane.addKeyListener(this);
    }

	public void aparecerEntidad(EntidadGrafica entidadGrafica) {
		misEntidadesGraficas.add(entidadGrafica);
		layeredPane.add(entidadGrafica, Integer.valueOf(entidadGrafica.getMiPrioridad())); 
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
	        case KeyEvent.VK_UP:
	          miJuego.cambiarSentidoActualPrincipal(Entidad.sentidoArriba);
	          break;
	        case KeyEvent.VK_DOWN:
	          miJuego.cambiarSentidoActualPrincipal(Entidad.sentidoAbajo);
	          break;
	        case KeyEvent.VK_LEFT:
	          miJuego.cambiarSentidoActualPrincipal(Entidad.sentidoIzquierda);
	          break;
	        case KeyEvent.VK_RIGHT:
	          miJuego.cambiarSentidoActualPrincipal(Entidad.sentidoDerecha);
	          break;          
	        case KeyEvent.VK_P:
	            break;
	        case KeyEvent.VK_R:
	            break;
	        case KeyEvent.VK_M:                
	            break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void actualizarPuntaje() {
		puntajeNum.setText(String.valueOf(miJuego.getPlayer().getScore()));		
	}
	
	public void actualizarVidasActuales(int vidasActuales) {
		if(vidasActuales==2) {
			vida3.setVisible(false);
		}
		else if(vidasActuales==1) {
			vida2.setVisible(false);
		}
		else if(vidasActuales==0) {
			vida1.setVisible(false);
		}
	}
	public void gameOver() {		
		gameOver.setVisible(true);		
	}
}
