package entidadesGraficas;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import entidadesLogicas.Posicion;

public abstract class EntidadGrafica extends JLabel {
	private static final long serialVersionUID = 1L;
	
	protected int miPrioridad;
	protected ImageIcon representacionActual;
	
	/**
	 * Hace desaparecer la entidad grafica
	 */
	public void desaparecer() {
		this.setVisible(false);
	}
	
	/**
	 * En el caso de ser la entidad grafica que debe usarlo se cambia las a las del estado frightened
	 * @param sentidoActual sentido que tiene la entidad
	 */
	public void asustarse(int sentidoActual) {}
	
	/**
	 * * En el caso de ser la entidad grafica que debe usarlo se cambia las imagenes a las del estado chase
	 * @param sentidoActual sentido que tiene la entidad
	 */
	public void perseguir(int sentidoActual) {}
	
	/**
	 * En el caso de ser la entidad grafica que debe usarlo le setea las imagenes correspondientes
	 */
	public void morir() {}
	
	/**
	 * Modela el efecto de la pocion bomba al principal a nivel grafico 
	 * @param sentidoActual
	 */
	public void efectoPocionBomba(int sentidoActual) {}
	
	/**
	 * Modela el efecto de la pocion de velocidad al principal a nivel grafico 
	 * @param sentidoActual
	 */
	public void efectoPocionVelocidad(int sentidoActual) {}
	
	/**
	 * Termina el efecto de la pocion a nivel grafico
	 * @param sentidoActual
	 */
	public void finEfectoPocion(int sentidoActual) {}
	
	/**
	 * Resetea las graficas para el cambio de nivel
	 */
	public void reset() {}
	
	/**
	 * Actualiza la representacion de la entidad grafica
	 * @param sentido que va a tener la representacion
	 */
	public abstract void actualizar (int sentido);
	
	/**
	 * Crea la entidad grafica 
	 * @param miPosicion en la que se va a crear la entidad grafica
	 */
	public abstract void crearGrafica(Posicion miPosicion);
	
	/**
	 * Setea la prioridad que va a tener la entidad grafica respecto de las capas
	 * @param miPrioridad
	 */
	public void setMiPrioridad(int miPrioridad) {
		this.miPrioridad = miPrioridad;
	}
	
	/**
	 * @return la prioridad que tiene la entidad grafica respecto de las capas
	 */
	public int getMiPrioridad() {
		return miPrioridad;
	}
	
}
