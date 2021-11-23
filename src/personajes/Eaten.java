package personajes;

import entidadesLogicas.Posicion;

/**
 * Class Eaten - Representa el estado 'Eaten' de un enemigo.
 * @author Grupo N°2: Bruno Mandolesi, Albano Mazzino, Nicolas Messina, Gonzalo Martin Perez.
 */
public class Eaten implements EstadoEnemigo {
	
	private Enemigo miEnemigo;
	private Posicion posicionRecuperacion;
	
	/**
	 * Crea un nuevo estado Eaten.
	 * @param miEnemigo Enemigo asociado.
	 * @param posicionRecuperacion Posicion de restauración de los enemigos.
	 */
	public Eaten (Enemigo miEnemigo, Posicion posicionRecuperacion) {
		this.miEnemigo = miEnemigo;
		this.posicionRecuperacion = posicionRecuperacion;
	}
	
	@Override
	public Posicion siguientePosicion() {
		Posicion toReturn = miEnemigo.getPosicion();
		double distanciaMinima = Double.MAX_VALUE;
		double distanciaActual;
		
		if (toReturn.equals(miEnemigo.getArribaDeLaCasa())) {
			miEnemigo.setTieneQueEntrarALaCasa(true);
			miEnemigo.entrarALaCasa();
		} 
			
		for (Posicion pos: miEnemigo.posiblesPosiciones()) {
			distanciaActual = pos.distanciaEntrePosicionesPitagoras(posicionRecuperacion);
			
			if (distanciaActual < distanciaMinima) {
				distanciaMinima = distanciaActual;
				toReturn = pos;
			}
		}	
		
		return toReturn;
	}
	
}
