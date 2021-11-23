package personajes;

import entidadesLogicas.Posicion;

/**
 * Class ChaseIA - Representa la IA asociada al estado 'Chase' de un enemigo.
 * @author Grupo N°2: Bruno Mandolesi, Albano Mazzino, Nicolas Messina, Gonzalo Martin Perez.
 */
public abstract class ChaseIA {
	
	/**
	 * Calcula la siguiente posición destino a la que se debe mover cada enemigo en particular.
	 * @return Posicion objetivo del enemigo.
	 */
	public abstract Posicion siguientePosicion();
	
}
