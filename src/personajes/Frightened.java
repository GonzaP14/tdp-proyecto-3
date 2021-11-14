package personajes;

import entidadesLogicas.Posicion;

public class Frightened implements EstadoEnemigo {
	
	Posicion posicionEnemigo;
	Posicion posicionPrincipal;
	
	@Override
	public Posicion siguientePosicion() {
		Posicion toReturn = posicionEnemigo;
		double distanciaMaxima = posicionEnemigo.distanciaEntrePosicionesPitagoras(posicionPrincipal);
		double distanciaActual;
		
		for (Posicion pos: posicionEnemigo.posicionesDestino()) {
			distanciaActual = pos.distanciaEntrePosicionesPitagoras(posicionPrincipal);
			
			if (distanciaActual > distanciaMaxima) {
				distanciaMaxima = distanciaActual;
				toReturn = pos;
			}
		}
		
		return toReturn;		
	}

	@Override
	public void setPosicionEnemigo(Posicion posicionEnemgigo) {
		this.posicionEnemigo = posicionEnemgigo;
	}

	@Override
	public void setPosicionObjetivo(Posicion posicionObjetivo) {
		this.posicionPrincipal = posicionObjetivo;
	}

}
