package personajes;

import entidadesLogicas.Posicion;

/**
 * Class Frightened - Representa el estado 'Frightened' de un enemigo.
 * @author Grupo N°2: Bruno Mandolesi, Albano Mazzino, Nicolas Messina, Gonzalo Martin Perez.
 */
public class Frightened implements EstadoEnemigo {
	
	private Enemigo miEnemigo;
	private Principal miPrincipal;
	
	/**
	 * Crea un nuevo estado Frightened.
	 * @param miEnemigo Enemigo asociado.
	 * @param miPrincipal Personaje principal del juego.
	 */
	public Frightened (Enemigo miEnemigo , Principal miPrincipal) {
		this.miEnemigo = miEnemigo;
		this.miPrincipal = miPrincipal;
	}
	
	@Override
	public Posicion siguientePosicion() {
		Posicion toReturn = miEnemigo.getPosicion();
		double distanciaMaxima = Double.MIN_VALUE;
		double distanciaActual;
		
		for (Posicion pos: miEnemigo.posiblesPosiciones()) {
			distanciaActual = pos.distanciaEntrePosicionesPitagoras(miPrincipal.getPosicion());
			
			if (distanciaActual > distanciaMaxima) {
				distanciaMaxima = distanciaActual;
				toReturn = pos;
			}
		}
		
		return toReturn;		
	}

}
