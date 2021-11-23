package personajes;

import entidadesLogicas.Posicion;

/**
 * Interface EstadoEnemigo - Representa un estado de los enemigos del juego.
 * @author Grupo N°2: Bruno Mandolesi, Albano Mazzino, Nicolas Messina, Gonzalo Martin Perez.
 */
public interface EstadoEnemigo {
	
	/**
	 * Calcula la siguiente posición destino a la que se debe mover el Enemigo.
	 * @return Posicion objetivo del enemigo.
	 */
	public Posicion siguientePosicion();

}
