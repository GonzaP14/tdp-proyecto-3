package entidadesGraficas;

import java.awt.Image;
import javax.swing.ImageIcon;
import entidadesLogicas.Entidad;

public class EnemigoGrafico extends EntidadGrafica{
	private static final long serialVersionUID = 1L;
	
	protected ImageIcon sentidoIzquierda;
	protected ImageIcon sentidoDerecha;
	protected ImageIcon sentidoArriba;
	protected ImageIcon sentidoAbajo;
	protected ImageIcon muerto;
	protected ImageIcon escapando;
	
	public EnemigoGrafico(ImageIcon[] imagenes) {
		sentidoArriba = new ImageIcon(imagenes[0].getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH));
		sentidoAbajo = new ImageIcon(imagenes[1].getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH));
		sentidoIzquierda = new ImageIcon(imagenes[2].getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH));
		sentidoDerecha = new ImageIcon(imagenes[3].getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH));
		muerto = new ImageIcon(imagenes[4].getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH));
		escapando = new ImageIcon(imagenes[5].getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH));
		
		miPrioridad = 2;
		
		aparecer();
	}
	
	private void aparecer() {
		setBounds(miPosicionLogica.getX(), miPosicionLogica.getY(), 25, 25);
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
		setLocation(miPosicionLogica.getX(), miPosicionLogica.getY());
	}
}
