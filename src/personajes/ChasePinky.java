package personajes;

import entidadesLogicas.Entidad;
import entidadesLogicas.Posicion;
import gui.Ventana;

public class ChasePinky extends ChaseIA {

	private Enemigo miEnemigo;
	private Principal miPrincipal;
	
	public ChasePinky(Enemigo pinky, Principal principal) {
		miEnemigo = pinky;
		miPrincipal = principal;
	}
	
	@Override
	public Posicion siguientePosicion() {
		Posicion toReturn = miEnemigo.getPosicion();
		Posicion posicionObjetivo = calcularPosicionObjetivo(miPrincipal.getPosicion());
		double distanciaMinima = Double.MAX_VALUE; 
		double distanciaActual;
		
		for (Posicion pos: miEnemigo.posiblesPosiciones()) {
			distanciaActual = pos.distanciaEntrePosicionesPitagoras(posicionObjetivo);
			
			if (distanciaActual < distanciaMinima) {
				distanciaMinima = distanciaActual;
				toReturn = pos;
			}
			
		}
		
		return toReturn;
	}

	private Posicion calcularPosicionObjetivo(Posicion posicionPrincipal) {
		Posicion toReturn = null;
		int sentidoPrincipal = miPrincipal.getSentidoActual();
		
		if (sentidoPrincipal == Entidad.sentidoAbajo ) {
			toReturn = new Posicion(posicionPrincipal.getX() , posicionPrincipal.getY() + (4 * Ventana.pixelesBloque) );
		}
		else if (sentidoPrincipal == Entidad.sentidoArriba) {
			toReturn = new Posicion(posicionPrincipal.getX() - (2 * Ventana.pixelesBloque) , posicionPrincipal.getY() - (4 * Ventana.pixelesBloque) );
		}
		else if (sentidoPrincipal == Entidad.sentidoIzquierda) {
			toReturn = new Posicion(posicionPrincipal.getX() - (4 * Ventana.pixelesBloque), posicionPrincipal.getY() );
		}
		else {
			toReturn = new Posicion(posicionPrincipal.getX() + (4 * Ventana.pixelesBloque) , posicionPrincipal.getY() );
		}
		
		return toReturn;
	}

}
