package personajes;

import entidadesLogicas.Posicion;

public class ChaseBlinky extends ChaseIA {
	
	@Override
	public Posicion calcularSiguientePosicion(Enemigo e, Posicion posicionPrincipal) {
		Posicion toReturn = e.getPosicion(); // Asumo que la posicion a retornar es la actual
		double distanciaMinima = Double.MAX_VALUE;
		double distanciaActual;
		
		for (Posicion pos: e.posicionesDestino()) { // Direcciones de Blinky
			distanciaActual = pos.distanciaEntrePosicionesPitagoras(posicionPrincipal);
			
			if (distanciaActual < distanciaMinima) {
				distanciaMinima = distanciaActual;
				toReturn = pos;
			}
			
			System.out.println("PosicionDestino = " + pos + " distanciaActual = " + distanciaActual);
		}
		
		System.out.println("toReturn = " + toReturn + " distanciaMinima = " + distanciaMinima);
		
		return toReturn;
	}

}
