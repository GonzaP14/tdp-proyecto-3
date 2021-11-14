package entidadesGraficas;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import entidadesLogicas.Posicion;

public abstract class EntidadGrafica extends JLabel {
	private static final long serialVersionUID = 1L;
	
	protected int miPrioridad;
	protected ImageIcon representacionActual;
	protected Posicion miPosicionLogica;
	
	public int getMiPrioridad() {
		return miPrioridad;
	}

	public void setMiPrioridad(int miPrioridad) {
		this.miPrioridad = miPrioridad;
	}
	
	public abstract void actualizar (int sentido);
	
	public abstract void aparecer(Posicion miPosicion);
	
	public abstract void desaparecer();
}
