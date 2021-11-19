package personajes;

import entidadesLogicas.Posicion;

public class ChaseBlinky extends ChaseIA {
	
	@Override
	public Posicion calcularSiguientePosicion(Enemigo e, Principal principal) {
		Posicion toReturn = e.getPosicion();
		Posicion posicionPrincipal = principal.getPosicion();
		double distanciaMinima = Double.MAX_VALUE; 
		/* Asumo que la distancia actual con el principal es la maxima posible.
		   Esto se realiza para no quedar que el enemigo e no quede en la misma posición, ya que cualquier
		   otra distancia sera menor con respecto a esta.
		*/ 
		double distanciaActual;
		
		for (Posicion pos: e.posicionesDestino()) { // Direcciones de Blinky
			distanciaActual = pos.distanciaEntrePosicionesPitagoras(posicionPrincipal);
			
			if (distanciaActual < distanciaMinima) {
				distanciaMinima = distanciaActual;
				toReturn = pos;
			}
			
		}
		
		return toReturn;
	}

}
