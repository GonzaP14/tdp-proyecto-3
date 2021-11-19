package personajes;

import entidadesLogicas.Entidad;
import entidadesLogicas.Posicion;

public class ChasePinky extends ChaseIA {

	@Override
	public Posicion calcularSiguientePosicion(Enemigo miEnemigo, Principal principal) {
		int sentidoPrincipal = principal.getSentidoActual();
		Posicion posicionPrincipal = principal.getPosicion();
		Posicion siguientePosicion;
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
		return siguientePosicion;
	}

}
