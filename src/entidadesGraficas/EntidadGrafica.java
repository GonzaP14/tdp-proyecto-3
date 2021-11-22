package entidadesGraficas;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import entidadesLogicas.Posicion;

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
	
	public abstract void actualizar (int sentido);
	
	public abstract void aparecer(Posicion miPosicion);
	
	public void desaparecer() {
		this.setVisible(false);
	}

	public void asustarse(int sentidoActual) {
		
	}
	
	public void perseguir(int sentidoActual) {
		
	}
	
	public void morir() {
		
	}

	public void reset() { 
		
	}
}
