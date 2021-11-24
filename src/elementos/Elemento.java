package elementos;

import entidadesLogicas.Entidad;
import entidadesLogicas.Posicion;
import gui.Ventana;

/**
 * Class Elemento - Representa una entidad no movil del juego.
 * @author Grupo N°2: Bruno Mandolesi, Albano Mazzino, Nicolas Messina, Gonzalo Martin Perez.
 */
public abstract class Elemento extends Entidad {
	
	protected int puntajeOtorgado;
	
	/**
	 * Setea el spawn del elemento y le asigna a su posicion el spawn y lo agrega a la lista de entidades del bloque
	 * @param spawn Posicion que se va a usar como spawn
	 */
	public void setSpawneo(Posicion spawn) {
		miSpawn = spawn;
		miPosicion = new Posicion(miSpawn.getX(), miSpawn.getY());
		miJuego.getGrilla().getBloque(miPosicion.getY() / Ventana.pixelesBloque , miPosicion.getX() / Ventana.pixelesBloque).agregarAListaEntidades(this);
	}
	
	/**
	 * Inicia el hilo que a va a llevar el tiempo en el que el elemento tiene efecto sobre el personaje
	 * @param timer Hilo que va a usar
	 */
	protected abstract void iniciarTimer(HiloElemento timer);
 	
	/**
	 * Modela lo que va a hacer el elemento cuando se termina su efecto
	 */
	public abstract void finPocion();
	
	/**
	 * Desaparece la entidad grafica
	 */
	public void despawnear() {
		miRepresentacion.desaparecer();
	}
	
	@Override
	public void reset() {
		setSpawneo(miSpawn);
		miRepresentacion.crearGrafica(miPosicion);
	}
	
}
