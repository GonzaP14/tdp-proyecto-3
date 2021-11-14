package personajes;

import entidadesLogicas.Posicion;

public class Eaten implements EstadoEnemigo {
	
	private Posicion posicionEnemigo;
	private Posicion posicionRecuperacion;
	
	@Override
	public Posicion siguientePosicion() {
		Posicion toReturn = posicionEnemigo;
		double distanciaMinima = posicionEnemigo.distanciaEntrePosicionesPitagoras(posicionRecuperacion);
		double distanciaActual;
		
		for (Posicion pos: posicionEnemigo.posicionesDestino()) {
			distanciaActual = pos.distanciaEntrePosicionesPitagoras(posicionRecuperacion);
			
			if (distanciaActual < distanciaMinima) {
				distanciaMinima = distanciaActual;
				toReturn = pos;
			}
		}
		
		return toReturn;
	}

	@Override
	public void setPosicionEnemigo(Posicion posicionEnemigo) {
		this.posicionEnemigo = posicionEnemigo;
	}

	@Override
	public void setPosicionObjetivo(Posicion posicionObjetivo) {
		this.posicionRecuperacion = posicionObjetivo;
	}


}
