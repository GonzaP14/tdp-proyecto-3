package entidadesGraficas;

import java.awt.Image;

import javax.swing.ImageIcon;

import entidadesLogicas.Entidad;
import personajes.Principal;

public class PrincipalGrafico extends EntidadGrafica {
	private static final long serialVersionUID = 1L;
	
	protected ImageIcon sentidoIzquierda;
	protected ImageIcon sentidoDerecha;
	protected ImageIcon sentidoArriba;
	protected ImageIcon sentidoAbajo;
	protected ImageIcon muerto;
	private Principal miPrincipal;
	
	public PrincipalGrafico(ImageIcon[] imagenes) {
		sentidoArriba = new ImageIcon(imagenes[0].getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH));
		sentidoAbajo = new ImageIcon(imagenes[1].getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH));
		sentidoIzquierda = new ImageIcon(imagenes[2].getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH));
		sentidoDerecha = new ImageIcon(imagenes[3].getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH));
		muerto = new ImageIcon(imagenes[4].getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH));
		
		miPrioridad = 2;
		
		aparecer();
	}
	
	private void aparecer() {
		setBounds(miPrincipal.getPosicion().getX(), miPrincipal.getPosicion().getY(), 25, 25);
		representacionActual = sentidoDerecha;
		setIcon(representacionActual);
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
		setIcon(representacionActual);
		setLocation(miPrincipal.getPosicion().getX(), miPrincipal.getPosicion().getY());
	}
}
