package gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import entidadesGraficas.EntidadGrafica;
import entidadesGraficas.Laberinto;
import entidadesLogicas.Entidad;
import entidadesLogicas.Juego;

public class Ventana extends JFrame implements KeyListener{

    private static final long serialVersionUID = 1L;
    private Juego miJuego;
    private ArrayList<EntidadGrafica> misEntidadesGraficas;
    private Laberinto miLaberinto;
    private JLayeredPane layeredPane;
    
    public Ventana(Juego miJuego) {
        this.miJuego = miJuego;
        miJuego.setMiVentana(this);
        misEntidadesGraficas = new ArrayList<EntidadGrafica>();
        miLaberinto = miJuego.getNivelActual().getLaberinto(miJuego.getMiGrilla());
		initialize();
		miJuego.iniciarJuego();
    }
    
    private void initialize() {
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
}
