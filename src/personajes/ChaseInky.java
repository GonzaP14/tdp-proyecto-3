package personajes;

import entidadesLogicas.Posicion;

/**
 * Class ChaseInky - Representa la IA asociada al estado 'Chase' de Inky.
 * @author Grupo N°2: Bruno Mandolesi, Albano Mazzino, Nicolas Messina, Gonzalo Martin Perez.
 */
public class ChaseInky extends ChaseIA {
		
	private Enemigo miEnemigo, miBlinky;
	private Principal miPrincipal;
	
	/**
	 * Crea un nuevo ChaseInky.
	 * @param inky Enemigo asociado.
	 * @param principal Personaje principal del juego.
	 * @param blinky Blinky asociado.
	 */
	public ChaseInky(Enemigo inky, Principal principal, Enemigo blinky) {
		miEnemigo = inky;
		miPrincipal = principal;
		miBlinky = blinky;
	}
	
	@Override
	public Posicion siguientePosicion() {
		Posicion toReturn = miEnemigo.getPosicion();
		Posicion objetivo = calcularPosicionObjetivo();
		double distanciaMinima = Double.MAX_VALUE; 
		double distanciaActual;
		
		for (Posicion pos: miEnemigo.posiblesPosiciones()) {
			distanciaActual = pos.distanciaEntrePosicionesPitagoras(objetivo);
			
			if (distanciaActual < distanciaMinima) {
				distanciaMinima = distanciaActual;
				toReturn = pos;
			}
			
		}
		
		return toReturn;
	}

	/**
	 * Calcula la posicion objetivo de Clyde de acuerdo a la rotación del vector de dirección en 180°.
	 * @return Posicion objetivo de Clyde.
	 */
	private Posicion calcularPosicionObjetivo() {
		return new Posicion (2* (miPrincipal.getPosicion().getX()) - miBlinky.getPosicion().getX(), 2 * (miPrincipal.getPosicion().getY()) - miBlinky.getPosicion().getY());
	}
	
}
