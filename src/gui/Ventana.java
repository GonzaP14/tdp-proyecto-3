package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

import entidadesGraficas.AnimacionMovimiento;
import entidadesGraficas.AnimationController;
import entidadesGraficas.EntidadGrafica;
import entidadesGraficas.Laberinto;
import entidadesGraficas.PrincipalGrafico;
import entidadesLogicas.Grilla;
import entidadesLogicas.Juego;


public class Ventana extends JFrame {

    private static final long serialVersionUID = 1L;
    private Juego miJuego;
    private EntidadGrafica miPrincipal;
    private static AnimationController animationControl;
    private Grilla grillaL;
    private Laberinto miLaberinto;
    private JLayeredPane layeredPane;
    
    public Ventana(Juego miJuego) {
        this.miJuego = miJuego;
        animationControl = new AnimationController();
        miPrincipal = new PrincipalGrafico();
        grillaL = new Grilla();
        miLaberinto = new Laberinto (grillaL);
        miLaberinto.setLocation(10, 0);
		miLaberinto.setSize(726, 794);
		initialize();
    
    this.addKeyListener(new KeyListener () {
    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }


    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
          case KeyEvent.VK_SPACE:
              break;
          case KeyEvent.VK_UP:
              if (animationControl.getAnimation() != null && !animationControl.getAnimation().isAnimationFinished()) {
                  animationControl.getAnimation().setSentidoAnimacion(1);
              }
              else {
                    animationControl.addMovement(new AnimacionMovimiento(1, (int) miPrincipal.getLocation().getX(), (int) miPrincipal.getLocation().getY(), miPrincipal));      
              }
            break;
        case KeyEvent.VK_DOWN:
            if (animationControl.getAnimation() != null && !animationControl.getAnimation().isAnimationFinished()) {
                  animationControl.getAnimation().setSentidoAnimacion(2);
              }
              else {
            	  animationControl.addMovement(new AnimacionMovimiento(2, (int) miPrincipal.getLocation().getX(), (int) miPrincipal.getLocation().getY(), miPrincipal));
              }
            break;
          case KeyEvent.VK_LEFT:
              if (animationControl.getAnimation() != null && !animationControl.getAnimation().isAnimationFinished()) {
                  animationControl.getAnimation().setSentidoAnimacion(3);
              }
              else {
            	  animationControl.addMovement(new AnimacionMovimiento(3, (int) miPrincipal.getLocation().getX(), (int) miPrincipal.getLocation().getY(), miPrincipal));
              }
            break;
          case KeyEvent.VK_RIGHT:
              if (animationControl.getAnimation() != null && !animationControl.getAnimation().isAnimationFinished()) {
                  animationControl.getAnimation().setSentidoAnimacion(4);
              }
              else {
            	  animationControl.addMovement(new AnimacionMovimiento(4, (int) miPrincipal.getLocation().getX(), (int) miPrincipal.getLocation().getY(), miPrincipal));
              }
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
    
    private void initialize() {
    	layeredPane = new JLayeredPane();
	    layeredPane.setBounds(0,0,500,500);
	    miPrincipal.setOpaque(true);
	    miPrincipal.setBackground(Color.GREEN);
	    miPrincipal.setBounds(25,250,25,25);
	    //layeredPane.add(label1, JLayeredPane.DEFAULT_LAYER);
	    layeredPane.add(miLaberinto, Integer.valueOf(0)); // Capa base -> Grilla
	    layeredPane.add(miPrincipal, Integer.valueOf(1)); // Elementos
	    //layeredPane.add(label3, Integer.valueOf(1)); // Principal // 3 -> Fantasas
	    this.getContentPane().add(layeredPane);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setSize(new Dimension(500, 500));
	    this.getContentPane().setLayout(null);
	    this.setVisible(true);
	    layeredPane.setFocusable(true);
		setBounds(0, 0, 1280, 846);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
	}
    
}
