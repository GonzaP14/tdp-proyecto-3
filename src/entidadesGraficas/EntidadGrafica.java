package entidadesGraficas;

import javax.swing.ImageIcon;

public abstract class EntidadGrafica {
	
	protected int miPrioridad;
	protected ImageIcon representacionActual;
	
	public int getMiPrioridad() {
		return miPrioridad;
	}

	public void setMiPrioridad(int miPrioridad) {
		this.miPrioridad = miPrioridad;
	}
	
	public ImageIcon getMiRepresentacionActual() {
		return representacionActual;
	}
	
}
