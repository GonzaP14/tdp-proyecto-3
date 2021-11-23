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
import entidadesLogicas.Entidad;
import entidadesLogicas.Juego;
import niveles.Laberinto;

import java.awt.Color;
import javax.swing.border.EmptyBorder;

import dominios.DominioJuego;

import javax.swing.JTextField;
import javax.swing.JButton;

public class Ventana extends JFrame implements KeyListener {
	
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
    private JLabel leaderBoard3;
    private JPanel endGameOver;
    private JPanel endWin;
    private JPanel pause;
    private JLabel vida1;
    private JLabel vida2;
    private JLabel vida3;
    private JLabel GameOver;
    private JLabel win;
    private JLabel pauseText;
    private JLabel leaderboardPuntaje;
    private JLabel leaderboardPuntaje2;
    private JLabel leaderboardPuntaje3;
    private Font fuente = null; 
    private Font fuenteTitulo = null; 
    private InputStream myStream = null;
    private JTextField txtName;
    private JTextField txtName2;
    private JButton Load;
    private JButton Load2;
    private JButton restart;
    private JButton restart2;
    private JLabel imagenMario;
    private JLabel imagenSonic;
    private JLabel imagenMuertoMario;
    private JLabel imagenLogoBowser;
    private JLabel imagenDrEggman;
    private JLabel imagenSonicMuerto;
    private JLabel levelActualNumero;
    private JLabel fuegosArtificiales;
    private JLabel fuegosArtificiales2;
    
    
    public Ventana(Juego miJuego, DominioJuego miDominio) {
        this.miJuego = miJuego;
        this.miDominio = miDominio;
        misEntidadesGraficas = new ArrayList<EntidadGrafica>();    
        miLaberinto = miJuego.getNivel().getLaberinto();
		initialize();
    }
    
    public void pasarNivel() {
    	misEntidadesGraficas = new ArrayList<EntidadGrafica>();
    	miLaberinto = miJuego.getNivel().getLaberinto();
    }
    
    private void initialize() {
    	crearFuente();
    	crearGameOver();	
    	crearPause();
    	crearWin();
		crearName();
		crearRestar();
		crearLoad();
		crearLogosLeaderBoard();
		crearScore();
		crearLevel();
		crearlifes();		
		crearLeaderBoard();
		crearLogosVidas();
		crearHub();
		crearCapasPanel();
		
    }
    
    private void crearFuente() {
		try {
			myStream = new BufferedInputStream(new FileInputStream("src/fuentes/Pixeled.ttf"));
			fuente = Font.createFont(Font.TRUETYPE_FONT, myStream);
	        fuente = fuente.deriveFont(Font.PLAIN, 26);
	        fuenteTitulo = fuente.deriveFont(Font.PLAIN, 60);
		} catch (IOException | FontFormatException e) {
			e.printStackTrace();
		} 
	}
    
    private void crearGameOver() {
		endGameOver = new JPanel();
    	endGameOver.setBounds(0, 0, 992, 770);
    	endGameOver.setBackground(Color.BLACK);
    	endGameOver.setOpaque(true);
    	endGameOver.setVisible(false);
		this.getContentPane().add(endGameOver);
		endGameOver.setLayout(null);
		
		GameOver = new JLabel("GAME OVER");
		GameOver.setForeground(Color.RED);
		GameOver.setFont(fuenteTitulo);
		GameOver.setBounds(315, 41, 375, 133);
		endGameOver.add(GameOver);
		
		crearMarioMuerto();
		crearLogoBowser();
		crearDrEggman();
		crearSonicMuerto();
	}
    
    private void crearPause() {
		pause = new JPanel();
		pause.setBounds(100, 225, 500, 275);
		pause.setVisible(false);
		this.getContentPane().add(pause);
		pause.setLayout(null);
		
		pauseText = new JLabel("");
		pauseText.setBounds(0, 0, 500, 275);
		ImageIcon icoPause = new ImageIcon(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/recursosImagenes/pause.jpg")));	
		ImageIcon imgPause = new ImageIcon(icoPause.getImage().getScaledInstance(pause.getWidth(), pause.getHeight(), Image.SCALE_SMOOTH));
		pauseText.setIcon(imgPause);
		pause.add(pauseText);

	}
    
    private void crearWin() {
		endWin = new JPanel();
		endWin.setBounds(0, 0, 992, 770);
		endWin.setBackground(Color.BLACK);
		endWin.setOpaque(true);
		endWin.setVisible(false);
		this.getContentPane().add(endWin);
		endWin.setLayout(null);
		
		win = new JLabel("CONGRATULATIONS");
		win.setForeground(Color.GREEN);
		win.setFont(fuenteTitulo);
		win.setBounds(175, 41, 650, 133);
		endWin.add(win);
		
		crearMario();
		crearSonic();
		crearFuegosArtificiales();
	}

    
    private void crearName() {
		txtName = new JTextField();
		txtName.setForeground(Color.WHITE);
		txtName.setBackground(Color.BLACK);
		txtName.setFont(fuente);
		txtName.setBounds(350, 490, 291, 70);
		endGameOver.add(txtName);
		txtName.setColumns(10);
		
		txtName2 = new JTextField();
		txtName2.setForeground(Color.WHITE);
		txtName2.setBackground(Color.BLACK);
		txtName2.setFont(fuente);
		txtName2.setBounds(350, 490, 291, 70);
		endWin.add(txtName2);
		txtName2.setColumns(10);
	}
    
    private void crearLoad() {
		Load = new JButton("LOAD NAME");
		Load.setBounds(350, 570, 296, 70);
		Load.setFont(fuente);
		endGameOver.add(Load);
		Load.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		
			miJuego.procesarPuntaje(txtName.getText());
			txtName.setText("");
			txtName.setEditable(false);
			mostrarLeaderboard();			
			}
		});
		
		Load2 = new JButton("LOAD NAME");
		Load2.setBounds(350, 570, 296, 70);
		Load2.setFont(fuente);
		endWin.add(Load2);
		Load2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		
			miJuego.procesarPuntaje(txtName2.getText());
			txtName2.setText("");
			txtName2.setEditable(false);
			mostrarLeaderboard();			
			}
		});
	}
    
    private void crearRestar() {
    	restart = new JButton("RESTART");
    	restart.setBounds(350, 650, 296, 70);
    	restart.setFont(fuente);
		endGameOver.add(restart);
		restart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		
				
			}
		});
		
		restart2 = new JButton("RESTART");
		restart2.setBounds(350, 650, 296, 70);
		restart2.setFont(fuente);
		endWin.add(restart2);
		restart2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		
	
			}
		});
    }
    

    private void crearLogosLeaderBoard() {
		leaderBoard2 = new JLabel("LEADERBOARD",SwingConstants.CENTER);
		leaderBoard2.setFont(fuente);
		leaderBoard2.setForeground(Color.WHITE);
		leaderBoard2.setBounds(350, 200, 300, 50);
		endGameOver.add(leaderBoard2);
		
		leaderboardPuntaje2 = new JLabel("",SwingConstants.CENTER);
		leaderboardPuntaje2.setBorder(new EmptyBorder(0, 0, 0, 0));
		leaderboardPuntaje2.setFont(fuente);
		leaderboardPuntaje2.setForeground(Color.WHITE);
		leaderboardPuntaje2.setBounds(350, 210, 300, 280);
		//mostrarLeaderboard();
		endGameOver.add(leaderboardPuntaje2);
		
		leaderBoard3 = new JLabel("LEADERBOARD",SwingConstants.CENTER);
		leaderBoard3.setFont(fuente);
		leaderBoard3.setForeground(Color.WHITE);
		leaderBoard3.setBounds(350, 200, 300, 50);
		endWin.add(leaderBoard3);
		
		leaderboardPuntaje3 = new JLabel("",SwingConstants.CENTER);
		leaderboardPuntaje3.setBorder(new EmptyBorder(0, 0, 0, 0));
		leaderboardPuntaje3.setFont(fuente);
		leaderboardPuntaje3.setForeground(Color.WHITE);
		leaderboardPuntaje3.setBounds(350, 210, 300, 280);
		//mostrarLeaderboard();
		endWin.add(leaderboardPuntaje3);
		
	
	}
    private void crearFuegosArtificiales() {
		fuegosArtificiales = new JLabel("");
		fuegosArtificiales.setBounds(20, 25, 150, 150);
		ImageIcon icoFuegos = new ImageIcon(this.getClass().getResource("/recursosImagenes/fuegosArtificiales.gif"));	
		ImageIcon imgFuegos = new ImageIcon(icoFuegos.getImage().getScaledInstance(fuegosArtificiales.getWidth(), fuegosArtificiales.getHeight(), Image.SCALE_DEFAULT));
		fuegosArtificiales.setIcon(imgFuegos);
		
		endWin.add(fuegosArtificiales);
		
		fuegosArtificiales2 = new JLabel("");
		fuegosArtificiales2.setBounds(800, 25, 150, 150);
		ImageIcon icoFuegos2 = new ImageIcon(this.getClass().getResource("/recursosImagenes/fuegosArtificiales.gif"));	
		ImageIcon imgFuegos2 = new ImageIcon(icoFuegos2.getImage().getScaledInstance(fuegosArtificiales2.getWidth(), fuegosArtificiales2.getHeight(), Image.SCALE_DEFAULT));
		fuegosArtificiales2.setIcon(imgFuegos2);
		
		endWin.add(fuegosArtificiales2);
	}
	private void crearMarioMuerto() {
		imagenMuertoMario = new JLabel("");
		imagenMuertoMario.setBounds(89, 428, 198, 205);
    	ImageIcon icoMario = new ImageIcon(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/recursosMarioBros/marioMuerto.png")));	
		ImageIcon imgMario = new ImageIcon(icoMario.getImage().getScaledInstance(imagenMuertoMario.getWidth(), imagenMuertoMario.getHeight(), Image.SCALE_SMOOTH));
		imagenMuertoMario.setIcon(imgMario);
		
		endGameOver.add(imagenMuertoMario);
	}
	private void crearMario() {
		imagenMario= new JLabel("");
		imagenMario.setBounds(89, 300, 198, 400);
    	ImageIcon icoMario2 = new ImageIcon(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/recursosMarioBros/marioWin.png")));	
		ImageIcon imgMario2 = new ImageIcon(icoMario2.getImage().getScaledInstance(imagenMario.getWidth(), imagenMario.getHeight(), Image.SCALE_SMOOTH));
		imagenMario.setIcon(imgMario2);
		endWin.add(imagenMario);
	}
	private void crearSonic() {
		imagenSonic= new JLabel("");
		imagenSonic.setBounds(650, 250, 350, 550);
    	ImageIcon icoSonic2 = new ImageIcon(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/recursosSonic/sonicWin.png")));	
		ImageIcon imgSonic2 = new ImageIcon(icoSonic2.getImage().getScaledInstance(imagenSonic.getWidth(), imagenSonic.getHeight(), Image.SCALE_SMOOTH));
		imagenSonic.setIcon(imgSonic2);
		endWin.add(imagenSonic);
	}
	
	private void crearLogoBowser() {
		imagenLogoBowser = new JLabel("");
		imagenLogoBowser.setBounds(64, 96, 203, 192);
		ImageIcon icoLogoBowser = new ImageIcon(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/recursosMarioBros/logoBowser.png")));	
		ImageIcon imgLogoBowser = new ImageIcon(icoLogoBowser.getImage().getScaledInstance(imagenLogoBowser.getWidth(), imagenLogoBowser.getHeight(), Image.SCALE_SMOOTH));
		imagenLogoBowser.setIcon(imgLogoBowser);
		endGameOver.add(imagenLogoBowser);
	}

	private void crearDrEggman() {
		imagenDrEggman = new JLabel("");
		imagenDrEggman.setBounds(742, 66, 181, 280);
		ImageIcon icoEggman = new ImageIcon(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/recursosSonic/Dr_Eggman.png")));	
		ImageIcon imgEggman= new ImageIcon(icoEggman.getImage().getScaledInstance(imagenDrEggman.getWidth(), imagenDrEggman.getHeight(), Image.SCALE_SMOOTH));
		imagenDrEggman.setIcon(imgEggman);
		endGameOver.add(imagenDrEggman);
	}
	
	private void crearSonicMuerto() {
		imagenSonicMuerto = new JLabel("");
		imagenSonicMuerto.setBounds(727, 425, 191, 205);
		ImageIcon icoSonicMuerto = new ImageIcon(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/recursosSonic/sonicMuerto.png")));	
		ImageIcon imgSonicMuerto= new ImageIcon(icoSonicMuerto.getImage().getScaledInstance(imagenSonicMuerto.getWidth(), imagenSonicMuerto.getHeight(), Image.SCALE_SMOOTH));
		imagenSonicMuerto.setIcon(imgSonicMuerto);
		endGameOver.add(imagenSonicMuerto);
	}
    
    private void crearScore() {
		score = new JLabel("SCORE",SwingConstants.CENTER);
		score.setFont(fuente);
		score.setForeground(Color.WHITE);
		score.setBounds(780, 50, 130, 50);
		this.getContentPane().add(score);
		
    	puntajeNum = new JLabel(miJuego.getPlayer().getScore()+"",SwingConstants.CENTER);
    	puntajeNum.setFont(fuente);
		puntajeNum.setForeground(Color.WHITE);
		puntajeNum.setBounds(780, 100, 130, 50);
		this.getContentPane().add(puntajeNum);
	}
    
    private void crearLevel() {
		level = new JLabel("LEVEL",SwingConstants.CENTER);
		level.setFont(fuente);
		level.setForeground(Color.WHITE);
		level.setBounds(780, 175, 130, 50);
		this.getContentPane().add(level);
		
		
		levelActualNumero = new JLabel("",SwingConstants.CENTER);
    	levelActualNumero.setFont(fuente);
    	levelActualNumero.setForeground(Color.WHITE);
    	levelActualNumero.setBounds(780, 230, 130, 50);
    	levelActualNumero.setText(String.valueOf(miJuego.getNivel().getNivelActual()));
		this.getContentPane().add(levelActualNumero);	
	}
    
    
    
    private void crearlifes() {
		lifes = new JLabel("LIFES",SwingConstants.CENTER);
		lifes.setFont(fuente);
		lifes.setForeground(Color.WHITE);
		lifes.setBounds(780, 300, 130, 50);
		this.getContentPane().add(lifes);
	}
    
    
    
    private void crearLeaderBoard() {
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
	}
    
	private void crearLogosVidas() {
		if(miJuego.getVidasActuales() == 3 || miJuego.getVidasActuales() == 2 || miJuego.getVidasActuales() == 1) {
			vida1 = new JLabel("", SwingConstants.CENTER);
			vida1.setBounds(775, 375, 50, 50);
	    	ImageIcon icovida1 = new ImageIcon(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource(miDominio.getImagenVidas())));	
			ImageIcon imgvida1 = new ImageIcon(icovida1.getImage().getScaledInstance(vida1.getWidth(), vida1.getHeight(), Image.SCALE_SMOOTH));
			vida1.setIcon(imgvida1);
			this.getContentPane().add(vida1);
		}
		if( miJuego.getVidasActuales() == 3 || miJuego.getVidasActuales() == 2) {
			vida2 = new JLabel("", SwingConstants.CENTER);
			vida2.setBounds(825, 375, 50, 50);
	    	ImageIcon icovida2 = new ImageIcon(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource(miDominio.getImagenVidas())));	
			ImageIcon imgvida2 = new ImageIcon(icovida2.getImage().getScaledInstance(vida2.getWidth(), vida2.getHeight(), Image.SCALE_SMOOTH));
			vida2.setIcon(imgvida2);
			this.getContentPane().add(vida2);
		}
		if( miJuego.getVidasActuales() == 3) {
			vida3 = new JLabel("", SwingConstants.CENTER);
			vida3.setBounds(875, 375, 50, 50);
	    	ImageIcon icovida3 = new ImageIcon(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource(miDominio.getImagenVidas())));	
			ImageIcon imgvida3 = new ImageIcon(icovida3.getImage().getScaledInstance(vida3.getWidth(), vida3.getHeight(), Image.SCALE_SMOOTH));
			vida3.setIcon(imgvida3);
			this.getContentPane().add(vida3);
		}	
	}
	
	private void crearHub() {
		hub = new JLabel("", SwingConstants.CENTER);
		hub.setBounds(700, 0, 300, 775);
    	ImageIcon ico = new ImageIcon(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/recursosImagenes/hudFondoPacman.png")));	
		ImageIcon img = new ImageIcon(ico.getImage().getScaledInstance(hub.getWidth(), hub.getHeight(), Image.SCALE_SMOOTH));
		hub.setIcon(img);
		this.getContentPane().add(hub);
	}
	
	private void crearCapasPanel() {
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
	        	miJuego.cambiarSentido(Entidad.sentidoArriba);
	          	break;
	        case KeyEvent.VK_DOWN:
	        	miJuego.cambiarSentido(Entidad.sentidoAbajo);
	          	break;
	        case KeyEvent.VK_LEFT:
	        	miJuego.cambiarSentido(Entidad.sentidoIzquierda);
	        	break;
	        case KeyEvent.VK_RIGHT:
	        	miJuego.cambiarSentido(Entidad.sentidoDerecha);
	        	break;          
	        case KeyEvent.VK_P:
	        	miJuego.pausarDespausarJuego();
	        	pause();
	        	break;
	        case KeyEvent.VK_M:   
	        	miJuego.muted();
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
		if (vidasActuales == 2) {
			vida3.setVisible(false);
		}
		else if (vidasActuales == 1) {
			vida2.setVisible(false);
		}
		else if (vidasActuales == 0) {
			vida1.setVisible(false);
		}
	}
	public void gameOver() {		
		endGameOver.setVisible(true);		
	}
	public void win() {		
		endWin.setVisible(true);		
	}
	public void pause() {
		if(pause.isVisible()==false) {
			pause.setVisible(true);	
		}	
		else {
			pause.setVisible(false);
		}
	}
	
	private void mostrarLeaderboard() {
		leaderboardPuntaje.setText(miJuego.getMiLeaderboard().getLeaderboard());
		leaderboardPuntaje2.setText(miJuego.getMiLeaderboard().getLeaderboard());
		leaderboardPuntaje3.setText(miJuego.getMiLeaderboard().getLeaderboard());
	}
	
}
