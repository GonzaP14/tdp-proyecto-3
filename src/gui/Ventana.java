package gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

import entidadesGraficas.AnimacionMovimiento;
import entidadesGraficas.AnimationController;
import entidadesGraficas.EntidadGrafica;
import entidadesGraficas.PrincipalGrafico;
import entidadesLogicas.Juego;


public class Ventana extends JFrame implements KeyListener {

	private static final long serialVersionUID = 1L;
	private Juego miJuego;
	private EntidadGrafica miPrincipal;
	private static AnimationController animationControl;
	
	
	public Ventana(Juego miJuego) {
		this.miJuego = miJuego;
		animationControl = new AnimationController();
		miPrincipal = new PrincipalGrafico();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
          case KeyEvent.VK_SPACE:
              break;
          case KeyEvent.VK_UP:
          	if (animationControl.getAnimation() != null && !animationControl.getAnimation().isAnimationFinished()) {
          		animationControl.getAnimation().setSentidoAnimacion(1);
          	}
          	else {
                	animationControl.addMovement(new AnimacionMovimiento(1, juancito.label2.getBounds().x, juancito.label2.getBounds().y));
          	}
            break;
        case KeyEvent.VK_DOWN:
        	if (animationControl.getAnimation() != null && !animationControl.getAnimation().isAnimationFinished()) {
          		animationControl.getAnimation().setSentidoAnimacion(2);
          	}
          	else {
          		animationControl.addMovement(new AnimacionMovimiento(2, juancito.label2.getBounds().x, juancito.label2.getBounds().y));
          	}
            break;
          case KeyEvent.VK_LEFT:
          	if (animationControl.getAnimation() != null && !animationControl.getAnimation().isAnimationFinished()) {
          		animationControl.getAnimation().setSentidoAnimacion(3);
          	}
          	else {
          		animationControl.addMovement(new AnimacionMovimiento(3, juancito.label2.getBounds().x, juancito.label2.getBounds().y));
          	}
            break;
          case KeyEvent.VK_RIGHT:
          	if (animationControl.getAnimation() != null && !animationControl.getAnimation().isAnimationFinished()) {
          		animationControl.getAnimation().setSentidoAnimacion(4);
          	}
          	else {
          		animationControl.addMovement(new AnimacionMovimiento(4, juancito.label2.getBounds().x, juancito.label2.getBounds().y));
          	}
            break;
         
          case KeyEvent.VK_P:

          	break;
          case KeyEvent.VK_R:

          	break;
          case KeyEvent.VK_M:	            
//          	if(clip.isRunning()) {
//          		clip.stop();
//          	}
//          	else if(!clip.isRunning()){
//          		clip.loop(Clip.LOOP_CONTINUOUSLY);
//          		clip.start();
//          	}
          	break;
      }
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
