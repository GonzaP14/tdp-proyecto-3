package personajes;

import entidadesLogicas.Posicion;

public class ChaseBlinky extends ChaseIA {
	
	@Override
	public Posicion calcularSiguientePosicion(Posicion posicionEnemigo, Posicion posicionPrincipal) {
		Posicion toReturn = posicionEnemigo;
		double distanciaMinima = posicionEnemigo.distanciaEntrePosicionesPitagoras(posicionPrincipal);
		double distanciaActual;
		
		for (Posicion pos: posicionEnemigo.posicionesDestino()) { // Direcciones de Blinky
			distanciaActual = pos.distanciaEntrePosicionesPitagoras(posicionPrincipal);
			
			if (distanciaActual < distanciaMinima) {
				distanciaMinima = distanciaActual;
				toReturn = pos;
			}
		}
		
		return toReturn;
	}

}
