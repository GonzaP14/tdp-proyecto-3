package entidadesGraficas;

import java.util.ArrayList;
import javax.swing.ImageIcon;
import entidadesLogicas.Posicion;

public abstract class PersonajeGrafico extends EntidadGrafica {
	
	private static final long serialVersionUID = 1L;

	protected ArrayList<ImageIcon> sentidosEstado;
	protected ImageIcon muerto;
	
	public void actualizar (int i) {
		representacionActual = sentidosEstado.get(i-1);
		setIcon(representacionActual);
	}
	
	public void aparecer(Posicion miPosicion) {
		this.setLocation((int) miPosicion.getX(), (int) miPosicion.getY());
		representacionActual = sentidosEstado.get(3);
		setIcon(representacionActual);
	}
	
}
