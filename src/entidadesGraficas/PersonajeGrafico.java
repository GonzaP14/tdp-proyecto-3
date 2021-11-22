package entidadesGraficas;

import java.util.ArrayList;
import javax.swing.ImageIcon;
import entidadesLogicas.Posicion;

public abstract class PersonajeGrafico extends EntidadGrafica {
	
	private static final long serialVersionUID = 1L;

	protected ArrayList<ImageIcon> sentidosEstado;
	protected ImageIcon muerto;
	
	@Override
	public void actualizar (int i) {
		representacionActual = sentidosEstado.get(i-1);
		setIcon(representacionActual);
	}
	
	@Override
	public void crearGrafica(Posicion miPosicion) {
		setLocation(miPosicion.getX(), miPosicion.getY());
		representacionActual = sentidosEstado.get(3);
		setIcon(representacionActual);
	}
	
}
