package personajes;

import entidadesLogicas.Posicion;

/**
 * Class Scatter - Representa el estado 'Scatter' de un enemigo.
 * @author Grupo N°2: Bruno Mandolesi, Albano Mazzino, Nicolas Messina, Gonzalo Martin Perez.
 */
public class Scatter implements EstadoEnemigo {
	
	private Enemigo miEnemigo;
	private Posicion posicionObjetivo;
	
	/**
	 * Crea un nuevo estado 'Scatter'
	 * @param miEnemigo Enemigo asociado.
	 * @param posicionObjetivo Posicion de la zona de Scatter del enemigo.
	 */
	public Scatter (Enemigo miEnemigo, Posicion posicionObjetivo) {
		this.miEnemigo = miEnemigo;
		this.posicionObjetivo = posicionObjetivo;
	}
	
	@Override
	public Posicion siguientePosicion() {
		Posicion toReturn = miEnemigo.getPosicion();
        double distanciaMinima = Double.MAX_VALUE; 
        double distanciaActual;

        for (Posicion pos: miEnemigo.posiblesPosiciones()) { //Direcciones de cada fantasma
            distanciaActual = pos.distanciaEntrePosicionesPitagoras(posicionObjetivo);

            if (distanciaActual < distanciaMinima) {
                distanciaMinima = distanciaActual;
                toReturn = pos;
            }

        }

        return toReturn;
	}

}
