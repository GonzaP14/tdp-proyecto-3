package gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;

import entidadesGraficas.ElementoGrafico;
import entidadesGraficas.EntidadGrafica;
import entidadesGraficas.Laberinto;
import entidadesLogicas.Entidad;
import entidadesLogicas.Juego;
import javax.swing.JLabel;

public class Ventana extends JFrame {

    private static final long serialVersionUID = 1L;
    private Juego miJuego;
    private ArrayList<EntidadGrafica> misEntidadesGraficas;
    private Laberinto miLaberinto;
    private JLayeredPane layeredPane;
    
    public Ventana(Juego miJuego) {
        this.miJuego = miJuego;
        miJuego.setMiVentana(this);
        misEntidadesGraficas = new ArrayList<EntidadGrafica>();
        miLaberinto = new Laberinto (miJuego.getMiGrilla());
        miLaberinto.setLocation(-141, 159);
		miLaberinto.setSize(700, 775);
		miLaberinto.ConstructorNivel(2);
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
		layeredPane.addKeyListener(new KeyListener () {
            @Override
            public void keyTyped(KeyEvent e) {
                // TODO Auto-generated method stub
                
            }

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


            public void keyReleased(KeyEvent e) {
                // TODO Auto-generated method stub
                
            }
            });
	}

	public void aparecerEntidad(EntidadGrafica entidadGrafica) {
		misEntidadesGraficas.add(entidadGrafica);
		layeredPane.add(entidadGrafica, Integer.valueOf(entidadGrafica.getMiPrioridad())); 
	}
}
