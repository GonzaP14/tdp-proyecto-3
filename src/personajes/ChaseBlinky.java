package personajes;

import entidadesLogicas.Posicion;

/**
 * Class ChaseBlinky - Representa la IA asociada al estado 'Chase' de Blinky.
 * @author Grupo N°2: Bruno Mandolesi, Albano Mazzino, Nicolas Messina, Gonzalo Martin Perez.
 */
public class ChaseBlinky extends ChaseIA {
	
	private Enemigo miEnemigo;
	private Principal miPrincipal;
	
	/**
	 * Crea un nuevo ChaseBlinky.
	 * @param blinky Enemigo asociado.
	 * @param principal Personaje principal del juego.
	 */
	public ChaseBlinky(Enemigo blinky, Principal principal) {
		miEnemigo = blinky;
		miPrincipal = principal;
	}
	
	@Override
	public Posicion siguientePosicion() {
		Posicion toReturn = miEnemigo.getPosicion();
		Posicion posicionPrincipal = miPrincipal.getPosicion();
		double distanciaMinima = Double.MAX_VALUE; 
		double distanciaActual;
		
		for (Posicion pos: miEnemigo.posiblesPosiciones()) {
			distanciaActual = pos.distanciaEntrePosicionesPitagoras(posicionPrincipal);
			
			if (distanciaActual < distanciaMinima) {
				distanciaMinima = distanciaActual;
				toReturn = pos;
			}
			
		}
		
		return toReturn;
	}

}
