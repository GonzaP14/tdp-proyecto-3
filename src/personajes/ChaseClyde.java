package personajes;

import entidadesLogicas.Posicion;
import gui.Ventana;

public class ChaseClyde extends ChaseIA {
	
	private Enemigo miEnemigo;
	private Principal miPrincipal;
	
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
