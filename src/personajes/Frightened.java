package personajes;

import entidadesLogicas.Posicion;

public class Frightened implements EstadoEnemigo {
	
	Enemigo miEnemigo;
	Posicion posicionPrincipal;
	
	@Override
	public Posicion siguientePosicion() {
		Posicion toReturn = miEnemigo.getPosicion();
		double distanciaMaxima = Double.MIN_VALUE;
		double distanciaActual;
		
		/* Asumo que la distancia actual con el principal es la maxima posible.
		   Esto se realiza para no quedar que el enemigo e no quede en la misma posición, ya que cualquier
		   otra distancia sera menor con respecto a esta.
		*/ 
		
		for (Posicion pos: miEnemigo.posicionesDestino()) {
			distanciaActual = pos.distanciaEntrePosicionesPitagoras(posicionPrincipal);
			
			if (distanciaActual > distanciaMaxima) {
				distanciaMaxima = distanciaActual;
				toReturn = pos;
			}
		}
		
		return toReturn;		
	}

	@Override
	public void setEnemigo(Enemigo e) {
		miEnemigo = e;
	}

	@Override
	public void setPosicionObjetivo(Posicion posicionObjetivo) {
		this.posicionPrincipal = posicionObjetivo;
	}

	@Override
	public void setPrincipal(Principal p) {
		// TODO Auto-generated method stub
		
	}

}
