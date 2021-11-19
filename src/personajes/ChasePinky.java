package personajes;

import entidadesLogicas.Entidad;
import entidadesLogicas.Posicion;

public class ChasePinky extends ChaseIA {

	@Override
	public Posicion calcularSiguientePosicion(Enemigo miEnemigo, Principal principal) {
		int sentidoPrincipal = principal.getSentidoActual();
		Posicion posicionPrincipal = principal.getPosicion();
		Posicion siguientePosicion;
		Posicion toReturn = miEnemigo.getPosicion();
		double distanciaMinima = Double.MAX_VALUE; 
		/* Asumo que la distancia actual con el principal es la maxima posible.
		   Esto se realiza para no quedar que el enemigo e no quede en la misma posición, ya que cualquier
		   otra distancia sera menor con respecto a esta.
		*/ 
		double distanciaActual;
		if(sentidoPrincipal == Entidad.sentidoAbajo ) {
			siguientePosicion = new Posicion(posicionPrincipal.getX() , posicionPrincipal.getY() + 4 );
		}
		else if(sentidoPrincipal == Entidad.sentidoArriba) {
			siguientePosicion = new Posicion(posicionPrincipal.getX() + 2 , posicionPrincipal.getY() - 4 );
		}
		else if(sentidoPrincipal == Entidad.sentidoIzquierda) {
			siguientePosicion = new Posicion(posicionPrincipal.getX() - 4, posicionPrincipal.getY() );
		}
		else {
			siguientePosicion = new Posicion(posicionPrincipal.getX() + 4 , posicionPrincipal.getY() );
		}
		
		
		for (Posicion pos: miEnemigo.posicionesDestino()) { // Direcciones posibles de pinky
			distanciaActual = pos.distanciaEntrePosicionesPitagoras(siguientePosicion);
			
			if (distanciaActual < distanciaMinima) {
				distanciaMinima = distanciaActual;
				toReturn = pos;
			}
			
		}
		
		return toReturn;
	}

}
