package personajes;

import entidadesLogicas.Juego;
import entidadesLogicas.Posicion;

/**
 * Class Clyde - Representa el Enemigo Clyde del Juego.
 * @author Grupo N°2: Bruno Mandolesi, Albano Mazzino, Nicolas Messina, Gonzalo Martin Perez.
 */
public class Clyde extends Enemigo {
	
	private static final Posicion posicionScatter = new Posicion(25, 750);
	private static final Posicion spawnClyde = new Posicion(400, 275);
	
	/**
	 * Crea un nuevo Clyde.
	 * @param miJuego Juego asociado a Clyde.
	 * @param imagenes Skins de Clyde.
	 */
	public Clyde(Juego miJuego, String[] imagenes) {
		setVelocidadPredeterminada(miJuego.getNivel().getVelocidadEnemigos());
		velocidadActual = velocidadPredeterminada;
		super.crearEnemigo(miJuego, spawnClyde, imagenes);
	}

	@Override
	public ChaseIA crearChaseIA() {
		return new ChaseClyde(this, miJuego.getPrincipal());
	}

	@Override
	public Posicion getPosicionScatter() {
		return posicionScatter;
	}
	
}
