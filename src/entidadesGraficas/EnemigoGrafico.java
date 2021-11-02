package entidadesGraficas;

import java.awt.Image;
import javax.swing.ImageIcon;
import entidadesLogicas.Posicion;

public class EnemigoGrafico extends EntidadGrafica{
	private static final long serialVersionUID = 1L;
	
	protected ImageIcon sentidoIzquierda;
	protected ImageIcon sentidoDerecha;
	protected ImageIcon sentidoArriba;
	protected ImageIcon sentidoAbajo;
	protected ImageIcon muerto;
	protected ImageIcon escapando;
	
	public EnemigoGrafico(ImageIcon[] imagenes, Posicion miSpawn) {
		sentidoArriba = new ImageIcon(imagenes[0].getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH));
		sentidoAbajo = new ImageIcon(imagenes[1].getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH));
		sentidoIzquierda = new ImageIcon(imagenes[2].getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH));
		sentidoDerecha = new ImageIcon(imagenes[3].getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH));
		muerto = new ImageIcon(imagenes[4].getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH));
		escapando = new ImageIcon(imagenes[5].getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH));
		
		miPrioridad = 2;
		
		aPosicionecerEnGrilla(miSpawn);
	}
	
	private void aPosicionecerEnGrilla(Posicion miSpawn) {
		setBounds(miSpawn.getX(), miSpawn.getY(), 25, 25);
		representacionActual = new ImageIcon(sentidoDerecha.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH));
		setIcon(representacionActual);
	}
}
