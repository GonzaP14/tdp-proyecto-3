package entidadesGraficas;

import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.ImageIcon;

import entidadesLogicas.Entidad;

public class PrincipalGrafico extends EntidadGrafica {
	private static final long serialVersionUID = 1L;
	
	protected ImageIcon sentidoIzquierda;
	protected ImageIcon sentidoDerecha;
	protected ImageIcon sentidoArriba;
	protected ImageIcon sentidoAbajo;
	
	public PrincipalGrafico() {
		/*sentidoIzquierda = new ImageIcon(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/recursosImagenes/MarioIzquierda.gif")));
		sentidoDerecha = new ImageIcon(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/recursosImagenes/MarioDerecha.gif")));
		sentidoArriba = new ImageIcon(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/recursosImagenes/MarioArriba.gif")));
		sentidoAbajo = new ImageIcon(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/recursosImagenes/MarioAbajo.gif")));
		
		miPrioridad = 2;
		representacionActual = sentidoDerecha;
		this.setBounds (100,100,25,25);
		ImageIcon auxiliar = new ImageIcon(representacionActual.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH));
		this.setIcon(auxiliar);*/
		
	}
	
	public void actualizar (int i) {
		if (i == Entidad.sentidoDerecha) {
			representacionActual = sentidoDerecha;
		}
		else if (i == Entidad.sentidoIzquierda) {
			representacionActual = sentidoIzquierda;
		}
		else if (i == Entidad.sentidoAbajo) {
			representacionActual = sentidoAbajo;
		}
		else if (i == Entidad.sentidoArriba) {
			representacionActual = sentidoArriba;
		}
		
		ImageIcon auxiliar = new ImageIcon(representacionActual.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH));
		this.setIcon(auxiliar);
	}
	
}
