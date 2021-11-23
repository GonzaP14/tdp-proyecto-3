package personajes;

import entidadesLogicas.Juego;
import entidadesLogicas.Posicion;

/**
 * Class Pinky - Representa el Enemigo Pinky del Juego.
 * @author Grupo N°2: Bruno Mandolesi, Albano Mazzino, Nicolas Messina, Gonzalo Martin Perez.
 */
public class Pinky extends Enemigo {
	
	private static final Posicion posicionScatter = new Posicion(25, -75);
	private static final Posicion spawnPinky = new Posicion(350, 275);
	
	/**
	 * Crea un nuevo Pinky.
	 * @param miJuego Juego asociado a Pinky.
	 * @param imagenes Skins de Pinky.
	 */
	public Pinky(Juego miJuego, String[] imagenes) {
		setVelocidadPredeterminada(miJuego.getNivel().getVelocidadEnemigos());
		velocidadActual = velocidadPredeterminada;
		super.crearEnemigo(miJuego, spawnPinky, imagenes);
	}

	@Override
	public Posicion getPosicionScatter() {
		return posicionScatter;
	}


	@Override
	public ChaseIA crearChaseIA() {
		return new ChasePinky(this, miJuego.getPrincipal());
	}
	
}
