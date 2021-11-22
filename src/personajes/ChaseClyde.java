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
		double distanciaMinima = Double.MAX_VALUE;
		double distanciaActual; 
		
		for (Posicion pos: miEnemigo.posiblesPosiciones()) {
			distanciaActual = pos.distanciaEntrePosicionesPitagoras(miPrincipal.getPosicion());

			if (distanciaActual <= 8.0 * Ventana.pixelesBloque) {
				siguientePosicion = new Posicion(650, 650);
				break;
			}
			else if (distanciaActual <= distanciaMinima){
				distanciaMinima = distanciaActual;
				siguientePosicion = pos;
			}
		}
		
		return siguientePosicion;
	}
}
