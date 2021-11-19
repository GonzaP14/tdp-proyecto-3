package personajes;

import entidadesLogicas.Posicion;
import gui.Ventana;

public class ChaseClyde extends ChaseIA {
	@Override
	public Posicion calcularSiguientePosicion(Enemigo enemigoLigado, Principal principal) {
		Posicion siguientePosicion = enemigoLigado.getPosicion();
		
		double distanciaMinima = Double.MAX_VALUE, distanciaPosiblePos; 
		
		for (Posicion posiblePos: enemigoLigado.posicionesDestino()) {
			distanciaPosiblePos = posiblePos.distanciaEntrePosicionesPitagoras(principal.getPosicion());

			if (distanciaPosiblePos <= 8.0 * Ventana.pixelesBloque) { // 8 bloques
				// entra en scatter mode
				// siguientePosicion = ScatterClyde.getInicio();
				// break
				siguientePosicion = new Posicion(650, 650);
				break;
			}
			else if (distanciaPosiblePos <= distanciaMinima){
				distanciaMinima = distanciaPosiblePos;
				siguientePosicion = posiblePos;
			}
		}
		
		return siguientePosicion;
	}
}
