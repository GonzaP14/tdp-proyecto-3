package gui;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import entidadesGraficas.EntidadGrafica;
import entidadesGraficas.Laberinto;
import entidadesLogicas.DominioJuego;
import entidadesLogicas.Entidad;
import entidadesLogicas.Juego;
import java.awt.Color;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Ventana extends JFrame implements KeyListener{
	public static final int pixelesBloque = 25;
    private static final long serialVersionUID = 1L;
    
    private Juego miJuego;
    private DominioJuego miDominio;
    private ArrayList<EntidadGrafica> misEntidadesGraficas;
    private Laberinto miLaberinto;
    private JLayeredPane layeredPane;
    private JLabel hub;
    private JLabel puntajeNum;
    private JLabel score;
    private JLabel level;
    private JLabel lifes;
    private JLabel leaderBoard;
    private JLabel leaderBoard2;
    private JPanel end;
    private JLabel vida1;
    private JLabel vida2;
    private JLabel vida3;
    private JLabel GameOver;
    private JLabel leaderboardPuntaje;
    private JLabel leaderboardPuntaje2;
    private Font fuente = null; 
    private Font fuenteTitulo = null; 
    private InputStream myStream = null;
    private JTextField txtName;
    private JButton Load;

    
    
    public Ventana(Juego miJuego, DominioJuego miDominio) {
        this.miJuego = miJuego;
        this.miDominio = miDominio;
        miJuego.setMiVentana(this);
        misEntidadesGraficas = new ArrayList<EntidadGrafica>();    
        miLaberinto = miJuego.getNivel().getLaberinto();
		initialize();
		miJuego.iniciarJuego();
    }
    
    private void initialize() {
    	try {
			myStream = new BufferedInputStream(new FileInputStream("src/fuentes/Pixeled.ttf"));
			fuente = Font.createFont(Font.TRUETYPE_FONT, myStream);
	        fuente = fuente.deriveFont(Font.PLAIN, 26);
	        fuenteTitulo = fuente.deriveFont(Font.PLAIN, 60);
		} catch (IOException | FontFormatException e) {
			e.printStackTrace();
		}      	
    	
    	end = new JPanel();
    	end.setBounds(0, 0, 992, 770);
    	end.setBackground(Color.BLACK);
    	end.setOpaque(true);
    	end.setVisible(false);
		this.getContentPane().add(end);
		end.setLayout(null);
		
		
		GameOver = new JLabel("GAME OVER");
		GameOver.setForeground(Color.WHITE);
		GameOver.setFont(fuenteTitulo);
		GameOver.setBounds(315, 41, 375, 133);
		end.add(GameOver);
		
		txtName = new JTextField();
		txtName.setForeground(Color.WHITE);
		txtName.setBackground(Color.BLACK);
		txtName.setFont(fuente);
		txtName.setBounds(350, 172, 291, 72);
		end.add(txtName);
		txtName.setColumns(10);
		
		Load = new JButton("LOAD NAME");
		Load.setBounds(350, 274, 296, 72);
		Load.setFont(fuente);
		end.add(Load);
		Load.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		
			miJuego.procesarPuntaje(txtName.getText());
			txtName.setText("");
			txtName.setEditable(false);
			mostrarLeaderboard();			
			}
		});
		
		
		leaderBoard2 = new JLabel("LEADERBOARD",SwingConstants.CENTER);
		leaderBoard2.setFont(fuente);
		leaderBoard2.setForeground(Color.WHITE);
		leaderBoard2.setBounds(350, 425, 300, 50);
		end.add(leaderBoard2);
		
		leaderboardPuntaje2 = new JLabel("",SwingConstants.CENTER);
		leaderboardPuntaje2.setBorder(new EmptyBorder(0, 0, 0, 0));
		leaderboardPuntaje2.setFont(fuente);
		leaderboardPuntaje2.setForeground(Color.WHITE);
		leaderboardPuntaje2.setBounds(350, 468, 300, 280);
		//mostrarLeaderboard();
		end.add(leaderboardPuntaje2);
		
		
		
		
		
		
		
    	score = new JLabel("SCORE",SwingConstants.CENTER);
		score.setFont(fuente);
		score.setForeground(Color.WHITE);
		score.setBounds(780, 50, 130, 50);
		this.getContentPane().add(score);
		
    	puntajeNum = new JLabel("0",SwingConstants.CENTER);
    	puntajeNum.setFont(fuente);
		puntajeNum.setForeground(Color.WHITE);
		puntajeNum.setBounds(780, 100, 130, 50);
		this.getContentPane().add(puntajeNum);
						
		level = new JLabel("LEVEL",SwingConstants.CENTER);
		level.setFont(fuente);
		level.setForeground(Color.WHITE);
		level.setBounds(780, 175, 130, 50);
		this.getContentPane().add(level);	
		
		lifes = new JLabel("LIFES",SwingConstants.CENTER);
		lifes.setFont(fuente);
		lifes.setForeground(Color.WHITE);
		lifes.setBounds(780, 300, 130, 50);
		this.getContentPane().add(lifes);
			
		leaderBoard = new JLabel("LEADERBOARD",SwingConstants.CENTER);
		leaderBoard.setFont(fuente);
		leaderBoard.setForeground(Color.WHITE);
		leaderBoard.setBounds(700, 450, 300, 50);
		this.getContentPane().add(leaderBoard);
		
		leaderboardPuntaje = new JLabel("",SwingConstants.CENTER);
		leaderboardPuntaje.setBorder(new EmptyBorder(0, 0, 0, 0));
		leaderboardPuntaje.setFont(fuente);
		leaderboardPuntaje.setForeground(Color.WHITE);
		leaderboardPuntaje.setBounds(700, 490, 300, 280);
		this.getContentPane().add(leaderboardPuntaje);
		mostrarLeaderboard();
		
		vida1 = new JLabel("", SwingConstants.CENTER);
		vida1.setBounds(775, 375, 50, 50);
    	ImageIcon icovida1 = new ImageIcon(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource(miDominio.getImagenVidas())));	
		ImageIcon imgvida1 = new ImageIcon(icovida1.getImage().getScaledInstance(vida1.getWidth(), vida1.getHeight(), Image.SCALE_SMOOTH));
		vida1.setIcon(imgvida1);
		this.getContentPane().add(vida1);

		vida2 = new JLabel("", SwingConstants.CENTER);
		vida2.setBounds(825, 375, 50, 50);
    	ImageIcon icovida2 = new ImageIcon(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource(miDominio.getImagenVidas())));	
		ImageIcon imgvida2 = new ImageIcon(icovida2.getImage().getScaledInstance(vida2.getWidth(), vida2.getHeight(), Image.SCALE_SMOOTH));
		vida2.setIcon(imgvida2);
		this.getContentPane().add(vida2);
		
		vida3 = new JLabel("", SwingConstants.CENTER);
		vida3.setBounds(875, 375, 50, 50);
    	ImageIcon icovida3 = new ImageIcon(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource(miDominio.getImagenVidas())));	
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
		setBounds(0, 0, 1008, 806);
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
		end.setVisible(true);		
	}
	
	private void mostrarLeaderboard() {
		leaderboardPuntaje.setText(miJuego.getMiLeaderboard().getLeaderboard());
		leaderboardPuntaje2.setText(miJuego.getMiLeaderboard().getLeaderboard());
	}
	
}
