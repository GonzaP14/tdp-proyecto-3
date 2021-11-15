package entidadesGraficas;

import java.util.ArrayList;

import javax.swing.ImageIcon;

import entidadesLogicas.Entidad;
import entidadesLogicas.Posicion;

public abstract class PersonajeGrafico extends EntidadGrafica {
	
	private static final long serialVersionUID = 1L;

	protected ArrayList<ImageIcon> sentidosEstado;
	protected ImageIcon muerto;
	
	public void actualizar (int i) {
//		if (i == Entidad.sentidoDerecha) {
//			representacionActual = sentidosEstado.get(0);
//		}
//		else if (i == Entidad.sentidoIzquierda) {
//			representacionActual = sentidosEstado.get(1);
//		}
//		else if (i == Entidad.sentidoAbajo) {
//			representacionActual = sentidosEstado.get(2);
//		}
//		else if (i == Entidad.sentidoArriba) {
//			representacionActual = sentidosEstado.get(3);
//		}
		representacionActual = sentidosEstado.get(i-1);
		setIcon(representacionActual);
	}
	
	public void aparecer(Posicion miPosicion) {
		this.setLocation((int) miPosicion.getX(), (int) miPosicion.getY());
		representacionActual = sentidosEstado.get(3);
		setIcon(representacionActual);
	}
	
}
