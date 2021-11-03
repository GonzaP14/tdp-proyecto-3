package entidadesGraficas;

import javax.swing.ImageIcon;

import entidadesLogicas.Entidad;
import entidadesLogicas.Posicion;

public class PersonajeGrafico extends EntidadGrafica{
	private static final long serialVersionUID = 1L;

	protected ImageIcon sentidoIzquierda;
	protected ImageIcon sentidoDerecha;
	protected ImageIcon sentidoArriba;
	protected ImageIcon sentidoAbajo;
	protected ImageIcon muerto;

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
	
	public void aparecer(Posicion miPosicion) {
		this.setBounds(miPosicion.getX(), miPosicion.getY(), 25, 25);
		representacionActual = sentidoDerecha;
		setIcon(representacionActual);
	}
}
