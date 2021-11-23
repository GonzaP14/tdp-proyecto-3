package personajes;

import entidadesLogicas.Entidad;
import entidadesLogicas.Posicion;
import gui.Ventana;

/**
 * Class ChasePinky - Representa la IA asociada al estado 'Chase' de Pinky.
 * @author Grupo N°2: Bruno Mandolesi, Albano Mazzino, Nicolas Messina, Gonzalo Martin Perez.
 */
public class ChasePinky extends ChaseIA {

	private Enemigo miEnemigo;
	private Principal miPrincipal;
	
	/**
	 * Crea un nuevo ChasePinky.
	 * @param pinky Enemigo asociado.
	 * @param principal Personaje principal del juego.
	 */
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

	/**
	 * Calcula la posicion objetivo de Clyde de acuerdo a la rotación del vector de dirección en 180°.
	 * @return Posicion objetivo de Pinky.
	 */
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
