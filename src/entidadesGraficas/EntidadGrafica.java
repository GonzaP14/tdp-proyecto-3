package entidadesGraficas;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public abstract class EntidadGrafica extends JLabel {
	
	private static final long serialVersionUID = 1L;
	
	protected int miPrioridad;
	protected ImageIcon representacionActual;
	
	public int getMiPrioridad() {
		return miPrioridad;
	}

	public void setMiPrioridad(int miPrioridad) {
		this.miPrioridad = miPrioridad;
	}
	
}
