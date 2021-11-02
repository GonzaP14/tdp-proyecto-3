package gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;

import entidadesGraficas.AnimacionMovimiento;
import entidadesGraficas.AnimationController;
import entidadesGraficas.EntidadGrafica;
import entidadesGraficas.Laberinto;
import entidadesGraficas.PrincipalGrafico;
import entidadesLogicas.Entidad;
import entidadesLogicas.Grilla;
import entidadesLogicas.Juego;
import personajes.Principal;


public class Ventana extends JFrame {

    private static final long serialVersionUID = 1L;
    private Juego miJuego;
    private EntidadGrafica miPrincipalGrafico;
    private Entidad miPrincipal;
    private static AnimationController animationControl;
    private Grilla grillaL;
    private Laberinto miLaberinto;
    private JLayeredPane layeredPane;
    
    public Ventana(Juego miJuego) {
        this.miJuego = miJuego;
        miPrincipal = miJuego.getMiPersonajePrincipal();
        animationControl = new AnimationController();
        grillaL = new Grilla();
        miLaberinto = new Laberinto (grillaL);
        miLaberinto.setLocation(10, 0);
		miLaberinto.setSize(726, 794);
		miLaberinto.ConstructorNivel(1);
		initialize();
		
    
    }
    
    private void initialize() {
    	layeredPane = new JLayeredPane();
	    layeredPane.setBounds(0,0,1250,850);
	    miPrincipalGrafico = miPrincipal.getMiRepresentacion();
	    System.out.println(miPrincipalGrafico);
	    layeredPane.add(miLaberinto,Integer.valueOf(0));
	    layeredPane.add(miPrincipalGrafico, Integer.valueOf(1)); // Principal // 3 -> Fantasas
	    this.getContentPane().add(layeredPane);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.getContentPane().setLayout(null);
	    this.setVisible(true);
	    layeredPane.setFocusable(true);
		setBounds(0, 0, 1250, 850);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.addKeyListener(new KeyListener () {
            @Override
            public void keyTyped(KeyEvent e) {
                // TODO Auto-generated method stub
                
            }


            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                  case KeyEvent.VK_SPACE:
                      miPrincipalGrafico.setLocation(miPrincipalGrafico.getX() + 2, miPrincipalGrafico.getY());
                      break;
                  case KeyEvent.VK_UP:
                      if (animationControl.getAnimation() != null && !animationControl.getAnimation().isAnimationFinished()) {
                          animationControl.getAnimation().setSentidoAnimacion(1);
                      }
                      else {
                    	  animationControl.addMovement(new AnimacionMovimiento(1, (int) miPrincipalGrafico.getLocation().getX(), (int) miPrincipalGrafico.getLocation().getY(), miPrincipalGrafico));      
                      }
                    break;
                case KeyEvent.VK_DOWN:
                    if (animationControl.getAnimation() != null && !animationControl.getAnimation().isAnimationFinished()) {
                          animationControl.getAnimation().setSentidoAnimacion(2);
                      }
                      else {
                          animationControl.addMovement(new AnimacionMovimiento(2, (int) miPrincipalGrafico.getLocation().getX(), (int) miPrincipalGrafico.getLocation().getY(), miPrincipalGrafico));
                      }
                    break;
                  case KeyEvent.VK_LEFT:
                      if (animationControl.getAnimation() != null && !animationControl.getAnimation().isAnimationFinished()) {
                          animationControl.getAnimation().setSentidoAnimacion(3);
                      }
                      else {
                          animationControl.addMovement(new AnimacionMovimiento(3, (int) miPrincipalGrafico.getLocation().getX(), (int) miPrincipalGrafico.getLocation().getY(), miPrincipalGrafico));
                      }
                    break;
                  case KeyEvent.VK_RIGHT:
                      if (animationControl.getAnimation() != null && !animationControl.getAnimation().isAnimationFinished()) {
                          animationControl.getAnimation().setSentidoAnimacion(4);
                      }
                      else {
                          animationControl.addMovement(new AnimacionMovimiento(4, (int) miPrincipalGrafico.getLocation().getX(), (int) miPrincipalGrafico.getLocation().getY(), miPrincipalGrafico));
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
    
}
