package personajes;

import entidadesLogicas.Juego;
import entidadesLogicas.Posicion;

/**
 * Class Blinky - Representa el Enemigo Blinky del Juego.
 * @author Grupo N°2: Bruno Mandolesi, Albano Mazzino, Nicolas Messina, Gonzalo Martin Perez.
 */
public class Blinky extends Enemigo {
	
	private static final Posicion posicionScatter = new Posicion(675, -75);
	private static final Posicion spawnBlinky = new Posicion(350, 275);
	
	/**
	 * Crea un nuevo Blinky.
	 * @param miJuego Juego asociado a Blinky.
	 * @param imagenes Skins de Blinky.
	 */
	public Blinky(Juego miJuego, String[] imagenes) {
		setVelocidadPredeterminada(miJuego.getNivel().getVelocidadEnemigos());
		velocidadActual = velocidadPredeterminada;
		super.crearEnemigo(miJuego, spawnBlinky, imagenes);
	}
	
	@Override
	public ChaseIA crearChaseIA() {
		return new ChaseBlinky(this, miJuego.getPrincipal());
	}

	@Override
	public Posicion getPosicionScatter() {
		return posicionScatter;
	}
	
}
