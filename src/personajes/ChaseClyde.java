package personajes;

import entidadesLogicas.Posicion;
import gui.Ventana;

/**
 * Class ChaseClyde - Representa la IA asociada al estado 'Chase' de Clyde.
 * @author Grupo N°2: Bruno Mandolesi, Albano Mazzino, Nicolas Messina, Gonzalo Martin Perez.
 */
public class ChaseClyde extends ChaseIA {
	
	private Enemigo miEnemigo;
	private Principal miPrincipal;
	
	/**
	 * Crea un nuevo ChaseClyde.
	 * @param clyde Enemigo asociado.
	 * @param principal Personaje principal del juego.
	 */
	public ChaseClyde(Enemigo clyde, Principal principal) {
		miEnemigo = clyde;
		miPrincipal = principal;
	}
	
	@Override
	public Posicion siguientePosicion() {
		Posicion siguientePosicion = miEnemigo.getPosicion();
		double distanciaMinimaAPrincipal = Double.MAX_VALUE, distanciaMinimaAMiScatter = Double.MAX_VALUE;
		double distanciaActualAPrincipal, distanciaActualAMiScatter; 
		
		for (Posicion pos: miEnemigo.posiblesPosiciones()) {
			distanciaActualAPrincipal = pos.distanciaEntrePosicionesPitagoras(miPrincipal.getPosicion());
			distanciaActualAMiScatter = pos.distanciaEntrePosicionesPitagoras(miEnemigo.getPosicionScatter());
			
			if (distanciaActualAPrincipal <= 8.0 * Ventana.pixelesBloque) {
				if (distanciaActualAMiScatter < distanciaMinimaAMiScatter) {
					distanciaMinimaAMiScatter = distanciaActualAMiScatter;
					siguientePosicion = pos;
				}
			}
			else if (distanciaActualAPrincipal < distanciaMinimaAPrincipal){
				distanciaMinimaAPrincipal = distanciaActualAPrincipal;
				siguientePosicion = pos;
			}
		}
		
		return siguientePosicion;
	}
}
